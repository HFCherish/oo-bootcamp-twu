package com.tw.parkinglot;

/**
 * @author pzzheng
 * @date 12/12/17
 */
public interface WithParkAvailability {
    <T> T usageStatistics(ParkingLot.Usage<T> usage);

    abstract Boolean park(Car car);

    Boolean isAvailable();

    Boolean unpark(Car car);
}
