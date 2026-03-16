package com.example.bookreview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bookreview.entity.Book;@Repository


public interface BookRepository extends JpaRepository<Book,Long>{

}