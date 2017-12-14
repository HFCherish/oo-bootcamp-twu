package com.tw.parkinglot;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

/**
 * @author pzzheng
 * @date 12/14/17
 */
public class ParkingLotTest {

    private Car car;

    /**
     * @author pzzheng
     */
    @Before
    public void setUp() {
        car = mock(Car.class);
    }

    /**
     * @author pzzheng
     */
    @Test
    public void should_park_when_lot_is_available() {
        ParkingLot parkingLot = new ParkingLot(1);
        assertThat(parkingLot.isAvailable(), is(true));

        boolean status = parkingLot.park(car);

        assertThat(status, is(true));
        assertThat(parkingLot.isAvailable(), is(false));
    }

    /**
     * @author pzzheng
     */
    @Test
    public void should_not_park_when_lot_is_not_available() {
        ParkingLot parkingLot = new ParkingLot(0);
        assertThat(parkingLot.isAvailable(), is(false));

        Boolean status = parkingLot.park(car);

        assertThat(status, is(false));
    }
}
