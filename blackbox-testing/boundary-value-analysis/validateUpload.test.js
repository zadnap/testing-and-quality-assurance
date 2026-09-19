import validateUpload from "./validateUpload";

const NOMINAL_NAME = "a".repeat(128);
const NOMINAL_SIZE = 50.0;
const NOMINAL_FILE_COUNT = 5;

const createNominalFiles = (count = NOMINAL_FILE_COUNT) =>
  Array.from({ length: count }, () => ({
    name: NOMINAL_NAME,
    size: NOMINAL_SIZE,
  }));

describe("validateUpload", () => {
  describe("TS_01: Nominal values", () => {
    it("TC_01: should return valid with nominal values", () => {
      const files = createNominalFiles();

      expect(validateUpload(files)).toBe("valid");
    });
  });

  describe("TS_02: Boundary values of file.name.length", () => {
    it("TC_01: should return invalid when name length is 0", () => {
      const files = createNominalFiles();
      files[0].name = "";

      expect(validateUpload(files)).toBe("invalid");
    });

    it("TC_02: should return valid when name length is 1", () => {
      const files = createNominalFiles();
      files[0].name = "a";

      expect(validateUpload(files)).toBe("valid");
    });

    it("TC_03: should return valid when name length is 2", () => {
      const files = createNominalFiles();
      files[0].name = "aa";

      expect(validateUpload(files)).toBe("valid");
    });

    it("TC_04: should return valid when name length is 254", () => {
      const files = createNominalFiles();
      files[0].name = "a".repeat(254);

      expect(validateUpload(files)).toBe("valid");
    });

    it("TC_05: should return valid when name length is 255", () => {
      const files = createNominalFiles();
      files[0].name = "a".repeat(255);

      expect(validateUpload(files)).toBe("valid");
    });

    it("TC_06: should return invalid when name length is 256", () => {
      const files = createNominalFiles();
      files[0].name = "a".repeat(256);

      expect(validateUpload(files)).toBe("invalid");
    });
  });

  describe("TS_03: Boundary values of file.size", () => {
    it("TC_01: should return invalid when file size is 0.000 MB", () => {
      const files = createNominalFiles();
      files[0].size = 0.0;

      expect(validateUpload(files)).toBe("invalid");
    });

    it("TC_02: should return valid when file size is 0.001 MB", () => {
      const files = createNominalFiles();
      files[0].size = 0.001;

      expect(validateUpload(files)).toBe("valid");
    });

    it("TC_03: should return valid when file size is 0.002 MB", () => {
      const files = createNominalFiles();
      files[0].size = 0.002;

      expect(validateUpload(files)).toBe("valid");
    });

    it("TC_04: should return valid when file size is 99.999 MB", () => {
      const files = createNominalFiles();
      files[0].size = 99.999;

      expect(validateUpload(files)).toBe("valid");
    });

    it("TC_05: should return valid when file size is 100.000 MB", () => {
      const files = createNominalFiles();
      files[0].size = 100.0;

      expect(validateUpload(files)).toBe("valid");
    });

    it("TC_06: should return invalid when file size is 100.001 MB", () => {
      const files = createNominalFiles();
      files[0].size = 100.001;

      expect(validateUpload(files)).toBe("invalid");
    });
  });

  describe("TS_04: Boundary values of files.length", () => {
    it("TC_01: should return invalid when file count is 0", () => {
      const files = createNominalFiles(0);

      expect(validateUpload(files)).toBe("invalid");
    });

    it("TC_02: should return valid when file count is 1", () => {
      const files = createNominalFiles(1);

      expect(validateUpload(files)).toBe("valid");
    });

    it("TC_03: should return valid when file count is 2", () => {
      const files = createNominalFiles(2);

      expect(validateUpload(files)).toBe("valid");
    });

    it("TC_04: should return valid when file count is 9", () => {
      const files = createNominalFiles(9);

      expect(validateUpload(files)).toBe("valid");
    });

    it("TC_05: should return valid when file count is 10", () => {
      const files = createNominalFiles(10);

      expect(validateUpload(files)).toBe("valid");
    });

    it("TC_06: should return invalid when file count is 11", () => {
      const files = createNominalFiles(11);

      expect(validateUpload(files)).toBe("invalid");
    });
  });
});
