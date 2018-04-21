package lt.rp.ltt.ltTest.basics.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * Data Transfer Object
 * 
 * @author rpajares
 */
public class Pair {
    /**
     * first number of pair
     */
    private int firstNumber;
    /**
     * second number of pair
     */
    private int secondNumber;

    /**
     * constructor
     * @param firstNumber first of pair
     * @param secondNumber second of pair
     */
    public Pair(int firstNumber, int secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }
    
	/**
	 * Constructor default 
	 */
	public Pair() {
		this.firstNumber = 0;
        this.secondNumber = 0;
	}

    /**
     * @return int
     */
    public int getFirstNumber() {
        return firstNumber;
    }

    /**
     * @return int
     */
    public int getSecondNumber() {
        return secondNumber;
    }


	@Override
	public String toString() {		
		return ReflectionToStringBuilder.toString(this);				
	}

}
