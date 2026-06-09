package com.revio.dto;

import java.time.LocalDateTime;

import com.revio.entity.IssueType;

public class ReviewCommentResponse {
	
	private Long id;
	private Long reviewId;
	private String commentText;
	private IssueType issueType;
	private LocalDateTime createdAt;
	
	public ReviewCommentResponse() {
		// TODO Auto-generated constructor stub
	}

	public ReviewCommentResponse(Long id, Long reviewId, String commentText, IssueType issueType,
			LocalDateTime createdAt) {
		super();
		this.id = id;
		this.reviewId = reviewId;
		this.commentText = commentText;
		this.issueType = issueType;
		this.createdAt = createdAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getReviewId() {
		return reviewId;
	}

	public void setReviewId(Long reviewId) {
		this.reviewId = reviewId;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	public IssueType getIssueType() {
		return issueType;
	}

	public void setIssueType(IssueType issueType) {
		this.issueType = issueType;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	

}
