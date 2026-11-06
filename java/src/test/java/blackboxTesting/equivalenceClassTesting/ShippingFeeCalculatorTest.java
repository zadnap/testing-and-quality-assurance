package blackboxTesting.equivalenceClassTesting;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.testing.ShippingFeeCalculator;

class ShippingFeeCalculatorTest {

    @Test
    void TC_01_orderValue_less_than_0() {
        assertEquals(-1,
                ShippingFeeCalculator.calculateShippingFee(-1, 5.0));
    }

    @Test
    void TC_02_orderValue_less_than_500000_and_weight_less_than_or_equal_5() {
        assertEquals(30_000,
                ShippingFeeCalculator.calculateShippingFee(250_000, 2.5));
    }

    @Test
    void TC_03_orderValue_less_than_500000_and_weight_greater_than_5() {
        assertEquals(50_000,
                ShippingFeeCalculator.calculateShippingFee(250_000, 12.5));
    }

    @Test
    void TC_04_orderValue_greater_than_or_equal_500000_and_weight_less_than_or_equal_5() {
        assertEquals(10_000,
                ShippingFeeCalculator.calculateShippingFee(600_000, 2.5));
    }
}