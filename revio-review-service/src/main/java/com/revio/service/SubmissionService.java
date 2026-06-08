package com.revio.service;

import java.util.List;

import com.revio.dto.CreateSubmissionRequest;
import com.revio.dto.SubmissionResponse;

public interface SubmissionService {

	SubmissionResponse createSubmission(CreateSubmissionRequest request, Long developerId, String developerEmail);
	
	List<SubmissionResponse> getMySubmissions(Long developerId);
	
	SubmissionResponse getSubmissionById(Long id);
}
