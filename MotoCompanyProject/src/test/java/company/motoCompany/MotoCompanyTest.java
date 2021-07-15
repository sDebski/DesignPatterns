package company.motoCompany;

import company.model.MotoCompany;
import company.model.workers.OfficeWorker;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class MotoCompanyTest {

    @Test
    public void addingWorkersWithGenericStaticMethod() {
        MotoCompany motoCompany = new MotoCompany("MotoCompany");

        MotoCompany.hireWorkers(OfficeWorker.class, "Office", 5, motoCompany.getOfficeWorkerList() );
        System.out.println(motoCompany.getOfficeWorkerList());

        Assert.assertEquals(motoCompany.getOfficeWorkerList().size(), 5);
    }

    @Test
    public void checkIfPresidentIsOnlyOneCauseOfSingletonConstruction () {

        //TO DO
    }
}
