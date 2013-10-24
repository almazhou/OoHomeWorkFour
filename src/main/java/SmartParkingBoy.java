import java.util.List;

public class SmartParkingBoy extends ParkingBoy {

    private SmartChooser smartChooser;

    public SmartParkingBoy(SmartChooser smartChooser) {
        this.smartChooser = smartChooser;
    }

    @Override
    public String park(Car car) {
        List<ParkingLot> sortedList = parkingLotList;
        ParkingLot max = smartChooser.choose(sortedList);
        return max != null ? max.park(car) : null;
    }

}
