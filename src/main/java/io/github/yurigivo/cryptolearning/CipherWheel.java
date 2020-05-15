package io.github.yurigivo.cryptolearning;

public class CipherWheel {
    private final int rotation;

    public CipherWheel(int rotation) {
        this.rotation = rotation;
    }

    public String encrypt(String plaintext) {
        StringBuilder result = new StringBuilder(plaintext.length());
        for (char next : plaintext.toCharArray())
            result.append((char) (next + rotation));
        return result.toString();
    }
    public String decrypt(String ciphertext) {
        StringBuilder result = new StringBuilder(ciphertext.length());
        for (char next : ciphertext.toCharArray())
            result.append((char) (next - rotation));
        return result.toString();
    }
}
