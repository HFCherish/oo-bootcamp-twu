package com.tw.parkinglot;

import org.mockito.Mock;

/**
 * @author pzzheng
 * @date 12/12/17
 */
public class TestHelper {
    @Mock
    public static Car car;

    public static WithParkAvailability emptyLot1() {
        return new ParkingLot(1);
    }

    public static WithParkAvailability fullLot() {
        return new ParkingLot(0);
    }
}
