package ru.yaotone;

public class ArabicCalculator implements Calculator, Converter{
    @Override
    public int convert(String number){
        return Integer.parseInt(number);
    }

    @Override
    public String convert(Integer number){
        return number.toString();
    }
}
