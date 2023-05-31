package com.Osama;

public class TestMyInteger {

    public static void main(String[] args) {

        MyInteger n1 = new MyInteger(5);
        MyInteger n2 = new MyInteger(24);

        System.out.println("n1 value is " + n1.getValue());
        System.out.println("n1 is even? " + n1.isEven());
        System.out.println("n1 is prime? " + n1.isPrime());

        System.out.println("n2 value is " + n2.getValue());
        System.out.println("n2 is odd? " + n2.isOdd());

        System.out.println("n1 is equal to n2? " + n1.equals(n2));
        System.out.println("n1 is equal to 5? " + n1.equals(5));

        System.out.println("n1 value after n1.add(n2) " + n1.add(n2).getValue());
        System.out.println("n2 value after n2.sub(n1) " + n2.sub(n1).getValue());
        System.out.println("n1 value after n1.mul(n2) " + n1.mul(n2).getValue());
        System.out.println("n2 value after n2.div(n1) " + n2.div(n1).getValue());

        System.out.println("15 is prime? " + MyInteger.isPrime(15));
        System.out.println("45 is odd? " + MyInteger.isOdd(45));
    }

}
