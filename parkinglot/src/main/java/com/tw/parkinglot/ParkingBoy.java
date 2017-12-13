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
    protected final LotSelector lotSelector;

    public ParkingBoy(LotSelector lotSelector, ParkingLot... parkingLots) {
        this.parkingLots = Arrays.asList(parkingLots);
        this.lotSelector = lotSelector;
    }

    protected List<ParkingLot> getParkingLots() {
        return Collections.unmodifiableList(parkingLots);
    }

    @Override
    public Boolean park(Car car) {
        return lotSelector.getLot(parkingLots)
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
