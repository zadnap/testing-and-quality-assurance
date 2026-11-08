
package manual.shippingFeeCalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.testing.ShippingFeeCalculator;

class ShippingFeeCalculatorTest {

    // =====================================
    // 1. Control Flow Testing (CFT)
    // =====================================

    @Test
    void CFT_TC_01_orderValue_less_than_0() {
        int result = ShippingFeeCalculator.calculateShippingFee(-5, 5.0);

        assertEquals(-1, result);
    }

    @Test
    void CFT_TC_02_weight_less_than_or_equal_0() {
        int result = ShippingFeeCalculator.calculateShippingFee(5, -5.0);

        assertEquals(-1, result);
    }

    @Test
    void CFT_TC_03_weight_greater_than_20() {
        int result = ShippingFeeCalculator.calculateShippingFee(5, 25.0);

        assertEquals(-1, result);
    }

    @Test
    void CFT_TC_04_orderValue_less_than_500000_and_weight_less_than_or_equal_5() {
        int result = ShippingFeeCalculator.calculateShippingFee(400_000, 2.5);

        assertEquals(30_000, result);
    }

    @Test
    void CFT_TC_05_orderValue_less_than_500000_and_weight_greater_than_5() {
        int result = ShippingFeeCalculator.calculateShippingFee(400_000, 8.0);

        assertEquals(50_000, result);
    }

    @Test
    void CFT_TC_06_orderValue_greater_than_or_equal_500000_and_weight_less_than_or_equal_5() {
        int result = ShippingFeeCalculator.calculateShippingFee(700_000, 2.5);

        assertEquals(10_000, result);
    }

    @Test
    void CFT_TC_07_orderValue_greater_than_or_equal_500000_and_weight_greater_than_5() {
        int result = ShippingFeeCalculator.calculateShippingFee(700_000, 8.0);

        assertEquals(30_000, result);
    }


    // =====================================
    // 2. Data Flow Testing (DFT)
    // =====================================

    @Test
    void DFT_TC_01_reject_negative_orderValue_and_weight() {
        assertEquals(-1,
                ShippingFeeCalculator.calculateShippingFee(-10, -10.0));
    }

    @Test
    void DFT_TC_02_should_return_50000() {
        assertEquals(50_000,
                ShippingFeeCalculator.calculateShippingFee(250_000, 7.5));
    }

    @Test
    void DFT_TC_03_should_return_30000() {
        assertEquals(30_000,
                ShippingFeeCalculator.calculateShippingFee(250_000, 2.5));
    }

    @Test
    void DFT_TC_04_should_return_10000() {
        assertEquals(10_000,
                ShippingFeeCalculator.calculateShippingFee(750_000, 2.5));
    }

    @Test
    void DFT_TC_05_should_return_30000() {
        assertEquals(30_000,
                ShippingFeeCalculator.calculateShippingFee(750_000, 7.5));
    }
}
