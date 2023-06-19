package company.model.workers.composite.decorators;

import company.factory.AbstractFactory;
import company.model.workers.composite.ForSureNotTeamLeader;
import company.model.workers.composite.TeamMember;

public abstract class TeamMemberDecorator extends TeamMember {
    protected TeamMember teamMember;

    protected TeamMemberDecorator(TeamMember teamMember) {
        super(teamMember.getName());
        this.teamMember = teamMember;
    }
}
