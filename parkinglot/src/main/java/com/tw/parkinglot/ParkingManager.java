package com.tw.parkinglot;

import java.util.Arrays;
import java.util.List;

/**
 * @author pzzheng
 * @date 12/14/17
 */
public class ParkingManager {
    private final List<ParkingBoy> parkingBoys;

    public ParkingManager(ParkingBoy... parkingBoys) {
        this.parkingBoys = Arrays.asList(parkingBoys);
    }

    public Boolean park(Car car) {
        return parkingBoys.stream().filter(parkingBoy -> parkingBoy.isAvailable())
                .findFirst()
                .map(parkingBoy -> parkingBoy.park(car))
                .orElse(false);
    }
}
