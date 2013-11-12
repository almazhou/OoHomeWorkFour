import java.util.List;

class NormalChooser implements Chooser {
    public ParkingLot choose(List<ParkingLot> sortedList) {
        for(ParkingLot lot : sortedList){
            if(lot.getEmptyLotNum()!= 0){
                return lot;
            }
        }
        return null;
    }
}
