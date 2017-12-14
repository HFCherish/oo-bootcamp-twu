package com.tw.parkinglot;

import org.junit.Test;

import static com.tw.parkinglot.ParkerSelector.firstAvailableSelector;
import static com.tw.parkinglot.TestHelper.emptyLot1;
import static com.tw.parkinglot.TestHelper.fullLot;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

/**
 * @author pzzheng
 * @date 12/14/17
 */
public class ParkerManagerTest {
    /**
     * @author pzzheng
     */
    @Test
    public void should_park_when_park_boy_is_available() {
        ParkingBoy availableBoy = new ParkingBoy(firstAvailableSelector, emptyLot1());
        ParkingBoy inAvailableBoy = new ParkingBoy(firstAvailableSelector, fullLot());
        ParkingManager parkingManager = new ParkingManager(inAvailableBoy, availableBoy);

        boolean status = parkingManager.park(mock(Car.class));

        assertThat(status, is(true));
        assertThat(availableBoy.isAvailable(), is(false));
    }
}
