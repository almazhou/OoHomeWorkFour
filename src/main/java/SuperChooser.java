import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class SuperChooser implements Chooser {
    public ParkingLot choose(List<ParkingLot> sortingList) {
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
