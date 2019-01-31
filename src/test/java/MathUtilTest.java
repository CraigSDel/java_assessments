import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Craig Stroberg <strobergcd@gmail.com>
 */
public class MathUtilTest {

    @Test(expected = MathsUtilException.class)
    public void highestCommonFactorEmptyArray() throws MathsUtilException {
        int[] numbers = new int[0];
        MathUtil.highestCommonFactor(numbers);
    }

    @Test
    public void highestCommonFactorOneValue() throws MathsUtilException {
        int[] numbers = new int[]{24};
        assertEquals(Integer.valueOf(24), Integer.valueOf(MathUtil.highestCommonFactor(numbers)));
    }

    @Test
    public void highestCommonFactorMultipleValues() throws MathsUtilException {
        int[] numbers = new int[]{24, 36, 48};
        assertEquals(Integer.valueOf(12), Integer.valueOf(MathUtil.highestCommonFactor(numbers)));
    }
}
