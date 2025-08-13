package com.deloitte.elrr.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedNativeQuery;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("CREDENTIAL")
@NamedNativeQuery(
    name = "Credential.findCredentialsWithFilters",
    query =
    """
    SELECT DISTINCT q.* FROM {h-schema}qualification q
    WHERE q.type = 'CREDENTIAL'
    -- by ID
    AND (CAST(:id AS uuid[]) IS NULL OR q.id = ANY(:id))
    -- by presence of (all) extension keys
    AND (CAST(:hasExtension AS text[]) IS NULL OR
        q.extensions \\?\\?& CAST(:hasExtension AS text[]))
    -- by returning items from all jsonpath queries
    AND (CAST(:extensionPath AS text[]) IS NULL OR
        (SELECT bool_and(q.extensions @\\?\\? path::jsonpath)
         FROM unnest(CAST(:extensionPath AS text[])) AS path))
    -- by returning items from all jsonpath predicates
    AND (CAST(:extensionPathMatch AS text[]) IS NULL OR
        (SELECT bool_and(q.extensions @@ path::jsonpath)
         FROM unnest(CAST(:extensionPathMatch AS text[])) AS path))
    AND (CAST(:identifier AS text[]) IS NULL OR
        q.identifier ILIKE ANY(CAST(:identifier AS text[])))
    AND (CAST(:identifierUrl AS text[]) IS NULL OR
        q.identifier_url = ANY(CAST(:identifierUrl AS text[])))
    """,
    resultClass = Credential.class
)
@Getter
@Setter
public class Credential extends AbstractQualification {
    @Getter
    @Setter
    public static class Filter extends AbstractQualification.Filter { }
}
