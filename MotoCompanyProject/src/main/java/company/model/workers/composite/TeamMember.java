package company.model.workers.composite;

import company.model.workers.IWorker;
import company.model.workers.Accountant;
import company.model.workers.visitiors.IVisitor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class TeamMember implements IWorker {

    protected Accountant accountantFollower;
    protected double income;
    protected int vacationDays;
    protected String name;

    public TeamMember(String name) {
        this.name = name;
        this.income = 2000;
        this.vacationDays = 15;
    }

    public abstract void Accept(IVisitor visitor);
    public abstract void Add(TeamMember teamMember);
    public abstract void Remove(TeamMember teamMember);
    public abstract void Display(int indent);
}
