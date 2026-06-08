package com.revio.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revio.dto.CreateReviewRequest;
import com.revio.dto.ReviewResponse;
import com.revio.service.ReviewService;

@RestController
@RequestMapping("/reviews")
@CrossOrigin
public class ReviewController {

	private final ReviewService reviewService;

	public ReviewController(ReviewService reviewService) {
		super();
		this.reviewService = reviewService;
	}
	
	@PostMapping("/{submissionId}")
	public ResponseEntity<ReviewResponse> createReview(@PathVariable Long submissionId, @RequestBody CreateReviewRequest request){
		return ResponseEntity.ok(reviewService.createReview(submissionId, request, 2L, "reviewer@gmail.com"));
	}
	
	@GetMapping("/{submissionId}")
	public ResponseEntity<List<ReviewResponse>> getReviewsBySubmission(@PathVariable Long submissionId){
		return ResponseEntity.ok(reviewService.getReviewsBySubmission(submissionId));
	}
}
