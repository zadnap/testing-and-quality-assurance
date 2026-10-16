import calculateLibraryFineLevel from "../../calculateLibraryFineLevel";

describe("calculateLibraryFineLevel (BVA)", () => {
  test("TC_01: RARE, 20, 5, 5 -> SEVERE", () => {
    expect(calculateLibraryFineLevel("RARE", 20, 5, 5)).toBe("SEVERE");
  });

  test("TC_02: NORMAL, 0, 5, 5 -> NONE", () => {
    expect(calculateLibraryFineLevel("NORMAL", 0, 5, 5)).toBe("NONE");
  });

  test("TC_03: REFERENCE, 3, 5, 5 -> SEVERE", () => {
    expect(calculateLibraryFineLevel("REFERENCE", 3, 5, 5)).toBe("SEVERE");
  });

  test("TC_04: NORMAL, 7, 5, 5 -> SEVERE", () => {
    expect(calculateLibraryFineLevel("NORMAL", 7, 5, 5)).toBe("SEVERE");
  });

  test("TC_05: RARE, 14, 5, 5 -> SEVERE", () => {
    expect(calculateLibraryFineLevel("RARE", 14, 5, 5)).toBe("SEVERE");
  });

  test("TC_06: RARE, -1, 5, 5 -> INVALID", () => {
    expect(calculateLibraryFineLevel("RARE", -1, 5, 5)).toBe("INVALID");
  });

  test("TC_07: REFERENCE, 1, 5, 5 -> SEVERE", () => {
    expect(calculateLibraryFineLevel("REFERENCE", 1, 5, 5)).toBe("SEVERE");
  });

  test("TC_08: NORMAL, 2, 5, 5 -> SEVERE", () => {
    expect(calculateLibraryFineLevel("NORMAL", 2, 5, 5)).toBe("SEVERE");
  });

  test("TC_09: REFERENCE, 4, 5, 5 -> SEVERE", () => {
    expect(calculateLibraryFineLevel("REFERENCE", 4, 5, 5)).toBe("SEVERE");
  });

  test("TC_10: RARE, 6, 5, 5 -> SEVERE", () => {
    expect(calculateLibraryFineLevel("RARE", 6, 5, 5)).toBe("SEVERE");
  });

  test("TC_11: NORMAL, 8, 5, 5 -> SEVERE", () => {
    expect(calculateLibraryFineLevel("NORMAL", 8, 5, 5)).toBe("SEVERE");
  });

  test("TC_12: REFERENCE, 13, 5, 5 -> SEVERE", () => {
    expect(calculateLibraryFineLevel("REFERENCE", 13, 5, 5)).toBe("SEVERE");
  });

  test("TC_13: RARE, 15, 5, 5 -> SEVERE", () => {
    expect(calculateLibraryFineLevel("RARE", 15, 5, 5)).toBe("SEVERE");
  });

  test("TC_14: NORMAL, 20, 0, 5 -> SEVERE", () => {
    expect(calculateLibraryFineLevel("NORMAL", 20, 0, 5)).toBe("SEVERE");
  });

  test("TC_15: NORMAL, 20, 1, 5 -> SEVERE", () => {
    expect(calculateLibraryFineLevel("NORMAL", 20, 1, 5)).toBe("SEVERE");
  });

  test("TC_16: RARE, 20, -1, 5 -> INVALID", () => {
    expect(calculateLibraryFineLevel("RARE", 20, -1, 5)).toBe("INVALID");
  });

  test("TC_17: REFERENCE, 20, 2, 5 -> SEVERE", () => {
    expect(calculateLibraryFineLevel("REFERENCE", 20, 2, 5)).toBe("SEVERE");
  });

  test("TC_18: NORMAL, 20, 5, 0 -> SEVERE", () => {
    expect(calculateLibraryFineLevel("NORMAL", 20, 5, 0)).toBe("SEVERE");
  });

  test("TC_19: RARE, 20, 5, 2 -> SEVERE", () => {
    expect(calculateLibraryFineLevel("RARE", 20, 5, 2)).toBe("SEVERE");
  });

  test("TC_20: REFERENCE, 20, 5, -1 -> INVALID", () => {
    expect(calculateLibraryFineLevel("REFERENCE", 20, 5, -1)).toBe("INVALID");
  });

  test("TC_21: NORMAL, 20, 5, 1 -> SEVERE", () => {
    expect(calculateLibraryFineLevel("NORMAL", 20, 5, 1)).toBe("SEVERE");
  });

  test("TC_22: RARE, 20, 5, 3 -> SEVERE", () => {
    expect(calculateLibraryFineLevel("RARE", 20, 5, 3)).toBe("SEVERE");
  });
});
