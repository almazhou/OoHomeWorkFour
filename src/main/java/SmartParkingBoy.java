import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SmartParkingBoy extends ParkingBoy {
    @Override
    public String park(Car car) {
        List<ParkingLot> sortedList = parkingLotList;
        ParkingLot max = new SmartChooser().choose(sortedList);
        return max != null ? max.park(car) : null;
    }

    class SmartChooser {
        public ParkingLot choose(List<ParkingLot> sortedList) {
            return Collections.max(sortedList, new Comparator<ParkingLot>() {
                @Override
                public int compare(ParkingLot lot, ParkingLot lot2) {
                    if (lot.getEmptyLotNum() != lot2.getEmptyLotNum()) {
                        return lot.getEmptyLotNum() > lot2.getEmptyLotNum() ? 1 : -1;
                    }
                    return 0;
                }
            });
        }
    }
}
