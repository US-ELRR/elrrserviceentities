package com.deloitte.elrr.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deloitte.elrr.entity.Goal;

@Repository
public interface GoalRepository extends JpaRepository<Goal, UUID> {

  /**
   * @param personId
   * @param goalId
   * @return Goal
   */
  Goal findByPersonIdAndGoalId(UUID personId, String goalId);

  /**
   * @param goalId
   * @return long
   */
  long deleteByGoalId(String goalId);

}
