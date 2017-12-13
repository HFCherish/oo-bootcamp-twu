package com.tw.parkinglot;

import java.util.HashSet;

/**
 * @author pzzheng
 * @date 12/12/17
 */
public class ParkingLot implements WithParkAvailability{
    private final HashSet<Car> cars;
    private Integer capacity;

    public ParkingLot(Integer capacity) {
        this.capacity = capacity;
        cars = new HashSet<>(capacity);
    }

    public Integer getRemained() {
        return capacity - cars.size();
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
        return getRemained() > 0;
    }

    public Boolean unpark(Car car) {
        return cars.remove(car);
    }

    public Boolean contains(Car car) {
        return cars.contains(car);
    }
}
