package whiteboxTesting.controlFlowTesting;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.testing.LibraryFineLevelCalculator;

class LibraryFineLevelCalculatorTest {

    @Test
    void TC_01_Invalid_bookType() {
        assertEquals("INVALID",
                LibraryFineLevelCalculator.calculateLibraryFineLevel("INVALID", 5, 5, 5));
    }

    @Test
    void TC_02_Negative_lateDays() {
        assertEquals("INVALID",
                LibraryFineLevelCalculator.calculateLibraryFineLevel("NORMAL", -5, 5, 5));
    }

    @Test
    void TC_03_Negative_memberYears() {
        assertEquals("INVALID",
                LibraryFineLevelCalculator.calculateLibraryFineLevel("NORMAL", 5, -5, 5));
    }

    @Test
    void TC_04_Negative_violationCount() {
        assertEquals("INVALID",
                LibraryFineLevelCalculator.calculateLibraryFineLevel("NORMAL", 5, 5, -5));
    }

    @Test
    void TC_05_No_late_days() {
        assertEquals("NONE",
                LibraryFineLevelCalculator.calculateLibraryFineLevel("NORMAL", 0, 5, 5));
    }

    @Test
    void TC_06_NORMAL_book_with_zero_member_years() {
        assertEquals("SEVERE",
                LibraryFineLevelCalculator.calculateLibraryFineLevel("NORMAL", 5, 0, 5));
    }

    @Test
    void TC_07_NORMAL_book_with_5_violations() {
        assertEquals("SEVERE",
                LibraryFineLevelCalculator.calculateLibraryFineLevel("NORMAL", 5, 5, 5));
    }

    @Test
    void TC_08_RARE_book_with_5_violations() {
        assertEquals("SEVERE",
                LibraryFineLevelCalculator.calculateLibraryFineLevel("RARE", 5, 5, 5));
    }

    @Test
    void TC_09_NORMAL_book_3_late_days() {
        assertEquals("LOW",
                LibraryFineLevelCalculator.calculateLibraryFineLevel("NORMAL", 3, 5, 1));
    }

    @Test
    void TC_10_NORMAL_book_5_late_days() {
        assertEquals("MEDIUM",
                LibraryFineLevelCalculator.calculateLibraryFineLevel("NORMAL", 5, 5, 1));
    }

    @Test
    void TC_11_NORMAL_book_10_late_days() {
        assertEquals("HIGH",
                LibraryFineLevelCalculator.calculateLibraryFineLevel("NORMAL", 10, 5, 1));
    }

    @Test
    void TC_12_NORMAL_book_18_late_days() {
        assertEquals("SEVERE",
                LibraryFineLevelCalculator.calculateLibraryFineLevel("NORMAL", 18, 5, 1));
    }

    @Test
    void TC_13_RARE_book_2_late_days() {
        assertEquals("HIGH",
                LibraryFineLevelCalculator.calculateLibraryFineLevel("RARE", 2, 5, 1));
    }

    @Test
    void TC_14_RARE_book_5_late_days() {
        assertEquals("SEVERE",
                LibraryFineLevelCalculator.calculateLibraryFineLevel("RARE", 5, 5, 1));
    }

    @Test
    void TC_15_REFERENCE_book_3_late_days() {
        assertEquals("MEDIUM",
                LibraryFineLevelCalculator.calculateLibraryFineLevel("REFERENCE", 3, 5, 1));
    }

    @Test
    void TC_16_REFERENCE_book_5_late_days() {
        assertEquals("HIGH",
                LibraryFineLevelCalculator.calculateLibraryFineLevel("REFERENCE", 5, 5, 1));
    }

    @Test
    void TC_17_REFERENCE_book_18_late_days() {
        assertEquals("SEVERE",
                LibraryFineLevelCalculator.calculateLibraryFineLevel("REFERENCE", 18, 5, 1));
    }
}