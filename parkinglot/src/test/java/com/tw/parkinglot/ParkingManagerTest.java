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
public class ParkingManagerTest {

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
        WithParkAvailability parkingManager = new ParkingBoy(firstAvailableSelector, inAvailableBoy(), availableBoy());

        boolean status = parkingManager.park(car);

        assertThat(status, is(true));
        assertThat(parkingManager.isAvailable(), is(false));
    }

    private WithParkAvailability inAvailableBoy() {
        return new ParkingBoy(firstAvailableSelector, fullLot());
    }

    /**
     * @author pzzheng
     */
    @Test
    public void should_not_park_when_park_boy_is_not_available() {
        WithParkAvailability parkingManager = new ParkingBoy(firstAvailableSelector, inAvailableBoy(), inAvailableBoy());

        boolean status = parkingManager.park(car);

        assertThat(status, is(false));
    }

    /**
     * @author pzzheng
     */
    @Test
    public void should_unpark_when_car_is_in() {
        WithParkAvailability availableBoy = availableBoy();
        WithParkAvailability parkingManager = new ParkingBoy(firstAvailableSelector, availableBoy);
        parkingManager.park(car);
        assertThat(availableBoy.isAvailable(), is(false));

        boolean status = parkingManager.unpark(car);

        assertThat(status, is(true));
        assertThat(availableBoy.isAvailable(), is(true));
    }

    private WithParkAvailability availableBoy() {
        return new ParkingBoy(firstAvailableSelector, emptyLot1());
    }

    /**
     * @author pzzheng
     */
    @Test
    public void should_not_unpark_when_car_is_not_in() {
        WithParkAvailability parkingManager = new ParkingBoy(firstAvailableSelector, availableBoy());

        boolean status = parkingManager.unpark(car);

        assertThat(status, is(false));
    }
}
