package org.com.deposit.depositcalculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Deposit calculator is the main method for calculating compound interest
 *
 */
@SpringBootApplication
public class DepositCalculator 
{
    public static void main( String[] args )
    {
       	SpringApplication.run(DepositCalculator.class, args);
    }
}
