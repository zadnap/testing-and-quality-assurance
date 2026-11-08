package ai.libraryFineLevelCalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.testing.LibraryFineLevelCalculator;

class WhiteboxTest {

    // ============================================================
    // PHẦN 1: CFT - Condition Coverage C3 (15 test case)
    // ============================================================
    private static Stream<Arguments> cftTestCases() {
        return Stream.of(
                Arguments.of(1, "NORMAL", 0, 5, 0, "NONE",
                        "1->2(T)->3(T)->4->5(5c1(F),5c2(F),5c3(F),5c4(F))->7(T)->8"),
                Arguments.of(2, "NORMAL", 3, 5, 0, "LOW",
                        "1->2(T)->3(T)->4->5(5c1(F),5c2(F),5c3(F),5c4(F))->7(F)->9(9c1(F),9c2(F))->11(T)->12(T)->13"),
                Arguments.of(3, "NORMAL", 5, 5, 0, "MEDIUM",
                        "1->2(T)->3(T)->4->5(5c1(F),5c2(F),5c3(F),5c4(F))->7(F)->9(9c1(F),9c2(F))->11(T)->12(F)->14(T)->15"),
                Arguments.of(4, "NORMAL", 10, 5, 0, "HIGH",
                        "1->2(T)->3(T)->4->5(5c1(F),5c2(F),5c3(F),5c4(F))->7(F)->9(9c1(F),9c2(F))->11(T)->12(F)->14(F)->16(T)->17"),
                Arguments.of(5, "NORMAL", 20, 5, 0, "SEVERE",
                        "1->2(T)->3(T)->4->5(5c1(F),5c2(F),5c3(F),5c4(F))->7(F)->9(9c1(F),9c2(F))->11(T)->12(F)->14(F)->16(F)->23(F)->25"),
                Arguments.of(6, "REFERENCE", 2, 5, 0, "MEDIUM",
                        "1->2(T)->3(F)->2(T)->3(T)->4->5(5c1(F),5c2(F),5c3(F),5c4(F))->7(F)->9(9c1(F),9c2(F))->11(F)->18(T)->19(T)->20"),
                Arguments.of(7, "REFERENCE", 5, 5, 0, "HIGH",
                        "1->2(T)->3(F)->2(T)->3(T)->4->5(5c1(F),5c2(F),5c3(F),5c4(F))->7(F)->9(9c1(F),9c2(F))->11(F)->18(T)->19(F)->21(T)->22"),
                Arguments.of(8, "REFERENCE", 10, 5, 0, "SEVERE",
                        "1->2(T)->3(F)->2(T)->3(T)->4->5(5c1(F),5c2(F),5c3(F),5c4(F))->7(F)->9(9c1(F),9c2(F))->11(F)->18(T)->19(F)->21(F)->23(F)->25"),
                Arguments.of(9, "RARE", 2, 5, 0, "HIGH",
                        "1->2(T)->3(F)->2(T)->3(F)->2(T)->3(T)->4->5(5c1(F),5c2(F),5c3(F),5c4(F))->7(F)->9(9c1(F),9c2(F))->11(F)->18(F)->23(T)->24"),
                Arguments.of(10, "OTHER", 5, 5, 0, "INVALID",
                        "1->2(T)->3(F)->2(T)->3(F)->2(T)->3(F)->2(F)->5(5c1(T))->6"),
                Arguments.of(11, "NORMAL", -1, 5, 0, "INVALID",
                        "1->2(T)->3(T)->4->5(5c1(F),5c2(T))->6"),
                Arguments.of(12, "NORMAL", 3, -1, 0, "INVALID",
                        "1->2(T)->3(T)->4->5(5c1(F),5c2(F),5c3(T))->6"),
                Arguments.of(13, "NORMAL", 3, 5, -1, "INVALID",
                        "1->2(T)->3(T)->4->5(5c1(F),5c2(F),5c3(F),5c4(T))->6"),
                Arguments.of(14, "NORMAL", 3, 0, 0, "SEVERE",
                        "1->2(T)->3(T)->4->5(5c1(F),5c2(F),5c3(F),5c4(F))->7(F)->9(9c1(T))->10"),
                Arguments.of(15, "NORMAL", 3, 5, 3, "SEVERE",
                        "1->2(T)->3(T)->4->5(5c1(F),5c2(F),5c3(F),5c4(F))->7(F)->9(9c1(F),9c2(T))->10")
        );
    }

