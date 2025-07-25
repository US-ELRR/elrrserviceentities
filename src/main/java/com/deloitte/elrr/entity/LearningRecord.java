package com.deloitte.elrr.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.JdbcType;
import org.hibernate.dialect.PostgreSQLEnumJdbcType;

import com.deloitte.elrr.entity.types.LearningStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "learning_record")
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LearningRecord extends Extensible<String> {

    @ManyToOne
    @JoinColumn(name = "learning_resource_id")
    private LearningResource learningResource;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @Column(name = "enrollment_date")
    private LocalDateTime enrollmentDate;

    @Column(name = "record_status", columnDefinition = "learning_status")
    @Enumerated(EnumType.STRING)
    @JdbcType(PostgreSQLEnumJdbcType.class)
    private LearningStatus recordStatus;

    @Column(name = "academic_grade", length = 50)
    private String academicGrade;

    @Column(name = "event_time")
    private LocalDateTime eventTime;

    @Override
    public String toString() {
        return "LearningRecord [id=" + id + ", learningResource="
                + learningResource + ", person=" + person + ", enrollmentDate="
                + enrollmentDate + ", recordStatus=" + recordStatus
                + ", academicGrade=" + academicGrade + ", eventTime="
                + eventTime + "]";
    }

}
