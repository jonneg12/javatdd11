package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class TestCreditCalculator {

    public final static int MAX_CREDIT_AMOUNT = 1_000_000;
    public final static int MAX_MONTHS_TO_REPAY = 60;
    public final static int MAX_PERCENT_PER_YEAR = 1000;

    Random random = new Random();

    @Test
    public void testGetMonthPaymentCalculation(){
        CreditCalculator creditCalculator = new CreditCalculator();
        double interestRate = (random.nextDouble() * MAX_PERCENT_PER_YEAR);
        int creditAmount = Math.abs(random.nextInt(MAX_CREDIT_AMOUNT));
        int monthsToRepay = Math.abs(random.nextInt(MAX_MONTHS_TO_REPAY));

        creditCalculator.setCreditAmount(creditAmount);
        creditCalculator.setMonthsToRepay(monthsToRepay);
        creditCalculator.setInterestRate(interestRate);


        double monthPayment = creditCalculator.getMonthPaymentCalculation();

        System.out.println(creditCalculator + " (month payment: " + monthPayment + ")");

        Assertions.assertEquals((100 + interestRate * monthsToRepay / 12) * creditAmount / 100 / monthsToRepay, monthPayment, "Test wrong month payment passed: ");
    }

    @Test
    public void testGetAmountToRepay(){
        CreditCalculator creditCalculator = new CreditCalculator();
        double interestRate = (random.nextDouble() * 100);
        int creditAmount = Math.abs(random.nextInt(MAX_CREDIT_AMOUNT));
        int monthsToRepay = Math.abs(random.nextInt(MAX_MONTHS_TO_REPAY));

        creditCalculator.setCreditAmount(creditAmount);
        creditCalculator.setMonthsToRepay(monthsToRepay);
        creditCalculator.setInterestRate(interestRate);

        double amountToRepay = creditCalculator.getAmountToRepay();

        System.out.println(creditCalculator + " (amount to repay: " + amountToRepay + ")");

        Assertions.assertEquals(((100 + interestRate * monthsToRepay / 12) * creditAmount / 100), amountToRepay, "Test wrong amount to repay passed: ");

    }

    @Test
    public void testGetOverpaidAmount(){
        CreditCalculator creditCalculator = new CreditCalculator();
        double interestRate = (random.nextDouble() * 100);
        int creditAmount = Math.abs(random.nextInt(MAX_CREDIT_AMOUNT));
        int monthsToRepay = Math.abs(random.nextInt(MAX_MONTHS_TO_REPAY));

        creditCalculator.setCreditAmount(creditAmount);
        creditCalculator.setMonthsToRepay(monthsToRepay);
        creditCalculator.setInterestRate(interestRate);


        double overpaidAmount = creditCalculator.getOverpaidAmount();

        System.out.println(creditCalculator + " (overpaid amount: " + overpaidAmount + ")");

        Assertions.assertEquals(((interestRate * monthsToRepay * creditAmount) / 1200), overpaidAmount, "Test wrong amount to repay passed: ");
    }
}
