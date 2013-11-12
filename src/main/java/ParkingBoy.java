import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ParkingBoy {
    protected List<ParkingLot> parkingLotList;
    protected Chooser chooser;

    public ParkingBoy(Chooser chooser) {
        this.chooser = chooser;
        this.parkingLotList = new ArrayList<ParkingLot>();
    }

    public void manage(ParkingLot parkingLot) {
        this.parkingLotList.add(parkingLot);
    }

    public String park(Car car) {
        ParkingLot lot = chooser.choose(parkingLotList);
        return lot != null ? lot.park(car) : null;
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
        for(ParkingLot lot : parkingLotList){
            if(lot.contains(token)){
               return lot.takeCar(token);
            }
        }
        return null;
    }

    public List<ParkingLot> getParkingLotList() {
        return parkingLotList;
    }


    public boolean isFull() {
        for(ParkingLot lot : parkingLotList){
            if(lot.getEmptyLotNum()>0){
                return false;
            }
        }
        return true;
    }

    public boolean contains(String token) {
        for(ParkingLot lot : parkingLotList){
            if(lot.contains(token)){
                return true;
            }
        }

        return false;
    }
}
