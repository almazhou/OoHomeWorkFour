import java.util.List;

public interface Chooser {
    public abstract ParkingLot choose(List<ParkingLot> sortedList);
}
