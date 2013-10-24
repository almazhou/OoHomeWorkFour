import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ParkingBoyTest {

    private ParkingBoy parkingBoy;
    private Car car2;
    private Car car1;
    private Car car;
    private ParkingLot parkingLot;
    private ParkingLot parkingLot1;

    @Before
    public void setUp() throws Exception {
        parkingLot = new ParkingLot(1, "1");
        parkingLot1 = new ParkingLot(1, "2");
        parkingBoy = new ParkingBoy(new NormalChooser());
        parkingBoy.manage(parkingLot);
        parkingBoy.manage(parkingLot1);
        car = new Car("0");
        car1 = new Car("1");
        car2 = new Car("2");
    }

    @Test
    public void should_park_car_when_has_location() throws Exception {
        parkingBoy.park(car);

        assertThat(parkingBoy.parkedThisCar(car),is(true));
    }

    @Test
    public void should_not_park_car_when_has_no_location() throws Exception {
        parkingBoy.park(car);
        parkingBoy.park(car1);
        parkingBoy.park(car2);

        assertThat(parkingBoy.parkedThisCar(car2),is(false));
    }

    @Test
    public void should_get_car_when_has_right_token() throws Exception {
        String token = parkingBoy.park(car);
        Car car3 = parkingBoy.takeCar(token);

        assertThat(car3,is(car));
    }

    @Test
    public void should_not_get_car_when_has_wrong_token() throws Exception {
        String token = parkingBoy.park(car2);

        assertThat(parkingBoy.takeCar("m"+token),nullValue());
    }
}
