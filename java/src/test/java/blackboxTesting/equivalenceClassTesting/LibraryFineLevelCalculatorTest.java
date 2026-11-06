package blackboxTesting.equivalenceClassTesting;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.testing.LibraryFineLevelCalculator;

class LibraryFineLevelCalculatorTest {

    @Test
    void TC_01_INVALID() {
        assertEquals("INVALID",
                LibraryFineLevelCalculator.calculateLibraryFineLevel("INVALID", 2, 5, 5));
    }

    @Test
    void TC_02_NONE() {
        assertEquals("NONE",
                LibraryFineLevelCalculator.calculateLibraryFineLevel("NORMAL", 0, 5, 5));
    }

    @Test
    void TC_03_LOW() {
        assertEquals("LOW",
                LibraryFineLevelCalculator.calculateLibraryFineLevel("NORMAL", 2, 3, 1));
    }

    @Test
    void TC_04_MEDIUM() {
        assertEquals("MEDIUM",
                LibraryFineLevelCalculator.calculateLibraryFineLevel("NORMAL", 5, 3, 1));
    }

    @Test
    void TC_05_HIGH() {
        assertEquals("HIGH",
                LibraryFineLevelCalculator.calculateLibraryFineLevel("REFERENCE", 5, 3, 1));
    }

    @Test
    void TC_06_SEVERE() {
        assertEquals("SEVERE",
                LibraryFineLevelCalculator.calculateLibraryFineLevel("RARE", 5, 3, 1));
    }
}