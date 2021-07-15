package company.model.workers.composite;
import company.model.workers.visitiors.IVisitor;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CompositeElement extends TeamMember {
    private List<TeamMember> memberList;


    public CompositeElement(String name) {
        super(name);
        memberList = new ArrayList<>();
    }

    @Override
    public void Accept(IVisitor visitor) {
        visitor.Visit(this);

        if(this.name.toLowerCase().contains("office")) {
            this.accountantFollower.update(this , "office");
        }
        else if(this.name.toLowerCase().contains("foodbar")) {
            this.accountantFollower.update(this, "foodbar");
        }
        else if(this.name.toLowerCase().contains("factory")) {
            this.accountantFollower.update(this, "factory");
        }
        else throw new RuntimeException("No changes after Visitor`s visit");
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
