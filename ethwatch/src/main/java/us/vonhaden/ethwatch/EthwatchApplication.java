package us.vonhaden.ethwatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EthwatchApplication {

	private static final Logger logger = LoggerFactory.getLogger(EthwatchApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(EthwatchApplication.class, args);
	}

	@Bean
	public CommandLineRunner run() throws Exception {
		return args -> {

			logger.info("started ethwatch");

		};
	}

}
