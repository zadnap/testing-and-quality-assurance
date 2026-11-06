const calculateLibraryFineLevel = (
  bookType,
  lateDays,
  memberYears,
  violationCount,
) => {
  const validBookTypes = ["NORMAL", "REFERENCE", "RARE"];

  if (
    !validBookTypes.includes(bookType) ||
    lateDays < 0 ||
    memberYears < 0 ||
    violationCount < 0
  ) {
    return "INVALID";
  }

  if (lateDays === 0) {
    return "NONE";
  }

  if (memberYears < 1 || violationCount > 2) {
    return "SEVERE";
  }

  if (bookType === "NORMAL") {
    if (lateDays <= 3) {
      return "LOW";
    } else if (lateDays <= 7) {
      return "MEDIUM";
    } else if (lateDays <= 14) {
      return "HIGH";
    }
  } else if (bookType === "REFERENCE") {
    if (lateDays <= 3) {
      return "MEDIUM";
    } else if (lateDays <= 7) {
      return "HIGH";
    }
  }

  if (lateDays <= 3) {
    return "HIGH";
  }

  return "SEVERE";
};

export default calculateLibraryFineLevel;
