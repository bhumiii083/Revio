package com.revio.dto;

import java.time.LocalDateTime;

public class AuditLogResponse {

	private Long id;
	private String action;
	private String performedBy;
	private LocalDateTime timestamp;
	
	public AuditLogResponse() {
		// TODO Auto-generated constructor stub
	}

	public AuditLogResponse(Long id, String action, String performedBy, LocalDateTime timestamp) {
		super();
		this.id = id;
		this.action = action;
		this.performedBy = performedBy;
		this.timestamp = timestamp;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getPerformedBy() {
		return performedBy;
	}

	public void setPerformedBy(String performedBy) {
		this.performedBy = performedBy;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	
	
}
