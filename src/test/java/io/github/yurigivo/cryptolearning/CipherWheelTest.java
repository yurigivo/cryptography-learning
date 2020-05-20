package io.github.yurigivo.cryptolearning;

import org.junit.Test;

import static io.github.yurigivo.cryptolearning.CipherWheel.ALPHABET_LENGTH;
import static org.junit.Assert.assertEquals;

public class CipherWheelTest {
    @Test public void encryptsAndDecryptsMessage_whenShiftingInsideAlphabet() {
        CipherWheel cipherWheel = new CipherWheel(2);
        assertEquals("cde", cipherWheel.encrypt("abc"));
        assertEquals("abc", cipherWheel.decrypt("cde"));
    }
    @Test public void lettersStayTheSame_whenNilRotation() {
        CipherWheel cipherWheel = new CipherWheel(0);
        assertEquals("abc", cipherWheel.encrypt("abc"));
        assertEquals("abc", cipherWheel.decrypt("abc"));
    }
    @Test public void goesAround_whenReachingEndOfAlphabet() {
        CipherWheel cipherWheel = new CipherWheel(1);
        assertEquals("a", cipherWheel.encrypt("z"));
        assertEquals("z", cipherWheel.decrypt("a"));
    }

    /** Ex. 1.1 (a) */
    @Test public void encryptsWithRotation11() {
        String plaintext = "A page of history is worth a volume of logic.";
        String ciphertext = new CipherWheel(11).encrypt(plaintext);
        System.out.println(ciphertext.toUpperCase());
    }
    /** Ex. 1.1 (b) */
    @Test public void decryptsWithRotation7() {
        String plaintext = "AOLYLHYLUVZLJYLAZILAALYAOHUAOLZLJYLAZAOHALCLYFIVKFNBLZZLZ";
        String ciphertext = new CipherWheel(7).decrypt(plaintext.toLowerCase());
        System.out.println(ciphertext);
    }
    /** Ex. 1.1 (c) */
    @Test public void decryptsWithRotation_changingByOneForEachLetter() {
        String ciphertext = "XJHRFTNZHMZGAHIUETXZJNBWNUTRHEPOMDNBJMAUGORFAOIZOCC";
        StringBuilder plaintext = new StringBuilder();
        char[] letters = ciphertext.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            String letter = String.valueOf(letters[i]).toLowerCase();
            plaintext.append(new CipherWheel((i + 1) % ALPHABET_LENGTH).decrypt(letter));
        }
        System.out.println(plaintext);
    }
}