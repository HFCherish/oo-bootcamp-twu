package com.tw.parkinglot;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

/**
 * @author pzzheng
 * @date 12/14/17
 */
public class ParkingLotTest {
    /**
     * @author pzzheng
     */
    @Test
    public void should_park_when_lot_is_available() {
        ParkingLot parkingLot = new ParkingLot(1);
//        assertThat(parkingLot.isAvailable(), is(true));

        boolean status = parkingLot.park(mock(Car.class));

        assertThat(status, is(true));
//        assertThat(parkingLot.isAvailable(), is(false));
    }


}
