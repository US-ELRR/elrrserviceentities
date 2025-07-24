package com.deloitte.elrr.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.deloitte.elrr.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, UUID> {

    /**
     * Find persons by optional filters.
     *
     * @param id Optional person ID filter
     * @param ifi Optional IFI (Inverse Functional Identifier) filter
     * @param organizationId Optional organization ID filter
     * @param organizationRelType Optional organization relationship type filter
     * @param hasExtension Optional filter for extension keys
     * @param extensionPath Optional filter for JSONPath expressions
     * @param extensionPathMatch Optional filter for JSONPath predicates
     * @return List of persons matching the criteria
     */
    List<Person> findPersonsWithFilters(
            @Param("id") UUID[] id,
            @Param("ifi") String ifi,
            @Param("organizationId") UUID organizationId,
            @Param("organizationRelType") String organizationRelType,
            @Param("hasExtension") String[] hasExtension,
            @Param("extensionPath") String[] extensionPath,
            @Param("extensionPathMatch") String[] extensionPathMatch);
}
