package ru.yaotone;

import com.sun.jdi.InvalidTypeException;

import javax.management.relation.InvalidRelationTypeException;
import java.security.InvalidParameterException;
import java.util.MissingFormatArgumentException;
import java.util.regex.Pattern;

public class TypeChecker {

    enum NumberType{
        Arabic,
        Roman
    }

    static Pattern romanPattern = Pattern.compile("^(I{1,3}|IV|VI{0,3}|IX|X)$");
    static Pattern arabicPattern = Pattern.compile("-?\\d+");

    public static NumberType defineType(String num1, String num2){
        if(TypeChecker.isArabic(num1) != TypeChecker.isArabic(num2)){
            throw new DifferentTypesException("Введенны числа разных типов");
        }
        else if(TypeChecker.isArabic(num1)) {
            return NumberType.Arabic;
        }
        else {
            return NumberType.Roman;
        }
    }

    public static boolean isRoman(String number){
        return romanPattern.matcher(number).matches();
    }

    public static boolean isArabic(String number) {
        return arabicPattern.matcher(number).matches();
    }
}

class DifferentTypesException extends RuntimeException{
    public DifferentTypesException(String message){
        super(message);
    }
}
