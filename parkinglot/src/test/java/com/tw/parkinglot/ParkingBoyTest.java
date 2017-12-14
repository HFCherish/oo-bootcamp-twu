package com.tw.parkinglot;

import org.junit.Test;

import static com.tw.parkinglot.TestHelper.emptyLot1;
import static com.tw.parkinglot.TestHelper.fullLot;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

/**
 * @author pzzheng
 * @date 12/14/17
 */
public class ParkingBoyTest {

    private final Car car;

    public ParkingBoyTest() {
        car = mock(Car.class);
    }

    /**
     * @author pzzheng
     */
    @Test
    public void should_park_when_lot_of_the_boy_is_available() {
        ParkingBoy parkingBoy = new ParkingBoy(LotSelector.firstAvailableSelector, emptyLot1());
        assertThat(parkingBoy.isAvailable(), is(true));

        boolean status = parkingBoy.park(car);

        assertThat(status, is(true));
        assertThat(parkingBoy.isAvailable(), is(false));
    }

    @Test
    public void should_park_to_first_when_many_lots_of_the_boy_is_available() {
        ParkingLot firstAvailableLot = emptyLot1();
        ParkingBoy parkingBoy = new ParkingBoy(LotSelector.firstAvailableSelector, fullLot(), firstAvailableLot, emptyLot1());
        assertThat(firstAvailableLot.isAvailable(), is(true));

        boolean status = parkingBoy.park(car);

        assertThat(status, is(true));
        assertThat(firstAvailableLot.isAvailable(), is(false));
    }

    /**
     * @author pzzheng
     */
    @Test
    public void should_unpark_when_is_in() {
        ParkingBoy parkingBoy = new ParkingBoy(LotSelector.firstAvailableSelector, emptyLot1());
        parkingBoy.park(car);
        assertThat(parkingBoy.isAvailable(), is(false));

        Boolean status = parkingBoy.unpark(car);

        assertThat(status, is(true));
        assertThat(parkingBoy.isAvailable(), is(true));
    }

    /**
     * @author pzzheng
     */
    @Test
    public void should_unpark_when_is_not_in() {
        ParkingBoy parkingBoy = new ParkingBoy(LotSelector.firstAvailableSelector, emptyLot1());
        assertThat(parkingBoy.isAvailable(), is(true));

        Boolean status = parkingBoy.unpark(car);

        assertThat(status, is(false));
        assertThat(parkingBoy.isAvailable(), is(true));
    }

}
