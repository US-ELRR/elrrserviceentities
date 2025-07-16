package com.deloitte.elrr.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.deloitte.elrr.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, UUID> {

    /**
     * Find persons by optional id and/or ifi filters.
     *
     * @param id Optional person ID filter
     * @param ifi Optional IFI (Inverse Functional Identifier) filter
     * @return List of persons matching the criteria
     */
    @Query("SELECT DISTINCT p FROM Person p "
           + "LEFT JOIN p.identities i "
           + "WHERE (:id IS NULL OR p.id = :id) AND "
           + "(:ifi IS NULL OR i.ifi = :ifi)")
    List<Person> findPersonsWithFilters(@Param("id") UUID id,
                                        @Param("ifi") String ifi);

}
