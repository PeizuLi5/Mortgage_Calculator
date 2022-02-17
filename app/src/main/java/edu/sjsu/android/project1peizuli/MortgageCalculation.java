package edu.sjsu.android.project1peizuli;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Calculate the mortgage based on the user's input.
 * @author Peizu Li
 */
public class MortgageCalculation {
    /**
     * Calculation method will be performed, and the result will round into 2 decimal places.
     * @param price principle (amount that a user borrow)
     * @param interest interest rate per month
     * @param year number of years of the loan
     * @param tax 0.1% monthly tax will be included if it is true
     * @return the monthly mortgage payment
     */
    public static double calc (double price, double interest, int year, boolean tax){
        double result;
        //no interest
        if(interest == 0){
            //with tax
            if(tax){
                result = ((price/(year*12) + (0.001*price)));
                //rounding
                BigDecimal bigDecimal = new BigDecimal(result).
                        setScale(2, RoundingMode.HALF_UP);
                return bigDecimal.doubleValue();
            }
            //without tax
            else{
                result = (price/(year*12));
                //rounding
                BigDecimal bigDecimal = new BigDecimal(result).
                        setScale(2, RoundingMode.HALF_UP);
                return bigDecimal.doubleValue();
            }
        }
        //has interest
        else{
            //with tax
            if (tax){
                result = ((price*interest/12)/(1-Math.pow(1+interest/12,-year*12)))+(0.001*price);
                //rounding
                BigDecimal bigDecimal = new BigDecimal(result).
                        setScale(2, RoundingMode.HALF_UP);
                return bigDecimal.doubleValue();
            }
            //without tax
            else{
                result = ((price*interest/12)/(1-Math.pow(1+interest/12,-year*12)));
                //rounding
                BigDecimal bigDecimal = new BigDecimal(result).
                        setScale(2, RoundingMode.HALF_UP);
                return bigDecimal.doubleValue();
            }
        }
    }
}
