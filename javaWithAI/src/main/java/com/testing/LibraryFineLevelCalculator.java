package com.testing;
public class LibraryFineLevelCalculator {

    public static String calculateLibraryFineLevel(
            String bookType,
            int lateDays,
            int memberYears,
            int violationCount) {

        String[] validBookTypes = {"NORMAL", "REFERENCE", "RARE"};

        boolean isValidBookType = false;
        for (String type : validBookTypes) {
            if (type.equals(bookType)) {
                isValidBookType = true;
                break;
            }
        }

        if (!isValidBookType || lateDays < 0 || memberYears < 0 || violationCount < 0) {
            return "INVALID";
        }

        if (lateDays == 0) {
            return "NONE";
        }

        if (memberYears < 1 || violationCount > 2) {
            return "SEVERE";
        }

        if ("NORMAL".equals(bookType)) {
            if (lateDays <= 3) {
                return "LOW";
            } else if (lateDays <= 7) {
                return "MEDIUM";
            } else if (lateDays <= 14) {
                return "HIGH";
            }
        } else if ("REFERENCE".equals(bookType)) {
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
    }
}