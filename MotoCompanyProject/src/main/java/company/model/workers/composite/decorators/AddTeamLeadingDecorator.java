package company.model.workers.composite.decorators;

import company.model.workers.composite.TeamMember;
import company.model.workers.visitiors.IVisitor;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class AddTeamLeadingDecorator extends TeamMemberDecorator {
    private List<TeamMember> memberList;

    public AddTeamLeadingDecorator(TeamMember teamMember) {
        super(teamMember);
        memberList = new ArrayList<>();
    }

    @Override
    public void Accept(IVisitor visitor) {
        visitor.Visit(this);
    }

    @Override
    public void Add(TeamMember teamMember) {
        memberList.add(teamMember);
    }

    @Override
    public void Remove(TeamMember teamMember) {
        if( !memberList.contains(teamMember)) {
            throw new IllegalArgumentException("There is no teamMember in this person`s team");
        }
        memberList.remove(teamMember);
    }

    @Override
    public void Display(int indent) {
        System.out.println(StringUtils.repeat("-", indent) + "  " + this.name);
        for ( TeamMember tm: memberList) {
            tm.Display(indent + 3);
        }
    }
}
