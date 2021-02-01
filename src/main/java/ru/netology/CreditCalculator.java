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

        return (100 + interestRate * monthsToRepay / 12) * creditAmount / 100  / monthsToRepay;
    }

    public double getAmountToRepay(){
        return (100 + interestRate * monthsToRepay / 12)  * creditAmount / 100;
    }

    public double getOverpaidAmount(){
        return (interestRate * monthsToRepay * creditAmount) / 1200;
    }

    @Override
    public String toString() {
        return "CreditCalculator{" +
                "creditAmount=" + creditAmount +
                ", interestRate=" + interestRate +
                ", monthsToRepay=" + monthsToRepay +
                '}';
    }
}
