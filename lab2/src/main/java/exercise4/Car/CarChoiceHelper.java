package exercise4.Car;

public class CarChoiceHelper {

    public static Car selectCar(CarType type, int minPrice, int maxPrice) {
        switch (type) {
            case CITY: return Car.SKODA;
            case SPORT: return Car.AUDI;
            case PREMIUM: return Car.MERCEDES;
            default: return Car.SKODA;
        }
    }
}
