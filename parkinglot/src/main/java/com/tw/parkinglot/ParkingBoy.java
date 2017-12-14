package com.tw.parkinglot;

import java.util.Arrays;
import java.util.List;

/**
 * @author pzzheng
 * @date 12/12/17
 */
public class ParkingBoy implements WithParkAvailability {
    protected final List<WithParkAvailability> parkingLots;
    protected final ParkerSelector parkerSelector;

    public ParkingBoy(ParkerSelector parkerSelector, WithParkAvailability... parkingLots) {
        this.parkingLots = Arrays.asList(parkingLots);
        this.parkerSelector = parkerSelector;
    }

    @Override
    public <T> T usageStatistics(ParkingLot.Usage<T> usage) {
        return null;
    }

    @Override
    public Boolean park(Car car) {
        return parkerSelector.getParker(parkingLots)
                .map(parkingLot -> parkingLot.park(car))
                .orElse(false);
    }

    @Override
    public Boolean isAvailable() {
        return parkingLots.stream().anyMatch(parkingLot -> parkingLot.isAvailable());
    }

    @Override
    public Boolean unpark(Car car) {
        return parkingLots.stream().anyMatch(parkingLot -> parkingLot.unpark(car));
    }
}
