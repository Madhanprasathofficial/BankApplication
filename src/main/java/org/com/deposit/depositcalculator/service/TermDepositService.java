package org.com.deposit.depositcalculator.service;

import java.text.DecimalFormat;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TermDepositService {

	private static final String MONTHLY = "monthly";

	private static final String QUARTERLY = "quarterly";

	private static final String ANNUALLY = "annually";

	private static final String AT_MATURITY = "at maturity";

	private static final int MONTH_PERIOD = 12;

	private static final int QUARTER_PERIOD = 4;

	private static final int ANNUAL_PERIOD = 1;

	private static final int PERCENTAGE = 100;

	private DecimalFormat decimalFormat = new DecimalFormat("#.##");

	private static final String EXCEPTION_MESSAGE = "Invalid interest paid period";

	private Logger logger = Logger.getLogger(TermDepositService.class.getName());

	/**
	 * calcualteFinalBalance method will have interSnal logic to calculate the
	 * component interest
	 * 
	 * @param startDepositAmount
	 * @param interestRate
	 * @param investmentTerm
	 * @param interestPaymentFrequency
	 * @return final calculated amount
	 */
	public String calculateFinalBalance(double startDepositAmount, double interestRate, int investmentTerm,
			String interestPaymentFrequency) {

		int compoundPeriodsPerYear = ANNUAL_PERIOD;

		switch (interestPaymentFrequency.toLowerCase()) {
		case MONTHLY:
			compoundPeriodsPerYear = MONTH_PERIOD;
			break;
		case QUARTERLY:
			compoundPeriodsPerYear = QUARTER_PERIOD;
			break;
		case ANNUALLY:
			compoundPeriodsPerYear = ANNUAL_PERIOD;
			break;
		case AT_MATURITY:
			compoundPeriodsPerYear = ANNUAL_PERIOD;
			break;
		default:
			throw new IllegalArgumentException(EXCEPTION_MESSAGE);
		}

		logger.info("Term deposit cailcuaiton has started ");
		double totalPeriods = investmentTerm * compoundPeriodsPerYear;
		double interestPerPeriod = interestRate / (compoundPeriodsPerYear * PERCENTAGE);
		return decimalFormat.format((startDepositAmount * Math.pow(ANNUAL_PERIOD + interestPerPeriod, totalPeriods)));
	}

}
