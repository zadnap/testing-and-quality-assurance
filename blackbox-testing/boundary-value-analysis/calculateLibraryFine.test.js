import calculateLibraryFine from "./calculateLibraryFine.js";

describe("calculateLibraryFine", () => {
  test.each([
    // TC_01
    {
      id: "TC_01",
      lateDays: 5,
      bookValue: 1_000_000,
      bookType: "RARE",
      memberType: "PREMIUM",
      expected: 80_000,
    },

    // TC_02
    {
      id: "TC_02",
      lateDays: 5,
      bookValue: 1_000,
      bookType: "NORMAL",
      memberType: "STUDENT",
      expected: 300,
    },

    // TC_03
    {
      id: "TC_03",
      lateDays: 5,
      bookValue: 2_000_000,
      bookType: "REFERENCE",
      memberType: "STANDARD",
      expected: 50_000,
    },

    // TC_04
    {
      id: "TC_04",
      lateDays: 5,
      bookValue: 999,
      bookType: "REFERENCE",
      memberType: "PREMIUM",
      expected: "invalid",
    },

    // TC_05
    {
      id: "TC_05",
      lateDays: 5,
      bookValue: 1_001,
      bookType: "NORMAL",
      memberType: "STANDARD",
      expected: 300,
    },

    // TC_06
    {
      id: "TC_06",
      lateDays: 5,
      bookValue: 1_999_999,
      bookType: "RARE",
      memberType: "STUDENT",
      expected: 70_000,
    },

    // TC_07
    {
      id: "TC_07",
      lateDays: 5,
      bookValue: 2_000_001,
      bookType: "NORMAL",
      memberType: "STUDENT",
      expected: 17_500,
    },

    // TC_08
    {
      id: "TC_08",
      lateDays: 0,
      bookValue: 1_000_000,
      bookType: "RARE",
      memberType: "PREMIUM",
      expected: 0,
    },

    // TC_09
    {
      id: "TC_09",
      lateDays: 3,
      bookValue: 1_000_000,
      bookType: "REFERENCE",
      memberType: "STANDARD",
      expected: 30_000,
    },

    // TC_10
    {
      id: "TC_10",
      lateDays: 7,
      bookValue: 1_000_000,
      bookType: "NORMAL",
      memberType: "STUDENT",
      expected: 24_500,
    },

    // TC_11
    {
      id: "TC_11",
      lateDays: -1,
      bookValue: 1_000_000,
      bookType: "RARE",
      memberType: "PREMIUM",
      expected: "invalid",
    },

    // TC_12
    {
      id: "TC_12",
      lateDays: 1,
      bookValue: 1_000_000,
      bookType: "REFERENCE",
      memberType: "STANDARD",
      expected: 10_000,
    },

    // TC_13
    {
      id: "TC_13",
      lateDays: 2,
      bookValue: 1_000_000,
      bookType: "RARE",
      memberType: "PREMIUM",
      expected: 32_000,
    },

    // TC_14
    {
      id: "TC_14",
      lateDays: 4,
      bookValue: 1_000_000,
      bookType: "NORMAL",
      memberType: "STUDENT",
      expected: 14_000,
    },

    // TC_15
    {
      id: "TC_15",
      lateDays: 6,
      bookValue: 1_000_000,
      bookType: "REFERENCE",
      memberType: "STANDARD",
      expected: 60_000,
    },

    // TC_16
    {
      id: "TC_16",
      lateDays: 8,
      bookValue: 1_000_000,
      bookType: "NORMAL",
      memberType: "PREMIUM",
      expected: 48_000,
    },

    // TC_17
    {
      id: "TC_17",
      lateDays: 4,
      bookValue: 2_000_000,
      bookType: "RARE",
      memberType: "STANDARD",
      expected: 180_000,
    },

    // TC_18
    {
      id: "TC_18",
      lateDays: 3,
      bookValue: 2_000_000,
      bookType: "RARE",
      memberType: "STANDARD",
      expected: 60_000,
    },
  ])("$id", ({ lateDays, bookValue, bookType, memberType, expected }) => {
    expect(
      calculateLibraryFine(bookType, lateDays, memberType, bookValue),
    ).toBe(expected);
  });
});
