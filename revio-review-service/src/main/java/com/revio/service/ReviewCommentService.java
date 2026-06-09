package com.revio.service;

import java.util.List;

import com.revio.dto.CreateReviewCommentRequest;
import com.revio.dto.ReviewCommentResponse;

public interface ReviewCommentService {

	ReviewCommentResponse addComment(Long reviewId, CreateReviewCommentRequest request);
	
	List<ReviewCommentResponse> getCommentsByReviewId(Long reviewId);
}
