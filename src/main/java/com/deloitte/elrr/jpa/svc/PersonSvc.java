/**
 *
 */
package com.deloitte.elrr.jpa.svc;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.deloitte.elrr.entity.Person;
import com.deloitte.elrr.repository.PersonRepository;
import com.deloitte.elrr.specification.PersonSpecification;

import lombok.extern.slf4j.Slf4j;

/**
 * @author mnelakurti
 *
 */

@Service
@Slf4j
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
            person.setMailingAddress(locationSvc.save(person
                    .getMailingAddress()));
        }
        return CommonSvc.super.save(person);
    }

    /**
     * Find persons using dynamic criteria.
     *
     * @param personId the person ID to filter by (optional)
     * @param ifi the inverse functional identifier to filter by (optional)
     * @return List of Person entities matching the criteria
     */
    public List<Person> findPersons(UUID personId, String ifi) {
        Specification<Person> spec = Specification.where(null);

        if (personId != null) {
            spec = spec.and(PersonSpecification.hasId(personId));
        }

        if (ifi != null && !ifi.trim().isEmpty()) {
            spec = spec.and(PersonSpecification.hasIfi(ifi));
        }

        return personRepository.findAll(spec);
    }

}
