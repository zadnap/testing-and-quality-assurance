package whiteboxTesting.dataFlowTesting;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.testing.ShippingFeeCalculator;

class ShippingFeeCalculatorTest {

    @Test
    void TC_01_reject_negative_orderValue_and_weight() {
        assertEquals(-1,
                ShippingFeeCalculator.calculateShippingFee(-10, -10.0));
    }

    @Test
    void TC_02_should_return_50000() {
        assertEquals(50_000,
                ShippingFeeCalculator.calculateShippingFee(250_000, 7.5));
    }

    @Test
    void TC_03_should_return_30000() {
        assertEquals(30_000,
                ShippingFeeCalculator.calculateShippingFee(250_000, 2.5));
    }

    @Test
    void TC_04_should_return_10000() {
        assertEquals(10_000,
                ShippingFeeCalculator.calculateShippingFee(750_000, 2.5));
    }

    @Test
    void TC_05_should_return_30000() {
        assertEquals(30_000,
                ShippingFeeCalculator.calculateShippingFee(750_000, 7.5));
    }
}