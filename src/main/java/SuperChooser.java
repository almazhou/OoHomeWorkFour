import java.util.List;

class SuperChooser implements Chooser {
    public Parkable choose(List<Parkable> sortingList) {
        if(sortingList.size() == 0){
            return null;
        }
        Parkable tempLot = sortingList.get(0);
        for(Parkable lot : sortingList){
            if(lot.getEmptyLotNum()>0 && lot.getEmptyLotNum()*1.0/lot.getLotNum() > tempLot.getEmptyLotNum()*1.0/tempLot.getLotNum()){
                tempLot = lot;
            }
        }
        return tempLot.getEmptyLotNum()>0 ? tempLot : null;
    }
}
