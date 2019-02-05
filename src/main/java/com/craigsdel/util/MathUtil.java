package com.craigsdel.util;

import com.craigsdel.exception.MathsUtilException;

import java.math.BigInteger;

/**
 * @author Craig Stroberg <strobergcd@gmail.com>
 */
public class MathUtil {

    private MathUtil() {
    }

    public static int highestCommonFactor(final int[] numbers) throws MathsUtilException {
        if (numbers.length > 1 & numbers.length > 1) {
            BigInteger gcdResult = BigInteger.valueOf(numbers[0]);
            for (int i = 0; i < numbers.length - 1; i++) {
                final BigInteger b1 = BigInteger.valueOf(numbers[i]);
                final BigInteger b2 = BigInteger.valueOf(numbers[i + 1]);
                final BigInteger gcd = b1.gcd(b2);
                if (gcdResult == null || gcd.intValue() < gcdResult.intValue()) {
                    gcdResult = gcd;
                }
            }
            return gcdResult.intValue();
        } else if (numbers.length == 1) {
            return numbers[0];
        }
        throw new MathsUtilException("Error in your input");
    }
}
