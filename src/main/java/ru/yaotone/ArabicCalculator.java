package ru.yaotone;

public class ArabicCalculator extends NumberCalculator {
    public String calculate(String num1, String operation, String num2) {

        Integer answer = switch (operation){
            case "+" -> NumbersConverter.StringToInt(num1) + NumbersConverter.StringToInt(num2);
            case "-" -> NumbersConverter.StringToInt(num1) - NumbersConverter.StringToInt(num2);
            case "*" -> NumbersConverter.StringToInt(num1) * NumbersConverter.StringToInt(num2);
            case "/" -> NumbersConverter.StringToInt(num1) / NumbersConverter.StringToInt(num2);
            default -> throw new IllegalArgumentException("Не является арифметическим оператором");
        };
        return answer.toString();
    }
}
