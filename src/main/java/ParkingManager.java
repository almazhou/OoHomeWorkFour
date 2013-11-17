import java.util.ArrayList;
import java.util.List;

public class ParkingManager extends ParkingBoy{
    @Override
    public String park(Car car) {
        for(Parkable boy : parkableList){
            if(!boy.isFull()){
               return boy.park(car);
            }
        }

        for(Parkable lot : parkingLotList){
            if(!lot.isFull()){
                return lot.park(car);
            }
        }
        return null;
    }

    private List<Parkable> parkableList;

    public ParkingManager(Chooser chooser) {
        super(chooser);
        parkableList = new ArrayList<Parkable>();
    }

    @Override
    public Car takeCar(String token) {
        for(Parkable boy : parkableList){
            if(boy.contains(token)){
                return boy.takeCar(token);
            }
        }
        for(Parkable lot : parkingLotList){
            if(lot.contains(token)){
                return lot.takeCar(token);
            }
        }
        return null;
    }

    public void manageBoy(Parkable parkable) {
        this.parkableList.add(parkable);
    }
}
