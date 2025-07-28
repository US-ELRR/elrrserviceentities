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

@Service
@Slf4j
@SuppressWarnings("checkstyle:ParameterNumber")
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
        if (person.getPhysicalAddress() != null) {
            person.setPhysicalAddress(
                    locationSvc.save(person.getPhysicalAddress()));
        }
        if (person.getShippingAddress() != null) {
            person.setShippingAddress(
                    locationSvc.save(person.getShippingAddress()));
        }
        if (person.getBillingAddress() != null) {
            person.setBillingAddress(
                    locationSvc.save(person.getBillingAddress()));
        }
        if (person.getOnCampusAddress() != null) {
            person.setOnCampusAddress(
                    locationSvc.save(person.getOnCampusAddress()));
        }
        if (person.getOffCampusAddress() != null) {
            person.setOffCampusAddress(
                    locationSvc.save(person.getOffCampusAddress()));
        }
        if (person.getTemporaryAddress() != null) {
            person.setTemporaryAddress(
                    locationSvc.save(person.getTemporaryAddress()));
        }
        if (person.getPermanentStudentAddress() != null) {
            person.setPermanentStudentAddress(
                    locationSvc.save(person.getPermanentStudentAddress()));
        }
        if (person.getEmploymentAddress() != null) {
            person.setEmploymentAddress(
                    locationSvc.save(person.getEmploymentAddress()));
        }
        if (person.getTimeOfAdmissionAddress() != null) {
            person.setTimeOfAdmissionAddress(
                    locationSvc.save(person.getTimeOfAdmissionAddress()));
        }
        if (person.getFatherAddress() != null) {
            person.setFatherAddress(
                    locationSvc.save(person.getFatherAddress()));
        }
        if (person.getMotherAddress() != null) {
            person.setMotherAddress(
                    locationSvc.save(person.getMotherAddress()));
        }
        if (person.getGuardianAddress() != null) {
            person.setGuardianAddress(
                    locationSvc.save(person.getGuardianAddress()));
        }
        if (person.getBirthplaceAddress() != null) {
            person.setBirthplaceAddress(
                    locationSvc.save(person.getBirthplaceAddress()));
        }
        return CommonSvc.super.save(person);
    }

    /**
     * Find persons with optional id and ifi filters.
     *
     * @param id Optional person ID filter
     * @param ifi Optional IFI (Inverse Functional Identifier) filter
     * @param associatedOrgId Optional associated organization ID filter
     * @param employerOrgId Optional employer organization ID filter
     * @param hasExtension Optional filter for extension keys
     * @param extensionPath Optional filter for JSONPath expressions
     * @param extensionPathMatch Optional filter for JSONPath predicates
     * @param name Optional name search filter
     * @param locationId Optional location ID filter for any location field
     * @return List of persons matching the criteria
     */
    public List<Person> findPersonsWithFilters(
        final UUID[] id,
        final String[] ifi,
        final UUID[] associatedOrgId,
        final UUID[] employerOrgId,
        final String[] hasExtension,
        final String[] extensionPath,
        final String[] extensionPathMatch,
        final String[] name,
        final UUID[] locationId) {

        return personRepository.findPersonsWithFilters(id, ifi, associatedOrgId,
                employerOrgId, hasExtension,
                extensionPath, extensionPathMatch, name, locationId);
    }
}
