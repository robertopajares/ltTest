package lt.rp.ltt.ltTest; 

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;


/**
 * LtTest App Spring Boot Main 
 * 
 * @author rpajares
 */

@ComponentScan
@EnableScheduling
public class LtTestApp {
	
	static Logger logger = LoggerFactory.getLogger(Logger.class);
   
    public static void main(String[] args) {
    	
    	logger.info("Starting LtTest Springboot App...");
    	    	
    	SpringApplication.run(LtTestApp.class, args);
    	
    	   	
    }
    
}
