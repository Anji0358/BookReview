package com.example.bookreview.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional
	@Cacheable("getBooks")
	public List<Book> findAll(){
		
		List<Book> allBooks=new ArrayList<>();
		
		bookRepository.findAll().forEach(allBooks::add);;
		return allBooks;
	}

	/**
     * IDを指定して書籍を1件取得します。
     * 見つからない場合は null を返すか、例外を投げます。
     */
	@Transactional(readOnly=true)
	@Cacheable(value="getBook",key="#p0")
	public Book findById(Long id) {
		return bookRepository.findById(id).orElse(null);
	}
	
	/**
     * 書籍を保存（新規登録・更新）します。
     * IDがあれば更新、なければ新規登録として動きます。
     */
	@Transactional
	@CacheEvict(value="getBooks",allEntries=true)
	public void save(Book book) {
		bookRepository.save(book);
	}
	
	/**
     * IDを指定して書籍を削除します。
     */
	@Transactional
	@Caching(evict = {
			@CacheEvict(value="getBook",key="#p0"),
			@CacheEvict(value="getBooks",allEntries=true)
	})
	public void deleteById(Long id) {
		bookRepository.deleteById(id);
	}
}
