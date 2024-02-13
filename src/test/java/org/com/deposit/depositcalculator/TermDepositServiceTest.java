package org.com.deposit.depositcalculator;

import static org.junit.Assert.assertEquals;

import org.com.deposit.depositcalculator.service.TermDepositService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TermDepositServiceTest {

	private static final double INVESTMENT = 10000;
	
	private static final String YEARLY_AMOUNT = "10333.64";
	
	private static final String MONTHLY_AMOUNT = "10335.35";
	
	private static final String QUARTERLY_AMOUNT = "10335.04";
	
	private static final double INTEREST_RATE = 1.1;
	
	private static final int INVESTMENT_YEARS = 3;

	private static final String MONTHLY = "monthly";

	private static final String QUARTERLY = "quarterly";

	private static final String ANNUALLY = "annually";

	private static final String AT_MATURITY = "at maturity";

	@InjectMocks
	private TermDepositService termDepositService;

	@Test
	public void testCalculateFinalBalanceQuarterly() {

		String actualFinalBalance = termDepositService.calculateFinalBalance(INVESTMENT, INTEREST_RATE,
				INVESTMENT_YEARS, QUARTERLY);
		assertEquals(QUARTERLY_AMOUNT, actualFinalBalance);
	}

	@Test
	public void testCalculateFinalBalanceMonthly() {

		String actualFinalBalance = termDepositService.calculateFinalBalance(INVESTMENT, INTEREST_RATE,
				INVESTMENT_YEARS, MONTHLY);
		assertEquals(MONTHLY_AMOUNT, actualFinalBalance);
	}

	@Test
	public void testCalculateFinalBalanceYearly() {

		String actualFinalBalance = termDepositService.calculateFinalBalance(INVESTMENT, INTEREST_RATE,
				INVESTMENT_YEARS, ANNUALLY);
		assertEquals(YEARLY_AMOUNT, actualFinalBalance);
	}

	@Test
	public void testCalculateFinalBalanceAtMaturity() {

		String actualFinalBalance = termDepositService.calculateFinalBalance(INVESTMENT, INTEREST_RATE,
				INVESTMENT_YEARS, AT_MATURITY);
		assertEquals(YEARLY_AMOUNT, actualFinalBalance);
	}
}
