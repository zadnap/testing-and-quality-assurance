import calculateShippingFee from "../../calculateShippingFee.js";

describe("calculateShippingFee (BVA)", () => {
  test.each([
    ["TC_01", 900_000, 10.0, 30_000],
    ["TC_02", 900_000, 0.0, -1],
    ["TC_03", 900_000, 5.0, 10_000],
    ["TC_04", 900_000, 20.0, 30_000],
    ["TC_05", 900_000, -0.01, -1],
    ["TC_06", 900_000, 0.01, 10_000],
    ["TC_07", 900_000, 4.99, 10_000],
    ["TC_08", 900_000, 5.01, 30_000],
    ["TC_09", 900_000, 19.99, 30_000],
    ["TC_10", 900_000, 20.01, -1],
    ["TC_11", 0, 10.0, 50_000],
    ["TC_12", 500_000, 10.0, 30_000],
    ["TC_13", -1, 10.0, -1],
    ["TC_14", 1, 10.0, 50_000],
    ["TC_15", 499_999, 10.0, 50_000],
    ["TC_16", 500_001, 10.0, 30_000],
  ])(
    "%s: orderValue=%s, weight=%s → %s",
    (tcId, orderValue, weight, expected) => {
      expect(calculateShippingFee(orderValue, weight)).toBe(expected);
    },
  );
});
