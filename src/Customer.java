
public class Customer extends Thread {
    Diler diler;
    Car car;
    String name;

    public Customer(String name,Car car) {
        this.car = car;
        this.name = name;
        diler = Diler.getDiler();
    }

    @Override
    public void run() {
        boolean isBuyCar = false;
        synchronized (diler) {
            while (!isBuyCar) {
                if (diler.buyCar(car) == null) {
                    try {
                        System.out.println(name + " ждёт машину.");
                        diler.wait(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        System.out.println(e.getMessage());
                    }
                } else {
                    System.out.println(name + " купил " + car);
                    isBuyCar = true;
                }
            }
        }
    }
}
