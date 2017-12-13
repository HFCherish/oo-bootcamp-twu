package com.tw.parkinglot;

import org.mockito.Mock;

/**
 * @author pzzheng
 * @date 12/12/17
 */
public class TestHelper {
    @Mock
    public static Car car;

    public static ParkingLot emptyLot1() {
        return new ParkingLot(1);
    }

    public static ParkingLot fullLot() {
        return new ParkingLot(0);
    }
}
