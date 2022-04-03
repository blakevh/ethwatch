/**
 * 
 */
package us.vonhaden.ethwatch.service;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

}
