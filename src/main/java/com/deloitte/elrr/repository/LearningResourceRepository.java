package com.deloitte.elrr.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deloitte.elrr.entity.LearningResource;

@Repository
public interface LearningResourceRepository extends JpaRepository<
        LearningResource, UUID> {

    /**
     * @param iri
     * @return LearningResource
     */
    LearningResource findByIri(String iri);
}
