import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class ParkingBoy {
    protected List<ParkingLot> parkingLotList;

    public ParkingBoy() {
        this.parkingLotList = new ArrayList<ParkingLot>();
    }

    public void manage(ParkingLot parkingLot) {
        this.parkingLotList.add(parkingLot);
    }

    public String park(Car car) {
        List<ParkingLot> sortedList = parkingLotList;
        ParkingLot lot = new NormalChooser().choose(sortedList);
        return lot != null ? lot.park(car) : null;
    }
    class NormalChooser{
        public ParkingLot choose(List<ParkingLot> sortedList) {
            Collection<ParkingLot> filteredLot = Collections2.filter(sortedList, new Predicate<ParkingLot>() {
                @Override
                public boolean apply(ParkingLot lot) {
                    return lot.getEmptyLotNum() > 0;
                }
            });
            ParkingLot lot = null;
            if (!filteredLot.isEmpty()) {
                lot = newArrayList(filteredLot).get(0);
            }
            return lot;
        }
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

        return filter.size() != 0 ? newArrayList(filter).get(0).takeCar(token) : null;
    }
}
