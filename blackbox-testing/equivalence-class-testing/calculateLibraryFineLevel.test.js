import calculateLibraryFineLevel from "../../calculateLibraryFineLevel";

describe("calculateLibraryFineLevel (ECT)", () => {
  test("TC_01 - INVALID", () => {
    expect(calculateLibraryFineLevel("INVALID", 2, 5, 5)).toBe("INVALID");
  });

  test("TC_02 - NONE", () => {
    expect(calculateLibraryFineLevel("NORMAL", 0, 5, 5)).toBe("NONE");
  });

  test("TC_03 - LOW", () => {
    expect(calculateLibraryFineLevel("NORMAL", 2, 3, 1)).toBe("LOW");
  });

  test("TC_04 - MEDIUM", () => {
    expect(calculateLibraryFineLevel("NORMAL", 5, 3, 1)).toBe("MEDIUM");
  });

  test("TC_05 - HIGH", () => {
    expect(calculateLibraryFineLevel("REFERENCE", 5, 3, 1)).toBe("HIGH");
  });

  test("TC_06 - SEVERE", () => {
    expect(calculateLibraryFineLevel("RARE", 5, 3, 1)).toBe("SEVERE");
  });
});
