package com.deloitte.elrr.specification;

import java.util.UUID;

import org.springframework.data.jpa.domain.Specification;

import com.deloitte.elrr.entity.Identity;
import com.deloitte.elrr.entity.Person;

import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;

/**
 * JPA Specifications for Person entity to build dynamic queries.
 */
public final class PersonSpecification {

    /**
     * Private constructor to prevent instantiation.
     */
    private PersonSpecification() {
        // Utility class
    }

    /**
     * Specification to filter by person ID.
     *
     * @param personId the person ID to filter by
     * @return Specification for Person
     */
    public static Specification<Person> hasId(UUID personId) {
        return (root, query, criteriaBuilder) -> {
            if (personId == null) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("id"), personId);
        };
    }

    /**
     * Specification to filter by inverse functional identifier (ifi).
     *
     * @param ifi the inverse functional identifier to filter by
     * @return Specification for Person
     */
    public static Specification<Person> hasIfi(String ifi) {
        return (root, query, criteriaBuilder) -> {
            if (ifi == null || ifi.trim().isEmpty()) {
                return criteriaBuilder.conjunction();
            }

            Join<Person, Identity> identityJoin = root.join("identities",
                    JoinType.INNER);
            return criteriaBuilder.equal(identityJoin.get("ifi"), ifi);
        };
    }
}
