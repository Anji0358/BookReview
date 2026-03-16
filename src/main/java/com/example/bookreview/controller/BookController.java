package com.example.bookreview.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.bookreview.entity.Book;
import com.example.bookreview.form.BookForm;
import com.example.bookreview.service.BookService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
	
	private final BookService bookService;
	
	/**
	 * 書籍一覧を表示する
	 */
	@GetMapping
	public String index(Model model) {
		
		model.addAttribute("books",bookService.findAll());
	
		return "books/index";
	}
	
	/**
	 * 書籍詳細とレビュー一覧を表示する
	 * @param id 書籍ID
	 */
	@GetMapping("/{id}")
	public String show(@PathVariable("id") Long id,Model model) {
		
		// Serviceを使ってIDで検索
		Book book=bookService.findById(id);
		
		// 本が見つからない場合のハンドリング（任意）
        if (book == null) {
            return "redirect:/books";
        }
        
        model.addAttribute("book", book);
		
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
	public String store(@ModelAttribute BookForm bookForm,RedirectAttributes redirectAttributes) {
		
		Book book = new Book();
        book.setTitle(bookForm.getTitle());
        book.setAuthor(bookForm.getAuthor());
        book.setIsbn(bookForm.getIsbn());
        book.setDescription(bookForm.getDescription());
		
        bookService.save(book);
        
        redirectAttributes.addFlashAttribute("successMessage", "書籍を登録しました");
		return "redirect:/books";
	}
}
