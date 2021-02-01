package ru.netology;

public class CreditCalculator {
    private int creditAmount;
    private double interestRate;
    private int monthsToRepay;

    public int getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(int creditAmount) {
        this.creditAmount = creditAmount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getMonthsToRepay() {
        return monthsToRepay;
    }

    public void setMonthsToRepay(int monthsToRepay) {
        this.monthsToRepay = monthsToRepay;
    }

    public double getMonthPaymentCalculation(){
        return 0;
    }

    public double getAmountToRepay(){
        return 0;
    }

    public double getOverpaidAmount(){
        return 0;
    }

}
