package blackboxTesting.decisionTable;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.testing.LibraryFineLevelCalculator;

class LibraryFineLevelCalculatorTest {

    @Test
    void TC_01_INVALID_bookType() {
        assertEquals("INVALID",
                LibraryFineLevelCalculator.calculateLibraryFineLevel("INVALID", 4, 5, 4));
    }

    @Test
    void TC_02_INVALID_lateDays() {
        assertEquals("INVALID",
                LibraryFineLevelCalculator.calculateLibraryFineLevel("NORMAL", -10, 5, 4));
    }

    @Test
    void TC_03_INVALID_memberYears() {
        assertEquals("INVALID",
                LibraryFineLevelCalculator.calculateLibraryFineLevel("NORMAL", 4, -10, 4));
    }

    @Test
    void TC_04_INVALID_violationCount() {
        assertEquals("INVALID",
                LibraryFineLevelCalculator.calculateLibraryFineLevel("NORMAL", 4, 5, -10));
    }

    @Test
    void TC_05_NONE() {
        assertEquals("NONE",
                LibraryFineLevelCalculator.calculateLibraryFineLevel("RARE", 0, 5, 5));
    }

    @Test
    void TC_06_LOW() {
        assertEquals("LOW",
                LibraryFineLevelCalculator.calculateLibraryFineLevel("NORMAL", 2, 5, 1));
    }

    @Test
    void TC_07_MEDIUM() {
        assertEquals("MEDIUM",
                LibraryFineLevelCalculator.calculateLibraryFineLevel("NORMAL", 5, 5, 1));
    }

    @Test
    void TC_08_MEDIUM() {
        assertEquals("MEDIUM",
                LibraryFineLevelCalculator.calculateLibraryFineLevel("REFERENCE", 2, 5, 1));
    }

    @Test
    void TC_09_HIGH() {
        assertEquals("HIGH",
                LibraryFineLevelCalculator.calculateLibraryFineLevel("NORMAL", 10, 5, 1));
    }

    @Test
    void TC_10_HIGH() {
        assertEquals("HIGH",
                LibraryFineLevelCalculator.calculateLibraryFineLevel("REFERENCE", 5, 5, 1));
    }

    @Test
    void TC_11_HIGH() {
        assertEquals("HIGH",
                LibraryFineLevelCalculator.calculateLibraryFineLevel("RARE", 2, 5, 1));
    }

    @Test
    void TC_12_SEVERE() {
        assertEquals("SEVERE",
                LibraryFineLevelCalculator.calculateLibraryFineLevel("NORMAL", 17, 5, 1));
    }

    @Test
    void TC_13_SEVERE() {
        assertEquals("SEVERE",
                LibraryFineLevelCalculator.calculateLibraryFineLevel("RARE", 5, 5, 1));
    }

    @Test
    void TC_14_SEVERE() {
        assertEquals("SEVERE",
                LibraryFineLevelCalculator.calculateLibraryFineLevel("REFERENCE", 9, 5, 1));
    }

    @Test
    void TC_15_SEVERE_with_memberYears_0() {
        assertEquals("SEVERE",
                LibraryFineLevelCalculator.calculateLibraryFineLevel("NORMAL", 3, 0, 5));
    }

    @Test
    void TC_16_SEVERE_with_violationCount_5() {
        assertEquals("SEVERE",
                LibraryFineLevelCalculator.calculateLibraryFineLevel("RARE", 3, 5, 5));
    }
}