package com.leetcode;

import java.util.*;

//https://leetcode.com/problems/car-fleet/description/
//#Sorting, #Math, #Stack

/**
 * Sort the cars based on the initial position in descending order
 * Calculate the time taken by each car to reach the target
 * If the car behind reaches the target before the car in front, then the car will reach at the same time.
 */
public class CarFleet {

    //Class to store the initial position and speed of the car
    class Car implements Comparable<Car> {
        int initialPosition;
        int speed;

        Car(int initialPosition, int speed) {
            this.initialPosition = initialPosition;
            this.speed = speed;
        }

        @Override
        public int compareTo(Car car) {
            //Sort in descending order
            return car.initialPosition - this.initialPosition;
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {
        List<Car> cars = new ArrayList<>(position.length);
        for (int i = 0; i < position.length; i++) {
            cars.add(new Car(position[i], speed[i]));
        }
        Collections.sort(cars); //Sort descending based on position
        int carsFleet = 1; //default set to 1 for first car
        double timeToReachTarget = calculateTime(cars.get(0), target); //first car time
        for (Car car : cars) {
            double currentCarTime = calculateTime(car, target);
            if (timeToReachTarget < currentCarTime) {
                //if previous car time is less than previous car will reach early and this car will not be able to catch up.
                //add this car to new fleet.
                timeToReachTarget = currentCarTime;
                carsFleet++;
            }
            //if previous car time is greater than current car time,
            //then this car will catch up to previous car and walk with the previous car. Making it part of previous car fleet.
            //So, no need to update the car fleet count.
            //plus since this car will also reach in the same time as previous car the time period to reach target will be same
            //and not updated
        }
        return carsFleet;
    }

    private double calculateTime(Car car, int target) {
        return ((target - car.initialPosition) * 1.0) / car.speed;
    }

    public static void main(String[] args) {
        CarFleet obj = new CarFleet();
        System.out.println(obj.carFleet(12, new int[]{10, 8, 0, 5, 3}, new int[]{2, 4, 1, 1, 3}));
        System.out.println(obj.carFleet(10, new int[]{3}, new int[]{3}));
        System.out.println(obj.carFleet(100, new int[]{0, 2, 4}, new int[]{4, 2, 1}));
        System.out.println(obj.carFleet(10, new int[]{6, 8}, new int[]{3, 2}));
    }
}
