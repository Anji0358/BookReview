package com.example.bookreview.controller;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.bookreview.entity.Book;
import com.example.bookreview.entity.Review;
import com.example.bookreview.form.ReviewForm;
import com.example.bookreview.security.LoginUser;
import com.example.bookreview.service.BookService;
import com.example.bookreview.service.ReviewService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/books/{bookId}/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;
    private final BookService bookService;

    /**
     * レビューを投稿する
     */
    @PostMapping
    public String store(
            @PathVariable("bookId") Long bookId,
            @ModelAttribute ReviewForm reviewForm,
            RedirectAttributes redirectAttributes,
            @AuthenticationPrincipal LoginUser loginUser) {

        // 未ログイン対策
        if (loginUser == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "レビューを投稿するにはログインが必要です");
            return "redirect:/login";
        }

        // どの本に対するレビューかを取得
        Book book = bookService.findById(bookId);

        // 本が存在しない場合
        if (book == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "指定された書籍が見つかりません");
            return "redirect:/books";
        }

        // FormからEntityへ詰め替え
        Review review = new Review();
        review.setReviewerName(reviewForm.getReviewerName());
        review.setScore(reviewForm.getScore());
        review.setContent(reviewForm.getContent());
        review.setBook(book);
        review.setUser(loginUser.getUser());

        // 保存
        reviewService.save(review);

        redirectAttributes.addFlashAttribute("successMessage", "レビューを投稿しました");

        // 詳細画面へ戻る
        return "redirect:/books/" + bookId;
    }

    /**
     * レビューを削除する
     * 投稿者本人または管理者のみ削除可能
     */
    @PostMapping("/{reviewId}/delete")
    public String delete(
            @PathVariable("bookId") Long bookId,
            @PathVariable("reviewId") Long reviewId,
            RedirectAttributes redirectAttributes,
            @AuthenticationPrincipal LoginUser loginUser) {

        // 未ログイン対策
        if (loginUser == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "レビューを削除するにはログインが必要です");
            return "redirect:/login";
        }

        try {
            reviewService.deleteReview(reviewId, loginUser.getUser());
            redirectAttributes.addFlashAttribute("successMessage", "レビューを削除しました");
        } catch (AccessDeniedException e) {
            redirectAttributes.addFlashAttribute("errorMessage", "このレビューを削除する権限がありません");
        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("errorMessage", "指定されたレビューが見つかりません");
        }

        return "redirect:/books/" + bookId;
    }
}