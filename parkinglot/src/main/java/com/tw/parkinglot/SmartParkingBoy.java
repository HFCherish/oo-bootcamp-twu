package com.tw.parkinglot;

import java.util.Comparator;

/**
 * @author pzzheng
 * @date 12/14/17
 */
public class SmartParkingBoy extends ParkingBoy{
    public SmartParkingBoy(ParkingLot... parkingLots) {
        super(parkingLots);
    }

    @Override
    public Boolean park(Car car) {
        return parkingLots.stream().max(Comparator.comparingInt(ParkingLot::remainedNumber))
                .map(parkingLot -> parkingLot.park(car))
                .orElse(false);
    }
}
