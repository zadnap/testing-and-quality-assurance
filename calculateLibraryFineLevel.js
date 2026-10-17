const calculateLibraryFineLevel = (
  bookType,
  lateDays,
  memberYears,
  violationCount,
) => {
  const validBookTypes = ["NORMAL", "REFERENCE", "RARE"];

  if (
    // M1: !validBookTypes.includes(bookType) -> validBookTypes.includes(bookType)
    // M2: lateDays < 0 -> lateDays <= 0
    // M3: memberYears < 0 -> memberYears <= 0
    // M4: violationCount < 0 -> violationCount <= 0
    !validBookTypes.includes(bookType) ||
    lateDays < 0 ||
    memberYears < 0 ||
    violationCount < 0
  ) {
    // M14: return "INVALID" -> return "NONE"
    return "INVALID";
  }

  // M5: lateDays === 0 -> lateDays !== 0
  if (lateDays === 0) {
    // M15: return "NONE" -> return "INVALID"
    return "NONE";
  }

  // M6: memberYears < 1 -> memberYears <= 1
  // M7: violationCount > 2 -> violationCount >= 2
  if (memberYears < 1 || violationCount > 2) {
    // M16: return "SEVERE" -> return "HIGH"
    return "SEVERE";
  }

  if (bookType === "NORMAL") {
    // M8: lateDays <= 3 -> lateDays < 3
    if (lateDays <= 3) {
      // M17: return "LOW" -> return "SEVERE"
      return "LOW";
      // M9: lateDays <= 7 -> lateDays < 7
    } else if (lateDays <= 7) {
      // M18: return "MEDIUM" -> return "LOW"
      return "MEDIUM";
      // M10: lateDays <= 14 -> lateDays < 14
    } else if (lateDays <= 14) {
      // M19: return "HIGH" -> return "LOW"
      return "HIGH";
    }
  } else if (bookType === "REFERENCE") {
    // M11: lateDays <= 3 -> lateDays < 3
    if (lateDays <= 3) {
      // M20: return "MEDIUM" -> return "SEVERE"
      return "MEDIUM";
      // M12: lateDays <= 7 -> lateDays < 7
    } else if (lateDays <= 7) {
      // M21: return "HIGH" -> return "NONE"
      return "HIGH";
    }
  } else if (bookType === "RARE") {
    // M13: lateDays <= 3 -> lateDays < 3
    if (lateDays <= 3) {
      // M22: return "HIGH" -> return "NONE"
      return "HIGH";
    }
  }

  // M23: return "SEVERE" -> return "LOW"
  return "SEVERE";
};

export default calculateLibraryFineLevel;
