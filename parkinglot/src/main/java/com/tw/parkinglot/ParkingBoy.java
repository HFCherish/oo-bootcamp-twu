package com.tw.parkinglot;

/**
 * @author pzzheng
 * @date 12/14/17
 */
public class ParkingBoy {
    private ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Boolean isAvailable() {
        return parkingLot.isAvailable();
    }

    public Boolean park(Car car) {
        return parkingLot.park(car);
    }
}
