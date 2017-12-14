package com.tw.parkinglot;

import java.util.HashSet;
import java.util.Set;

/**
 * @author pzzheng
 * @date 12/14/17
 */
public class ParkingLot {
    private final Set<Car> cars;
    private int capacity;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        cars = new HashSet<>(capacity);
    }

    public Boolean isAvailable() {
        return capacity - cars.size() > 0;
    }

    public Boolean park(Car car) {
        if(isAvailable()) {
            return cars.add(car);
        }
        return false;
    }

    public Boolean unpark(Car car) {
        return cars.remove(car);
    }

    public Integer remainedNumber() {
        return capacity - cars.size();
    }
}
