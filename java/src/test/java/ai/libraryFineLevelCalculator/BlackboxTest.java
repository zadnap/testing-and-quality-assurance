package ai.libraryFineLevelCalculator;

import static com.testing.LibraryFineLevelCalculator.calculateLibraryFineLevel;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * 3. JUNIT 5 PARAMETERIZED TEST THỰC THI TOÀN BỘ 44 TEST CASE
 */

public class BlackboxTest {

    @ParameterizedTest(name = "Test ID {0}: bookType={1}, lateDays={2}, memberYears={3}, violationCount={4} => Expected: {5}")
    @CsvSource(delimiter = '|', nullValues = "null", textBlock = """
        # =========================================================================================================
        # PHẦN 1: 22 TEST CASES - KỸ THUẬT PHÂN TÍCH GIÁ TRỊ BIÊN (BVA)
        # =========================================================================================================
        # Test ID   | bookType  | lateDays | memberYears | violationCount | Expected Output
        01 (BVA)    | NORMAL    | -1       | 3           | 1              | INVALID
        02 (BVA)    | NORMAL    | 0        | 3           | 1              | NONE
        03 (BVA)    | NORMAL    | 1        | 3           | 1              | LOW
        04 (BVA)    | NORMAL    | 2        | 3           | 1              | LOW
        05 (BVA)    | NORMAL    | 3        | 3           | 1              | LOW
        06 (BVA)    | NORMAL    | 4        | 3           | 1              | MEDIUM
        07 (BVA)    | NORMAL    | 6        | 3           | 1              | MEDIUM
        08 (BVA)    | NORMAL    | 7        | 3           | 1              | MEDIUM
        09 (BVA)    | NORMAL    | 8        | 3           | 1              | HIGH
        10 (BVA)    | NORMAL    | 13       | 3           | 1              | HIGH
        11 (BVA)    | NORMAL    | 14       | 3           | 1              | HIGH
        12 (BVA)    | NORMAL    | 15       | 3           | 1              | SEVERE
        13 (BVA)    | NORMAL    | 5        | -1          | 1              | INVALID
        14 (BVA)    | NORMAL    | 5        | 0           | 1              | SEVERE
        15 (BVA)    | NORMAL    | 5        | 1           | 1              | MEDIUM
        16 (BVA)    | NORMAL    | 5        | 2           | 1              | MEDIUM
        17 (BVA)    | NORMAL    | 5        | 3           | -1             | INVALID
        18 (BVA)    | NORMAL    | 5        | 3           | 0              | MEDIUM
        19 (BVA)    | NORMAL    | 5        | 3           | 1              | MEDIUM
        20 (BVA)    | NORMAL    | 5        | 3           | 2              | MEDIUM
        21 (BVA)    | NORMAL    | 5        | 3           | 3              | SEVERE
        22 (BVA)    | NORMAL    | 5        | 3           | 1              | MEDIUM
        # =========================================================================================================
        # PHẦN 2: 06 TEST CASES - PHÂN HOẠCH TƯƠNG ĐƯƠNG THEO ĐẦU RA (EP)
        # =========================================================================================================
        23 (EP)     | NORMAL    | -5       | 3           | 1              | INVALID
        24 (EP)     | NORMAL    | 0        | 2           | 1              | NONE
        25 (EP)     | NORMAL    | 2        | 3           | 1              | LOW
        26 (EP)     | NORMAL    | 5        | 2           | 1              | MEDIUM
        27 (EP)     | NORMAL    | 10       | 4           | 0              | HIGH
        28 (EP)     | NORMAL    | 20       | 2           | 1              | SEVERE
        # =========================================================================================================
        # PHẦN 3: 16 TEST CASES - BẢNG QUYẾT ĐỊNH (DT)
        # =========================================================================================================
        29 (DT)     | null      | 5        | 2           | 1              | INVALID
        30 (DT)     | NORMAL    | -1       | 2           | 1              | INVALID
        31 (DT)     | NORMAL    | 5        | -1          | 1              | INVALID
        32 (DT)     | NORMAL    | 5        | 2           | -1             | INVALID
        33 (DT)     | NORMAL    | 0        | 2           | 1              | NONE
        34 (DT)     | NORMAL    | 2        | 0           | 1              | SEVERE
        35 (DT)     | NORMAL    | 2        | 2           | 3              | SEVERE
        36 (DT)     | NORMAL    | 2        | 2           | 1              | LOW
        37 (DT)     | NORMAL    | 5        | 2           | 1              | MEDIUM
        38 (DT)     | NORMAL    | 10       | 2           | 1              | HIGH
        39 (DT)     | NORMAL    | 15       | 2           | 1              | SEVERE
        40 (DT)     | REFERENCE | 2        | 2           | 1              | MEDIUM
        41 (DT)     | REFERENCE | 5        | 2           | 1              | HIGH
        42 (DT)     | REFERENCE | 10       | 2           | 1              | SEVERE
        43 (DT)     | RARE      | 2        | 2           | 1              | HIGH
        44 (DT)     | RARE      | 5        | 2           | 1              | SEVERE
        """)
    @DisplayName("Kiểm thử tự động 44 test cases kết hợp 3 kỹ thuật BVA, EP và DT")
    void testCalculateLibraryFineLevelCombined(
            String testId, 
            String bookType, 
            int lateDays, 
            int memberYears, 
            int violationCount, 
            String expectedOutput) {

        String actualOutput = calculateLibraryFineLevel(bookType, lateDays, memberYears, violationCount);
        assertEquals(expectedOutput, actualOutput, "Thất bại tại Test ID: " + testId);
    }
}