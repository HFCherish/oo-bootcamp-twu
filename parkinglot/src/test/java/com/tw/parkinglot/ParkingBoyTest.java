package com.tw.parkinglot;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

/**
 * @author pzzheng
 * @date 12/14/17
 */
public class ParkingBoyTest {
    /**
     * @author pzzheng
     */
    @Test
    public void should_park_when_lot_of_the_boy_is_available() {
        ParkingBoy parkingBoy = new ParkingBoy(TestHelper.emptyLot1());
        assertThat(parkingBoy.isAvailable(), is(true));

        boolean status = parkingBoy.park(mock(Car.class));

        assertThat(status, is(true));
        assertThat(parkingBoy.isAvailable(), is(false));
    }
}
