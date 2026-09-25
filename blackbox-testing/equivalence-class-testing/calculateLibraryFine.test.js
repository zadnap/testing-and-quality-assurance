import { describe, expect, test } from "@jest/globals";

import calculateLibraryFine from "../calculateLibraryFine.js";

describe("calculateLibraryFine (ECT)", () => {
  test("TC_01: At least one input is invalid → invalid", () => {
    expect(calculateLibraryFine("NORMAL", 5, "STANDARD", 500)).toBe("invalid");
  });

  test("TC_02: lateDays = 0 → 0", () => {
    expect(calculateLibraryFine("NORMAL", 0, "STANDARD", 100_000)).toBe(0);
  });

  test("TC_03: lateDays > 0 → positive fine", () => {
    expect(calculateLibraryFine("NORMAL", 1, "STANDARD", 100_000)).toBe(5_000);
  });
});
