/**
 * 
 */
package us.vonhaden.ethwatch.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author blake
 *
 */
@Service
public class EthwatchService {
    private Logger logger = LoggerFactory.getLogger(getClass());
    
    public void executeEthwatchJob() {
        logger.info("Checking ethereum prices");
    	
    }
}
