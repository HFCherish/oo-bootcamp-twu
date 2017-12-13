package com.tw.parkinglot;

import org.junit.Before;
import org.junit.Test;

import static com.tw.parkinglot.ParkingLot.Usage.remained;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author pzzheng
 * @date 12/12/17
 */
public class ParkingLotTest {
    private static final Integer CAPACITY = 1;
    private ParkingLot parkingLot;
    private Car car;
    private Boolean status;

    /**
     * @author pzzheng
     */
    @Before
    public void setUp() {
        parkingLot = new ParkingLot(CAPACITY);
        car = new Car();
    }

    @Test
    public void should_park_when_lot_is_available() {
        assertThat(parkingLot.usageStatistics(remained), is(CAPACITY));

        status = parkingLot.park(car);

        assertThat(status, is(true));
        assertThat(parkingLot.usageStatistics(remained), is(CAPACITY - 1));
    }

    /**
     * @author pzzheng
     */
    @Test
    public void should_not_park_when_lot_not_available() {
        status = parkingLot.park(car);
        assertThat(parkingLot.usageStatistics(remained), is(0));

        status = parkingLot.park(new Car());

        assertThat(status, is(false));
        assertThat(parkingLot.usageStatistics(remained), is(0));
    }

    /**
     * @author pzzheng
     */
    @Test
    public void should_unpark_when_car_is_in_lot() {
        parkingLot.park(car);
        assertThat(parkingLot.usageStatistics(remained), is(0));

        status = parkingLot.unpark(car);

        assertThat(status, is(true));
        assertThat(parkingLot.usageStatistics(remained), is(CAPACITY));
    }

    /**
     * @author pzzheng
     */
    @Test
    public void should_not_unpark_when_car_is_not_in_lot() {
        status = parkingLot.unpark(car);

        assertThat(status, is(false));
    }
}
