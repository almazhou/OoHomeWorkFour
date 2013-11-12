import java.util.List;

class SmartChooser implements Chooser {
    public ParkingLot choose(List<ParkingLot> sortedList) {
        if(sortedList.size() == 0){
            return null;
        }
        ParkingLot tempLot = sortedList.get(0);
        for(ParkingLot lot : sortedList){
            if(lot.getEmptyLotNum()> tempLot.getEmptyLotNum()){
                tempLot = lot;
            }
        }
        return tempLot.getEmptyLotNum()>0 ? tempLot : null;
    }


}
