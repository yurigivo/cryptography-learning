package io.github.yurigivo;

import static org.junit.Assert.assertEquals;

public class CustomAssert {
    public static void assertAllEqual(long a, long b, long c) {
        assertEquals("a != b", a, b);
        assertEquals("b != c", b, c);
    }
}
