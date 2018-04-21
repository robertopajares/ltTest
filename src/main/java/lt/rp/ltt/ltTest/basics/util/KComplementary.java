package lt.rp.ltt.ltTest.basics.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lt.rp.ltt.ltTest.basics.dto.Pair;


/**
 * is k complementary methods
 * 
 * @author rpajares 
 */
public class KComplementary {

    /**
     * @param K
     * @param numbers
     * @return
     */
    public static Set<Pair> complementaryPairsMethodOne(int K, int[] numbers) {
        Set<Pair> pairs = null;
        if (numbers != null && numbers.length >= Constants.MIN_LENGTH) {
            pairs = new HashSet<>();
            Set<Integer> uniqueNumbers = Arrays.stream(numbers).boxed().collect(Collectors.toSet());          
            Stream <Integer> ps = uniqueNumbers.parallelStream();
            Stream <Integer> psFiltered = ps.filter(number -> number < K && uniqueNumbers.contains(K - number));
            Stream <Pair> map= psFiltered.map(number -> new Pair(number, K - number));
            List<Pair> pairList = map.collect(Collectors.toList());            
            pairs.addAll(pairList);
        }

        return pairs;
    }
    
    /**
     * @param K
     * @param numbers
     * @return
     */
    public static Set<String> complementaryPairsMethodTwo(int K, int[] numbers) {    	
        Set<String> uniqueSet = new HashSet<>();                       
        for(int i=0;i<=numbers.length;i++){
            for(int j=i;j<numbers.length-1;j++){
                if(numbers[i] + numbers[j+1] == K){
                	uniqueSet.add(numbers[i]+" & "+numbers[j+1]);                            	                	
                }
            }
        }                               
        return uniqueSet;            
    }
    

}

 

