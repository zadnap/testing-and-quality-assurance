import calculateLibraryFineLevel from "../../calculateLibraryFineLevel.js";

describe("calculateLibraryFineLevel (DFT)", () => {
  it("TC_01 - Should return INVALID when lateDays is negative", () => {
    expect(calculateLibraryFineLevel("NORMAL", -10, 5, 5)).toBe("INVALID");
  });

  it("TC_02 - Should return NONE when lateDays is 0", () => {
    expect(calculateLibraryFineLevel("RARE", 0, 8, 5)).toBe("NONE");
  });

  it("TC_03 - Should return SEVERE for REFERENCE book with 10 late days", () => {
    expect(calculateLibraryFineLevel("REFERENCE", 10, 10, 5)).toBe("SEVERE");
  });

  it("TC_04 - Should return LOW for NORMAL book with 2 late days", () => {
    expect(calculateLibraryFineLevel("NORMAL", 2, 9, 1)).toBe("LOW");
  });

  it("TC_05 - Should return MEDIUM for NORMAL book with 5 late days", () => {
    expect(calculateLibraryFineLevel("NORMAL", 5, 5, 1)).toBe("MEDIUM");
  });

  it("TC_06 - Should return HIGH for NORMAL book with 10 late days", () => {
    expect(calculateLibraryFineLevel("NORMAL", 10, 6, 1)).toBe("HIGH");
  });

  it("TC_07 - Should return MEDIUM for REFERENCE book with 2 late days", () => {
    expect(calculateLibraryFineLevel("REFERENCE", 2, 5, 1)).toBe("MEDIUM");
  });

  it("TC_08 - Should return HIGH for REFERENCE book with 5 late days", () => {
    expect(calculateLibraryFineLevel("REFERENCE", 5, 9, 1)).toBe("HIGH");
  });

  it("TC_09 - Should return SEVERE for REFERENCE book with 10 late days", () => {
    expect(calculateLibraryFineLevel("REFERENCE", 10, 11, 1)).toBe("SEVERE");
  });

  it("TC_10 - Should return SEVERE for RARE book with 5 late days", () => {
    expect(calculateLibraryFineLevel("RARE", 5, 10, 1)).toBe("SEVERE");
  });

  it("TC_11 - Should return SEVERE for NORMAL book with 17 late days", () => {
    expect(calculateLibraryFineLevel("NORMAL", 17, 5, 1)).toBe("SEVERE");
  });
});
