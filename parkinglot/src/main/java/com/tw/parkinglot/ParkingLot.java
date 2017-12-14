package com.tw.parkinglot;

import java.util.HashSet;
import java.util.Set;

import static com.tw.parkinglot.ParkingLot.Usage.isAvailable;

/**
 * @author pzzheng
 * @date 12/12/17
 */
public class ParkingLot implements WithParkAvailability{
    private final Set<Car> cars;
    private Integer capacity;

    public ParkingLot(Integer capacity) {
        this.capacity = capacity;
        cars = new HashSet<>(capacity);
    }

    @Override
    public <T> T usageStatistics(Usage<T> usage) {
        return usage.getStatistics(capacity, cars.size());
    }

    public interface Usage<T> {
        Usage<Integer> remained = (c, u) -> c - u;
        Usage<Double> vacancyRate = (c, u) -> remained.getStatistics(c, u) / (c * 1.0);
        Usage<Boolean> isAvailable = (c, u) -> remained.getStatistics(c, u) > 0;

        T getStatistics(Integer capacity, Integer used);
    }

    /**
     * @param car
     */
    public Boolean park(Car car) {
        if (isAvailable()) {
            return cars.add(car);
        }
        return false;
    }

    public Boolean isAvailable() {
        return usageStatistics(isAvailable);
    }

    public Boolean unpark(Car car) {
        return cars.remove(car);
    }

    public Boolean contains(Car car) {
        return cars.contains(car);
    }

}
