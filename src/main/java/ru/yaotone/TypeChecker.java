package ru.yaotone;

import ru.yaotone.exception.DifferentTypesException;

import java.util.regex.Pattern;

public class TypeChecker {

    final static Pattern romanPattern = Pattern.compile("^(I{1,3}|IV|VI{0,3}|IX|X)$");
    final static Pattern arabicPattern = Pattern.compile("-?\\d+");

    public static CalculatorType defineType(String num1, String num2){
        if(TypeChecker.isArabic(num1) != TypeChecker.isArabic(num2)){
            throw new DifferentTypesException("Введенны числа разных типов");
        }
        else if(TypeChecker.isArabic(num1)) {
            return CalculatorType.ARABIC;
        }
        else {
            return CalculatorType.ROMAN;
        }
    }

    public static boolean isRoman(String number){
        return romanPattern.matcher(number).matches();
    }

    public static boolean isArabic(String number) {
        return arabicPattern.matcher(number).matches();
    }
}

