package com.deloitte.elrr.jpa.svc;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.deloitte.elrr.entity.Goal;
import com.deloitte.elrr.repository.GoalRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GoalSvc implements CommonSvc<Goal, UUID> {

    private final GoalRepository goalRepository;

    /**
     * @param argsGoalRepository
     */
    public GoalSvc(final GoalRepository argsGoalRepository) {
        this.goalRepository = argsGoalRepository;
    }

    @Override
    public CrudRepository<Goal, UUID> getRepository() {
        return this.goalRepository;
    }

    @Override
    public UUID getId(final Goal goal) {
        return goal.getId();
    }

    @Override
    public Goal save(final Goal goal) {
        return CommonSvc.super.save(goal);
    }

}
