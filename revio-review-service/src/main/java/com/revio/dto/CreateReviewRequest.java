package com.revio.dto;

import com.revio.entity.ReviewDecision;

public class CreateReviewRequest {
	
	private ReviewDecision decision;
	
	public CreateReviewRequest() {
		// TODO Auto-generated constructor stub
	}
	public ReviewDecision getDecision() {
		return decision;
	}
	public void setDecision(ReviewDecision decision) {
		this.decision = decision;
	}
	

}
