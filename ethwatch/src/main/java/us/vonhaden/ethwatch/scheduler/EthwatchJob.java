/**
 * 
 */
package us.vonhaden.ethwatch.scheduler;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import us.vonhaden.ethwatch.EmailServiceImpl;
import us.vonhaden.ethwatch.service.EthwatchService;

/**
 * @author blake
 *
 */
@Component
@EnableAutoConfiguration
public class EthwatchJob implements Job {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private EthwatchService ethwatchService;

	@Autowired
	public EmailServiceImpl emailService;

	@Autowired
	public RestTemplate restTemplate;

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {

		logger.info("Job ** {} ** fired @ {}", context.getJobDetail().getKey().getName(), context.getFireTime());

		ethwatchService.executeEthwatchJob(emailService, restTemplate);

		logger.info("Next job scheduled @ {}", context.getNextFireTime());
	}

}
