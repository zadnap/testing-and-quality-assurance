const calculateShippingFee = (orderValue, weight) => {
  if (orderValue < 0 || weight <= 0.0 || weight > 20.0) {
    return "invalid";
  }

  if (orderValue < 500_000) {
    if (weight <= 5.0) {
      return 30_000;
    }

    return 50_000;
  }

  if (weight <= 5.0) {
    return 10_000;
  }

  return 30_000;
};

export default calculateShippingFee;
