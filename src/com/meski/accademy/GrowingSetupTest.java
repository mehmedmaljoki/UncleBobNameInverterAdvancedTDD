package com.meski.accademy;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GrowingSetupTest {
    private final double delta;
    private Account newAccount;
    private Account oldAccount;
    private double oldRate = 0.0025;
    private double newRate = 0.0035;

    public GrowingSetupTest() {
        delta = 0.000001;
    }

    @Before
    public void setUp() throws Exception {
        Bank.setStandardRate(oldRate);
        oldAccount = new Account();
        Bank.setStandardRate(newRate);
        newAccount = new Account();
    }

    @Test
    public void uponNewAccount_balanceWillBeZero() throws Exception {
        Account newAccount = new Account();
        assertEquals(0, newAccount.getBalance());
    }

    @Test
    public void uponNewAccount_hasStandardInterestRate() throws Exception {
        assertEquals(Bank.getStandardRate(), newAccount.getInterestRate(), delta);
    }

    @Test
    public void whenRateChange_oldAccountKeepsOldRate() throws Exception {
        assertEquals(oldRate, oldAccount.getInterestRate(), delta);
        assertEquals(newRate, newAccount.getInterestRate(), delta);
    }
}
