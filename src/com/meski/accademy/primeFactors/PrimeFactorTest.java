package com.meski.accademy.primeFactors;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PrimeFactorTest {
    @Before
    public void setup() {

    }

    private List<Integer> list(Integer... ints) {
        return Arrays.asList(ints);
    }


    @Test
    public void canFactorIntoPrimes() throws Exception {
        assertPrimeFactors(1, list());
        assertPrimeFactors(2, list(2));
        assertPrimeFactors(3, list(3));
        assertPrimeFactors(4, list(2,2));
        assertPrimeFactors(5, list(5));
        assertPrimeFactors(6, list(2,3));
        assertPrimeFactors(7, list(7));
        assertPrimeFactors(8, list(2,2,2));
        assertPrimeFactors(9, list(3,3));
    }

    private void assertPrimeFactors(int n, List<Integer> primeFactors) {
        assertEquals(primeFactors, of(n));
    }

    private List<Integer> of(int n) {
        ArrayList<Integer> factors = new ArrayList<>();
        if (n > 1) {
            while (n % 2 == 0) {
                factors.add(2);
                n /= 2;
            }
            while (n % 3 == 0) {
                factors.add(3);
                n /= 3;
            }
            if (n > 1)
                factors.add(n);
        }
        return factors;
    }
}
