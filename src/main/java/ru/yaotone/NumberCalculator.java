package ru.yaotone;

public class NumberCalculator implements Calculator{

    public String calculate(String num1, String operation, String num2) {
        Calculator calculator = CalculatorFactory.createCalculator(TypeChecker.defineType(num1,num2));
        return calculator.calculate(num1, operation, num2);
    }
}
