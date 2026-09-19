const validateUpload = (files) => {
  if (files.length < 1 || files.length > 10) {
    return "invalid";
  }

  const hasInvalidName = files.some(
    (file) => file.name.length < 1 || file.name.length > 255,
  );

  if (hasInvalidName) {
    return "invalid";
  }

  const hasInvalidSize = files.some(
    (file) => file.size < 0.001 || file.size > 100.0,
  );

  if (hasInvalidSize) {
    return "invalid";
  }

  return "valid";
};

export default validateUpload;
