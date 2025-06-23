package com.deloitte.elrr.entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

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
     * The person who owns the goal.
     */
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    /**
     * The Competencies associated with the goal.
     */
    @OneToMany(mappedBy = "goal")
    private Set<Competency> competencies;

    /**
     * The Credentials associated with the goal.
     */
    @OneToMany(mappedBy = "goal")
    private Set<Credential> credentials;

    /**
     * The Learning Resources associated with the goal.
     */
    @OneToMany(mappedBy = "goal")
    private Set<LearningResource> learningResources;


    @Override
    public String toString() {
        return "Goal [id=" + id + ", person=" + person
        + "]";
    }

 }
