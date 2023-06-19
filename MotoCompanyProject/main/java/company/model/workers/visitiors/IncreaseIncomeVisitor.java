package company.model.workers.visitiors;

import company.model.workers.IWorker;
import company.model.workers.composite.TeamMember;

public class IncreaseIncomeVisitor implements IVisitor {
    @Override
    public void Visit(TeamMember worker) {
        Double income = worker.getIncome();

        worker.setIncome(income * 1.1);
    }
}
