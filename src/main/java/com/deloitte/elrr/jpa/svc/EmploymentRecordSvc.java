package com.deloitte.elrr.jpa.svc;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.deloitte.elrr.entity.EmploymentRecord;
import com.deloitte.elrr.repository.EmploymentRecordRepository;

@Service
public class EmploymentRecordSvc implements CommonSvc<EmploymentRecord, UUID> {
    /**
     *
     */
    private final EmploymentRecordRepository employmentRecordRepository;
    /**
     *
     * @param argsEmploymentRecordRepository
     */
    public EmploymentRecordSvc(
            final EmploymentRecordRepository argsEmploymentRecordRepository) {
        this.employmentRecordRepository = argsEmploymentRecordRepository;
    }
    /**
     *
     */
    @Override
    public CrudRepository<EmploymentRecord, UUID> getRepository() {
        return this.employmentRecordRepository;
    }
    /**
     *
     */
    @Override
    public UUID getId(final EmploymentRecord employmentRecord) {
        return employmentRecord.getId();
    }
    /**
     *
     */
    @Override
    public EmploymentRecord save(final EmploymentRecord employmentRecord) {
        return CommonSvc.super.save(employmentRecord);
    }

}
