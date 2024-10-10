package ru.yaotone;

public class RomanCalculator implements Calculator{
    public String calculate(String num1, String operation, String num2) {
        Integer answer = switch (operation){
            case "+" -> NumbersConverter.RomanToInt(num1) + NumbersConverter.RomanToInt(num2);
            case "-" -> NumbersConverter.RomanToInt(num1) - NumbersConverter.RomanToInt(num2);
            case "*" -> NumbersConverter.RomanToInt(num1) * NumbersConverter.RomanToInt(num2);
            case "/" -> NumbersConverter.RomanToInt(num1) / NumbersConverter.RomanToInt(num2);
            default -> throw new IllegalArgumentException("Не является арифметическим оператором");
        };
        return NumbersConverter.intToRoman(answer);
    }
}
