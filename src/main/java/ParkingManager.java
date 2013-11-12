import java.util.ArrayList;
import java.util.List;

public class ParkingManager extends ParkingBoy{
    @Override
    public String park(Car car) {
        for(ParkingBoy boy : parkingBoyList){
            if(!boy.isFull()){
               return boy.park(car);
            }
        }

        for(ParkingLot lot : parkingLotList){
            if(lot.getEmptyLotNum()>0){
                return lot.park(car);
            }
        }
        return null;
    }

    private List<ParkingBoy> parkingBoyList;

    public ParkingManager(Chooser chooser) {
        super(chooser);
        parkingBoyList = new ArrayList<ParkingBoy>();
    }

    @Override
    public Car takeCar(String token) {
        for(ParkingBoy boy : parkingBoyList){
            if(boy.contains(token)){
                return boy.takeCar(token);
            }
        }
        for(ParkingLot lot : parkingLotList){
            if(lot.contains(token)){
                return lot.takeCar(token);
            }
        }
        return null;
    }

    public void manageBoy(ParkingBoy parkingBoy) {
        this.parkingBoyList.add(parkingBoy);
    }
}
