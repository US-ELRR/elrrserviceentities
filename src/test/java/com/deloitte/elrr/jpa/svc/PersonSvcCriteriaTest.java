package com.deloitte.elrr.jpa.svc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.jpa.domain.Specification;

import com.deloitte.elrr.entity.Person;
import com.deloitte.elrr.repository.PersonRepository;

@ExtendWith(MockitoExtension.class)
public class PersonSvcCriteriaTest {

    @Mock
    private PersonRepository personRepository;

    @Mock
    private LocationSvc locationSvc;

    @InjectMocks
    private PersonSvc personSvc;

    @Test
    void testFindPersonsWithNoCriteria() {
        // Arrange
        Person person1 = new Person();
        person1.setId(UUID.randomUUID());
        Person person2 = new Person();
        person2.setId(UUID.randomUUID());
        
        List<Person> expectedPersons = Arrays.asList(person1, person2);
        
        when(personRepository.findAll(ArgumentMatchers.<Specification<Person>>any())).thenReturn(expectedPersons);

        // Act
        List<Person> result = personSvc.findPersons(null, null);

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    void testFindPersonsWithPersonId() {
        // Arrange
        UUID testPersonId = UUID.randomUUID();
        Person person = new Person();
        person.setId(testPersonId);
        
        List<Person> expectedPersons = Arrays.asList(person);
        
        when(personRepository.findAll(ArgumentMatchers.<Specification<Person>>any())).thenReturn(expectedPersons);

        // Act
        List<Person> result = personSvc.findPersons(testPersonId, null);

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(testPersonId, result.get(0).getId());
    }

    @Test
    void testFindPersonsWithIfi() {
        // Arrange
        String testIfi = "test@example.com";
        Person person = new Person();
        person.setId(UUID.randomUUID());
        
        List<Person> expectedPersons = Arrays.asList(person);
        
        when(personRepository.findAll(ArgumentMatchers.<Specification<Person>>any())).thenReturn(expectedPersons);

        // Act
        List<Person> result = personSvc.findPersons(null, testIfi);

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
    }
}
