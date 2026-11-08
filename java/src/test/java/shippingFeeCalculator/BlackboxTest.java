package shippingFeeCalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.testing.ShippingFeeCalculator;

class BlackboxTest {

    @Nested
    @DisplayName("Boundary Value Analysis (BVA)")
    class BoundaryValueAnalysis {

        @Test
        void TC_01() {
            assertEquals(30_000,
                    ShippingFeeCalculator.calculateShippingFee(900_000, 10.0));
        }

        @Test
        void TC_02() {
            assertEquals(-1,
                    ShippingFeeCalculator.calculateShippingFee(900_000, 0.0));
        }

        @Test
        void TC_03() {
            assertEquals(10_000,
                    ShippingFeeCalculator.calculateShippingFee(900_000, 5.0));
        }

        @Test
        void TC_04() {
            assertEquals(30_000,
                    ShippingFeeCalculator.calculateShippingFee(900_000, 20.0));
        }

        @Test
        void TC_05() {
            assertEquals(-1,
                    ShippingFeeCalculator.calculateShippingFee(900_000, -0.01));
        }

        @Test
        void TC_06() {
            assertEquals(10_000,
                    ShippingFeeCalculator.calculateShippingFee(900_000, 0.01));
        }

        @Test
        void TC_07() {
            assertEquals(10_000,
                    ShippingFeeCalculator.calculateShippingFee(900_000, 4.99));
        }

        @Test
        void TC_08() {
            assertEquals(30_000,
                    ShippingFeeCalculator.calculateShippingFee(900_000, 5.01));
        }

        @Test
        void TC_09() {
            assertEquals(30_000,
                    ShippingFeeCalculator.calculateShippingFee(900_000, 19.99));
        }

        @Test
        void TC_10() {
            assertEquals(-1,
                    ShippingFeeCalculator.calculateShippingFee(900_000, 20.01));
        }

        @Test
        void TC_11() {
            assertEquals(50_000,
                    ShippingFeeCalculator.calculateShippingFee(0, 10.0));
        }

        @Test
        void TC_12() {
            assertEquals(30_000,
                    ShippingFeeCalculator.calculateShippingFee(500_000, 10.0));
        }

        @Test
        void TC_13() {
            assertEquals(-1,
                    ShippingFeeCalculator.calculateShippingFee(-1, 10.0));
        }

        @Test
        void TC_14() {
            assertEquals(50_000,
                    ShippingFeeCalculator.calculateShippingFee(1, 10.0));
        }

        @Test
        void TC_15() {
            assertEquals(50_000,
                    ShippingFeeCalculator.calculateShippingFee(499_999, 10.0));
        }

        @Test
        void TC_16() {
            assertEquals(30_000,
                    ShippingFeeCalculator.calculateShippingFee(500_001, 10.0));
        }
    }

    @Nested
    @DisplayName("Decision Table Testing")
    class DecisionTable {

        @Test
        void TC_01_orderValue_less_than_0() {
            assertEquals(-1,
                    ShippingFeeCalculator.calculateShippingFee(-100, 10.0));
        }

        @Test
        void TC_02_weight_greater_than_20() {
            assertEquals(-1,
                    ShippingFeeCalculator.calculateShippingFee(250_000, 50.0));
        }

        @Test
        void TC_03_orderValue_less_than_500000_and_weight_less_than_or_equal_5() {
            assertEquals(30_000,
                    ShippingFeeCalculator.calculateShippingFee(250_000, 2.5));
        }

        @Test
        void TC_04_orderValue_greater_than_or_equal_500000_and_weight_greater_than_5() {
            assertEquals(30_000,
                    ShippingFeeCalculator.calculateShippingFee(750_000, 12.5));
        }

        @Test
        void TC_05_orderValue_less_than_500000_and_weight_greater_than_5() {
            assertEquals(50_000,
                    ShippingFeeCalculator.calculateShippingFee(250_000, 12.5));
        }

        @Test
        void TC_06_orderValue_greater_than_or_equal_500000_and_weight_less_than_or_equal_5() {
            assertEquals(10_000,
                    ShippingFeeCalculator.calculateShippingFee(750_000, 2.5));
        }
    }

    @Nested
    @DisplayName("Equivalence Class Testing")
    class EquivalenceClass {

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
}