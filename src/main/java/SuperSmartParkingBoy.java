import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SuperSmartParkingBoy extends ParkingBoy {
    @Override
    public String park(Car car) {
        List<ParkingLot> sortingList = parkingLotList;
        ParkingLot min = new SuperChooser().choose1(sortingList);
        return min != null? min.park(car) : null;
    }

    class SuperChooser{
        public ParkingLot choose1(List<ParkingLot> sortingList) {
            return Collections.min(sortingList, new Comparator<ParkingLot>() {
                @Override
                public int compare(ParkingLot lot, ParkingLot lot2) {
                    if (lot.getRatio() != lot2.getRatio()) {
                        return lot.getRatio() > lot2.getRatio() ? 1 : -1;
                    }
                    return 0;
                }
            });
        }
    }
}
