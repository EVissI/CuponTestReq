package com.example.CuponRequest.devtools.math

object MathOperation {
    // Вычисление процентного изменения
    fun calculatePercentageChange(oldValue: Double, newValue: Double): Int {
        return Math.toIntExact(Math.round(Math.abs((newValue - oldValue) / oldValue * 100)))
    }
}