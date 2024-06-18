package sort;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {
    private static QuickSort quickSort;

    @BeforeAll
    public static void init() {
        quickSort = new QuickSort();
    }

    @ParameterizedTest(name = "{index} test that List {0} has been sorted correctly")
    @MethodSource
    void testThatQuickSortWorkCorrectlyWithList (List<Integer> inputList, List<Integer> expected) {

        assertEquals(expected, quickSort.quickSort(inputList));
    }

    private static Stream<Arguments> testThatQuickSortWorkCorrectlyWithList () {
        return Stream.of(
                Arguments.of(new ArrayList<>(), new ArrayList<>()),
                Arguments.of(Arrays.asList(1), Arrays.asList(1)),
                Arguments.of(Arrays.asList(2,1), Arrays.asList(1,2)),
                Arguments.of(Arrays.asList(4,2,1), Arrays.asList(1,2,4)),
                Arguments.of(Arrays.asList(3,4,1,2), Arrays.asList(1,2,3,4)),
                Arguments.of(Arrays.asList(1,1,1), Arrays.asList(1,1,1)),
                Arguments.of(Arrays.asList(3,4,1,4), Arrays.asList(1,3,4,4)),
                Arguments.of(Arrays.asList(3,-4,1,-8), Arrays.asList(-8,-4,1,3)),
                Arguments.of(Arrays.asList(-3, -5, -4), Arrays.asList(-5, -4, -3))
        );
    }
}