package com.tw.parkinglot;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * @author pzzheng
 * @date 12/14/17
 */
public interface LotSelector {
    LotSelector firstAvailableSelector = parkingLots -> parkingLots.stream().filter(parkingLot -> parkingLot.isAvailable()).findFirst();
    LotSelector mostVacancySelector = parkingLots -> parkingLots.stream().max(Comparator.comparingInt(ParkingLot::remainedNumber));
    Optional<ParkingLot> getLot(List<ParkingLot> parkingLots);
}
