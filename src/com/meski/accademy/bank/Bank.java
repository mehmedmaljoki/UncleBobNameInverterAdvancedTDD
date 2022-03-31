package com.meski.accademy.bank;

public class Bank {
    public static double currentInterestRate;
    private static double standardRate = .0025;

    public static double getStandardRate() {
        return standardRate;
    }

    public static void setStandardRate(double rate) {
        standardRate = rate;
    }
}
