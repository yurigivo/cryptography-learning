package io.github.yurigivo.cryptolearning;

import java.util.*;

/**
 * Frequency of letters (in %):
 * E = 13.11    M = 2.54
 * T = 10.47    U = 2.46
 * A =  8.15    G = 1.99
 * O =  8.00    Y = 1.98
 * N =  7.10    P = 1.98
 * R =  6.83    W = 1.54
 * I =  6.35    B = 1.44
 * S =  6.10    V = 0.92
 * H =  5.26    K = 0.42
 * D =  3.79    X = 0.17
 * L =  3.39    J = 0.13
 * F =  2.92    Q = 0.12
 * C =  2.76    Z = 0.08
 *
 * Frequency of bigrams per 1000 words:
 * th = 168
 * he = 132
 * an =  92
 * re =  91
 * er =  88
 * in =  86
 * on =  71
 * at =  68
 * nd =  61
 * st =  53
 * es =  52
 * en =  51
 * of =  49
 * te =  46
 * ed =  46
 */
public class SubstitutionCipherDecryption {
    private static final String ANSI_RED   = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";

    private final String ciphertext;

    public SubstitutionCipherDecryption(String ciphertext) {
        this.ciphertext = ciphertext;
    }

    public Map<Character, Integer> getLetterFrequencies() {
        Map<Character, Integer> result = new LinkedHashMap<>();
        for (int i = 0; i < this.ciphertext.length(); i++) {
            char ch = this.ciphertext.charAt(i);
            if (ch != ' ' && ch != '\n') {
                int freq = result.getOrDefault(ch, 0);
                result.put(ch, freq + 1);
            }
        }
        return sortByValueDesc(result);
    }
    public Map<String, Integer> getBigramFrequencies() {
        Map<String, Integer> result = new LinkedHashMap<>();
        char prev = this.ciphertext.charAt(0);
        for (int i = 1; i < this.ciphertext.length(); i++) {
            char current = this.ciphertext.charAt(i);
            if (current != ' ' && current != '\n') {
                String bigram = String.format("%s%s", prev, current);
                int freq = result.getOrDefault(bigram, 0);
                result.put(bigram, freq + 1);
                prev = current;
            }
        }
        return sortByValueDesc(result);
    }

    public void printGuess(SubstitutionCipher guess) {
        Map<Character, Character> cipherToPlain = guess.getCipherToPlain();
        for (int i = 0; i < this.ciphertext.length(); i++) {
            char ch = ciphertext.charAt(i);
            if (cipherToPlain.containsKey(ch)) {
                ch = cipherToPlain.get(ch);
                System.out.print(ANSI_RED + ch + ANSI_RESET);
            } else
                System.out.print(ch);
        }
    }

    private static <K, V extends Comparable<? super V>> Map<K, V> sortByValueDesc(Map<K, V> map) {
        List<Map.Entry<K, V>> entries = new ArrayList<>(map.entrySet());
        entries.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : entries)
            result.put(entry.getKey(), entry.getValue());
        return result;
    }
}
