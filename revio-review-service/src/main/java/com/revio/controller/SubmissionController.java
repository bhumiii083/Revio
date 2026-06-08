package com.revio.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revio.dto.CreateSubmissionRequest;
import com.revio.dto.SubmissionResponse;
import com.revio.service.SubmissionService;

@RestController
@RequestMapping("/submissions")
@CrossOrigin
public class SubmissionController {

	private final SubmissionService submissionService;

	public SubmissionController(SubmissionService submissionService) {
		super();
		this.submissionService = submissionService;
	}
	
	@PostMapping
	public ResponseEntity<SubmissionResponse> createSubmission(@RequestBody CreateSubmissionRequest request){
		return ResponseEntity.ok(submissionService.createSubmission(request, 1L, "developer@gmail.com"));
	}
	
	@GetMapping("/my")
	public ResponseEntity<List<SubmissionResponse>> getMySubmissions(){
		return ResponseEntity.ok(submissionService.getMySubmissions(1L));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<SubmissionResponse> getSubmissionById(@PathVariable Long id){
		return ResponseEntity.ok(submissionService.getSubmissionById(id));
	}
	
}
