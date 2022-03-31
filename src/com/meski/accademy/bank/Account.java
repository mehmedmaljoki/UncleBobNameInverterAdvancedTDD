package com.meski.accademy.bank;


public class Account {
    private int balance = 0;
    private double interest = 0;
    private double value = 0;


    public Account() {
        balance = 0;
        interest = Bank.getStandardRate();
    }

    public Account(double value) {
        this.value = value;
    }

    public int getBalance() {
        return balance;
    }

    public double getInterestRate() {
        return interest;
    }


}
