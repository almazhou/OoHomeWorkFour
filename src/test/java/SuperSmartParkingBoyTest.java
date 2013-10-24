import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SuperSmartParkingBoyTest {

    private SuperSmartParkingBoy superSmartParkingBoy;
    private ParkingLot parkingLot1;
    private ParkingLot parkingLot;
    private Car car;
    private Car car1;
    private Car car2;

    @Before
    public void setUp() throws Exception {
        parkingLot = new ParkingLot(2, "1");
        parkingLot1 = new ParkingLot(4, "2");
        superSmartParkingBoy = new SuperSmartParkingBoy(new SuperChooser());
        superSmartParkingBoy.manage(parkingLot);
        superSmartParkingBoy.manage(parkingLot1);
        car = new Car("0");
        car1 = new Car("1");
        car2 = new Car("2");
    }

    @Test
    public void should_park_car_to_parking_lot_with_lower_ratio() throws Exception {
        parkingLot1.park(car1);
        parkingLot.park(car2);
        superSmartParkingBoy.park(car);
        assertThat(parkingLot1.getEmptyLotNum(),is(2));
    }
}
