import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ParkingManagerTest {

    private ParkingLot parkingLot1;
    private ParkingBoy parkingBoy;
    private ParkingLot parkingLot2;
    private ParkingManager manager;
    private Car car;

    @Before
    public void setUp() throws Exception {
        manager = new ParkingManager(new NormalChooser());
        parkingLot1 = new ParkingLot(1, "1");
        manager.manage(parkingLot1);
        parkingBoy = new ParkingBoy(new NormalChooser());
        parkingLot2 = new ParkingLot(1, "2");
        parkingBoy.manage(parkingLot2);
        manager.manageBoy(parkingBoy);
        car = new Car("car");

    }

    @Test
    public void should_ask_parking_boy_to_park_when_parking_boy_has_lot() throws Exception {
         manager.park(car);
        assertThat(parkingLot2.contains(car),is(true));
    }

    @Test
    public void should_park_by_himself_when_parking_boy_has_no_lot() throws Exception {
        manager.park(new Car("car"));
        manager.park(car);

        assertThat(parkingLot1.contains(car),is(true));
    }

    @Test
    public void should_get_car_by_token() throws Exception {
        String park = manager.park(car);
        Car car1 = manager.takeCar(park);

        assertThat(car1,sameInstance(car));
    }
}
