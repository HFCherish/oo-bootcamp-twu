package com.tw.parkinglot;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static com.tw.parkinglot.ParkingLot.Usage.remained;
import static com.tw.parkinglot.ParkingLot.Usage.vacancyRate;

/**
 * @author pzzheng
 * @date 12/12/17
 */
@FunctionalInterface
public interface LotSelector {
    LotSelector mostVacancySelector = parkingLots -> parkingLots.stream().max(Comparator.comparingInt(parkingLot -> parkingLot.usageStatistics(remained))).filter(parkingLot -> parkingLot.isAvailable());
    LotSelector firstAvailableSelector = parkingLots ->  parkingLots.stream().filter(parkingLot -> parkingLot.isAvailable()).findFirst();
    LotSelector mostVacancyRateSelector = parkingLots -> parkingLots.stream().max(Comparator.comparingDouble(parkingLot -> parkingLot.usageStatistics(vacancyRate))).filter(parkingLot -> parkingLot.isAvailable());

    Optional<ParkingLot> getLot(List<ParkingLot> parkingLots);
}