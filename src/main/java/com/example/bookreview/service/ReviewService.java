package com.example.bookreview.service;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.bookreview.entity.Review;
import com.example.bookreview.repository.ReviewRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewService {
	private final ReviewRepository reviewRepository;
	
	/**
     * レビューを保存する
     */
	@Transactional
	@CacheEvict(value="getReviews", allEntries=true)
    public void save(Review review) {
        reviewRepository.save(review);
    }

    /**
     * 特定の書籍に紐付くレビューを全件取得する
     * （BookControllerの詳細画面などで使用します）
     */
	@Transactional(readOnly=true)
	@Cacheable("getReviews")
    public List<Review> findByBookId(Long bookId) {
        return reviewRepository.findByBookId(bookId);
    }
    
    /**
     * レビューを削除する（必要に応じて）
     */
	@Transactional
	@CacheEvict(value="getReviews",allEntries=true)
    public void deleteById(Long id) {
        reviewRepository.deleteById(id);
    }
}


