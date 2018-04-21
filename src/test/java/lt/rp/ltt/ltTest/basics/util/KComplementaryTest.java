package lt.rp.ltt.ltTest.basics.util;

import org.junit.Test;

import lt.rp.ltt.ltTest.basics.dto.Pair;

import java.util.Set;

import static org.junit.Assert.*;


/**
 * kcomplementary methods unit tests
 * 
 * @author rpajares 
 */
public class KComplementaryTest {

    @Test
    public void testComplementaryPairs() throws Exception {
        int K = 10;
        int[] numbers = {1, 3, 7, 7, 8, 3, 2};
        Set<Pair> pairs = KComplementary.complementaryPairsMethodOne(K, numbers);

        assertNotNull(pairs);
        assertEquals(pairs.size(), 4);
    }

    @Test
    public void testComplementaryPairsNullValue() throws Exception {
        Set<Pair> pairs = KComplementary.complementaryPairsMethodOne(0, null);
        assertNull(pairs);
    }
}