import { describe, expect, test } from "@jest/globals";
import calculateShippingFee from "../../calculateShippingFee.js";

describe("calculateShippingFee (CFT)", () => {
  test("TC_01: orderValue < 0", () => {
    const result = calculateShippingFee(-5, 5.0);

    expect(result).toBe(-1);
  });

  test("TC_02: weight <= 0", () => {
    const result = calculateShippingFee(5, -5.0);

    expect(result).toBe(-1);
  });

  test("TC_03: weight > 20", () => {
    const result = calculateShippingFee(5, 25.0);

    expect(result).toBe(-1);
  });

  test("TC_04: orderValue < 500000 and weight <= 5", () => {
    const result = calculateShippingFee(400000, 2.5);

    expect(result).toBe(30000);
  });

  test("TC_05: orderValue < 500000 and weight > 5", () => {
    const result = calculateShippingFee(400000, 8.0);

    expect(result).toBe(50000);
  });

  test("TC_06: orderValue >= 500000 and weight <= 5", () => {
    const result = calculateShippingFee(700000, 2.5);

    expect(result).toBe(10000);
  });

  test("TC_07: orderValue >= 500000 and weight > 5", () => {
    const result = calculateShippingFee(700000, 8.0);

    expect(result).toBe(30000);
  });
});
