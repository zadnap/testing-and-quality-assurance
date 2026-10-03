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

  if (
    bookType === "NORMAL" &&
    lateDays > 0 &&
    lateDays <= 3 &&
    memberYears >= 1 &&
    violationCount >= 0 &&
    violationCount <= 2
  ) {
    return "LOW";
  }

  if (
    (bookType === "NORMAL" &&
      lateDays > 3 &&
      lateDays <= 7 &&
      memberYears >= 1 &&
      violationCount >= 0 &&
      violationCount <= 2) ||
    (bookType === "REFERENCE" &&
      lateDays > 0 &&
      lateDays <= 3 &&
      memberYears >= 1 &&
      violationCount >= 0 &&
      violationCount <= 2)
  ) {
    return "MEDIUM";
  }

  if (
    (bookType === "NORMAL" &&
      lateDays > 7 &&
      lateDays <= 14 &&
      memberYears >= 1 &&
      violationCount >= 0 &&
      violationCount <= 2) ||
    (bookType === "REFERENCE" &&
      lateDays > 3 &&
      lateDays <= 7 &&
      memberYears >= 1 &&
      violationCount >= 0 &&
      violationCount <= 2) ||
    (bookType === "RARE" &&
      lateDays > 0 &&
      lateDays <= 3 &&
      memberYears >= 1 &&
      violationCount >= 0 &&
      violationCount <= 2)
  ) {
    return "HIGH";
  }

  return "SEVERE";
};

export default calculateLibraryFineLevel;
