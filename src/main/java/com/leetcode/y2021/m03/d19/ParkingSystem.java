package com.leetcode.y2021.m03.d19;

/**
 * https://leetcode-cn.com/problems/design-parking-system/
 *
 * @author duwenlei
 **/
public class ParkingSystem {
    private int big;
    private int medium;
    private int small;

    public ParkingSystem(int big, int medium, int small) {
        if (big < 0 || big > 1000) {
            throw new IllegalArgumentException();
        }
        if (medium < 0 || medium > 1000) {
            throw new IllegalArgumentException();
        }
        if (small < 0 || small > 1000) {
            throw new IllegalArgumentException();
        }
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    public boolean addCar(int carType) {
        boolean ret = true;
        switch (carType) {
            case 1:
                if (big - 1 == -1) {
                    ret = false;
                } else {
                    big--;
                }
                break;
            case 2:
                if (medium - 1 == -1) {
                    ret = false;
                } else {
                    medium--;
                }
                break;
            case 3:
                if (small - 1 == -1) {
                    ret = false;
                } else {
                    small--;
                }
                break;
            default:
                ret = false;
        }
        return ret;
    }

    public static void main(String[] args) {
        ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);
        System.out.println(parkingSystem.addCar(1));
        System.out.println(parkingSystem.addCar(2));
        System.out.println(parkingSystem.addCar(3));
        System.out.println(parkingSystem.addCar(1));
    }
}
