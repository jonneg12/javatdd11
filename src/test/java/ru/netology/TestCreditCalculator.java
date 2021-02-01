package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class TestCreditCalculator {

    public final static int MAX_CREDIT_AMOUNT = 1_000_000;
    public final static int MAX_MONTHS_TO_REPAY = 60;
    public final static int PERCENT_PER_YEAR = 100;

    Random random = new Random();

    @Test
    public void testGetMonthPaymentCalculation(){
        CreditCalculator creditCalculator = new CreditCalculator();
        double interestRate = random.nextInt(PERCENT_PER_YEAR);
        int creditAmount = Math.abs(random.nextInt(MAX_CREDIT_AMOUNT));
        int monthsToRepay = Math.abs(random.nextInt(MAX_MONTHS_TO_REPAY));

        creditCalculator.setCreditAmount(creditAmount);
        creditCalculator.setMonthsToRepay(monthsToRepay);
        creditCalculator.setInterestRate(interestRate);

        double monthPayment = creditCalculator.getMonthPaymentCalculation();

        Assertions.assertTrue(monthPayment == (100 + interestRate * monthsToRepay / 12) * creditAmount / 100  / monthsToRepay, "Test wrong month payment passed: ");
    }

    @Test
    public void testGetAmountToRepay(){
        CreditCalculator creditCalculator = new CreditCalculator();
        double interestRate = Math.abs(random.nextInt(PERCENT_PER_YEAR));
        int creditAmount = Math.abs(random.nextInt(MAX_CREDIT_AMOUNT));
        int monthsToRepay = Math.abs(random.nextInt(MAX_MONTHS_TO_REPAY));

        creditCalculator.setCreditAmount(creditAmount);
        creditCalculator.setMonthsToRepay(monthsToRepay);
        creditCalculator.setInterestRate(interestRate);

        double amountToRepay = creditCalculator.getAmountToRepay();

        Assertions.assertTrue(amountToRepay == ((100 + interestRate * monthsToRepay / 12)  * creditAmount / 100), "Test wrong amount to repay passed: ");

    }

    @Test
    public void testGetOverpaidAmount(){
        CreditCalculator creditCalculator = new CreditCalculator();
        double interestRate = Math.abs(random.nextInt(PERCENT_PER_YEAR));
        int creditAmount = Math.abs(random.nextInt(MAX_CREDIT_AMOUNT));
        int monthsToRepay = Math.abs(random.nextInt(MAX_MONTHS_TO_REPAY));

        creditCalculator.setCreditAmount(creditAmount);
        creditCalculator.setMonthsToRepay(monthsToRepay);
        creditCalculator.setInterestRate(interestRate);

        double overpaidAmount = creditCalculator.getOverpaidAmount();

        Assertions.assertTrue(overpaidAmount == ((interestRate * monthsToRepay * creditAmount) / 1200) , "Test wrong amount to repay passed: ");
    }
}
