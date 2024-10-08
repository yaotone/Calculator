package ru.yaotone;

public class RomanCalculator extends Calculator{
    public static int calculate(int num1, String operation, int num2) {
        return switch (operation){
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> num1 / num2;
            default -> throw new IllegalArgumentException("Не является арифметическим оператором");
        };
    }
}
