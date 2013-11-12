import java.util.List;

class SuperChooser implements Chooser {
    public ParkingLot choose(List<ParkingLot> sortingList) {
        if(sortingList.size() == 0){
            return null;
        }
        ParkingLot tempLot = sortingList.get(0);
        for(ParkingLot lot : sortingList){
            if(lot.getEmptyLotNum()>0 && lot.getRatio() < tempLot.getRatio()){
                tempLot = lot;
            }
        }
        return tempLot.getEmptyLotNum()>0 ? tempLot : null;
    }
}
