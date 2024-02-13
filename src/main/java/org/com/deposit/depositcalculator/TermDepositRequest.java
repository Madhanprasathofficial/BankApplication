package org.com.deposit.depositcalculator;

/**
 * TermDepositRequest is a request body  
 */
public class TermDepositRequest {
    
		private double startDepositAmount;
	    private double interestRate;
	    private int investmentTerm;
	    private String interestPaymentFrequency;

	    // Add getters and setters
	    public double getStartDepositAmount() {
	        return startDepositAmount;
	    }

	    public void setStartDepositAmount(double startDepositAmount) {
	        this.startDepositAmount = startDepositAmount;
	    }

	    public double getInterestRate() {
	        return interestRate;
	    }

	    public void setInterestRate(double interestRate) {
	        this.interestRate = interestRate;
	    }

	    public int getInvestmentTerm() {
	        return investmentTerm;
	    }

	    public void setInvestmentTerm(int investmentTerm) {
	        this.investmentTerm = investmentTerm;
	    }

	    public String getInterestPaymentFrequency() {
	        return interestPaymentFrequency;
	    }

	    public void setInterestPaymentFrequency(String interestPaymentFrequency) {
	        this.interestPaymentFrequency = interestPaymentFrequency;
	    }   
}
