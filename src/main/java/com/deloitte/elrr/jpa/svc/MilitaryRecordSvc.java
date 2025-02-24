package com.deloitte.elrr.jpa.svc;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.deloitte.elrr.entity.MilitaryRecord;
import com.deloitte.elrr.repository.MilitaryRecordRepository;

@Service
public class MilitaryRecordSvc implements CommonSvc<MilitaryRecord, UUID> {
    /**
     *
     */
    private final MilitaryRecordRepository militaryRecordRepository;
    /**
     *
     * @param argsMilitaryRecordRepository
     */
    public MilitaryRecordSvc(
            final MilitaryRecordRepository argsMilitaryRecordRepository) {
        this.militaryRecordRepository = argsMilitaryRecordRepository;
    }
    /**
     *
     */
    @Override
    public CrudRepository<MilitaryRecord, UUID> getRepository() {
        return this.militaryRecordRepository;
    }
    /**
     *
     */
    @Override
    public UUID getId(final MilitaryRecord militaryRecord) {
        return militaryRecord.getId();
    }
    /**
     *
     */
    @Override
    public MilitaryRecord save(final MilitaryRecord militaryRecord) {
        return CommonSvc.super.save(militaryRecord);
    }

}
