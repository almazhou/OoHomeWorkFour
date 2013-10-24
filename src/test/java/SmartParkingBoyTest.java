import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SmartParkingBoyTest {

    private SmartParkingBoy smartParkingBoy;
    private ParkingLot parkingLot1;
    private ParkingLot parkingLot;
    private Car car;
    private Car car1;
    private Car car2;

    @Before
    public void setUp() throws Exception {
        parkingLot = new ParkingLot(1, "1");
        parkingLot1 = new ParkingLot(3, "2");
        smartParkingBoy = new SmartParkingBoy();
        smartParkingBoy.manage(parkingLot);
        smartParkingBoy.manage(parkingLot1);
        car = new Car("0");
        car1 = new Car("1");
        car2 = new Car("2");
    }

    @Test
    public void should_park_car_in_parking_lot_with_more_empty_location() throws Exception {
        smartParkingBoy.park(car);

        assertThat(parkingLot1.getEmptyLotNum(),is(2));
    }


}
