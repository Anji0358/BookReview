package com.example.bookreview.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.bookreview.entity.Book;
import com.example.bookreview.form.BookForm;

@Controller
@RequestMapping("/books")
public class BookController {
	
	@GetMapping
	public String showlist(Model model) {
		
		//一覧を表示するためのテスト
		Book book=new Book();
		
		ArrayList<Book> books=new ArrayList<>();
				

		model.addAttribute("book",books);
		
		
		return "books/list";
	}
	
	
	@GetMapping("/new")
	public String showCreateForm(Model model) {
		model.addAttribute("bookForm",new BookForm());
		return "books/create";
	}
	
	@PostMapping
	public String create(@ModelAttribute BookForm bookform) {
		
		//todo DB登録、確認画面
		return "/books";
	}
	
	@GetMapping("/{id}")
	public String showEditForm() {
		
		return "books/edit";
	}

}
