package company.model.workers.composite.decorators;

import company.model.workers.composite.TeamMember;
import company.model.workers.visitiors.IVisitor;
import org.apache.commons.lang.StringUtils;

public class RemoveTeamLeadingDecorator extends TeamMemberDecorator {

    public RemoveTeamLeadingDecorator(TeamMember teamMember) {
        super(teamMember);
    }

    @Override
    public void Accept(IVisitor visitor) {
        visitor.Visit(this);
    }

    @Override
    public void Add(TeamMember teamMember) {
        throw new RuntimeException("Can not add team member to NotTeamLeader");
    }

    @Override
    public void Remove(TeamMember teamMember) {
        throw new RuntimeException("NotTeamLeader does not have any team members");
    }

    @Override
    public void Display(int indent) {
        System.out.println(StringUtils.repeat("-", 3) + "  " + this.name);    }
}
