package com.revio.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.revio.dto.CreateReviewRequest;
import com.revio.dto.ReviewResponse;
import com.revio.entity.Review;
import com.revio.entity.ReviewDecision;
import com.revio.entity.Submission;
import com.revio.entity.SubmissionStatus;
import com.revio.exception.SubmissionNotFoundException;
import com.revio.repo.ReviewRepository;
import com.revio.repo.SubmissionRepository;

@Service
public class ReviewServiceImpl implements ReviewService {
	
	private final ReviewRepository reviewRepository;
	private final SubmissionRepository submissionRepository;
	
	
	

	public ReviewServiceImpl(ReviewRepository reviewRepository, SubmissionRepository submissionRepository) {
		super();
		this.reviewRepository = reviewRepository;
		this.submissionRepository = submissionRepository;
	}

	@Override
	public ReviewResponse createReview(Long submissionId, CreateReviewRequest request, Long reviewerId,
			String reviewerEmail) {

		Submission submission = submissionRepository.findById(submissionId)
				.orElseThrow(() -> new SubmissionNotFoundException("Submission not found!"));
		
		Review review = new Review();
		
		review.setSubmissionId(submissionId);
        review.setReviewerId(reviewerId);
        review.setReviewerEmail(reviewerEmail);
        review.setDecision(request.getDecision());
        
        Review saved=reviewRepository.save(review);
        
        if(request.getDecision()==ReviewDecision.APPROVED) {
        	submission.setStatus(SubmissionStatus.APPROVED);
        }
        else {
        	submission.setStatus(SubmissionStatus.REJECTED);

        }
        submissionRepository.save(submission);
		
		return map(saved);
	}
	
	
	
	private ReviewResponse map(Review review) {
		ReviewResponse response = new ReviewResponse();
		
		response.setId(review.getId());
        response.setSubmissionId(review.getSubmissionId());
        response.setReviewerId(review.getReviewerId());
        response.setReviewerEmail(review.getReviewerEmail());
        response.setDecision(review.getDecision());
        response.setReviewedAt(review.getReviewedAt());
        
        return response;
	}

	@Override
	public List<ReviewResponse> getReviewsBySubmission(Long submissionId) {

		List<Review> reviews = reviewRepository.findBySubmissionId(submissionId);
		List<ReviewResponse> responses = new ArrayList<>();
		
		for(Review review : reviews) {
			responses.add(map(review));
		}
				
		
		return responses;
	}

}
