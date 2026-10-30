import calculateShippingFee from "../../calculateShippingFee.js";

describe("calculateShippingFee (DFT)", () => {
  it("TC_01 - should reject negative orderValue and weight", () => {
    expect(calculateShippingFee(-10, -10.0)).toBe(-1);
  });

  it("TC_02 - should return 50,000", () => {
    expect(calculateShippingFee(250000, 7.5)).toBe(50000);
  });

  it("TC_03 - should return 30,000", () => {
    expect(calculateShippingFee(250000, 2.5)).toBe(30000);
  });

  it("TC_04 - should return 10,000", () => {
    expect(calculateShippingFee(750000, 2.5)).toBe(10000);
  });

  it("TC_05 - should return 30,000", () => {
    expect(calculateShippingFee(750000, 7.5)).toBe(30000);
  });
});
