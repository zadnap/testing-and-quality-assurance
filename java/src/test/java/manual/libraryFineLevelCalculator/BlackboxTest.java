
package manual.libraryFineLevelCalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.testing.LibraryFineLevelCalculator;

class BlackboxTest {

    // ==============================
    // 1. Boundary Value Analysis
    // ==============================

    @Test
    void BVA_TC_01() {
        assertEquals("SEVERE",
            LibraryFineLevelCalculator.calculateLibraryFineLevel("RARE", 20, 5, 5));
    }

    @Test
    void BVA_TC_02() {
        assertEquals("NONE",
            LibraryFineLevelCalculator.calculateLibraryFineLevel("NORMAL", 0, 5, 5));
    }

    @Test
    void BVA_TC_03() {
        assertEquals("SEVERE",
            LibraryFineLevelCalculator.calculateLibraryFineLevel("REFERENCE", 3, 5, 5));
    }

    @Test
    void BVA_TC_04() {
        assertEquals("SEVERE",
            LibraryFineLevelCalculator.calculateLibraryFineLevel("NORMAL", 7, 5, 5));
    }

    @Test
    void BVA_TC_05() {
        assertEquals("SEVERE",
            LibraryFineLevelCalculator.calculateLibraryFineLevel("RARE", 14, 5, 5));
    }

    @Test
    void BVA_TC_06() {
        assertEquals("INVALID",
            LibraryFineLevelCalculator.calculateLibraryFineLevel("RARE", -1, 5, 5));
    }

    @Test
    void BVA_TC_07() {
        assertEquals("SEVERE",
            LibraryFineLevelCalculator.calculateLibraryFineLevel("REFERENCE", 1, 5, 5));
    }

    @Test
    void BVA_TC_08() {
        assertEquals("SEVERE",
            LibraryFineLevelCalculator.calculateLibraryFineLevel("NORMAL", 2, 5, 5));
    }

    @Test
    void BVA_TC_09() {
        assertEquals("SEVERE",
            LibraryFineLevelCalculator.calculateLibraryFineLevel("REFERENCE", 4, 5, 5));
    }

    @Test
    void BVA_TC_10() {
        assertEquals("SEVERE",
            LibraryFineLevelCalculator.calculateLibraryFineLevel("RARE", 6, 5, 5));
    }

    @Test
    void BVA_TC_11() {
        assertEquals("SEVERE",
            LibraryFineLevelCalculator.calculateLibraryFineLevel("NORMAL", 8, 5, 5));
    }

    @Test
    void BVA_TC_12() {
        assertEquals("SEVERE",
            LibraryFineLevelCalculator.calculateLibraryFineLevel("REFERENCE", 13, 5, 5));
    }

    @Test
    void BVA_TC_13() {
        assertEquals("SEVERE",
            LibraryFineLevelCalculator.calculateLibraryFineLevel("RARE", 15, 5, 5));
    }

    @Test
    void BVA_TC_14() {
        assertEquals("SEVERE",
            LibraryFineLevelCalculator.calculateLibraryFineLevel("NORMAL", 20, 0, 5));
    }

    @Test
    void BVA_TC_15() {
        assertEquals("SEVERE",
            LibraryFineLevelCalculator.calculateLibraryFineLevel("NORMAL", 20, 1, 5));
    }

    @Test
    void BVA_TC_16() {
        assertEquals("INVALID",
            LibraryFineLevelCalculator.calculateLibraryFineLevel("RARE", 20, -1, 5));
    }

    @Test
    void BVA_TC_17() {
        assertEquals("SEVERE",
            LibraryFineLevelCalculator.calculateLibraryFineLevel("REFERENCE", 20, 2, 5));
    }

    @Test
    void BVA_TC_18() {
        assertEquals("SEVERE",
            LibraryFineLevelCalculator.calculateLibraryFineLevel("NORMAL", 20, 5, 0));
    }

    @Test
    void BVA_TC_19() {
        assertEquals("SEVERE",
            LibraryFineLevelCalculator.calculateLibraryFineLevel("RARE", 20, 5, 2));
    }

    @Test
    void BVA_TC_20() {
        assertEquals("INVALID",
            LibraryFineLevelCalculator.calculateLibraryFineLevel("REFERENCE", 20, 5, -1));
    }

    @Test
    void BVA_TC_21() {
        assertEquals("SEVERE",
            LibraryFineLevelCalculator.calculateLibraryFineLevel("NORMAL", 20, 5, 1));
    }

    @Test
    void BVA_TC_22() {
        assertEquals("SEVERE",
            LibraryFineLevelCalculator.calculateLibraryFineLevel("RARE", 20, 5, 3));
    }


    // ==============================
    // 2. Decision Table Testing
    // ==============================

