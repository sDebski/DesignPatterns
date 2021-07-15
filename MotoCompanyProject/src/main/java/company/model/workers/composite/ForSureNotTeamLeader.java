package company.model.workers.composite;

import company.model.workers.visitiors.IVisitor;
import org.apache.commons.lang.StringUtils;

public class ForSureNotTeamLeader extends TeamMember {

    @Override
    public void Accept(IVisitor visitor) {visitor.Visit(this);

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

    public ForSureNotTeamLeader(String name) {
        super(name);
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
