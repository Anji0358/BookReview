package com.example.bookreview.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
		
		//model.addAttribute("books",bookServise.findAll());
		
		//一覧を表示するためのテスト		
		ArrayList<Book> books=new ArrayList<>();
		
		Book b1=new Book();
		Book b2=new Book();
		Book b3=new Book();
		Book b4=new Book();
		Book b5=new Book();
		
		b1.setId(1L);
		b2.setId(2L);
		b3.setId(3L);
		b4.setId(4L);
		b5.setId(5L);
		
		books.add(b1);
		books.add(b2);
		books.add(b3);
		books.add(b4);
		books.add(b5);
		
		model.addAttribute("books",books);
	
		return "books/index";
	}
	
	/**
	 * 書籍詳細とレビュー一覧を表示する
	 * @param id 書籍ID
	 */
	@GetMapping("/{id}")
	public String show(@PathVariable("id") Long id,Model model) {
		
		// @PathVariableはURL内の{id}を取得するための注釈
		
		return "books/show";
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
	public String store(@ModelAttribute BookForm bookForm) {
		
		// @Validatedは入力チェック（バリデーション）を実行する注釈
        // if (result.hasErrors()) return "books/register";
        // bookService.save(bookForm);
		
		return "redirect:/books";
	}
}
