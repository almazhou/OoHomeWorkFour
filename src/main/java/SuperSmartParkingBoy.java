import java.util.List;

public class SuperSmartParkingBoy extends ParkingBoy {

    private SuperChooser superChooser;

    public SuperSmartParkingBoy(SuperChooser superChooser) {
        this.superChooser = superChooser;
    }

    @Override
    public String park(Car car) {
        List<ParkingLot> sortingList = parkingLotList;
        ParkingLot min = superChooser.choose(sortingList);
        return min != null? min.park(car) : null;
    }

}
