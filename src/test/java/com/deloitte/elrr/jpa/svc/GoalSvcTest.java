package com.deloitte.elrr.jpa.svc;

import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.deloitte.elrr.entity.Goal;
import com.deloitte.elrr.entity.types.GoalType;
import com.deloitte.elrr.entity.Competency;
import com.deloitte.elrr.jpa.svc.GoalSvc;
import com.deloitte.elrr.repository.GoalRepository;

@ExtendWith(MockitoExtension.class)
public class GoalSvcTest {

    @Mock
    private GoalRepository goalRepository;

    @InjectMocks
    private GoalSvc goalSvc;

    private static UUID goalId = UUID.randomUUID();

    @Test
    void saveTest() {
        Goal goal = new Goal();
        goal.setId(goalId);
        goal.setName("Test Goal");
        goal.setDescription("This is a test goal.");
        goal.setType(GoalType.SELF);

        goalSvc.save(goal);
    }   

}