package io.github.yurigivo.cryptolearning;

import org.junit.Test;

import java.math.BigInteger;

import static io.github.yurigivo.cryptolearning.Divisibility.gcd;
import static org.junit.Assert.assertEquals;

public class DivisibilityTest {
    /** Ex. 1.9 */
    @Test public void checksGcd() {
        assertEquals(3, gcd(291, 252));
        assertEquals(161, gcd(16261, 85652));
        assertEquals(1, gcd(139024789, 93278890));
        assertEquals(new BigInteger("43"), gcd("16534528044", "8332745927"));
    }
    /** Ex. 1.10 */
    @Test public void checksLinearCombinationOfGcd() {
        assertGcdEqualsToLinearCombination("291", "252", "13", "-15");
        assertGcdEqualsToLinearCombination("85652", "16261", "15", "-79");
        assertGcdEqualsToLinearCombination("139024789", "93278890", "6944509", "-10350240");
        assertGcdEqualsToLinearCombination("16534528044", "8332745927", "81440996", "-161602003");
    }

    /** Asserts that a*u + b*v = gcd(a, b) */
    private static void assertGcdEqualsToLinearCombination(String a, String b, String u, String v) {
        assertEquals(gcd(a, b), new BigInteger(a).multiply(new BigInteger(u)).add(new BigInteger(b).multiply(new BigInteger(v))));
    }
}