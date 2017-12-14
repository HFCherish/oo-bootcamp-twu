package com.tw.parkinglot;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author pzzheng
 * @date 12/12/17
 */
public class ParkingBoy implements WithParkAvailability {
    protected final List<ParkingLot> parkingLots;
    protected final ParkerSelector parkerSelector;

    public ParkingBoy(ParkerSelector parkerSelector, ParkingLot... parkingLots) {
        this.parkingLots = Arrays.asList(parkingLots);
        this.parkerSelector = parkerSelector;
    }

    protected List<ParkingLot> getParkingLots() {
        return Collections.unmodifiableList(parkingLots);
    }

    @Override
    public Boolean park(Car car) {
        return parkerSelector.getLot(parkingLots)
                .map(parkingLot -> parkingLot.park(car))
                .orElse(false);
    }

    @Override
    public Boolean isAvailable() {
        return parkingLots.stream().anyMatch(parkingLot -> parkingLot.isAvailable());
    }

    @Override
    public Boolean unpark(Car car) {
        return parkingLots.stream().filter(parkingLot -> parkingLot.contains(car))
                .findAny()
                .map(parkingLot -> parkingLot.unpark(car))
                .orElse(false);
    }
}
