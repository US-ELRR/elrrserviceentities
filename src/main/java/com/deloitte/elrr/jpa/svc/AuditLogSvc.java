package com.deloitte.elrr.jpa.svc;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.deloitte.elrr.entity.AuditLog;
import com.deloitte.elrr.repository.AuditLogRepository;

@Service
public class AuditLogSvc implements CommonSvc<AuditLog, UUID> {
    private final AuditLogRepository auditLogRepository;

    /**
     * Constructor for AuditLogSvc.
     *
     * @param argsAuditLogRepository the audit log repository
     */
    public AuditLogSvc(final AuditLogRepository argsAuditLogRepository) {
        this.auditLogRepository = argsAuditLogRepository;
    }

    @Override
    public CrudRepository<AuditLog, UUID> getRepository() {
        return this.auditLogRepository;
    }

    @Override
    public UUID getId(final AuditLog auditLog) {
        return auditLog.getId();
    }

    @Override
    public AuditLog save(final AuditLog auditLog) {
        return CommonSvc.super.save(auditLog);
    }
}
