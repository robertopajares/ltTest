package lt.rp.ltt.ltTest.basics.service;

import java.util.Arrays;
import java.util.Date;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import lt.rp.ltt.ltTest.basics.dto.Pair;
import lt.rp.ltt.ltTest.basics.util.Constants;
import lt.rp.ltt.ltTest.basics.util.KComplementary;
import lt.rp.ltt.ltTest.basics.util.Palindrome;
import lt.rp.ltt.ltTest.tfidf.ngram.NgramTfIdf;



/**
 * Business Object impl
 * 
 * @author rpajares
 */

@PropertySource(Constants.PROPERTIES_LTTEST)
@Service
public class LtTestServiceImpl implements ILtTestService{

    private Logger logger = LoggerFactory.getLogger(getClass());
    
    @Value(Constants.PALINDROME)
	private String palindrome;
    
    @Value(Constants.INT_ARRAY)
	private String integersArray;
	  
    @Value(Constants.COMP_K)
	private String complementaryK;
            
    @Value(Constants.DIR)
	private String directory;
    
    @Value(Constants.TERM)
	private String termsTT;
    
    @Value(Constants.COUNT)
	private String countN;
    
    @Value(Constants.PERIOD)
	private String periodP;
    
	
	/**
	 * Execute job. 3 exercises. 
	 *	 
	 */
    @PostConstruct
    public void executeJob() {

        logger.info("The job service has begun...");                                
        
        try {

        	long sysDateMilisecondsINIT = (new Date()).getTime();        	
        	boolean isPalindrome=Palindrome.isPalindromeMethodOne(palindrome);
        	long sysDateMilisecondsEND = (new Date()).getTime();
        	long algorithmMiliseconds = sysDateMilisecondsEND - sysDateMilisecondsINIT;  
        	logger.info("method 1 isPalindrome: {} algorithmMiliseconds: {} ", isPalindrome,algorithmMiliseconds);
        	

        	sysDateMilisecondsINIT = (new Date()).getTime();        	
        	isPalindrome=Palindrome.isPalindromeMethodTwo(palindrome);
        	sysDateMilisecondsEND = (new Date()).getTime();
        	algorithmMiliseconds = sysDateMilisecondsEND - sysDateMilisecondsINIT;  
        	logger.info("method 2 isPalindrome: {} algorithmMiliseconds: {} ", isPalindrome,algorithmMiliseconds);
        	
        	
        	sysDateMilisecondsINIT = (new Date()).getTime();        	
        	isPalindrome=Palindrome.isPalindromeMethodThree(palindrome);
        	sysDateMilisecondsEND = (new Date()).getTime();
        	algorithmMiliseconds = sysDateMilisecondsEND - sysDateMilisecondsINIT;  
        	logger.info("method 3 isPalindrome: {} algorithmMiliseconds: {} ", isPalindrome,algorithmMiliseconds);
        	logger.info("\n\n\n\n"); 
        	
        	//TODO split invalid numbers
        	//TODO split char into properties file
        	int[] numbers = Arrays.stream(integersArray.split(Constants.SPLIT_CHAR)).mapToInt(Integer::parseInt).toArray();
        	sysDateMilisecondsINIT = (new Date()).getTime();   
        	//TODO consider unique numbers ??
        	//TODO bug: pair "0 and X" is considered.. but pair "X and 0" is NOT considered with this algorithm        	
        	Set<Pair> complementaryPairs = KComplementary.complementaryPairsMethodOne(Integer.parseInt(complementaryK),numbers);        	 
        	sysDateMilisecondsEND = (new Date()).getTime();
        	algorithmMiliseconds = sysDateMilisecondsEND - sysDateMilisecondsINIT;  
        	logger.info("complementaryPairsMethodOne algorithmMiliseconds: {} ", algorithmMiliseconds);
        	for (Pair pair : complementaryPairs) {
        		logger.info("pair: {} & {}", pair.getFirstNumber(), pair.getSecondNumber());
        	}
        	 	       	
        	//TODO set of Pair instead of String
        	Set<String> sComplementaryPairs=KComplementary.complementaryPairsMethodTwo(Integer.parseInt(complementaryK),numbers);  
        	sysDateMilisecondsEND = (new Date()).getTime();
        	algorithmMiliseconds = sysDateMilisecondsEND - sysDateMilisecondsINIT;  
        	logger.info("complementaryPairsMethodTwo algorithmMiliseconds: {} ", algorithmMiliseconds);
        	for (String pair : sComplementaryPairs) {
        		logger.info("pair: {}", pair);
        	}
        	logger.info("\n\n\n\n");  
        	
             
            // -d  -n  -p -t       	
        	
        	String[] args = new String[4];
            args[0]=directory;
            args[1]=countN;
            args[2]=periodP;
            args[3]=termsTT;   	      		
		
            NgramTfIdf.watchForNewDocuments(args,logger);
        	 
        	 
        		
        } catch (Exception e) {
            logger.error("Error while executing job service", e);
        } finally{
        	logger.info("Job service has finished...");        	
        }           
    }
}



