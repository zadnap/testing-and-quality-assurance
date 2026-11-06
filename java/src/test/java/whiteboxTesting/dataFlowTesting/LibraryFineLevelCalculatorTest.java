package whiteboxTesting.dataFlowTesting;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.testing.LibraryFineLevelCalculator;

class LibraryFineLevelCalculatorTest {

    @Test
    void TC_01_negative_lateDays_returns_INVALID() {
        assertEquals("INVALID",
                LibraryFineLevelCalculator.calculateLibraryFineLevel("NORMAL", -10, 5, 5));
    }

    @Test
    void TC_02_zero_lateDays_returns_NONE() {
        assertEquals("NONE",
                LibraryFineLevelCalculator.calculateLibraryFineLevel("RARE", 0, 8, 5));
    }

    @Test
    void TC_03_REFERENCE_book_10_lateDays_returns_SEVERE() {
        assertEquals("SEVERE",
                LibraryFineLevelCalculator.calculateLibraryFineLevel("REFERENCE", 10, 10, 5));
    }

    @Test
    void TC_04_NORMAL_book_2_lateDays_returns_LOW() {
        assertEquals("LOW",
                LibraryFineLevelCalculator.calculateLibraryFineLevel("NORMAL", 2, 9, 1));
    }

    @Test
    void TC_05_NORMAL_book_5_lateDays_returns_MEDIUM() {
        assertEquals("MEDIUM",
                LibraryFineLevelCalculator.calculateLibraryFineLevel("NORMAL", 5, 5, 1));
    }

    @Test
    void TC_06_NORMAL_book_10_lateDays_returns_HIGH() {
        assertEquals("HIGH",
                LibraryFineLevelCalculator.calculateLibraryFineLevel("NORMAL", 10, 6, 1));
    }

    @Test
    void TC_07_REFERENCE_book_2_lateDays_returns_MEDIUM() {
        assertEquals("MEDIUM",
                LibraryFineLevelCalculator.calculateLibraryFineLevel("REFERENCE", 2, 5, 1));
    }

    @Test
    void TC_08_REFERENCE_book_5_lateDays_returns_HIGH() {
        assertEquals("HIGH",
                LibraryFineLevelCalculator.calculateLibraryFineLevel("REFERENCE", 5, 9, 1));
    }

    @Test
    void TC_09_REFERENCE_book_10_lateDays_returns_SEVERE() {
        assertEquals("SEVERE",
                LibraryFineLevelCalculator.calculateLibraryFineLevel("REFERENCE", 10, 11, 1));
    }

    @Test
    void TC_10_RARE_book_5_lateDays_returns_SEVERE() {
        assertEquals("SEVERE",
                LibraryFineLevelCalculator.calculateLibraryFineLevel("RARE", 5, 10, 1));
    }

    @Test
    void TC_11_NORMAL_book_17_lateDays_returns_SEVERE() {
        assertEquals("SEVERE",
                LibraryFineLevelCalculator.calculateLibraryFineLevel("NORMAL", 17, 5, 1));
    }
}