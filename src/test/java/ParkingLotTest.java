import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ParkingLotTest {

    private ParkingLot lot;
    private Car car;

    @Before
    public void setUp() throws Exception {
        lot = new ParkingLot(1, "1");
        car = new Car("0");

    }

    @Test
    public void should_park_car_in_when_parking_lot_is_not_full() throws Exception {
        lot.park(car);

        assertThat(lot.getEmptyLotNum(),is(0));
    }

    @Test
    public void should_not_park_car_when_parking_lot_is_full() throws Exception {
        lot.park(new Car("m"));
        lot.park(car);

        assertThat(lot.contains(car),is(false));
    }

    @Test
    public void should_get_car_with_token() throws Exception {
        String token = lot.park(car);

        assertThat(lot.takeCar(token),is(car));
    }

    @Test
    public void should_not_get_car_with_wrong_token() throws Exception {
        String token = lot.park(car);

        assertThat(lot.takeCar("m"+token),nullValue());
    }
}
