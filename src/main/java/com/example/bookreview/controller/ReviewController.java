package com.example.bookreview.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.bookreview.entity.Book;
import com.example.bookreview.entity.Review;
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
    public String store(@PathVariable("bookId") Long bookId, 
                        @ModelAttribute ReviewForm reviewForm, 
                        RedirectAttributes redirectAttributes) {
        
        // 1. どの本に対するレビューかを取得
        Book book = bookService.findById(bookId);
        
        // 2. FormからEntityへ詰め替え
        Review review = new Review();
        review.setReviewerName(reviewForm.getReviewerName());
        review.setScore(reviewForm.getScore());
        review.setContent(reviewForm.getContent());
        review.setBook(book); // ここで本と紐付け！

        // 3. 保存
        reviewService.save(review);

        redirectAttributes.addFlashAttribute("successMessage", "レビューを投稿しました");

        // 4. その本の詳細画面に戻る
        return "redirect:/books/" + bookId;
    }
}
}
