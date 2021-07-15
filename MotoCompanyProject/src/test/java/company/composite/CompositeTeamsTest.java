package company.composite;

import company.model.MotoCompany;
import company.model.workers.FoodBarWorker;
import company.model.workers.OfficeWorker;
import company.model.workers.composite.CompositeElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CompositeTeamsTest {
    private MotoCompany motoCompany = new MotoCompany("MotoCompany");

    @Test
    public void addingTeamMembersToTeamLeader() {
        MotoCompany.hireWorkers(OfficeWorker.class, "Office", 5, motoCompany.getOfficeWorkerList());

        List<OfficeWorker> list = motoCompany.getOfficeWorkerList();
        CompositeElement headTeamLeader = list.get(0);

        headTeamLeader.Add(list.get(1));
        headTeamLeader.Add(list.get(2));

        CompositeElement secondTeamLeader = list.get(2);

        secondTeamLeader.Add(list.get(3));
        secondTeamLeader.Add(list.get(4));

        System.out.println("addingTeamMembersToTeamLeader Test");
        headTeamLeader.Display(3);

    }

    @Test
    public void removingTeamMembersFromTeam() {
        MotoCompany.hireWorkers(OfficeWorker.class, "Office", 5, motoCompany.getOfficeWorkerList());
        List<OfficeWorker> list = motoCompany.getOfficeWorkerList();
        CompositeElement headTeamLeader = list.get(0);

        headTeamLeader.Add(list.get(1));
        headTeamLeader.Add(list.get(2));

        CompositeElement secondTeamLeader = list.get(2);

        secondTeamLeader.Add(list.get(3));
        secondTeamLeader.Add(list.get(4));

        System.out.println("removingTeamMembersFromTeam Test");
        headTeamLeader.Display(3);

        System.out.println("After deleting worker 1 and 3");

        headTeamLeader.Remove(list.get(1));
        secondTeamLeader.Remove(list.get(3));

        headTeamLeader.Display(3);
        Assertions.assertEquals(headTeamLeader.getMemberList().stream().count(), 1);
        Assertions.assertEquals(secondTeamLeader.getMemberList().stream().count(), 1);

    }

    @Test
    public void tryingToRemoveNonExistingTeamMember() {
        MotoCompany.hireWorkers(OfficeWorker.class, "Office", 5, motoCompany.getOfficeWorkerList());
        List<OfficeWorker> list = motoCompany.getOfficeWorkerList();
        CompositeElement headTeamLeader = list.get(0);

        headTeamLeader.Add(list.get(1));
        headTeamLeader.Add(list.get(2));

        org.assertj.core.api.Assertions.assertThatThrownBy( () -> headTeamLeader.Remove(list.get(3)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void tryingToAddTeamMemberToForSureNotTeamLeader() {

        MotoCompany.hireWorkers(OfficeWorker.class, "Office", 5, motoCompany.getOfficeWorkerList());
        motoCompany.hireFoodBarWorkers(5);

        List<OfficeWorker> officeWorkerList = motoCompany.getOfficeWorkerList();
        CompositeElement headTeamLeader = officeWorkerList.get(0);

        List<FoodBarWorker> foodBarWorkerList = motoCompany.getFoodBarWorkerList();
        FoodBarWorker foodBarWorker = foodBarWorkerList.get(0);

        headTeamLeader.Add(officeWorkerList.get(1));
        headTeamLeader.Add(foodBarWorker);

        Assertions.assertEquals(headTeamLeader.getMemberList().stream().count(), 2);
        org.assertj.core.api.Assertions.assertThatThrownBy( () -> foodBarWorker.Add(foodBarWorkerList.get(2)))
                .isInstanceOf(RuntimeException.class);

        org.assertj.core.api.Assertions.assertThatThrownBy( () -> foodBarWorker.Remove(foodBarWorkerList.get(2)))
                .isInstanceOf(RuntimeException.class);

    }
}