    @ParameterizedTest(name = "CFT-TC{0}: bookType={1}, lateDays={2}, memberYears={3}, violationCount={4} => {5}")
    @MethodSource("cftTestCases")
    void testCFT(int testId, String bookType, int lateDays, int memberYears,
                 int violationCount, String expected, String testPath) {
        String actual = LibraryFineLevelCalculator.calculateLibraryFineLevel(
                bookType, lateDays, memberYears, violationCount);
        assertEquals(expected, actual, "Sai tại CFT test path: " + testPath);
    }

    // ============================================================
    // PHẦN 2: DFT - All-uses (12 test case khả thi)
    // ============================================================
    private static Stream<Arguments> dftTestCases() {
        return Stream.of(
                Arguments.of(16, "OTHER", 5, 5, 0, "INVALID",
                        "1,2,3,4,5,4,5,4,5,4,10,11"),
                Arguments.of(17, "NORMAL", 0, 5, 0, "NONE",
                        "1,2,3,4,5,6,7,10,13,14"),
                Arguments.of(18, "NORMAL", 3, 5, 0, "LOW",
                        "1,2,3,4,5,6,7,10,13,16,19,20,21"),
                Arguments.of(19, "NORMAL", 5, 5, 0, "MEDIUM",
                        "1,2,3,4,5,6,7,10,13,16,19,20,22,23"),
                Arguments.of(20, "NORMAL", 10, 5, 0, "HIGH",
                        "1,2,3,4,5,6,7,10,13,16,19,20,22,24,25"),
                Arguments.of(21, "NORMAL", 20, 5, 0, "SEVERE",
                        "1,2,3,4,5,6,7,10,13,16,19,20,22,24,34,37"),
                Arguments.of(22, "REFERENCE", 2, 5, 0, "MEDIUM",
                        "1,2,3,4,5,4,5,6,7,10,13,16,19,27,28,29"),
                Arguments.of(23, "REFERENCE", 5, 5, 0, "HIGH",
                        "1,2,3,4,5,4,5,6,7,10,13,16,19,27,28,30,31"),
                Arguments.of(24, "REFERENCE", 10, 5, 0, "SEVERE",
                        "1,2,3,4,5,4,5,6,7,10,13,16,19,27,28,30,34,37"),
                Arguments.of(25, "RARE", 2, 5, 0, "HIGH",
                        "1,2,3,4,5,4,5,4,5,6,7,10,13,16,19,27,34,35"),
                Arguments.of(26, "NORMAL", -1, 5, 0, "INVALID",
                        "1,2,3,4,5,6,7,10,11"),
                Arguments.of(27, "NORMAL", 3, 0, 0, "SEVERE",
                        "1,2,3,4,5,6,7,10,13,16,17")
        );
    }

    @ParameterizedTest(name = "DFT-TC{0}: bookType={1}, lateDays={2}, memberYears={3}, violationCount={4} => {5}")
    @MethodSource("dftTestCases")
    void testDFT(int testId, String bookType, int lateDays, int memberYears,
                 int violationCount, String expected, String testPath) {
        String actual = LibraryFineLevelCalculator.calculateLibraryFineLevel(
                bookType, lateDays, memberYears, violationCount);
        assertEquals(expected, actual, "Sai tại DFT test path: " + testPath);
    }

    // ============================================================
    // PHẦN 3: DU-pair infeasible (Test 28) - lưu vết, không chạy
    // ============================================================
    @Test
    @Disabled("Infeasible DU-pair (3,<10,13>): isValidBookType=false tại nút 3 và không có def lại tại nút 6, nên tại nút 10 luôn đi nhánh <10,11>")
    void infeasibleDuPair_3_10_13() {
        // Test path cấu trúc: <1,2,3,4,5,4,5,4,5,4,10,13,16,19,20,21>
        // Inputs: N/A
    }
}