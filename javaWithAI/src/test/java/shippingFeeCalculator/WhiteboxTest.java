package shippingFeeCalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.testing.ShippingFeeCalculator;

class WhiteboxTest {

    static Stream<Arguments> mergedTestCases() {
        return Stream.of(
                Arguments.of("C3-1", "C3", "<1c1(T), 2, 10>", -1L, 1.0, -1),
                Arguments.of("C3-2", "C3", "<1c1(F), 1c2(T), 2, 10>", 100_000L, 0.0, -1),
                Arguments.of("C3-3", "C3", "<1c1(F), 1c2(F), 1c3(T), 2, 10>", 100_000L, 25.0, -1),
                Arguments.of("C3-4", "C3", "<1c1(F), 1c2(F), 1c3(F), 3c1(T), 4c1(T), 5, 10>", 100_000L, 1.0, 30_000),
                Arguments.of("C3-5", "C3", "<1c1(F), 1c2(F), 1c3(F), 3c1(T), 4c1(F), 6, 10>", 100_000L, 6.0, 50_000),
                Arguments.of("C3-6", "C3", "<1c1(F), 1c2(F), 1c3(F), 3c1(F), 7c1(T), 8, 10>", 600_000L, 3.0, 10_000),
                Arguments.of("C3-7", "C3", "<1c1(F), 1c2(F), 1c3(F), 3c1(F), 7c1(F), 9, 10>", 600_000L, 10.0, 30_000),
                Arguments.of("DFT-1", "All-uses", "<1,2,3>", 300_000L, 25.0, -1),
                Arguments.of("DFT-2", "All-uses", "<1,2,5,6,7>", 100_000L, 1.0, 30_000),
                Arguments.of("DFT-3", "All-uses", "<1,2,5,6,9>", 200_000L, 6.0, 50_000),
                Arguments.of("DFT-4", "All-uses", "<1,2,5,11,12>", 600_000L, 3.0, 10_000),
                Arguments.of("DFT-5", "All-uses", "<1,2,5,11,14>", 700_000L, 10.0, 30_000)
        );
    }

    @ParameterizedTest(name = "{0} | {1} | {2} | orderValue={3}, weight={4} => {5}")
    @MethodSource("mergedTestCases")
    void testCalculateShippingFee(
            String testId,
            String technique,
            String path,
            long orderValue,
            double weight,
            int expected
    ) {
        int actual = ShippingFeeCalculator.calculateShippingFee(orderValue, weight);
        assertEquals(expected, actual, testId + " | " + technique + " | " + path);
    }
}