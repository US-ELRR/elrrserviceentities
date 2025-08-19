package com.deloitte.elrr.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import com.deloitte.elrr.entity.types.ActionType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "audit_log")
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AuditLog extends com.deloitte.elrr.entity.Entity {

    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    @Column(name = "request_id", nullable = false)
    private UUID requestId;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "is_api_user", nullable = false)
    private Boolean isApiUser;

    @Column(name = "resource", nullable = false)
    private String resource;

    @Enumerated(EnumType.STRING)
    @Column(name = "action", nullable = false)
    private ActionType action;

    @Column(name = "entity_type", nullable = false)
    private String entityType;

    @Column(name = "entity_id", nullable = false)
    private UUID entityId;

    @Override
    public String toString() {
        return "AuditLog [id=" + id + ", timestamp=" + timestamp
            + ", requestId=" + requestId + ", username=" + username
            + ", isApiUser=" + isApiUser + ", resource=" + resource
            + ", action=" + action + ", entityType=" + entityType
            + ", entityId=" + entityId + "]";
    }

}
