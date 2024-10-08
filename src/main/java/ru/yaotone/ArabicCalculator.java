package ru.yaotone;

public class ArabicCalculator extends Calculator{
    public static String calculate(int num1, String operation, int num2) {
        Integer answer = switch (operation){
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> num1 / num2;
            default -> throw new IllegalArgumentException("Не является арифметическим оператором");
        };
        return answer.toString();
    }
}
