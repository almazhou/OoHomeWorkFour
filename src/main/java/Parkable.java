public interface Parkable {

    String park(Car car);

    Car takeCar(String token);

    boolean isFull();

    boolean contains(String token);
    public void manage(Parkable parkable);

    public int getEmptyLotNum();

    public int getLotNum();
}
