package com.revio.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revio.dto.AuditLogResponse;
import com.revio.service.AuditService;

@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminController {

	private final AuditService auditService;
	
	public AdminController(

            AuditService auditService) {

        this.auditService = auditService;

    }
	
	@PostMapping("/logs")
	public void saveLog(@RequestParam String action, @RequestParam String performedBy) {
		auditService.saveLog(action, performedBy);
	}
	
	@GetMapping("/logs")
	public List<AuditLogResponse> getAllLogs(){
		return auditService.getAllLogs();
	}
}
