package com.tw.parkinglot;

/**
 * @author pzzheng
 * @date 12/14/17
 */
public class TestHelper {
    public static ParkingLot emptyLot1() {
        return new ParkingLot(1);
    }
    public static ParkingLot fullLot() {
        return new ParkingLot(0);
    }
}
