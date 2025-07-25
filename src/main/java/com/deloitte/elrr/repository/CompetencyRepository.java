package com.deloitte.elrr.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deloitte.elrr.entity.Competency;

@Repository
public interface CompetencyRepository extends JpaRepository<Competency, UUID> {

    /**
     * @param identifier
     * @return Competency
     */
    Competency findByIdentifier(String identifier);
}
