package com.meski.accademy;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(Enclosed.class)
public class BankTests {
    private static final double MONEY_DELTA = .00001;

    private static void assertMoneyEquals(double expected, double actual) {
        assertEquals(expected, actual, MONEY_DELTA);
    }

    public static class BankContext {
        @Before
        public void setCurrentInterestRate() {
            Bank.currentInterestRate = 2.75;
        }

        @Test
        public void dummy() throws Exception {

        }
    }

    public static class NewAccountContext extends BankContext {
        private Account newAccount;

        @Before
        public void createNewAccount() {
            newAccount = new Account();
        }

        @Test
        public void balanceIsZero() throws Exception {
            assertMoneyEquals(0.0, newAccount.getBalance());
        }

        @Test
        public void interestRateBalance() throws Exception {
            assertMoneyEquals(2.75, newAccount.getInterestRate());
        }
    }

    public static class OldAccountContext extends BankContext {
        protected Account oldAccount;

        @Before
        public void createOldAccount() {
            oldAccount = new Account();
        }

        @Test
        public void dummy() throws Exception {

        }
    }

    public static class AfterInterestRateChangeContext extends OldAccountContext {
        @Before
        public void changeInterestRate() {
            Bank.currentInterestRate = 3.25;
        }

        @Test
        public void shouldHaveOldInterestRate() throws Exception {
            assertMoneyEquals(2.75, oldAccount.getInterestRate());
        }
    }

    public static class ExistingAccountWithBalance extends BankContext {
        private Account existingAccount;

        @Before
        public void createExistingAccountWithBalance() {
            existingAccount = new Account(100.00);
        }

        @Test
        public void hasStartingBalance() throws Exception {
            assertMoneyEquals(100.00, existingAccount.getBalance());
        }
    }

}
