package com.revio.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name="review_comments")
public class ReviewComment {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	private Long reviewId;
	
	@Column(length=2000)
	private String commentText;
	
	@Enumerated(EnumType.STRING)
	private IssueType issueType;
	
	private LocalDateTime createdAt;
	
	public ReviewComment() {
		// TODO Auto-generated constructor stub
	}
	
	@PrePersist
	public void prePersist() {
		createdAt = LocalDateTime.now();
	}

	public ReviewComment(Long id, Long reviewId, String commentText, IssueType issueType, LocalDateTime createdAt) {
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
