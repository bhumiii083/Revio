package com.revio.service;

import java.util.List;

import com.revio.dto.AuditLogResponse;

public interface AuditService {

	void saveLog(String action , String performedBy);
	
	List<AuditLogResponse> getAllLogs();
}
