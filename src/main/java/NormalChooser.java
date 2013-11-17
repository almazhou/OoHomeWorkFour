import java.util.List;

class NormalChooser implements Chooser {
    public Parkable choose(List<Parkable> sortedList) {
        for(Parkable lot : sortedList){
            if(lot.getEmptyLotNum()!= 0){
                return lot;
            }
        }
        return null;
    }
}
