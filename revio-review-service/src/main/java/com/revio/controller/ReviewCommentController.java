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

import com.revio.dto.CreateReviewCommentRequest;
import com.revio.dto.ReviewCommentResponse;
import com.revio.service.ReviewCommentService;

@RestController
@CrossOrigin
@RequestMapping("/comments")
public class ReviewCommentController {
	
	private final ReviewCommentService commentService;

	public ReviewCommentController(ReviewCommentService commentService) {
		this.commentService = commentService;
	}
	
	@PostMapping("/{reviewId}")
	public ResponseEntity<ReviewCommentResponse> addComment(@PathVariable Long reviewId, @RequestBody CreateReviewCommentRequest request){
		
		return ResponseEntity.ok(commentService.addComment(reviewId, request));
	}
	
	@GetMapping("/{reviewId}")
	public ResponseEntity<List<ReviewCommentResponse>> getCommentsByReviewID(@PathVariable Long reviewId){
		
		return ResponseEntity.ok(commentService.getCommentsByReviewId(reviewId));
	}

	
}
