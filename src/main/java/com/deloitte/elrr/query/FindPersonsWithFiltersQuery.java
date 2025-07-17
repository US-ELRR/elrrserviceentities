package com.deloitte.elrr.query;

public final class FindPersonsWithFiltersQuery {

    private FindPersonsWithFiltersQuery() {
        // Utility class - prevent instantiation
    }

    public static final String QUERY =
    """
            SELECT DISTINCT p FROM Person p
            LEFT JOIN p.identities i
            LEFT JOIN p.associations a
            LEFT JOIN p.employmentRecords er
            WHERE (:id IS NULL OR p.id = :id)
            AND (:ifi IS NULL OR i.ifi = :ifi)
            AND (:organizationId IS NULL OR
                ((:organizationRelType IS NULL OR
                  :organizationRelType = 'Association')
                 AND a.organization.id = :organizationId)
                OR (:organizationRelType = 'Employment'
                    AND er.employerOrganization.id = :organizationId))
            """;
}
