package company.model.workers.visitiors;

import company.model.workers.composite.TeamMember;

public class GiveVacationVisitor implements IVisitor {
    @Override
    public void Visit(TeamMember worker) {
        int vacationDays = worker.getVacationDays();

        worker.setVacationDays(vacationDays + 3);
    }
}
