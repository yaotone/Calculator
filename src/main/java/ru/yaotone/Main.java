package ru.yaotone;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите выражение \n");

        String[] UserInput = input.nextLine().split(" ");

        Calculator calculator = new NumberCalculator();
        String answer = calculator.calculate(UserInput[0], UserInput[1], UserInput[2]);
        System.out.println(answer);

        input.close();
    }
}

