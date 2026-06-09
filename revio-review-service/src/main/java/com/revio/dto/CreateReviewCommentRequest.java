package com.revio.dto;

import com.revio.entity.IssueType;

public class CreateReviewCommentRequest {
	
	private String commentText;
	private IssueType issueType;
	
	public CreateReviewCommentRequest() {
		// TODO Auto-generated constructor stub
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
	
	
	

}
