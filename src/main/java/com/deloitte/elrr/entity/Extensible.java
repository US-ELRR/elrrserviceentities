package com.deloitte.elrr.entity;

import java.util.Map;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public abstract class Extensible<U> extends Auditable<U> {

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "extensions", columnDefinition = "JSONB")
    private Map<String, Object> extensions;

}
