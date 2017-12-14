package com.tw.parkinglot;

import org.junit.Test;

import java.util.Arrays;
import java.util.Optional;

import static com.tw.parkinglot.ParkerSelector.mostVacancySelector;
import static com.tw.parkinglot.TestHelper.fullLot;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author pzzheng
 * @date 12/12/17
 */
public class MostVacancySelectorTest {

    /**
     * @author pzzheng
     */
    @Test
    public void should_get_lot_with_most_vacancy() {
        WithParkAvailability moreVacancyLot = new ParkingLot(2);
        WithParkAvailability lessVacancyLot = new ParkingLot(1);

        Optional<WithParkAvailability> selected = mostVacancySelector.getParker(Arrays.asList(moreVacancyLot, lessVacancyLot));

        assertThat(selected.isPresent(), is(true));
        assertThat(selected.get(), is(moreVacancyLot));
    }

    /**
     * @author pzzheng
     */
    @Test
    public void should_get_one_lot_when_all_lots_with_same_vacancy() {
        assertThat(mostVacancySelector.getParker(Arrays.asList(new ParkingLot(1), new ParkingLot(1))).isPresent(), is(true));
    }


    /**
     * @author pzzheng
     */
    @Test
    public void should_not_get_lot_if_all_lots_are_not_available() {
        assertThat(mostVacancySelector.getParker(Arrays.asList(fullLot(), fullLot())).isPresent(), is(false));
    }

}
