const calculateShippingFee = (orderValue, weight) => {
  // M1: orderValue < 0 -> orderValue <= 0
  // M2: weight <= 0 => weight < 0
  // M3: weight > 20.0 => weight >= 20.0
  if (orderValue < 0 || weight <= 0.0 || weight > 20.0) {
    // M7: return -1 -> return 30_000
    return -1;
  }

  // M4: orderValue < 500_000 => orderValue <= 500_000
  if (orderValue < 500_000) {
    // M5: weight <= 5.0 => weight < 5.0
    if (weight <= 5.0) {
      // M8: return 30_000 -> return 50_000
      return 30_000;
    }

    // M9: return 50_000 -> return 30_000
    return 50_000;
  }

  // M6: weight <= 5.0 => weight < 5.0
  if (weight <= 5.0) {
    // M10: return 10_000 -> return 30_000
    return 10_000;
  }

  // M11: return 30_000 -> return 10_000
  return 30_000;
};

export default calculateShippingFee;
