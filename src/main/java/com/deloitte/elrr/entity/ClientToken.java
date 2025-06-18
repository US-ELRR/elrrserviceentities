package com.deloitte.elrr.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Map;

@Entity
@Table(name = "client_token")
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClientToken extends Auditable<String> {

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "jwtPayload", columnDefinition = "JSONB")
    private Map<String, Object> jwtPayload;

    @Override
    public String toString() {
        return "ClientToken [id=" + id + "]";
    }
}
