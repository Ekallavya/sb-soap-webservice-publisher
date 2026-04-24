package com.universe.emdpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.universe.loaneligibility.Acknowledgement;
import com.universe.loaneligibility.CustomerRequest;
import com.universe.service.LoanEligibilityService;

@Endpoint
public class LoanEligibilityIndicatorEndpoint {

	private static final String NAMESPACE = "http://www.universe.com/soap/api/loanEligibility";
	@Autowired
	private LoanEligibilityService service;

	@PayloadRoot(namespace = NAMESPACE, localPart = "CustomerRequest")
	@ResponsePayload
	public Acknowledgement getLoanStatus(@RequestPayload CustomerRequest request) {
		return service.checkLoanEligibility(request);
	}

}
