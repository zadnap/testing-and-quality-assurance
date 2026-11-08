package ai.shippingFeeCalculator;

import static com.testing.ShippingFeeCalculator.calculateShippingFee;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BlackboxTest {

    @ParameterizedTest(name = "[{0}] {1} | orderValue={2}, weight={3} => EO={4}")
    @CsvSource({
        // =========================================================================
        // 1. PHÂN TÍCH GIÁ TRỊ BIÊN (BVA: 16 test cases)
        // =========================================================================
        "01, BVA,      -1,  2.50,     -1",  // min- (orderValue)
        "02, BVA,       0,  2.50,  30000",  // min (orderValue)
        "03, BVA,       1,  2.50,  30000",  // min+ (orderValue)
        "04, BVA,  499999,  2.50,  30000",  // point- (500k)
        "05, BVA,  500000,  2.50,  10000",  // point (500k)
        "06, BVA,  500001,  2.50,  10000",  // point+ (500k)
        "07, BVA,  250000, -0.01,     -1",  // min- (weight)
        "08, BVA,  250000,  0.00,     -1",  // min (weight)
        "09, BVA,  250000,  0.01,  30000",  // min+ (weight)
        "10, BVA,  250000,  4.99,  30000",  // point- (5.00)
        "11, BVA,  250000,  5.00,  30000",  // point (5.00)
        "12, BVA,  250000,  5.01,  50000",  // point+ (5.00)
        "13, BVA,  250000, 19.99,  50000",  // max- (weight)
        "14, BVA,  250000, 20.00,  50000",  // max (weight)
        "15, BVA,  250000, 20.01,     -1",  // max+ (weight)
        "16, BVA,  250000,  2.50,  30000",  // All-norm

        // =========================================================================
        // 2. PHÂN HOẠCH TƯƠNG ĐƯƠNG THEO ĐẦU RA (ECT: 4 test cases)
        // =========================================================================
        "17, ECT,  -50000, 10.00,     -1",  // Lớp đầu ra: -1
        "18, ECT,  200000,  3.00,  30000",  // Lớp đầu ra: 30,000
        "19, ECT,  300000, 12.00,  50000",  // Lớp đầu ra: 50,000
        "20, ECT,  750000,  2.00,  10000",  // Lớp đầu ra: 10,000

        // =========================================================================
        // 3. BẢNG QUYẾT ĐỊNH (DT: 6 test cases)
        // =========================================================================
        "21, DT,   -10000,  2.50,     -1",  // Rule 1: C1=F, C2=T
        "22, DT,   200000, 25.00,     -1",  // Rule 2: C1=T, C2=F
        "23, DT,   200000,  2.50,  30000",  // Rule 3: C1=T, C2=T, C3=T, C4=T
        "24, DT,   200000, 10.00,  50000",  // Rule 4: C1=T, C2=T, C3=T, C4=F
        "25, DT,   600000,  2.50,  10000",  // Rule 5: C1=T, C2=T, C3=F, C4=T
        "26, DT,   600000, 10.00,  30000"   // Rule 6: C1=T, C2=T, C3=F, C4=F
    })
    @DisplayName("Unified Test Suite: BVA + ECT + DT for calculateShippingFee")
    void testCalculateShippingFeeUnified(String testId, String technique, long orderValue, double weight, int expectedOutput) {
        // Gọi hàm từ class bên ngoài (thay thế bằng ClassName.calculateShippingFee nếu không dùng static import)
        int actualOutput = calculateShippingFee(orderValue, weight);
        
        assertEquals(expectedOutput, actualOutput, 
            String.format("Failed at [%s] (%s) with orderValue=%d, weight=%.2f", 
                testId, technique, orderValue, weight));
    }
}