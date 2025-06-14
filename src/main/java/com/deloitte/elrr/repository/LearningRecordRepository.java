package com.deloitte.elrr.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deloitte.elrr.entity.LearningRecord;

@Repository
public interface LearningRecordRepository extends JpaRepository<LearningRecord,
        UUID> {

    /**
     * @param personId
     * @param learningResourceId
     * @return LearningRecord
     */
    LearningRecord findByPersonIdAndLearningResourceId(UUID personId,
            UUID learningResourceId);
}
