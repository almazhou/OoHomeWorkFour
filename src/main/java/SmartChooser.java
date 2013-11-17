import java.util.List;

class SmartChooser implements Chooser {
    public Parkable choose(List<Parkable> sortedList) {
        if(sortedList.size() == 0){
            return null;
        }
        Parkable tempLot = sortedList.get(0);
        for(Parkable lot : sortedList){
            if(lot.getEmptyLotNum()> tempLot.getEmptyLotNum()){
                tempLot = lot;
            }
        }
        return tempLot.getEmptyLotNum()>0 ? tempLot : null;
    }


}
