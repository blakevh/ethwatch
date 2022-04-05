/**
 * 
 */
package us.vonhaden.ethwatch.service;

import java.math.BigDecimal;
import java.time.Duration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;
import us.vonhaden.ethwatch.EmailServiceImpl;
import us.vonhaden.ethwatch.domain.Request;

/**
 * @author blake
 *
 */
@Service
@EnableAutoConfiguration
public class EthwatchService {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	WebClient webClient;


	public void executeEthwatchJob(EmailServiceImpl emailService, RestTemplate restTemplate) {
		logger.info("Checking ethereum prices");
		Request request = restTemplate.getForObject(
				"https://api.etherscan.io/api?module=stats&action=ethprice&apikey=YourApiKeyToken", Request.class);
		BigDecimal val = new BigDecimal("2950");
		if (request.getUSD().compareTo(val) <= 0) {
			logger.info("lower than " + request.toString());
			emailService.sendSimpleMessage("6125991864@vtext.com", "Low Price", request.toString());
		} else {
			logger.info("higher than " + request.toString());
			emailService.sendSimpleMessage("6125991864@vtext.com", "High Price", request.toString());
		}
	}

	public void executeEthwatchJob(EmailServiceImpl emailService) {
		logger.info("Checking ethereum prices");
		Request request = get().block();
		BigDecimal val = new BigDecimal("2950");
		if (request.getUSD().compareTo(val) <= 0) {
			logger.info("lower than " + request.toString());
			emailService.sendSimpleMessage("6125991864@vtext.com", "Low Price", request.toString());
		} else {
			logger.info("higher than " + request.toString());
			emailService.sendSimpleMessage("6125991864@vtext.com", "High Price", request.toString());
		}
	}


	public Mono<Request> get()
	{
		return webClient.get()
				.uri("/api?module=stats&action=ethprice&apikey=YourApiKeyToken")
				.retrieve()
				.bodyToMono(Request.class)
				.timeout(Duration.ofMillis(10_000));
	}

	
}
