package com.tw.parkinglot;

/**
 * @author pzzheng
 * @date 12/12/17
 */
public interface WithParkAvailability {
    abstract Boolean park(Car car);

    Boolean isAvailable();

    Boolean unpark(Car car);
}
