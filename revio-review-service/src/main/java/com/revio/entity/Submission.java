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
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name="submissions")
public class Submission {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	@Column(name="title")
	private String title;
	
	@Column(name="description", length=2000)
	private String description;
	
	@Column(name="github_url")
	private String githubUrl;
	
	@Column(name="branch_name")
	private String branchName;
	
	@Column(name="developer_id")
	private Long developerId;
	
	@Column(name="developer_email")
	private String developerEmail;
	
	@Enumerated(EnumType.STRING)
	private SubmissionStatus status;
	
	@Column(name="created_at")
	private  LocalDateTime createdAt;
	
	@Column(name="updated_at")
	private  LocalDateTime updatedAt;
	
	
	public Submission() {
		// TODO Auto-generated constructor stub
	}

	@PrePersist

    public void prePersist() {

        createdAt = LocalDateTime.now();

        updatedAt = LocalDateTime.now();

    }

    @PreUpdate

    public void preUpdate() {

        updatedAt = LocalDateTime.now();

    }




	public Submission(Long id, String title, String description, String githubUrl, String branchName,
			Long developerId, String developerEmail, SubmissionStatus status, LocalDateTime createdAt,
			LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.githubUrl = githubUrl;
		this.branchName = branchName;
		this.developerId = developerId;
		this.developerEmail = developerEmail;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getGithubUrl() {
		return githubUrl;
	}


	public void setGithubUrl(String githubUrl) {
		this.githubUrl = githubUrl;
	}


	public String getBranchName() {
		return branchName;
	}


	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}


	public Long getDeveloperId() {
		return developerId;
	}


	public void setDeveloperId(Long developerId) {
		this.developerId = developerId;
	}


	public String getDeveloperEmail() {
		return developerEmail;
	}


	public void setDeveloperEmail(String developerEmail) {
		this.developerEmail = developerEmail;
	}

	public SubmissionStatus getStatus() {
		return status;
	}

	public void setStatus(SubmissionStatus status) {
		this.status = status;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}


	
	
	
}
