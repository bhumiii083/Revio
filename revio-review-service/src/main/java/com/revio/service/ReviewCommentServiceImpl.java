package com.revio.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.revio.dto.CreateReviewCommentRequest;
import com.revio.dto.ReviewCommentResponse;
import com.revio.entity.Review;
import com.revio.entity.ReviewComment;
import com.revio.exception.ReviewNotFoundException;
import com.revio.repo.ReviewCommentRepository;
import com.revio.repo.ReviewRepository;

@Service
public class ReviewCommentServiceImpl implements ReviewCommentService {
	
	private final ReviewCommentRepository commentRepository;
	private final ReviewRepository reviewRepository;
	
	

	public ReviewCommentServiceImpl(ReviewCommentRepository commentRepository, ReviewRepository reviewRepository) {
		this.commentRepository = commentRepository;
		this.reviewRepository = reviewRepository;
	}

	@Override
	public ReviewCommentResponse addComment(Long reviewId, CreateReviewCommentRequest request) {

		Review review = reviewRepository.findById(reviewId)
				.orElseThrow(() -> new ReviewNotFoundException("Review Not Found!"));
		
		ReviewComment comment = new ReviewComment();
		
	    comment.setReviewId(reviewId);
	    comment.setCommentText(request.getCommentText());
	    comment.setIssueType(request.getIssueType());
		
		ReviewComment savedComment = commentRepository.save(comment);
		
		return new ReviewCommentResponse(savedComment.getId(),
				savedComment.getReviewId(), savedComment.getCommentText(),
				savedComment.getIssueType(), savedComment.getCreatedAt());
	}

	@Override
	public List<ReviewCommentResponse> getCommentsByReviewId(Long reviewId) {
		
		List<ReviewComment> comments = commentRepository.findByReviewId(reviewId);
		List<ReviewCommentResponse> responses = new ArrayList<>();
		
		for(ReviewComment comment : comments) {
			responses.add(new ReviewCommentResponse(comment.getId(),comment.getReviewId(),
					comment.getCommentText(),comment.getIssueType(),comment.getCreatedAt()));
		}
		return responses;
	}

}
