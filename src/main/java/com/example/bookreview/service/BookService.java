package com.example.bookreview.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookreview.entity.Book;
import com.example.bookreview.repository.BookRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	
	/**
     * 全ての書籍を取得します。
     */
	public List<Book> findAll(){
		
		List<Book> allBooks=new ArrayList<>();
		
		bookRepository.findAll().forEach(allBooks::add);;
		return allBooks;
	}
	

	/**
     * IDを指定して書籍を1件取得します。
     * 見つからない場合は null を返すか、例外を投げます。
     */
	public Optional<Book> findById(Long id) {
		return bookRepository.findById(id);
	}
	
	/**
     * 書籍を保存（新規登録・更新）します。
     * IDがあれば更新、なければ新規登録として動きます。
     */
	public void save(Book book) {
		bookRepository.save(book);
	}
	
	/**
     * IDを指定して書籍を削除します。
     */
	public void deleteById(Long id) {
		bookRepository.deleteById(id);
	}
}
