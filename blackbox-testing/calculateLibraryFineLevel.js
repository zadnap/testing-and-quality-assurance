const calculateLibraryFineLevel = (
  bookType,
  lateDays,
  memberYears,
  violationCount,
) => {
  const validBookTypes = ["NORMAL", "REFERENCE", "RARE"];

  // M1: lateDays < 0 -> lateDays <= 0
  // M2: memberYears < 0 -> memberYears <= 0
  // M3: violationCount < 0 -> violationCount <= 0
  if (
    !validBookTypes.includes(bookType) ||
    lateDays < 0 ||
    memberYears < 0 ||
    violationCount < 0
  ) {
    // M34: return "INVALID" -> return "SEVERE"
    return "INVALID";
  }

  // M4: lateDays === 0 -> lateDays !== 0
  if (lateDays === 0) {
    // M35: return "NONE" -> return "LOW"
    return "NONE";
  }

  if (
    bookType === "NORMAL" &&
    // M5: lateDays > 0 -> lateDays >= 0
    lateDays > 0 &&
    // M6: lateDays <= 3 -> lateDays < 3
    lateDays <= 3 &&
    // M7: memberYears >= 1 -> memberYears > 1
    memberYears >= 1 &&
    // M8: violationCount >= 0 -> violationCount > 0
    violationCount >= 0 &&
    // M9: violationCount <= 2 -> violationCount < 2
    violationCount <= 2
  ) {
    // M36: return "LOW" -> return "MEDIUM"
    return "LOW";
  }

  if (
    (bookType === "NORMAL" &&
      // M10: lateDays > 3 -> lateDays >= 3
      lateDays > 3 &&
      // M11: lateDays <= 7 -> lateDays < 7
      lateDays <= 7 &&
      // M12: memberYears >= 1 -> memberYears > 1
      memberYears >= 1 &&
      // M13: violationCount >= 0 -> violationCount > 0
      violationCount >= 0 &&
      // M14: violationCount <= 2 -> violationCount < 2
      violationCount <= 2) ||
    (bookType === "REFERENCE" &&
      // M15: lateDays > 0 -> lateDays >= 0
      lateDays > 0 &&
      // M16: lateDays <= 3 -> lateDays < 3
      lateDays <= 3 &&
      // M17: memberYears >= 1 -> memberYears > 1
      memberYears >= 1 &&
      // M18: violationCount >= 0 -> violationCount > 0
      violationCount >= 0 &&
      // M19: violationCount <= 2 -> violationCount < 2
      violationCount <= 2)
  ) {
    // M37: return "MEDIUM" -> return "LOW"
    return "MEDIUM";
  }

  if (
    (bookType === "NORMAL" &&
      // M20: lateDays > 7 -> lateDays >= 7
      lateDays > 7 &&
      // M21: lateDays <= 14 -> lateDays < 14
      lateDays <= 14 &&
      // M22: memberYears >= 1 -> memberYears > 1
      memberYears >= 1 &&
      // M23: violationCount >= 0 -> violationCount > 0
      violationCount >= 0 &&
      // M24: violationCount <= 2 -> violationCount < 2
      violationCount <= 2) ||
    (bookType === "REFERENCE" &&
      // M25: lateDays > 3 -> lateDays >= 3
      lateDays > 3 &&
      // M26: lateDays <= 7 -> lateDays < 7
      lateDays <= 7 &&
      // M27: memberYears >= 1 -> memberYears > 1
      memberYears >= 1 &&
      // M28: violationCount >= 0 -> violationCount > 0
      violationCount >= 0 &&
      // M29: violationCount <= 2 -> violationCount < 2
      violationCount <= 2) ||
    (bookType === "RARE" &&
      // M30: lateDays > 0 -> lateDays >= 0
      lateDays > 0 &&
      // M31: lateDays <= 3 -> lateDays < 3
      lateDays <= 3 &&
      // M32: memberYears >= 1 -> memberYears > 1
      memberYears >= 1 &&
      // M33: violationCount >= 0 -> violationCount > 0
      violationCount >= 0 &&
      // M34: violationCount <= 2 -> violationCount < 2
      violationCount <= 2)
  ) {
    // M38: return "HIGH" -> return "MEDIUM"
    return "HIGH";
  }

  // M39: return "SEVERE" -> return "HIGH"
  return "SEVERE";
};

export default calculateLibraryFineLevel;
