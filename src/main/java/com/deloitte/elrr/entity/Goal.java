package com.deloitte.elrr.entity;

import org.hibernate.annotations.JdbcType;
import org.hibernate.dialect.PostgreSQLEnumJdbcType;

import java.util.Set;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import com.deloitte.elrr.entity.types.GoalType;


/**
 * A Goal represents a relationship between a Person and a number of
 * Competencies, Credentials, and Learning Resources.
 */

 @Entity
 @Table(name = "goal")
 @RequiredArgsConstructor
 @AllArgsConstructor
 @Getter
 @Setter
 public class Goal extends Auditable<String> {

    /**
     * The Person who owns the Goal.
     */
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    /**
     * The type of the Goal, enum of SELF or ASSIGNED.
     */
    @Column(
        name = "type", nullable = false, columnDefinition = "elrr.goal_type")
    @Enumerated(EnumType.STRING)
    @JdbcType(PostgreSQLEnumJdbcType.class)
    private GoalType type;

    /**
     * The name of the Goal.
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * The description of the Goal.
     */
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    /**
     * The start date of the Goal.
     */
    @Column(name = "start_date")
    private LocalDate startDate;

    /**
     * The achieved-by date of the Goal.
     */
    @Column(name = "achieved_by_date")
    private LocalDate achievedByDate;

    /**
     * The expiration date of the Goal.
     */
    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    /**
     * The Competencies associated with the Goal.
     */
    @ManyToMany
    @JoinTable(
        name = "goal_competency",
        joinColumns = @JoinColumn(name = "goal_id"),
        inverseJoinColumns = @JoinColumn(name = "competency_id")
    )
    private Set<Competency> competencies;

    /**
     * The Credentials associated with the Goal.
     */
    @ManyToMany
    @JoinTable(
        name = "goal_credential",
        joinColumns = @JoinColumn(name = "goal_id"),
        inverseJoinColumns = @JoinColumn(name = "credential_id")
    )
    private Set<Credential> credentials;

    /**
     * The Learning Resources associated with the Goal.
     */
    @ManyToMany
    @JoinTable(
        name = "goal_learning_resource",
        joinColumns = @JoinColumn(name = "goal_id"),
        inverseJoinColumns = @JoinColumn(name = "learning_resource_id")
    )
    private Set<LearningResource> learningResources;

    @Override
    public String toString() {
        return "Goal [id=" + id + ", person=" + person
        + "]";
    }

 }
