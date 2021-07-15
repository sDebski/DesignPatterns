package company.visitorAndObserver;

import company.model.MotoCompany;
import company.model.workers.Accountant;
import company.model.workers.FactoryWorker;
import company.model.workers.OfficeWorker;
import company.model.workers.composite.CompositeElement;
import company.model.workers.visitiors.IncreaseIncomeVisitor;
import company.model.workers.visitiors.TakeBackVacationVisitor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class visitorAndObserver {

    @Test
    public void checkIfObjectAcceptVisitor() {
        MotoCompany motoCompany = new MotoCompany("MotoCompany");
        Accountant accountant = new Accountant("Accountant");

        motoCompany.hireWorkers(OfficeWorker.class, "Office", 5, motoCompany.getOfficeWorkerList());

        for (CompositeElement ow: motoCompany.getOfficeWorkerList()) {
            ow.setAccountantFollower(accountant);
        }

        IncreaseIncomeVisitor iiv = new IncreaseIncomeVisitor();

        CompositeElement ow = motoCompany.getOfficeWorkerList().get(0);

        ow.Accept(iiv);

        Assertions.assertEquals(ow.getIncome(), 2000 * 1.1);

    }

    @Test
    public void checkIfAccountantSeeChangesOnOneVisitorActionOnOfficeWorker() {
        MotoCompany motoCompany = new MotoCompany("MotoCompany");
        Accountant accountant = new Accountant("Accountant");

        motoCompany.hireWorkers(OfficeWorker.class, "Office", 5, motoCompany.getOfficeWorkerList());

        for (CompositeElement ow: motoCompany.getOfficeWorkerList()) {
            ow.setAccountantFollower(accountant);
        }

        accountant.AddWorkersToLists(motoCompany.getOfficeWorkerList(), "office");

        Assertions.assertEquals(accountant.getOfficeWorkersMap().containsKey("officeworker0"), true);
        Assertions.assertEquals(accountant.getOfficeWorkersMap().get("officeworker0").getIncome(), 2000);



    }

    @Test
    public void seeIfAccountantSeeChangesOnManyFactoryWorkers() {
        MotoCompany motoCompany = new MotoCompany("MotoCompany");
        Accountant accountant = new Accountant("Accountant");

        motoCompany.hireWorkers(FactoryWorker.class, "Factory", 5, motoCompany.getFactoryWorkerList());

        for (CompositeElement fw: motoCompany.getFactoryWorkerList()) {
            fw.setAccountantFollower(accountant);
        }

        accountant.AddWorkersToLists(motoCompany.getFactoryWorkerList(), "factory");

        IncreaseIncomeVisitor iiv = new IncreaseIncomeVisitor();
        TakeBackVacationVisitor takeBackVacationVisitor = new TakeBackVacationVisitor();

        for (CompositeElement fw: motoCompany.getFactoryWorkerList()) {
            fw.Accept(iiv);
            fw.Accept(takeBackVacationVisitor);
        }

        for (CompositeElement fw: motoCompany.getFactoryWorkerList()) {
            Assertions.assertEquals(accountant.getFactoryWorkerMap().get(fw.getName()).getIncome(), 2000 * 1.1);
            Assertions.assertEquals(accountant.getFactoryWorkerMap().get(fw.getName()).getVacationDays(), 15 - 3);
        }
    }
}
