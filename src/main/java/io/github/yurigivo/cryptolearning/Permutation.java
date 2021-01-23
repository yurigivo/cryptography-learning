package io.github.yurigivo.cryptolearning;

import java.util.List;

import static java.util.Collections.unmodifiableList;

public class Permutation {
    private final List<Character> letters;

    public Permutation(List<Character> letters) {
        this.letters = unmodifiableList(letters);
    }

    public List<Character> getLetters() {
        return letters;
    }

    @Override public String toString() {
        return "" + letters;
    }
}
