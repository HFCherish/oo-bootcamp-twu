package com.tw.parkinglot;

import java.util.Arrays;
import java.util.List;

/**
 * @author pzzheng
 * @date 12/14/17
 */
public class ParkingBoy {
    protected List<ParkingLot> parkingLots;

    public ParkingBoy(ParkingLot... parkingLots) {
        this.parkingLots = Arrays.asList(parkingLots);
    }

    public Boolean isAvailable() {
        return parkingLots.stream().anyMatch(parkingLot -> parkingLot.isAvailable());
    }

    public Boolean park(Car car) {
        return parkingLots.stream().filter(parkingLot -> parkingLot.isAvailable()).findFirst()
                .map(parkingLot -> parkingLot.park(car))
                .orElse(false);
    }

    public Boolean unpark(Car car) {
        return parkingLots.stream().anyMatch(parkingLot -> parkingLot.unpark(car));
    }
}
