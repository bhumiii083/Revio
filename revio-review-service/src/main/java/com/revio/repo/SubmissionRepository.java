package com.revio.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revio.entity.Submission;

public interface SubmissionRepository extends JpaRepository<Submission , Long>{
	
	List<Submission> findByDeveloperId(Long developerId);

}
