package company.model.workers.visitiors;

import company.model.workers.composite.TeamMember;

public class LowerIncomeVisitor implements IVisitor {

    @Override
    public void Visit(TeamMember worker) {
        double income = worker.getIncome();

        worker.setIncome(income * 0.9);
    }
}
