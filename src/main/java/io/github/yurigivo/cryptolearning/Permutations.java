package io.github.yurigivo.cryptolearning;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableList;
import static org.apache.commons.math3.util.CombinatoricsUtils.factorial;

public class Permutations {
    private final List<Character> letters;
    private final List<Permutation> permutations;

    public static Permutations fromLetters(Character... lettersArray) {
        List<Character> letters = asList(lettersArray);
        return new Permutations(letters, generateAllPermutations(letters));
    }
    private Permutations(List<Character> letters, List<Permutation> permutations) {
        this.letters = unmodifiableList(letters);
        this.permutations = unmodifiableList(permutations);
    }

    public int size() {
        return this.permutations.size();
    }

    public List<Permutation> getAll() {
        return permutations;
    }

    public Permutations withExactlyNumberOfFixedLetters(int n) {
        return withNumberOfFixedLetters(n, false);
    }
    public Permutations withAtLeastNumberOfFixedLetters(int n) {
        return withNumberOfFixedLetters(n, true);
    }
    private Permutations withNumberOfFixedLetters(int n, boolean atLeast) {
        if (n > letters.size())
            throw new IllegalArgumentException(String.format("Number of fixed letters [%d] shouldn't be greater than number of initial letters [%d].", n, this.letters.size()));
        List<Permutation> filtered = new ArrayList<>();
        for (Permutation permutation : this.permutations) {
            int fixed = 0;
            for (int i = 0; i < this.letters.size(); i++) {
                if (this.letters.get(i).equals(permutation.getLetters().get(i)))
                    fixed++;
            }
            if (fixed == n || atLeast && fixed > n)
                filtered.add(permutation);
        }
        return new Permutations(this.letters, filtered);
    }

    public void print() {
        List<Permutation> all = getAll();
        for (int i = 0; i < all.size(); i++)
            System.out.printf("%02d: %s%n", i + 1, all.get(i));
        System.out.println("--------------------");
    }

    private static List<Permutation> generateAllPermutations(List<Character> letters) {
        List<Permutation> result = new ArrayList<>();
        int size = letters.size();
        int nOfPermutations = (int) factorial(size);
        for (int i = 0; ; i++) {
            List<Character> permutation = new ArrayList<>(size);
            int index = i;
            for (int j = size - 1; j >= 0; j--) {
                permutation.add(letters.get(index % size));
                index /= size;
            }
            Collections.reverse(permutation);
            if (permutation.size() != new HashSet<>(permutation).size())//has duplicates
                continue;
            result.add(new Permutation(permutation));
            if (result.size() == nOfPermutations)
                break;
        }
        return result;
    }
}
