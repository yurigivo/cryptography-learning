package io.github.yurigivo.cryptolearning;

public class CipherWheel {
    private static final char START_LETTER = 'a';
    public static final int ALPHABET_LENGTH = 26;
    private final int rotation;

    public CipherWheel(int rotation) {
        this.rotation = rotation;
    }

    public String encrypt(String plaintext) {
        plaintext = plaintext.toLowerCase();
        StringBuilder result = new StringBuilder(plaintext.length());
        for (char next : plaintext.toCharArray())
            result.append((char) ((next - START_LETTER + rotation) % ALPHABET_LENGTH + START_LETTER));
        return result.toString();
    }
    public String decrypt(String ciphertext) {
        ciphertext = ciphertext.toLowerCase();
        StringBuilder result = new StringBuilder(ciphertext.length());
        for (char next : ciphertext.toCharArray())
            result.append((char) ((next - START_LETTER - rotation + ALPHABET_LENGTH) % ALPHABET_LENGTH + START_LETTER));
        return result.toString();
    }
}
