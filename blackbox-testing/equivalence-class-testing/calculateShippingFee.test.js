import { describe, expect, test } from "@jest/globals";
import calculateShippingFee from "../calculateShippingFee.js";

describe("calculateShippingFee (ECT)", () => {
  test("TC_01: orderValue < 0 → invalid", () => {
    expect(calculateShippingFee(-1, 5.0)).toBe("invalid");
  });

  test("TC_02: orderValue < 500000 && weight <= 5 → 30000", () => {
    expect(calculateShippingFee(30_000, 3.0)).toBe(30_000);
  });

  test("TC_03: orderValue < 500000 && weight > 5 → 50000", () => {
    expect(calculateShippingFee(50_000, 6.0)).toBe(50_000);
  });

  test("TC_04: orderValue >= 500000 && weight <= 5 → 10000", () => {
    expect(calculateShippingFee(600_000, 5.0)).toBe(10_000);
  });
});
