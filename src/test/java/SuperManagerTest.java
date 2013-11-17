import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SuperManagerTest {

    private ParkingBoy superManager;
    private ParkingLot parkingLot1;
    private Parkable parkingManager;
    private ParkingLot parkingLot2;
    private Car car;

    @Before
    public void setUp() throws Exception {
        superManager = new ParkingBoy(new NormalChooser());
        parkingLot1 = new ParkingLot(1, "ddd");
        superManager.manage(parkingLot1);
        parkingManager = new ParkingBoy(new NormalChooser());
        parkingLot2 = new ParkingLot(1, "manager");
        parkingManager.manage(parkingLot2);
        superManager.manage(parkingManager);
        car = new Car("newVar");

    }

    @Test
    @Ignore
    public void should_ask_parking_manager_to_park() throws Exception {
        superManager.park(car);
        assertThat(parkingLot2.getEmptyLotNum(),is(0));
    }

    @Test
    public void should_park_by_him_self_when_parking_manager_is_full() throws Exception {
        superManager.park(new Car("lsls"));
        superManager.park(car);

        assertThat(parkingLot1.getEmptyLotNum(),is(0));
    }

    @Test
    public void should_take_car_by_right_token() throws Exception {
        String park = superManager.park(car);
        Car car1 = superManager.takeCar(park);

        assertThat(car1,sameInstance(car));
    }
}
