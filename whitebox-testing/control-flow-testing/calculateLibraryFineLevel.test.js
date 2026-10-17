import calculateLibraryFineLevel from "../..//calculateLibraryFineLevel.js";

describe("calculateLibraryFineLevel", () => {
  test("TC_01: Invalid book type", () => {
    expect(calculateLibraryFineLevel("INVALID", 5, 5, 5)).toBe("INVALID");
  });

  test("TC_02: Negative lateDays", () => {
    expect(calculateLibraryFineLevel("NORMAL", -5, 5, 5)).toBe("INVALID");
  });

  test("TC_03: Negative memberYears", () => {
    expect(calculateLibraryFineLevel("NORMAL", 5, -5, 5)).toBe("INVALID");
  });

  test("TC_04: Negative violationCount", () => {
    expect(calculateLibraryFineLevel("NORMAL", 5, 5, -5)).toBe("INVALID");
  });

  test("TC_05: No late days", () => {
    expect(calculateLibraryFineLevel("NORMAL", 0, 5, 5)).toBe("NONE");
  });

  test("TC_06: Member has less than one year", () => {
    expect(calculateLibraryFineLevel("NORMAL", 5, 0, 5)).toBe("SEVERE");
  });

  test("TC_07: More than two violations", () => {
    expect(calculateLibraryFineLevel("NORMAL", 5, 5, 5)).toBe("SEVERE");
  });

  test("TC_08: NORMAL book, late 3 days", () => {
    expect(calculateLibraryFineLevel("NORMAL", 3, 5, 1)).toBe("LOW");
  });

  test("TC_09: NORMAL book, late 5 days", () => {
    expect(calculateLibraryFineLevel("NORMAL", 5, 5, 1)).toBe("MEDIUM");
  });

  test("TC_10: NORMAL book, late 10 days", () => {
    expect(calculateLibraryFineLevel("NORMAL", 10, 5, 1)).toBe("HIGH");
  });

  test("TC_11: NORMAL book, late 18 days", () => {
    expect(calculateLibraryFineLevel("NORMAL", 18, 5, 1)).toBe("SEVERE");
  });

  test("TC_12: RARE book, late 2 days", () => {
    expect(calculateLibraryFineLevel("RARE", 2, 5, 1)).toBe("HIGH");
  });

  test("TC_13: RARE book, late 5 days", () => {
    expect(calculateLibraryFineLevel("RARE", 5, 5, 1)).toBe("SEVERE");
  });

  test("TC_14: REFERENCE book, late 3 days", () => {
    expect(calculateLibraryFineLevel("REFERENCE", 3, 5, 1)).toBe("MEDIUM");
  });

  test("TC_15: REFERENCE book, late 5 days", () => {
    expect(calculateLibraryFineLevel("REFERENCE", 5, 5, 1)).toBe("HIGH");
  });

  test("TC_16: REFERENCE book, late 18 days", () => {
    expect(calculateLibraryFineLevel("REFERENCE", 18, 5, 1)).toBe("SEVERE");
  });
});
