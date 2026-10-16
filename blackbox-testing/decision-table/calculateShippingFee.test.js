import calculateShippingFee from "../../calculateShippingFee";

describe("calculateShippingFee - Decision Table", () => {
  test("TC_01: orderValue < 0", () => {
    expect(calculateShippingFee(-100, 10.0)).toBe(-1);
  });

  test("TC_02: weight > 20", () => {
    expect(calculateShippingFee(250_000, 50.0)).toBe(-1);
  });

  test("TC_03: orderValue < 500,000 and weight <= 5", () => {
    expect(calculateShippingFee(250_000, 2.5)).toBe(30_000);
  });

  test("TC_04: orderValue >= 500,000 and weight > 5", () => {
    expect(calculateShippingFee(750_000, 12.5)).toBe(30_000);
  });

  test("TC_05: orderValue < 500,000 and weight > 5", () => {
    expect(calculateShippingFee(250_000, 12.5)).toBe(50_000);
  });

  test("TC_06: orderValue >= 500,000 and weight <= 5", () => {
    expect(calculateShippingFee(750_000, 2.5)).toBe(10_000);
  });
});
