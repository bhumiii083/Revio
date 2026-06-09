package com.revio.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revio.entity.ReviewComment;

public interface ReviewCommentRepository extends JpaRepository<ReviewComment,Long>{
	
	List<ReviewComment> findByReviewId(Long reviewId);

}
