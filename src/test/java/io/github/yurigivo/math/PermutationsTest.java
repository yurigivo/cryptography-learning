package io.github.yurigivo.math;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

public class PermutationsTest {
    @Test public void generatesAllPermutations() {
        List<Permutation> permutations = Permutations.fromLetters('a', 'b', 'c').getAll();
        assertEquals(6, permutations.size());
        assertEquals("[a, b, c]", permutations.get(0).toString());
        assertEquals("[a, c, b]", permutations.get(1).toString());
        assertEquals("[b, a, c]", permutations.get(2).toString());
        assertEquals("[b, c, a]", permutations.get(3).toString());
        assertEquals("[c, a, b]", permutations.get(4).toString());
        assertEquals("[c, b, a]", permutations.get(5).toString());
    }
    @Test public void filtersPermutationsByExactlyNumberOfFixedLetters() {
        Permutations permutations = Permutations.fromLetters('a', 'b', 'c');

        List<Permutation> withNil = permutations.withExactlyNumberOfFixedLetters(0).getAll();
        assertEquals(2, withNil.size());
        assertEquals("[b, c, a]", withNil.get(0).toString());
        assertEquals("[c, a, b]", withNil.get(1).toString());

        List<Permutation> withOne = permutations.withExactlyNumberOfFixedLetters(1).getAll();
        assertEquals(3, withOne.size());
        assertEquals("[a, c, b]", withOne.get(0).toString());
        assertEquals("[b, a, c]", withOne.get(1).toString());
        assertEquals("[c, b, a]", withOne.get(2).toString());

        List<Permutation> withTwo = permutations.withExactlyNumberOfFixedLetters(2).getAll();
        assertTrue(withTwo.isEmpty());

        List<Permutation> withThree = permutations.withExactlyNumberOfFixedLetters(3).getAll();
        assertEquals(1, withThree.size());
        assertEquals("[a, b, c]", withThree.get(0).toString());
    }
    @Test public void filtersPermutationsByAtLeastNumberOfFixedLetters() {
        Permutations permutations = Permutations.fromLetters('a', 'b', 'c');

        List<Permutation> atLeastNil = permutations.withAtLeastNumberOfFixedLetters(0).getAll();
        assertEquals(6, atLeastNil.size());
        assertEquals("[a, b, c]", atLeastNil.get(0).toString());
        assertEquals("[a, c, b]", atLeastNil.get(1).toString());
        assertEquals("[b, a, c]", atLeastNil.get(2).toString());
        assertEquals("[b, c, a]", atLeastNil.get(3).toString());
        assertEquals("[c, a, b]", atLeastNil.get(4).toString());
        assertEquals("[c, b, a]", atLeastNil.get(5).toString());

        List<Permutation> atLeastOne = permutations.withAtLeastNumberOfFixedLetters(1).getAll();
        assertEquals(4, atLeastOne.size());
        assertEquals("[a, b, c]", atLeastOne.get(0).toString());
        assertEquals("[a, c, b]", atLeastOne.get(1).toString());
        assertEquals("[b, a, c]", atLeastOne.get(2).toString());
        assertEquals("[c, b, a]", atLeastOne.get(3).toString());

        List<Permutation> atLeastTwo = permutations.withAtLeastNumberOfFixedLetters(2).getAll();
        assertEquals(1, atLeastTwo.size());
        assertEquals("[a, b, c]", atLeastTwo.get(0).toString());

        List<Permutation> atLeastThree = permutations.withAtLeastNumberOfFixedLetters(3).getAll();
        assertEquals(1, atLeastThree.size());
        assertEquals("[a, b, c]", atLeastThree.get(0).toString());
    }
    @Test public void errsIfPassedParameterGreaterThanNumberOfInitialLetters_whenFilteringByExactNumberOfFixedLetters() {
        Permutations permutations = Permutations.fromLetters('a', 'b', 'c');
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> permutations.withExactlyNumberOfFixedLetters(4));
        assertThat(exception.getMessage(), containsString("Number of fixed letters [4] shouldn't be greater than number of initial letters [3]."));
    }
    @Test public void errsIfPassedParameterGreaterThanNumberOfInitialLetters_whenFilteringByAtLeastNumberOfFixedLetters() {
        Permutations permutations = Permutations.fromLetters('a', 'b', 'c');
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> permutations.withAtLeastNumberOfFixedLetters(4));
        assertThat(exception.getMessage(), containsString("Number of fixed letters [4] shouldn't be greater than number of initial letters [3]."));
    }

    @Test public void printsPermutations() {
        Permutations permutations = Permutations.fromLetters('a', 'b', 'c', 'd');
        permutations.withExactlyNumberOfFixedLetters(0).print();
        permutations.withAtLeastNumberOfFixedLetters(1).print();
    }
}