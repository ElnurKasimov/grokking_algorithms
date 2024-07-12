package search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.Predicate;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


class BreadthFirstSearchTest {
//    private BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch();
    @BeforeEach
    private void clearQueue() {
        BreadthFirstSearch.initializeQueue();
    }
    @ParameterizedTest(name = "{index}")
    @MethodSource
    void testThatFindNearestMangoSellerWorksCorrectly (Predicate<String> condition, String expectedMessage) {
        String result = BreadthFirstSearch.findNearestMangoSeller(condition);
        assertEquals(expectedMessage,result);
    }

    private static Stream<Arguments> testThatFindNearestMangoSellerWorksCorrectly() {
        return Stream.of(
                Arguments.of((Predicate<String>)(name) -> name.charAt(0) == 'Y', "There is no mango seller between neither your acquaintances nor their acquaintances"),
                Arguments.of((Predicate<String>)(name) -> name.charAt(name.length() - 2) == 'y', "The nearest to you mango seller is Tanya"),
                Arguments.of((Predicate<String>)(name) -> name.charAt(name.length() - 1) == 'r', "The nearest to you mango seller is Vazir"),
                Arguments.of((Predicate<String>)(name) -> name.charAt(name.length() - 1) == 'r', "The nearest to you mango seller is Vazir"),
                Arguments.of((Predicate<String>)(name) -> name.charAt(name.length() - 1) == 'y' && name.charAt(2) == 'd', "The nearest to you mango seller is Andrey")
         );
    }
}