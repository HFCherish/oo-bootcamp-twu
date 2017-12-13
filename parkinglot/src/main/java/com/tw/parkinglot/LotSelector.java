package com.tw.parkinglot;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * @author pzzheng
 * @date 12/12/17
 */
@FunctionalInterface
public interface LotSelector {
    LotSelector mostVacancySelector = parkingLots -> parkingLots.stream().max(Comparator.comparingInt(ParkingLot::getRemained)).filter(parkingLot -> parkingLot.isAvailable());
    LotSelector firstAvailableSelector = parkingLots ->  parkingLots.stream().filter(parkingLot -> parkingLot.isAvailable()).findFirst();
    LotSelector mostVacancyRateSelector = parkingLots -> parkingLots.stream().max(Comparator.comparingDouble(ParkingLot::getUsageRate)).filter(parkingLot -> parkingLot.isAvailable());

    Optional<ParkingLot> getLot(List<ParkingLot> parkingLots);
}