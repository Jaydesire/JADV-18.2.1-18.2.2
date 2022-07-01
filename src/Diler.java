import java.util.ArrayList;
import java.util.List;

public class Diler {

    private static Diler diler;
    volatile List<Car> cars = new ArrayList<Car>();

    public synchronized Car buyCar(Car car) {
        if (cars.contains(car)) {
            cars.remove(car);
            return car;
        } else {
            return null;
        }
    }

    public synchronized void addCars(List<Car> cars) {
        System.out.println("В автосалон поступили новые автомобили.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.cars.addAll(cars);
        notifyAll();
    }

    public static Diler getDiler(){
        if(diler == null){
            diler = new Diler();
        }
        return diler;
    }


}
