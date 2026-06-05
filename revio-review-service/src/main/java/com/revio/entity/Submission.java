package com.revio.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="submissions")
public class Submission {
	
	@Id
	@Column(name="submission_id")
	private String id;

	
	private String title;
	private String githubUrl;
	private String branchName;
	private String developerId;
	private String status;
	private String createdAt;
	private String updatedAt;
}
