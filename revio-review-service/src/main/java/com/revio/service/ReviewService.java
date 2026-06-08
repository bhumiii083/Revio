package com.revio.service;

import java.util.List;

import com.revio.dto.CreateReviewRequest;
import com.revio.dto.ReviewResponse;

public interface ReviewService {

	ReviewResponse createReview(Long submissionId,CreateReviewRequest request,Long reviewerId,String reviewerEmail);
	List<ReviewResponse> getReviewsBySubmission(Long submissionId);
}
