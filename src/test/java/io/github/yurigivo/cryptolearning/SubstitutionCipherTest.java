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

    /** Ex. 1.4 (a) A Piratical Treasure */
    @Test public void decryptsPiraticalTreasure() {
        String ciphertext =
                "JNRZR BNIGI BJRGZ IZLQR OTDNJ GRIHT USDKR ZZWLG OIBTM NRGJN\n" +
                "IJTZJ LZISJ NRSBL QVRSI ORIQT QDEKJ JNRQW GLOFN IJTZX QLFQL\n" +
                "WBIMJ ITQXT HHTBL KUHQL JZKMM LZRNT OBIMI EURLW BLQZJ GKBJT\n" +
                "QDIQS LWJNR OLGRI EZJGK ZRBGS MJLDG IMNZT OIHRK MOSOT QHIJL\n" +
                "QBRJN IJJNT ZFIZL WIZTO MURZM RBTRZ ZKBNN LFRVR GIZFL KUHIM\n" +
                "MRIGJ LJNRB GKHRT QJRUU RBJLW JNRZI TULGI EZLUK JRUST QZLUK\n" +
                "EURFT JNLKJ JNRXR S";
        SubstitutionCipherDecryption decryption = new SubstitutionCipherDecryption(ciphertext);
        System.out.println(decryption.getLetterFrequencies());
        //{R=33, J=30, I=27, L=25, Z=24, T=20, N=19, Q=16, B=15, G=15, K=13, M=12, U=12,
        // O=10, S=9, H=8, W=7, F=6, D=5, E=5, X=3, V=2}
        // {JN=11, NR=8, TQ=6, LW=5, RB=5, RZ=5, JL=5}

        SubstitutionCipher guess = new SubstitutionCipher(
                new SimpleEntry<>('e', 'R'),
                new SimpleEntry<>('t', 'J'), new SimpleEntry<>('h', 'N')
        );
        System.out.println();
        decryption.printGuess(guess);
    }
}