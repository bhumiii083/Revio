package com.revio.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.revio.dto.CreateSubmissionRequest;
import com.revio.dto.SubmissionResponse;
import com.revio.entity.Submission;
import com.revio.entity.SubmissionStatus;
import com.revio.exception.SubmissionNotFoundException;
import com.revio.repo.SubmissionRepository;

@Service
public class SubmissionServiceImpl implements SubmissionService{

	private final SubmissionRepository repository;
	
	
	public SubmissionServiceImpl(SubmissionRepository repository) {
		super();
		this.repository = repository;
	}
	

	@Override
	public SubmissionResponse createSubmission(CreateSubmissionRequest request, Long developerId,
			String developerEmail) {
		
		Submission submission = new Submission();
		submission.setTitle(request.getTitle());
		submission.setDescription(request.getDescription());
		submission.setGithubUrl(request.getGithubUrl());
		submission.setBranchName(request.getBranchName());
		submission.setDeveloperId(developerId);
		submission.setDeveloperEmail(developerEmail);
		submission.setStatus(SubmissionStatus.PENDING);
		
		Submission saved= repository.save(submission);
		
		return convertToResponse(saved);
		
		
	}
	
	private SubmissionResponse convertToResponse(Submission submission) {
		SubmissionResponse response = new SubmissionResponse();
		
		response.setId(submission.getId());
		response.setTitle(submission.getTitle());
        response.setDescription(submission.getDescription());
        response.setGithubUrl(submission.getGithubUrl());
        response.setBranchName(submission.getBranchName());
        response.setDeveloperId(submission.getDeveloperId());
        response.setDeveloperEmail(submission.getDeveloperEmail());
        response.setStatus(submission.getStatus());
        
        return response;
		
	}

	@Override
	public List<SubmissionResponse> getMySubmissions(Long developerId) {
		
		List<Submission> submissions = repository.findByDeveloperId(developerId);
		List<SubmissionResponse> responses = new ArrayList<>();
		
		for(Submission submission : submissions) {
			responses.add(convertToResponse(submission));
		}
		return responses;
	}

	@Override
	public SubmissionResponse getSubmissionById(Long id) {
		
		Submission submission = repository.findById(id)
				.orElseThrow(() -> new SubmissionNotFoundException("Submission not found"));
		return convertToResponse(submission);
	}

}
