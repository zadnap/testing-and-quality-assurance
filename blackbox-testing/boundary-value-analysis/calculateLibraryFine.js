const calculateLibraryFine = (bookType, lateDays, memberType, bookValue) => {
  const validBookTypes = ["NORMAL", "REFERENCE", "RARE"];
  const validMemberTypes = ["STANDARD", "PREMIUM", "STUDENT"];

  if (
    lateDays < 0 ||
    bookValue < 1_000 ||
    !validBookTypes.includes(bookType) ||
    !validMemberTypes.includes(memberType)
  ) {
    return "invalid";
  }

  if (lateDays === 0) {
    return 0;
  }

  let libraryFine;

  if (bookType === "NORMAL") {
    libraryFine = lateDays * 5_000;
  } else if (bookType === "REFERENCE") {
    libraryFine = lateDays * 10_000;
  } else {
    libraryFine = lateDays * 20_000;
  }

  if (memberType === "PREMIUM") {
    libraryFine *= 0.8;
  } else if (memberType === "STUDENT") {
    libraryFine *= 0.7;
  }

  if (lateDays > 7) {
    libraryFine *= 1.5;
  }

  if (bookType === "RARE" && bookValue >= 2_000_000 && lateDays > 3) {
    libraryFine += 100_000;
  }

  if (libraryFine > 0.3 * bookValue) {
    libraryFine = 0.3 * bookValue;
  }

  return Math.floor(libraryFine);
};
export default calculateLibraryFine;
