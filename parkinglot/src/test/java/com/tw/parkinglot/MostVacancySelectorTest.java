package com.tw.parkinglot;

import org.junit.Test;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.Optional;

import static com.tw.parkinglot.LotSelector.mostVacancySelector;
import static com.tw.parkinglot.TestHelper.fullLot;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author pzzheng
 * @date 12/12/17
 */
public class MostVacancySelectorTest {
    @Mock
    Car car;

    /**
     * @author pzzheng
     */
    @Test
    public void should_park_to_lot_with_most_vacancy_of_the_boy() {
        ParkingLot moreVacancyLot = new ParkingLot(2);
        ParkingLot lessVacancyLot = new ParkingLot(1);
        Optional<ParkingLot> selected = mostVacancySelector.getLot(Arrays.asList(moreVacancyLot, lessVacancyLot));
        assertThat(selected.isPresent(), is(true));
        assertThat(selected.get(), is(moreVacancyLot));
    }

    /**
     * @author pzzheng
     */
    @Test
    public void should_park_when_all_lots_with_same_vacancy() {
        assertThat(mostVacancySelector.getLot(Arrays.asList(new ParkingLot(1), new ParkingLot(1))).isPresent(), is(true));
    }


    /**
     * @author pzzheng
     */
    @Test
    public void should_not_park_if_all_lots_of_the_boy_is_not_available() {
        assertThat(mostVacancySelector.getLot(Arrays.asList(fullLot(), fullLot())).isPresent(), is(false));
    }

}
