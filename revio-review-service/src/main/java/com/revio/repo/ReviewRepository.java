package com.revio.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revio.entity.Review;

public interface ReviewRepository extends JpaRepository<Review,Long>{
	
	List<Review> findByReviewerId(Long reviewerId);
	
	List<Review> findBySubmissionId(Long submissionId);

}
