package ru.yaotone;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите выражение");

        String number1 = input.next();
        String operation = input.next();
        String number2 = input.next();

        input.close();

        Pattern pattern = Pattern.compile("\\d+");

        try {
            if (pattern.matcher(number1).matches() != pattern.matcher(number2).matches()){
                throw new ArithmeticException("Введенные числа не соответствуют формату");
            }
            else if(pattern.matcher(number1).matches()){
                Calculator calculator = new ArabicCalculator();
//                int answer =
//                calculator.calculate(calculator.convertToInt(number1), operation, calculator.convertToInt(number2));
//
                String answer = calculator.calculate(number1, operation, number2);
                System.out.println(answer);
            }
            else {
                Calculator calculator = new RomanCalculator();

//                String answer =
//                calculator.convertToRoman(calculator.calculate(calculator.convertToInt(number1), operation, calculator.convertToInt(number2)));
//
                String answer = calculator.calculate(number1, operation, number2);
                System.out.println(answer);
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}

