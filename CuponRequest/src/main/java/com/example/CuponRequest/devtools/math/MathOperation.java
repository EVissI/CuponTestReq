package com.example.CuponRequest.devtools.math;

import lombok.ToString;

public class MathOperation {
    // Вычисление процентного изменения
    public static Integer calculatePercentageChange(double oldValue, double newValue) {
        Integer percentageChange = Math.toIntExact(Math.round(Math.abs(((newValue - oldValue) / oldValue) * 100)));

        return percentageChange;
    }
}
