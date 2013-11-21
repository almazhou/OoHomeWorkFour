import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ReporterTest {

    private ParkingLot boyParkingLot;
    private ParkingLot managerLot;
    private ParkingLot superManagerLot;
    private ParkingBoy boy;
    private ParkingBoy manager;
    private ParkingBoy superManager;

    @Before
    public void setUp() throws Exception {
        boy = new ParkingBoy(new NormalChooser());
        boyParkingLot = new ParkingLot(1, "ParkingLot");
        boy.manage(boyParkingLot);
        boy.manage(boyParkingLot);
        boy.setName("Boy");
        manager = new ParkingBoy(new NormalChooser());
        manager.manage(boy);
        managerLot = new ParkingLot(1, "ParkingLot");
        manager.manage(managerLot);
        manager.setName("Manager");
        superManager = new ParkingBoy(new NormalChooser());
        superManager.manage(manager);
        superManagerLot = new ParkingLot(1, "ParkingLot");
        superManager.manage(superManagerLot);
        superManager.setName("SuperManager");


    }

    @Test
    public void should_collect_information_from_all_lots() throws Exception {
        Reporter reporter = new Reporter();

        String report = reporter.report(superManager, 0, new StringBuilder());

        String treeReport = "SuperManager\n" +
                "--Manager\n" +
                "----Boy\n" +
                "------ParkingLot\n" +
                "------ParkingLot\n" +
                "----ParkingLot\n" +
                "--ParkingLot\n";
        assertThat(report,is(treeReport));
    }
}
