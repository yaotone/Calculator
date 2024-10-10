package ru.yaotone;

public class CalculatorFactory {
    public static Calculator createCalculator(CalculatorType type){

        return switch (type){
            case ROMAN -> new RomanCalculator();
            case ARABIC -> new ArabicCalculator();
        };
    }
}
