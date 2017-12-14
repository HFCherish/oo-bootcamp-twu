package com.tw.parkinglot;

import org.junit.Before;
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
    public void should_park_when_park_boy_is_available() {
        ParkingBoy availableBoy = new ParkingBoy(firstAvailableSelector, emptyLot1());
        ParkingBoy inAvailableBoy = new ParkingBoy(firstAvailableSelector, fullLot());
        ParkingManager parkingManager = new ParkingManager(inAvailableBoy, availableBoy);

        boolean status = parkingManager.park(car);

        assertThat(status, is(true));
        assertThat(availableBoy.isAvailable(), is(false));
    }

    /**
     * @author pzzheng
     */
    @Test
    public void should_not_park_when_park_boy_is_not_available() {
        ParkingManager parkingManager = new ParkingManager(new ParkingBoy(firstAvailableSelector, fullLot()), new ParkingBoy(firstAvailableSelector, fullLot()));

        boolean status = parkingManager.park(car);

        assertThat(status, is(false));
    }


}
