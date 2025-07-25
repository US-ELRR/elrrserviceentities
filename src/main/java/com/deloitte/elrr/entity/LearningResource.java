package com.deloitte.elrr.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "learning_resource")
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LearningResource extends Extensible<String> {

    @Column(name = "iri")
    private String iri;

    @Column(name = "title")
    private String title;

    @Column(name = "subject_matter")
    private String subjectMatter;

    @Column(name = "subject_abbreviation", length = 20)
    private String subjectAbbreviation;

    @Column(name = "level")
    private String level;

    @Column(name = "number")
    private String number;

    @Column(name = "instruction_method")
    private String instructionMethod;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "provider_name")
    private String providerName;

    @Column(name = "department_name")
    private String departmentName;

    @Column(name = "grade_scale_code")
    private String gradeScaleCode;

    @Column(name = "metadata_repository")
    private String metadataRepository;

    @Column(name = "lrs_endpoint")
    private String lrsEndpoint;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Override
    public String toString() {
        return "LearningResource [iri=" + iri + ", title=" + title + ", id="
                + id + ", subjectMatter=" + subjectMatter
                + ", subjectAbbreviation=" + subjectAbbreviation + ", level="
                + level + ", number=" + number + ", instructionMethod="
                + instructionMethod + ", startDate=" + startDate + ", endDate="
                + endDate + ", providername = " + providerName
                + ", departmentname = " + departmentName + ", gradeScaleCode="
                + gradeScaleCode + ", metadataRepository=" + metadataRepository
                + ", lrsEndpoint=" + lrsEndpoint + ", description="
                + description + "]";
    }
}
