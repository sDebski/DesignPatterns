package company.model.workers.visitiors;

import company.model.workers.IWorker;
import company.model.workers.composite.TeamMember;

public interface IVisitor {
    void Visit(TeamMember worker);
}
