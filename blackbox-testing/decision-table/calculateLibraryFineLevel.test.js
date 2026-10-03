import calculateLibraryFineLevel from "../calculateLibraryFineLevel.js";

describe("calculateLibraryFineLevel (DT)", () => {
  test("TC_01 - INVALID bookType", () => {
    expect(calculateLibraryFineLevel("INVALID", 4, 5, 4)).toBe("INVALID");
  });

  test("TC_02 - INVALID lateDays", () => {
    expect(calculateLibraryFineLevel("NORMAL", -10, 5, 4)).toBe("INVALID");
  });

  test("TC_03 - INVALID memberYears", () => {
    expect(calculateLibraryFineLevel("NORMAL", 4, -10, 4)).toBe("INVALID");
  });

  test("TC_04 - INVALID violationCount", () => {
    expect(calculateLibraryFineLevel("NORMAL", 4, 5, -10)).toBe("INVALID");
  });

  test("TC_05 - NONE", () => {
    expect(calculateLibraryFineLevel("RARE", 0, 5, 5)).toBe("NONE");
  });

  test("TC_06 - LOW", () => {
    expect(calculateLibraryFineLevel("NORMAL", 2, 5, 1)).toBe("LOW");
  });

  test("TC_07 - MEDIUM", () => {
    expect(calculateLibraryFineLevel("NORMAL", 5, 5, 1)).toBe("MEDIUM");
  });

  test("TC_08 - MEDIUM", () => {
    expect(calculateLibraryFineLevel("REFERENCE", 2, 5, 1)).toBe("MEDIUM");
  });

  test("TC_09 - HIGH", () => {
    expect(calculateLibraryFineLevel("NORMAL", 10, 5, 1)).toBe("HIGH");
  });

  test("TC_10 - HIGH", () => {
    expect(calculateLibraryFineLevel("REFERENCE", 5, 5, 1)).toBe("HIGH");
  });

  test("TC_11 - HIGH", () => {
    expect(calculateLibraryFineLevel("RARE", 2, 5, 1)).toBe("HIGH");
  });

  test("TC_12 - SEVERE", () => {
    expect(calculateLibraryFineLevel("NORMAL", 17, 5, 1)).toBe("SEVERE");
  });

  test("TC_13 - SEVERE", () => {
    expect(calculateLibraryFineLevel("RARE", 5, 5, 1)).toBe("SEVERE");
  });

  test("TC_14 - SEVERE", () => {
    expect(calculateLibraryFineLevel("REFERENCE", 9, 5, 1)).toBe("SEVERE");
  });

  test("TC_15 - SEVERE with memberYears = 0", () => {
    expect(calculateLibraryFineLevel("NORMAL", 3, 0, 5)).toBe("SEVERE");
  });

  test("TC_16 - SEVERE with violationCount = 5", () => {
    expect(calculateLibraryFineLevel("RARE", 3, 5, 5)).toBe("SEVERE");
  });
});
