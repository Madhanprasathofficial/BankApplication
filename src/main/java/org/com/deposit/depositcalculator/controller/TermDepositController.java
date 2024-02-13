package org.com.deposit.depositcalculator.controller;

import java.util.logging.Logger;

import org.com.deposit.depositcalculator.TermDepositRequest;
import org.com.deposit.depositcalculator.service.TermDepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/term-deposit")
public class TermDepositController {

	private Logger logger = Logger.getLogger(TermDepositService.class.getName());

	@Autowired
	private TermDepositService termDepositService;

	/**
	 * calculateTermDeposit method is used to calculate the deposited amount with
	 * compound interest
	 * 
	 * @param TermDepositRequest
	 * @return final amount at maturity
	 */
	@PostMapping("/calculate-term-deposit")
	public String calculateTermDeposit(@RequestBody TermDepositRequest termDepositRequest) {

		logger.info("calculate term deposit method has started ");
		double startDepositAmount = termDepositRequest.getStartDepositAmount();
		double interestRate = termDepositRequest.getInterestRate(); 
		int investmentTerm = termDepositRequest.getInvestmentTerm();
		String interestPaymentFrequency = termDepositRequest.getInterestPaymentFrequency();
		return termDepositService.calculateFinalBalance(startDepositAmount, interestRate, investmentTerm,
				interestPaymentFrequency);
	}

}