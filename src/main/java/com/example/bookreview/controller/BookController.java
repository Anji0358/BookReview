package com.example.bookreview.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.bookreview.entity.Book;
import com.example.bookreview.form.BookForm;
import com.example.bookreview.form.ReviewForm;
import com.example.bookreview.security.LoginUser;
import com.example.bookreview.service.BookService;
import com.example.bookreview.service.ReviewService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

	private final BookService bookService;
	private final ReviewService reviewService;

	/**
	 * 書籍一覧を表示する
	 */
	@GetMapping
	public String index(Model model) {

		model.addAttribute("books", bookService.findAll());

		return "books/index";
	}

	/**
	 * 書籍詳細とレビュー一覧を表示する
	 * @param id 書籍ID
	 */
	@GetMapping("/{id}")
	public String show(@PathVariable("id") Long id, Model model) {

		Book book = bookService.findById(id);

		if (book == null) {
			return "redirect:/books";
		}

		model.addAttribute("book", book);
		model.addAttribute("reviews", reviewService.findByBookId(id));
		model.addAttribute("reviewForm", new ReviewForm());
		return "books/detail";
	}

	/**
	 * 新規登録画面を表示する
	 */
	@GetMapping("/register")
	public String create(@ModelAttribute BookForm bookForm) {

		// @ModelAttributeはFormオブジェクトをViewに渡すための注釈

		return "books/register";
	}

	/**
	 * 書籍を保存する
	 */
	@PostMapping("/register")
	public String store(
			@ModelAttribute @Validated BookForm bookForm,
			BindingResult bindingResult,
			RedirectAttributes redirectAttributes,
			Model model,
			@AuthenticationPrincipal LoginUser loginUser) {

		if (bindingResult.hasErrors()) {
			return "books/register";
		}

		Book book = new Book();
		book.setTitle(bookForm.getTitle());
		book.setAuthor(bookForm.getAuthor());
		book.setIsbn(bookForm.getIsbn());
		book.setDescription(bookForm.getDescription());

		// ★ ここが重要
		book.setUser(loginUser.getUser());

		bookService.save(book);

		redirectAttributes.addFlashAttribute("successMessage", "書籍を登録しました");

		return "redirect:/books";
	}

	/**
	 * 編集画面を表示する
	 */
	@GetMapping("/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {

		Book book = bookService.findById(id);

		if (book == null) {
			return "redirect:/books";
		}

		BookForm bookForm = new BookForm();
		bookForm.setTitle(book.getTitle());
		bookForm.setAuthor(book.getAuthor());
		bookForm.setIsbn(book.getIsbn());
		bookForm.setDescription(book.getDescription());

		model.addAttribute("bookForm", bookForm);
		model.addAttribute("id", id);

		return "books/edit";
	}

	/**
	 * 書籍情報を更新する
	 */
	@PostMapping("/{id}/edit")
	public String update(@PathVariable("id") Long id,
			@ModelAttribute @Validated BookForm bookForm,
			BindingResult bindingResult,
			Model model,
			RedirectAttributes redirectAttributes) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("id", id);
			return "books/edit";
		}

		Book book = bookService.findById(id);

		book.setTitle(bookForm.getTitle());
		book.setAuthor(bookForm.getAuthor());
		book.setIsbn(bookForm.getIsbn());
		book.setDescription(bookForm.getDescription());

		bookService.save(book);

		redirectAttributes.addFlashAttribute("successMessage", "書籍情報を更新しました");

		return "redirect:/books/" + id;
	}
}
