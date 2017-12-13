package com.tw.parkinglot;

import org.junit.Test;

import java.util.Arrays;
import java.util.Optional;

import static com.tw.parkinglot.LotSelector.mostVacancyRateSelector;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

/**
 * @author pzzheng
 * @date 12/13/17
 */
public class MostVacancyRateSelectorTest {

    /**
     * @author pzzheng
     */
    @Test
    public void should_get_lot_with_most_vacancy() {
        ParkingLot lessVacancyRateLot = lotWithHalfVacancyRate();
        ParkingLot biggerVacancyRateLot = new ParkingLot(1);

        Optional<ParkingLot> selected = mostVacancyRateSelector.getLot(Arrays.asList(lessVacancyRateLot, biggerVacancyRateLot));

        assertThat(selected.isPresent(), is(true));
        assertThat(selected.get(), is(biggerVacancyRateLot));
    }

    private ParkingLot lotWithHalfVacancyRate() {
        ParkingLot lessVacancyRateLot = new ParkingLot(2);
        lessVacancyRateLot.park(mock(Car.class));
        return lessVacancyRateLot;
    }

    /**
     * @author pzzheng
     */
    @Test
    public void should_get_one_lot_when_all_lots_with_same_vacancy_rate() {
        assertThat(mostVacancyRateSelector.getLot(Arrays.asList(lotWithHalfVacancyRate(), lotWithHalfVacancyRate())).isPresent(), is(true));
    }
//
//
//    /**
//     * @author pzzheng
//     */
//    @Test
//    public void should_not_get_lot_if_all_lots_are_not_available() {
//        assertThat(mostVacancySelector.getLot(Arrays.asList(fullLot(), fullLot())).isPresent(), is(false));
//    }


}
