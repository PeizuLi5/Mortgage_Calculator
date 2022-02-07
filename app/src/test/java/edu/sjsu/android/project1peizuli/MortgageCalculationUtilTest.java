package edu.sjsu.android.project1peizuli;

import static org.junit.Assert.assertEquals;

import junit.framework.TestCase;

public class MortgageCalculationUtilTest extends TestCase {


    public void testCalc() {
        assertEquals(213.00, MortgageCalculation.calc(20000.0, 0.1, 20, true));
        assertEquals(97.76, MortgageCalculation.calc(10000.0, 0.1, 30, true));
        assertEquals(83.33, MortgageCalculation.calc(20000.0, 0, 20, false));
    }
}