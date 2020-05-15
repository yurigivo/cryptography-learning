package io.github.yurigivo.cryptolearning;

import org.junit.Test;


import static org.junit.Assert.assertEquals;
public class CipherWheelTest {
    @Test public void encryptsAndDecryptsMessage_whenShiftingInsideAlphabet() {
        CipherWheel cipherWheel = new CipherWheel(1);
        assertEquals("bcd", cipherWheel.encrypt("abc"));
        assertEquals("abc", cipherWheel.decrypt("bcd"));
    }
}