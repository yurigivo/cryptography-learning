package io.github.yurigivo.cryptolearning;

import org.junit.Test;

import java.util.AbstractMap.SimpleEntry;

public class SubstitutionCipherTest {
    /** Ex. 1.3 (a) */
    @Test public void encryptsMessage() {
        String plaintext = "The gold is hidden in the garden.";
        System.out.println(substitutionCipher().encrypt(plaintext));
    }
    /** Ex. 1.3 (b) */
    @Test public void printsEncryptionAndDecryptionTables() {
        SubstitutionCipher substitutionCipher = substitutionCipher();
        substitutionCipher.printEncryptionTable();
        substitutionCipher.printDecryptionTable();
    }
    /** Ex. 1.3 (c) */
    @Test public void decryptsMessage() {
        String ciphertext = "IBXLX JVXIZ SLLDE VAQLL DEVAU QLB";
        System.out.println(substitutionCipher().decrypt(ciphertext.replace(" ", "")));
    }

    private static SubstitutionCipher substitutionCipher() {
        return new SubstitutionCipher(
                new SimpleEntry<>('a', 'S'),
                new SimpleEntry<>('b', 'C'),
                new SimpleEntry<>('c', 'J'),
                new SimpleEntry<>('d', 'A'),
                new SimpleEntry<>('e', 'X'),
                new SimpleEntry<>('f', 'U'),
                new SimpleEntry<>('g', 'F'),
                new SimpleEntry<>('h', 'B'),
                new SimpleEntry<>('i', 'Q'),
                new SimpleEntry<>('j', 'K'),
                new SimpleEntry<>('k', 'T'),
                new SimpleEntry<>('l', 'P'),
                new SimpleEntry<>('m', 'R'),
                new SimpleEntry<>('n', 'W'),
                new SimpleEntry<>('o', 'E'),
                new SimpleEntry<>('p', 'Z'),
                new SimpleEntry<>('q', 'H'),
                new SimpleEntry<>('r', 'V'),
                new SimpleEntry<>('s', 'L'),
                new SimpleEntry<>('t', 'I'),
                new SimpleEntry<>('u', 'G'),
                new SimpleEntry<>('v', 'Y'),
                new SimpleEntry<>('w', 'D'),
                new SimpleEntry<>('x', 'N'),
                new SimpleEntry<>('y', 'M'),
                new SimpleEntry<>('z', 'O')
        );
    }
}