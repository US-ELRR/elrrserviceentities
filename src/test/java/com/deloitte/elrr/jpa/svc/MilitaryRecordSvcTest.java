package com.deloitte.elrr.jpa.svc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.deloitte.elrr.entity.MilitaryRecord;
import com.deloitte.elrr.repository.MilitaryRecordRepository;
import com.google.common.collect.Iterables;

@ExtendWith(MockitoExtension.class)
public class MilitaryRecordSvcTest {

    @Mock
    private MilitaryRecordRepository militaryRecordRepository;

    @InjectMocks
    private MilitaryRecordSvc militaryRecordSvc;

    private static UUID militaryRecordId = UUID.randomUUID();

    @Test
    void findAllTest() {
        Mockito.doReturn(getTestMilitaryRecords())
            .when(militaryRecordRepository).findAll();
        Iterable<MilitaryRecord> militaryRecords =
            militaryRecordSvc.findAll();
        assertEquals(Iterables.size(militaryRecords), 1);
    }

    @Test
    void getTest() {
        Mockito.doReturn(Optional.of(getTestMilitaryRecord()))
                .when(militaryRecordRepository).findById(militaryRecordId);
        MilitaryRecord militaryRecord = militaryRecordSvc
            .get(militaryRecordId).orElse(null);
        assertEquals(militaryRecord.getId(), militaryRecordId);
    }

    @Test
    void saveTest() {
        militaryRecordSvc.save(getTestMilitaryRecord());
    }

    @Test
    void saveAllTest() {
        militaryRecordSvc.saveAll(getTestMilitaryRecords());
    }

    @Test
    void deleteTest() {
        Mockito.doReturn(true).when(militaryRecordRepository)
                .existsById(militaryRecordId);
        militaryRecordSvc.delete(militaryRecordId);
    }

    @Test
    void deleteAllTest() {
        militaryRecordSvc.deleteAll();
    }

    @Test
    void updateTest() {
        Mockito.doReturn(true).when(militaryRecordRepository)
                .existsById(militaryRecordId);
        militaryRecordSvc.update(getTestMilitaryRecord());
    }

    @Test
    void getIdTest() {
        assertEquals(militaryRecordSvc.getId(getTestMilitaryRecord()),
            militaryRecordId);
    }

    @Test
    void getRepository() {
        assertEquals(militaryRecordSvc.getRepository(),
            militaryRecordRepository);
    }

    private MilitaryRecord getTestMilitaryRecord() {
        MilitaryRecord militaryRecord = new MilitaryRecord();
        militaryRecord.setId(militaryRecordId);
        return militaryRecord;
    }

    private Iterable<MilitaryRecord> getTestMilitaryRecords() {
        ArrayList<MilitaryRecord> militaryRecords =
            new ArrayList<MilitaryRecord>();
        militaryRecords.add(getTestMilitaryRecord());
        return militaryRecords;
   }

}
