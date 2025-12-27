package com.example.demo.util;

import java.util.List;

public class ValidationUtil {

    private static final List<String> VALID_SEASONS =
            List.of("Kharif", "Rabi", "Zaid");

    public static boolean validSeason(String season) {
        return VALID_SEASONS.contains(season);
    }

    public static boolean validNpk(String npk) {
        return npk != null && npk.matches("\\d+-\\d+-\\d+");
    }

    public static boolean validPhRange(double min, double max) {
        return min > 0 && max > 0 && min <= max;
    }
}
