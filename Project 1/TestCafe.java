package com.Osama;

import java.sql.Time;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class TestCafe {

    public static void main(String[] args) throws InterruptedException {

        Cafe c1 = new Cafe(5.5, 3.5, 2.25, 100, 100, 50, 10);
        int i = 0;
        while (true) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("**********************************************************************\n" +
                    "*\t\t\t\t\t\tWelcome to Cafe :)\t\t\t\t\t\t\t *\n" +
                    "*\t\t\t\t\t---------------------------\t\t\t\t\t\t *\n" +
                    "*\t\tPlease enter one of the following options: \t\t\t\t\t *\n" +
                    "*\t\t1) order ==> this allows you to order a drink \t\t\t\t *\n" +
                    "*\t\t2) quit ==> to end this program \t\t\t\t\t\t\t *\n" +
                    "*\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t *\n" +
                    "**********************************************************************");
            System.out.print("Enter your option :> ");
            byte input = scanner.nextByte();
            if (input == 2) {
                System.out.println("Total sales: " + i);
                System.out.println("Thanks. Goodbye!");
                break;
            }

            System.out.print("Please, enter order(#cups of coffee, #cups of tea and #donuts: ");
            int coffeeQty = scanner.nextInt();
            int teaQty = scanner.nextInt();
            int donutQty = scanner.nextInt();

            i++;

            if(c1.order(coffeeQty, teaQty, donutQty) == 0)
                break;

            TimeUnit.SECONDS.sleep(3);

        }


    }
}
