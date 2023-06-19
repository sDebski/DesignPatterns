package company.composite;

import company.model.workers.OfficeWorker;
import company.model.workers.composite.CompositeElement;
import company.model.workers.composite.ForSureNotTeamLeader;
import company.model.workers.composite.decorators.AddTeamLeadingDecorator;
import company.model.workers.composite.decorators.RemoveTeamLeadingDecorator;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class DecoratorOnComposite {

    @Test
    public void ChangingForSureNotTeamLeaderForTeamLeaderWithDecorator() {
        ForSureNotTeamLeader forSureNotTeamLeader = new ForSureNotTeamLeader("ForSureNotTeamLeader");

        AddTeamLeadingDecorator teamLeadingDecorator = new AddTeamLeadingDecorator(forSureNotTeamLeader);

        Assertions.assertThat(teamLeadingDecorator).isNotNull();
    }

    @Test
    public void AddingTeamMembersToForSureNotTeamLeaderBeforeDecoration() {
        ForSureNotTeamLeader forSureNotTeamLeader = new ForSureNotTeamLeader("ForSureNotTeamLeader");
        OfficeWorker officeWorker = new OfficeWorker("OfficeWorker");

        Assertions.assertThatThrownBy( () -> forSureNotTeamLeader.Add(officeWorker))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void AddingTeamMembersToForSureNotTeamLeaderAfterDecorations() {
        ForSureNotTeamLeader forSureNotTeamLeader = new ForSureNotTeamLeader("ForSureNotTeamLeader");
        OfficeWorker officeWorker = new OfficeWorker("OfficeWorker");
        OfficeWorker officeWorker1 = new OfficeWorker("OfficeWorker1");
        OfficeWorker officeWorker2 = new OfficeWorker("OfficeWorker2");

        AddTeamLeadingDecorator teamLeadingDecorator = new AddTeamLeadingDecorator(forSureNotTeamLeader);

        teamLeadingDecorator.Add(officeWorker);
        teamLeadingDecorator.Add(officeWorker1);
        officeWorker1.Add(officeWorker2);

        teamLeadingDecorator.Display(3);
        Assert.assertEquals(teamLeadingDecorator.getMemberList().stream().count(), 2);
    }

    @Test
    public void ChangingTeamLeaderIntoForSureNotTeamLeaderWithDecorator() {
        CompositeElement compositeElement = new CompositeElement("compositeElement");

        RemoveTeamLeadingDecorator removeTeamLeadingDecorator = new RemoveTeamLeadingDecorator(compositeElement);

        Assertions.assertThat(removeTeamLeadingDecorator).isNotNull();
    }

    @Test
    public void AddingTeamMembersToTeamLeaderBeforeDecoration() {
        CompositeElement compositeElement = new CompositeElement("compositeElement");
        OfficeWorker officeWorker = new OfficeWorker("OfficeWorker");

        compositeElement.Add(officeWorker);


        Assert.assertEquals(compositeElement.getMemberList().stream().count(), 1);
    }

    @Test
    public void AddingTeamMembersToNotTeamLeaderAfterDecorations() {
        CompositeElement compositeElement = new CompositeElement("compositeElement");
        OfficeWorker officeWorker = new OfficeWorker("OfficeWorker");

        RemoveTeamLeadingDecorator removeTeamLeadingDecorator = new RemoveTeamLeadingDecorator(compositeElement);

        Assertions.assertThatThrownBy( () -> removeTeamLeadingDecorator.Add(officeWorker))
                .isInstanceOf(RuntimeException.class);
    }
}
