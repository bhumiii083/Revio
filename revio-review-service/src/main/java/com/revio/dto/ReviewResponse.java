package com.revio.dto;

import java.time.LocalDateTime;

import com.revio.entity.ReviewDecision;

public class ReviewResponse {
	
	private Long id;
	private Long submissionId;
	private Long reviewerId;
	private String reviewerEmail;
	private ReviewDecision decision;
	private LocalDateTime reviewedAt;
	
	public ReviewResponse() {
		// TODO Auto-generated constructor stub
	}
	
	

	public ReviewResponse(Long id, Long submissionId, Long reviewerId, String reviewerEmail, ReviewDecision decision,
			LocalDateTime reviewedAt) {
		super();
		this.id = id;
		this.submissionId = submissionId;
		this.reviewerId = reviewerId;
		this.reviewerEmail = reviewerEmail;
		this.decision = decision;
		this.reviewedAt = reviewedAt;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSubmissionId() {
		return submissionId;
	}

	public void setSubmissionId(Long submissionId) {
		this.submissionId = submissionId;
	}

	public Long getReviewerId() {
		return reviewerId;
	}

	public void setReviewerId(Long reviewerId) {
		this.reviewerId = reviewerId;
	}

	public String getReviewerEmail() {
		return reviewerEmail;
	}

	public void setReviewerEmail(String reviewerEmail) {
		this.reviewerEmail = reviewerEmail;
	}

	public ReviewDecision getDecision() {
		return decision;
	}

	public void setDecision(ReviewDecision decision) {
		this.decision = decision;
	}

	public LocalDateTime getReviewedAt() {
		return reviewedAt;
	}

	public void setReviewedAt(LocalDateTime reviewedAt) {
		this.reviewedAt = reviewedAt;
	}
	
	

}
