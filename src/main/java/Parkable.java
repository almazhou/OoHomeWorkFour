import java.util.ArrayList;
import java.util.List;

public interface Parkable {

    String park(Car car);

    Car takeCar(String token);

    boolean isFull();

    boolean contains(String token);
    public void manage(Parkable parkable);

    public int getEmptyLotNum();

    public int getLotNum();

    public String getName();
    public void setName(String name);

    public List<Parkable> getParkableList();
}
