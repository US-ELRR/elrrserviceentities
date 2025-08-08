package com.deloitte.elrr.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.deloitte.elrr.entity.EmploymentRecord;

@Repository
public interface EmploymentRecordRepository extends JpaRepository<
        EmploymentRecord, UUID> {

    /**
     * Find employment records by optional filters.
     *
     * @param id Optional employment record ID filter
     * @param hasExtension Optional filter for extension keys
     * @param extensionPath Optional filter for JSONPath expressions
     * @param extensionPathMatch Optional filter for JSONPath predicates
     * @return List of employment records matching the criteria
     */
    List<EmploymentRecord> findEmploymentRecordsWithFilters(
        @Param("id") UUID[] id,
        @Param("hasExtension") String[] hasExtension,
        @Param("extensionPath") String[] extensionPath,
        @Param("extensionPathMatch") String[] extensionPathMatch
    );

    /**
     * Find employment records using a filter object.
     *
     * @param filter EmploymentRecord.Filter containing all filter criteria
     * @return List of employment records matching the criteria
     */
    default List<EmploymentRecord> findEmploymentRecordsWithFilters(
        EmploymentRecord.Filter filter) {
        return findEmploymentRecordsWithFilters(
            filter.getId(),
            filter.getHasExtension(),
            filter.getExtensionPath(),
            filter.getExtensionPathMatch()
        );
    }
}
