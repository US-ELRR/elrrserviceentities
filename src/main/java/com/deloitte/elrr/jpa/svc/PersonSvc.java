/**
 *
 */
package com.deloitte.elrr.jpa.svc;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.deloitte.elrr.entity.Person;
import com.deloitte.elrr.repository.PersonRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * @author mnelakurti
 *
 */

@Service @Slf4j
public class PersonSvc implements CommonSvc<Person, UUID> {

    private final PersonRepository personRepository;

    @Autowired
    private LocationSvc locationSvc;

    /**
     *
     * @param argsPersonRepository
     */
    public PersonSvc(final PersonRepository argsPersonRepository) {
        this.personRepository = argsPersonRepository;
    }

    /**
     *
     * @return CrudRepository<Person, Long>
     */
    @Override
    public CrudRepository<Person, UUID> getRepository() {
        return this.personRepository;
    }

    /**
     *
     * @return Long
     */
    @Override
    public UUID getId(final Person person) {
        return person.getId();
    }

    /**
     *
     * @return Person
     */
    @Override
    public Person save(final Person person) {
        if (person.getMailingAddress() != null) {
            person.setMailingAddress(
                    locationSvc.save(person.getMailingAddress()));
        }
        return CommonSvc.super.save(person);
    }

    /**
     * Find persons with optional id and ifi filters.
     *
     * @param id Optional person ID filter
     * @param ifi Optional IFI (Inverse Functional Identifier) filter
     * @param organizationId Optional organization ID filter
     * @param organizationRelType Optional organization relationship type filter
     * @param hasExtension Optional filter for extension keys
     * @return List of persons matching the criteria
     */
    public List<Person> findPersonsWithFilters(final UUID id, final String ifi,
            final UUID organizationId, final String organizationRelType,
            final List<String> hasExtension) {

        // Convert hasExtension to Stringp[] for the query
        String[] hasExtensionArray = hasExtension != null
                ? hasExtension.toArray(new String[0])
                : null;
        return personRepository.findPersonsWithFilters(id, ifi, organizationId,
                organizationRelType, hasExtensionArray);
    }
}
