package com.example.bookreview.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.bookreview.entity.Book;@Repository


public interface BookRepository extends CrudRepository<Book,Long>{

}
