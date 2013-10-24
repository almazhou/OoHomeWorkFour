import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class ParkingBoy {
    private List<ParkingLot> parkingLotList;

    public ParkingBoy() {
        this.parkingLotList = new ArrayList<ParkingLot>();
    }

    public void manage(ParkingLot parkingLot) {
        this.parkingLotList.add(parkingLot);
    }

    public String park(Car car) {
        Collection<ParkingLot> filteredLot = Collections2.filter(parkingLotList, new Predicate<ParkingLot>() {
            @Override
            public boolean apply(ParkingLot lot) {
                return lot.getEmptyLotNum() > 0;
            }
        });

        return filteredLot.size() != 0 ? newArrayList(filteredLot).get(0).park(car) : null;
    }

    public boolean parkedThisCar(final Car car) {
        Collection<ParkingLot> filter = Collections2.filter(parkingLotList, new Predicate<ParkingLot>() {
            @Override
            public boolean apply(ParkingLot lot) {
                return lot.contains(car);
            }
        });
        return filter.size() != 0 ? true : false;
    }

    public Car takeCar(final String token) {
        Collection<ParkingLot> filter = Collections2.filter(parkingLotList, new Predicate<ParkingLot>() {
            @Override
            public boolean apply(ParkingLot lot) {
                return lot.takeCar(token) != null;
            }
        });

        return filter.size()!= 0 ? newArrayList(filter).get(0).takeCar(token):null;
    }
}
