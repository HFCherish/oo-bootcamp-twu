package com.tw.parkinglot;

import org.junit.Test;

import static com.tw.parkinglot.ParkerSelector.firstAvailableSelector;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


/**
 * @author pzzheng
 * @date 12/12/17
 */
public class FirstAvailableSelectorParkingBoyTest {

    /**
     * @author pzzheng
     */
    @Test
    public void should_park_when_parking_lots_of_the_boy_is_available() {
        WithParkAvailability availableLot = TestHelper.emptyLot1();
        WithParkAvailability fullLot = TestHelper.fullLot();
        WithParkAvailability parkingBoy = new ParkingBoy(firstAvailableSelector, availableLot, fullLot);

        Boolean status = parkingBoy.park(TestHelper.car);

        assertThat(status, is(true));
        assertThat(parkingBoy.isAvailable(), is(false));
    }

    /**
     * @author pzzheng
     */
    @Test
    public void should_park_to_first_avaliable_lot_of_the_boy_when_many_is_available() {
        WithParkAvailability availableLot = TestHelper.emptyLot1();
        WithParkAvailability availableLot2 = TestHelper.emptyLot1();
        WithParkAvailability parkingBoy = new ParkingBoy(firstAvailableSelector, availableLot, availableLot2);
        assertThat(availableLot.isAvailable(), is(true));

        Boolean status = parkingBoy.park(TestHelper.car);

        assertThat(status, is(true));
        assertThat(availableLot.isAvailable(), is(false));
        assertThat(parkingBoy.isAvailable(), is(true));
    }

    /**
     * @author pzzheng
     */
    @Test
    public void should_not_park_if_all_lots_of_the_boy_is_not_available() {
        WithParkAvailability parkingBoy = new ParkingBoy(firstAvailableSelector, TestHelper.fullLot(), TestHelper.fullLot());
        assertThat(parkingBoy.isAvailable(), is(false));

        Boolean status = parkingBoy.park(TestHelper.car);

        assertThat(status, is(false));
        assertThat(parkingBoy.isAvailable(), is(false));
    }

    /**
     * @author pzzheng
     */
    @Test
    public void should_unpark_when_car_is_in_lot_of_the_boy() {
        WithParkAvailability parkingBoy = new ParkingBoy(firstAvailableSelector, TestHelper.emptyLot1(), TestHelper.fullLot());
        parkingBoy.park(TestHelper.car);
        assertThat(parkingBoy.isAvailable(), is(false));

        Boolean status = parkingBoy.unpark(TestHelper.car);

        assertThat(status, is(true));
        assertThat(parkingBoy.isAvailable(), is(true));
    }

    /**
     * @author pzzheng
     */
    @Test
    public void should_not_unpark_is_car_is_not_in_any_lots_of_the_boy() {
        WithParkAvailability parkingBoy = new ParkingBoy(firstAvailableSelector, TestHelper.emptyLot1(), TestHelper.fullLot());

        Boolean status = parkingBoy.unpark(TestHelper.car);

        assertThat(status, is(false));
    }
}
