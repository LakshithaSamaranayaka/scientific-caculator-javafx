package com.calculator;

public class CalculatorLogic {

    public static double calculate(double num1, double num2, String operator) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 == 0) {
                    throw new ArithmeticException("Cannot divide by zero");
                }
                return num1 / num2;
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }

    public static double squareRoot(double value) {
        if (value < 0) {
            throw new ArithmeticException("Cannot calculate square root of a negative number");
        }
        return Math.sqrt(value);
    }

    public static double square(double value) {
        return value * value;
    }

    public static double sin(double value) {
        return Math.sin(Math.toRadians(value));
    }

    public static double cos(double value) {
        return Math.cos(Math.toRadians(value));
    }

    public static double tan(double value) {
        return Math.tan(Math.toRadians(value));
    }

    public static double log(double value) {
        if (value <= 0) {
            throw new ArithmeticException("Log is undefined for zero or negative numbers");
        }
        return Math.log10(value);
    }

    public static double ln(double value) {
        if (value <= 0) {
            throw new ArithmeticException("Natural log is undefined for zero or negative numbers");
        }
        return Math.log(value);
    }

    public static String formatResult(double value) {
        if (value == (long) value) {
            return String.valueOf((long) value);
        }
        return String.valueOf(value);
    }
}