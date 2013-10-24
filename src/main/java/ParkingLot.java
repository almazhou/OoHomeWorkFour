import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final Map<String, Car> carMap;
    private Integer lotNum;
    private String name;

    public ParkingLot(int lotNum, String name) {
        this.lotNum = lotNum;
        this.name = name;
        this.carMap = new HashMap<String,Car>();
    }

    public String park(Car car) {
        if(getEmptyLotNum()>0){
            String token = generateToken(car.getLicense());
            carMap.put(token,car);
        return token;
        }
        return null;
    }

    private String generateToken(String license) {
        return this.name + license;
    }

    public int getEmptyLotNum() {
        return lotNum-carMap.size();
    }

    public boolean contains(Car car) {
        return carMap.containsValue(car);
    }

    public Car takeCar(String token) {
        return carMap.get(token);
    }

    public double getRatio() {
        return carMap.size()*1.0/lotNum;
    }
}
