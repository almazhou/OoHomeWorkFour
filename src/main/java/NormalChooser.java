import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;

import java.util.Collection;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

class NormalChooser implements Chooser {
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
