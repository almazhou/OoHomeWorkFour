import java.util.List;

public interface Chooser {
    public abstract Parkable choose(List<Parkable> sortedList);
}
