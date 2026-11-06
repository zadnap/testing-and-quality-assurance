package blackboxTesting.boundaryValueAnalysis;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.testing.LibraryFineLevelCalculator;

class LibraryFineLevelCalculatorTest {

    @Test
    void TC_01() {
        assertEquals("SEVERE",
            LibraryFineLevelCalculator.calculateLibraryFineLevel("RARE", 20, 5, 5));
    }

    @Test
    void TC_02() {
        assertEquals("NONE",
            LibraryFineLevelCalculator.calculateLibraryFineLevel("NORMAL", 0, 5, 5));
    }

    @Test
    void TC_03() {
        assertEquals("SEVERE",
            LibraryFineLevelCalculator.calculateLibraryFineLevel("REFERENCE", 3, 5, 5));
    }

    @Test
    void TC_04() {
        assertEquals("SEVERE",
            LibraryFineLevelCalculator.calculateLibraryFineLevel("NORMAL", 7, 5, 5));
    }

    @Test
    void TC_05() {
        assertEquals("SEVERE",
            LibraryFineLevelCalculator.calculateLibraryFineLevel("RARE", 14, 5, 5));
    }

    @Test
    void TC_06() {
        assertEquals("INVALID",
            LibraryFineLevelCalculator.calculateLibraryFineLevel("RARE", -1, 5, 5));
    }

    @Test
    void TC_07() {
        assertEquals("SEVERE",
            LibraryFineLevelCalculator.calculateLibraryFineLevel("REFERENCE", 1, 5, 5));
    }

    @Test
    void TC_08() {
        assertEquals("SEVERE",
            LibraryFineLevelCalculator.calculateLibraryFineLevel("NORMAL", 2, 5, 5));
    }

    @Test
    void TC_09() {
        assertEquals("SEVERE",
            LibraryFineLevelCalculator.calculateLibraryFineLevel("REFERENCE", 4, 5, 5));
    }

    @Test
    void TC_10() {
        assertEquals("SEVERE",
            LibraryFineLevelCalculator.calculateLibraryFineLevel("RARE", 6, 5, 5));
    }

    @Test
    void TC_11() {
        assertEquals("SEVERE",
            LibraryFineLevelCalculator.calculateLibraryFineLevel("NORMAL", 8, 5, 5));
    }

    @Test
    void TC_12() {
        assertEquals("SEVERE",
            LibraryFineLevelCalculator.calculateLibraryFineLevel("REFERENCE", 13, 5, 5));
    }

    @Test
    void TC_13() {
        assertEquals("SEVERE",
            LibraryFineLevelCalculator.calculateLibraryFineLevel("RARE", 15, 5, 5));
    }

    @Test
    void TC_14() {
        assertEquals("SEVERE",
            LibraryFineLevelCalculator.calculateLibraryFineLevel("NORMAL", 20, 0, 5));
    }

    @Test
    void TC_15() {
        assertEquals("SEVERE",
            LibraryFineLevelCalculator.calculateLibraryFineLevel("NORMAL", 20, 1, 5));
    }

    @Test
    void TC_16() {
        assertEquals("INVALID",
            LibraryFineLevelCalculator.calculateLibraryFineLevel("RARE", 20, -1, 5));
    }

    @Test
    void TC_17() {
        assertEquals("SEVERE",
            LibraryFineLevelCalculator.calculateLibraryFineLevel("REFERENCE", 20, 2, 5));
    }

    @Test
    void TC_18() {
        assertEquals("SEVERE",
            LibraryFineLevelCalculator.calculateLibraryFineLevel("NORMAL", 20, 5, 0));
    }

    @Test
    void TC_19() {
        assertEquals("SEVERE",
            LibraryFineLevelCalculator.calculateLibraryFineLevel("RARE", 20, 5, 2));
    }

    @Test
    void TC_20() {
        assertEquals("INVALID",
            LibraryFineLevelCalculator.calculateLibraryFineLevel("REFERENCE", 20, 5, -1));
    }

    @Test
    void TC_21() {
        assertEquals("SEVERE",
            LibraryFineLevelCalculator.calculateLibraryFineLevel("NORMAL", 20, 5, 1));
    }

    @Test
    void TC_22() {
        assertEquals("SEVERE",
            LibraryFineLevelCalculator.calculateLibraryFineLevel("RARE", 20, 5, 3));
    }
}
