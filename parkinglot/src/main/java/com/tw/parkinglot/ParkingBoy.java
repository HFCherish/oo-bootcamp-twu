package com.tw.parkinglot;

import java.util.Arrays;
import java.util.List;

/**
 * @author pzzheng
 * @date 12/14/17
 */
public class ParkingBoy {
    protected final LotSelector lotSelector;
    protected List<ParkingLot> parkingLots;

    public ParkingBoy(LotSelector lotSelector, ParkingLot... parkingLots) {
        this.parkingLots = Arrays.asList(parkingLots);
        this.lotSelector = lotSelector;
    }

    public Boolean isAvailable() {
        return parkingLots.stream().anyMatch(parkingLot -> parkingLot.isAvailable());
    }

    public Boolean park(Car car) {
        return lotSelector.getLot(parkingLots)
                .map(parkingLot -> parkingLot.park(car))
                .orElse(false);
    }

    public Boolean unpark(Car car) {
        return parkingLots.stream().anyMatch(parkingLot -> parkingLot.unpark(car));
    }
}
