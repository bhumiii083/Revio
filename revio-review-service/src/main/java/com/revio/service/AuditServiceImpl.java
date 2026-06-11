package com.revio.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.revio.dto.AuditLogResponse;
import com.revio.entity.AuditLog;
import com.revio.repo.AuditLogRepository;

@Service
public class AuditServiceImpl implements AuditService {
	
	private final AuditLogRepository repository;
	
	public AuditServiceImpl(AuditLogRepository repository) {

        this.repository = repository;

    }

	@Override
	public void saveLog(String action, String performedBy) {

		AuditLog log = new AuditLog();
		log.setAction(action);
		log.setPerformedBy(performedBy);
		repository.save(log);
	}

	@Override
	public List<AuditLogResponse> getAllLogs() {

		List<AuditLog> logs= repository.findAll();
		List<AuditLogResponse> responses = new ArrayList<>();
		
		for(AuditLog log:logs) {
			responses.add(
					new AuditLogResponse(
							log.getId(),log.getAction(),log.getPerformedBy(),log.getTimestamp())
					);
		}
		return responses;
	}

}