    @Test
    void DT_TC_01_INVALID_bookType() {
        assertEquals("INVALID",
            LibraryFineLevelCalculator.calculateLibraryFineLevel("INVALID", 4, 5, 4));
    }

    @Test
    void DT_TC_02_INVALID_lateDays() {
        assertEquals("INVALID",
            LibraryFineLevelCalculator.calculateLibraryFineLevel("NORMAL", -10, 5, 4));
    }

    @Test
    void DT_TC_03_INVALID_memberYears() {
        assertEquals("INVALID",
            LibraryFineLevelCalculator.calculateLibraryFineLevel("NORMAL", 4, -10, 4));
    }

    @Test
    void DT_TC_04_INVALID_violationCount() {
        assertEquals("INVALID",
            LibraryFineLevelCalculator.calculateLibraryFineLevel("NORMAL", 4, 5, -10));
    }

    @Test
    void DT_TC_05_NONE() {
        assertEquals("NONE",
            LibraryFineLevelCalculator.calculateLibraryFineLevel("RARE", 0, 5, 5));
    }

    @Test
    void DT_TC_06_LOW() {
        assertEquals("LOW",
            LibraryFineLevelCalculator.calculateLibraryFineLevel("NORMAL", 2, 5, 1));
    }

    @Test
    void DT_TC_07_MEDIUM() {
        assertEquals("MEDIUM",
            LibraryFineLevelCalculator.calculateLibraryFineLevel("NORMAL", 5, 5, 1));
    }

    @Test
    void DT_TC_08_MEDIUM() {
        assertEquals("MEDIUM",
            LibraryFineLevelCalculator.calculateLibraryFineLevel("REFERENCE", 2, 5, 1));
    }

    @Test
    void DT_TC_09_HIGH() {
        assertEquals("HIGH",
            LibraryFineLevelCalculator.calculateLibraryFineLevel("NORMAL", 10, 5, 1));
    }

    @Test
    void DT_TC_10_HIGH() {
        assertEquals("HIGH",
            LibraryFineLevelCalculator.calculateLibraryFineLevel("REFERENCE", 5, 5, 1));
    }

    @Test
    void DT_TC_11_HIGH() {
        assertEquals("HIGH",
            LibraryFineLevelCalculator.calculateLibraryFineLevel("RARE", 2, 5, 1));
    }

    @Test
    void DT_TC_12_SEVERE() {
        assertEquals("SEVERE",
            LibraryFineLevelCalculator.calculateLibraryFineLevel("NORMAL", 17, 5, 1));
    }

    @Test
    void DT_TC_13_SEVERE() {
        assertEquals("SEVERE",
            LibraryFineLevelCalculator.calculateLibraryFineLevel("RARE", 5, 5, 1));
    }

    @Test
    void DT_TC_14_SEVERE() {
        assertEquals("SEVERE",
            LibraryFineLevelCalculator.calculateLibraryFineLevel("REFERENCE", 9, 5, 1));
    }

    @Test
    void DT_TC_15_SEVERE_with_memberYears_0() {
        assertEquals("SEVERE",
            LibraryFineLevelCalculator.calculateLibraryFineLevel("NORMAL", 3, 0, 5));
    }

    @Test
    void DT_TC_16_SEVERE_with_violationCount_5() {
        assertEquals("SEVERE",
            LibraryFineLevelCalculator.calculateLibraryFineLevel("RARE", 3, 5, 5));
    }


    // ==============================
    // 3. Equivalence Class Testing
    // ==============================

    @Test
    void ECT_TC_01_INVALID() {
        assertEquals("INVALID",
            LibraryFineLevelCalculator.calculateLibraryFineLevel("INVALID", 2, 5, 5));
    }

    @Test
    void ECT_TC_02_NONE() {
        assertEquals("NONE",
            LibraryFineLevelCalculator.calculateLibraryFineLevel("NORMAL", 0, 5, 5));
    }

    @Test
    void ECT_TC_03_LOW() {
        assertEquals("LOW",
            LibraryFineLevelCalculator.calculateLibraryFineLevel("NORMAL", 2, 3, 1));
    }

    @Test
    void ECT_TC_04_MEDIUM() {
        assertEquals("MEDIUM",
            LibraryFineLevelCalculator.calculateLibraryFineLevel("NORMAL", 5, 3, 1));
    }

    @Test
    void ECT_TC_05_HIGH() {
        assertEquals("HIGH",
            LibraryFineLevelCalculator.calculateLibraryFineLevel("REFERENCE", 5, 3, 1));
    }

    @Test
    void ECT_TC_06_SEVERE() {
        assertEquals("SEVERE",
            LibraryFineLevelCalculator.calculateLibraryFineLevel("RARE", 5, 3, 1));
    }
}
