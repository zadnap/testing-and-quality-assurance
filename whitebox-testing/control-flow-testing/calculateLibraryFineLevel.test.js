import calculateLibraryFineLevel from "../../calculateLibraryFineLevel.js";

describe("calculateLibraryFineLevel", () => {
  test("TC_01: Invalid bookType", () => {
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

  test("TC_06: NORMAL book with zero member years", () => {
    expect(calculateLibraryFineLevel("NORMAL", 5, 0, 5)).toBe("SEVERE");
  });

  test("TC_07: NORMAL book with 5 violations", () => {
    expect(calculateLibraryFineLevel("NORMAL", 5, 5, 5)).toBe("SEVERE");
  });

  test("TC_08: RARE book with 5 violations", () => {
    expect(calculateLibraryFineLevel("RARE", 5, 5, 5)).toBe("SEVERE");
  });

  test("TC_09: NORMAL book, 3 late days", () => {
    expect(calculateLibraryFineLevel("NORMAL", 3, 5, 1)).toBe("LOW");
  });

  test("TC_10: NORMAL book, 5 late days", () => {
    expect(calculateLibraryFineLevel("NORMAL", 5, 5, 1)).toBe("MEDIUM");
  });

  test("TC_11: NORMAL book, 10 late days", () => {
    expect(calculateLibraryFineLevel("NORMAL", 10, 5, 1)).toBe("HIGH");
  });

  test("TC_12: NORMAL book, 18 late days", () => {
    expect(calculateLibraryFineLevel("NORMAL", 18, 5, 1)).toBe("SEVERE");
  });

  test("TC_13: RARE book, 2 late days", () => {
    expect(calculateLibraryFineLevel("RARE", 2, 5, 1)).toBe("HIGH");
  });

  test("TC_14: RARE book, 5 late days", () => {
    expect(calculateLibraryFineLevel("RARE", 5, 5, 1)).toBe("SEVERE");
  });

  test("TC_15: REFERENCE book, 3 late days", () => {
    expect(calculateLibraryFineLevel("REFERENCE", 3, 5, 1)).toBe("MEDIUM");
  });

  test("TC_16: REFERENCE book, 5 late days", () => {
    expect(calculateLibraryFineLevel("REFERENCE", 5, 5, 1)).toBe("HIGH");
  });

  test("TC_17: REFERENCE book, 18 late days", () => {
    expect(calculateLibraryFineLevel("REFERENCE", 18, 5, 1)).toBe("SEVERE");
  });
});
