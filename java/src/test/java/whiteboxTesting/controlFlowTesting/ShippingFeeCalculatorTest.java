package whiteboxTesting.controlFlowTesting;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.testing.ShippingFeeCalculator;

class ShippingFeeCalculatorTest {

    @Test
    void TC_01_orderValue_less_than_0() {
        int result = ShippingFeeCalculator.calculateShippingFee(-5, 5.0);

        assertEquals(-1, result);
    }

    @Test
    void TC_02_weight_less_than_or_equal_0() {
        int result = ShippingFeeCalculator.calculateShippingFee(5, -5.0);

        assertEquals(-1, result);
    }

    @Test
    void TC_03_weight_greater_than_20() {
        int result = ShippingFeeCalculator.calculateShippingFee(5, 25.0);

        assertEquals(-1, result);
    }

    @Test
    void TC_04_orderValue_less_than_500000_and_weight_less_than_or_equal_5() {
        int result = ShippingFeeCalculator.calculateShippingFee(400_000, 2.5);

        assertEquals(30_000, result);
    }

    @Test
    void TC_05_orderValue_less_than_500000_and_weight_greater_than_5() {
        int result = ShippingFeeCalculator.calculateShippingFee(400_000, 8.0);

        assertEquals(50_000, result);
    }

    @Test
    void TC_06_orderValue_greater_than_or_equal_500000_and_weight_less_than_or_equal_5() {
        int result = ShippingFeeCalculator.calculateShippingFee(700_000, 2.5);

        assertEquals(10_000, result);
    }

    @Test
    void TC_07_orderValue_greater_than_or_equal_500000_and_weight_greater_than_5() {
        int result = ShippingFeeCalculator.calculateShippingFee(700_000, 8.0);

        assertEquals(30_000, result);
    }
}