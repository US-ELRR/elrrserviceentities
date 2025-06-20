package com.deloitte.elrr.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.SqlTypes;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "client_token")
@EntityListeners(AuditingEntityListener.class)
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClientToken {

    @Id
    @Column(name = "id")
    private UUID id;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "jwtPayload", columnDefinition = "JSONB")
    private Map<String, Object> jwtPayload;

    @Column(name = "inserted_date", updatable = false)
    @CreationTimestamp
    private LocalDateTime insertedDate;

    @Column(name = "updated_by", length = 20)
    @LastModifiedBy
    private String updatedBy;

    @Column(name = "last_modified")
    @UpdateTimestamp
    private LocalDateTime lastModified;

    @Column(name = "label", length = 100)
    private String label;

    @Override
    public String toString() {
        return "ClientToken [id=" + id + "]";
    }
}
