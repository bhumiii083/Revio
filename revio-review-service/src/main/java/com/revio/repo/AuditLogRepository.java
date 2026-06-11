package com.revio.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revio.entity.AuditLog;

public interface AuditLogRepository extends JpaRepository<AuditLog , Long> {

}
