package io.github.yurigivo.cryptolearning;

public interface Cipher {
    String encrypt(String plaintext);
    String decrypt(String ciphertext);
}
