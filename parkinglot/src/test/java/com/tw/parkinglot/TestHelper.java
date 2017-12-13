package com.tw.parkinglot;

import com.tw.parkinglot.Car;
import com.tw.parkinglot.ParkingLot;
import org.mockito.Mock;

/**
 * @author pzzheng
 * @date 12/12/17
 */
public class TestHelper {
    @Mock
    public static Car car;

    public static ParkingLot availableLot() {
        return new ParkingLot(1);
    }

    public static ParkingLot fullLot() {
        return new ParkingLot(0);
    }
}
