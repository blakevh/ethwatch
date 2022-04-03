package us.vonhaden.ethwatch;

import us.vonhaden.ethwatch.domain.Request;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class EthwatchApplication {

	private static final Logger log = LoggerFactory.getLogger(EthwatchApplication.class);

	@Autowired
	public EmailServiceImpl emailService;

	public static void main(String[] args) {
		SpringApplication.run(EthwatchApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			Request request = restTemplate.getForObject(
					"https://api.etherscan.io/api?module=stats&action=ethprice&apikey=YourApiKeyToken", Request.class);
			BigDecimal val = new BigDecimal("2950");
			if (request.getUSD().compareTo(val) <= 0) {
				log.info("lower than " + request.toString());

				emailService.sendSimpleMessage("6125991864@vtext.com", "New Price", request.toString());
			} else {
				log.info("higher than " + request.toString());
			}
		};
	}

}
