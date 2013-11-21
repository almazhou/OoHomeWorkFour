import java.util.ArrayList;
import java.util.List;

public class ParkingBoy implements Parkable {
    protected List<Parkable> parkingLotList;
    protected Chooser chooser;
    private String name;

    public ParkingBoy(Chooser chooser) {
        this.chooser = chooser;
        this.parkingLotList = new ArrayList<Parkable>();
    }



    @Override
    public String park(Car car) {
        Parkable lot = chooser.choose(parkingLotList);
        return lot != null ? lot.park(car) : null;
    }

    @Override
    public Car takeCar(final String token) {
        for(Parkable lot : parkingLotList){
            if(lot.contains(token)){
               return lot.takeCar(token);
            }
        }
        return null;
    }

    public List<Parkable> getParkingLotList() {
        return parkingLotList;
    }


    @Override
    public boolean isFull() {
        for(Parkable lot : parkingLotList){
            if(!lot.isFull()){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean contains(String token) {
        for(Parkable lot : parkingLotList){
            if(lot.contains(token)){
                return true;
            }
        }

        return false;
    }

    @Override
    public void manage(Parkable parkable) {
        this.parkingLotList.add(parkable);
    }

    @Override
    public int getEmptyLotNum() {
        int num = 0;
        for(Parkable parkable : parkingLotList){
           num += parkable.getEmptyLotNum();
        }
        return num;
    }

    @Override
    public int getLotNum() {
        int num = 0;
        for(Parkable parkable : parkingLotList){
            num += parkable.getLotNum();
        }
        return num;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public List<Parkable> getParkableList() {
        return parkingLotList;
    }
}
