package io.github.yurigivo.cryptolearning;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class SubstitutionCipher implements Cipher {
    private final Map<Character, Character> plainToCipher;
    private final Map<Character, Character> cipherToPlain;

    @SafeVarargs
    public SubstitutionCipher(Entry<Character, Character>... values) {
        Map<Character, Character> plainToCipher = new HashMap<>();
        Map<Character, Character> cipherToPlain = new HashMap<>();
        for (Entry<Character, Character> next : values) {
            plainToCipher.put(next.getKey(), next.getValue());
            cipherToPlain.put(next.getValue(), next.getKey());
        }
        this.plainToCipher = plainToCipher;
        this.cipherToPlain = cipherToPlain;
    }

    public Map<Character, Character> getCipherToPlain() {
        return cipherToPlain;
    }

    @Override public String encrypt(String plaintext) {
        StringBuilder result = new StringBuilder(plaintext.length());
        for (char plainLetter : plaintext.toCharArray()) {
            Character cipherLetter = plainToCipher.get(plainLetter);
            if (cipherLetter == null)
                throw new IllegalArgumentException(String.format("Not found encryption for letter [%s].", plainLetter));
            result.append(cipherLetter);
        }
        return result.toString();
    }
    @Override public String decrypt(String ciphertext) {
        StringBuilder result = new StringBuilder(ciphertext.length());
        for (char cipherLetter : ciphertext.toCharArray()) {
            Character plainLetter = cipherToPlain.get(cipherLetter);
            if (plainLetter == null)
                throw new IllegalArgumentException(String.format("Not found decryption for letter [%s].", cipherLetter));
            result.append(plainLetter);
        }
        return result.toString();
    }

    public void printEncryptionTable() {
        printTable(plainToCipher);
    }
    public void printDecryptionTable() {
        printTable(cipherToPlain);
    }
    private static void printTable(Map<Character, Character> values) {
        StringBuilder sb = new StringBuilder();
        int cellLength = 1;
        sb.append("┎");
        for (int column = 0; column < values.size() - 1; column++)
            sb.append(multiply("─", cellLength + 1));
        sb.append(multiply("─", cellLength)).append("┐").append("\n").append("┃");
        for (Character next : values.keySet())
            sb.append(next).append("│");
        sb.append("\n").append("┃");
        for (Character next : values.values())
            sb.append(next).append("│");
        sb.append("\n┕");
        for (int column = 0; column < values.size() - 1; column++)
            sb.append(multiply("─", cellLength + 1));
        sb.append(multiply("─", cellLength)).append("┘").append("\n");
        System.out.println(sb.toString());
    }
    private static String multiply(@SuppressWarnings("SameParameterValue") String string, int nOfTimes) {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < nOfTimes; i++) result.append(string);
        return result.toString();
    }
}
