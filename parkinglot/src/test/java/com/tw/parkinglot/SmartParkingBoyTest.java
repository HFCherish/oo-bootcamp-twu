package com.tw.parkinglot;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

/**
 * @author pzzheng
 * @date 12/14/17
 */
public class SmartParkingBoyTest {
    /**
     * @author pzzheng
     */
    @Test
    public void should_park_to_the_lot_with_most_vacancy() {
        ParkingLot lessVacancyLot = TestHelper.emptyLot1();
        ParkingLot mostVacancyLot = new ParkingLot(2);
        ParkingBoy smartParkingBoy = new SmartParkingBoy(lessVacancyLot, mostVacancyLot);
        assertThat(lessVacancyLot.isAvailable(), is(true));
        assertThat(mostVacancyLot.remainedNumber(), is(2));

        boolean status = smartParkingBoy.park(mock(Car.class));

        assertThat(status, is(true));
        assertThat(lessVacancyLot.isAvailable(), is(true));
        assertThat(mostVacancyLot.remainedNumber(), is(1));
    }
}
