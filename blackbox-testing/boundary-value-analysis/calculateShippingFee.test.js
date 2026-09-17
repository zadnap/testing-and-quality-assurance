import calculateShippingFee from "./calculateShippingFee.js";

describe("calculateShippingFee", () => {
  describe("TS_01: Both inputs are nominal values", () => {
    it("TC_01: should return 30,000 for orderValue 250,000 and weight 2.50", () => {
      expect(calculateShippingFee(250_000, 2.5)).toBe(30_000);
    });

    it("TC_02: should return 50,000 for orderValue 250,000 and weight 7.50", () => {
      expect(calculateShippingFee(250_000, 7.5)).toBe(50_000);
    });

    it("TC_03: should return 10,000 for orderValue 900,000 and weight 2.50", () => {
      expect(calculateShippingFee(900_000, 2.5)).toBe(10_000);
    });

    it("TC_04: should return 30,000 for orderValue 900,000 and weight 7.50", () => {
      expect(calculateShippingFee(900_000, 7.5)).toBe(30_000);
    });
  });

  describe("TS_02: Nominal orderValue (250,000) with boundary weight values", () => {
    it("TC_01: should reject weight 0.00", () => {
      expect(calculateShippingFee(250_000, 0)).toBe("invalid");
    });

    it("TC_02: should return 30,000 for weight 0.01", () => {
      expect(calculateShippingFee(250_000, 0.01)).toBe(30_000);
    });

    it("TC_03: should return 30,000 for weight 0.02", () => {
      expect(calculateShippingFee(250_000, 0.02)).toBe(30_000);
    });

    it("TC_04: should return 30,000 for weight 4.99", () => {
      expect(calculateShippingFee(250_000, 4.99)).toBe(30_000);
    });

    it("TC_05: should return 30,000 for weight 5.00", () => {
      expect(calculateShippingFee(250_000, 5.0)).toBe(30_000);
    });

    it("TC_06: should return 50,000 for weight 5.01", () => {
      expect(calculateShippingFee(250_000, 5.01)).toBe(50_000);
    });

    it("TC_07: should return 50,000 for weight 5.02", () => {
      expect(calculateShippingFee(250_000, 5.02)).toBe(50_000);
    });

    it("TC_08: should return 50,000 for weight 19.99", () => {
      expect(calculateShippingFee(250_000, 19.99)).toBe(50_000);
    });

    it("TC_09: should return 50,000 for weight 20.00", () => {
      expect(calculateShippingFee(250_000, 20.0)).toBe(50_000);
    });

    it("TC_10: should reject weight 20.01", () => {
      expect(calculateShippingFee(250_000, 20.01)).toBe("invalid");
    });
  });

  describe("TS_03: Nominal orderValue (900,000) with boundary weight values", () => {
    it("TC_01: should reject weight 0.00", () => {
      expect(calculateShippingFee(900_000, 0)).toBe("invalid");
    });

    it("TC_02: should return 10,000 for weight 0.01", () => {
      expect(calculateShippingFee(900_000, 0.01)).toBe(10_000);
    });

    it("TC_03: should return 10,000 for weight 0.02", () => {
      expect(calculateShippingFee(900_000, 0.02)).toBe(10_000);
    });

    it("TC_04: should return 10,000 for weight 4.99", () => {
      expect(calculateShippingFee(900_000, 4.99)).toBe(10_000);
    });

    it("TC_05: should return 10,000 for weight 5.00", () => {
      expect(calculateShippingFee(900_000, 5.0)).toBe(10_000);
    });

    it("TC_06: should return 30,000 for weight 5.01", () => {
      expect(calculateShippingFee(900_000, 5.01)).toBe(30_000);
    });

    it("TC_07: should return 30,000 for weight 5.02", () => {
      expect(calculateShippingFee(900_000, 5.02)).toBe(30_000);
    });

    it("TC_08: should return 30,000 for weight 19.99", () => {
      expect(calculateShippingFee(900_000, 19.99)).toBe(30_000);
    });

    it("TC_09: should return 30,000 for weight 20.00", () => {
      expect(calculateShippingFee(900_000, 20.0)).toBe(30_000);
    });

    it("TC_10: should reject weight 20.01", () => {
      expect(calculateShippingFee(900_000, 20.01)).toBe("invalid");
    });
  });

  describe("TS_04: Nominal weight (2.50) with boundary orderValue values", () => {
    it("TC_01: should reject orderValue -1", () => {
      expect(calculateShippingFee(-1, 2.5)).toBe("invalid");
    });

    it("TC_02: should return 30,000 for orderValue 0", () => {
      expect(calculateShippingFee(0, 2.5)).toBe(30_000);
    });

    it("TC_03: should return 30,000 for orderValue 1", () => {
      expect(calculateShippingFee(1, 2.5)).toBe(30_000);
    });

    it("TC_04: should return 30,000 for orderValue 499,998", () => {
      expect(calculateShippingFee(499_998, 2.5)).toBe(30_000);
    });

    it("TC_05: should return 30,000 for orderValue 499,999", () => {
      expect(calculateShippingFee(499_999, 2.5)).toBe(30_000);
    });

    it("TC_06: should return 10,000 for orderValue 500,000", () => {
      expect(calculateShippingFee(500_000, 2.5)).toBe(10_000);
    });

    it("TC_07: should return 10,000 for orderValue 500,001", () => {
      expect(calculateShippingFee(500_001, 2.5)).toBe(10_000);
    });

    it("TC_08: should return 10,000 for orderValue 900,000", () => {
      expect(calculateShippingFee(900_000, 2.5)).toBe(10_000);
    });
  });

  describe("TS_05: Nominal weight (7.50) with boundary orderValue values", () => {
    it("TC_01: should reject orderValue -1", () => {
      expect(calculateShippingFee(-1, 7.5)).toBe("invalid");
    });

    it("TC_02: should return 50,000 for orderValue 0", () => {
      expect(calculateShippingFee(0, 7.5)).toBe(50_000);
    });

    it("TC_03: should return 50,000 for orderValue 1", () => {
      expect(calculateShippingFee(1, 7.5)).toBe(50_000);
    });

    it("TC_04: should return 50,000 for orderValue 499,998", () => {
      expect(calculateShippingFee(499_998, 7.5)).toBe(50_000);
    });

    it("TC_05: should return 50,000 for orderValue 499,999", () => {
      expect(calculateShippingFee(499_999, 7.5)).toBe(50_000);
    });

    it("TC_06: should return 30,000 for orderValue 500,000", () => {
      expect(calculateShippingFee(500_000, 7.5)).toBe(30_000);
    });

    it("TC_07: should return 30,000 for orderValue 500,001", () => {
      expect(calculateShippingFee(500_001, 7.5)).toBe(30_000);
    });

    it("TC_08: should return 30,000 for orderValue 900,000", () => {
      expect(calculateShippingFee(900_000, 7.5)).toBe(30_000);
    });
  });
});
