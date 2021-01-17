package io.github.yurigivo.cryptolearning;

import org.apache.commons.math3.util.ArithmeticUtils;

import java.math.BigInteger;

public class Divisibility {
    public static int gcd(int a, int b) {
        return ArithmeticUtils.gcd(a, b);
    }
    public static BigInteger gcd(String a, String b) {
        return new BigInteger(a).gcd(new BigInteger(b));
    }
}
