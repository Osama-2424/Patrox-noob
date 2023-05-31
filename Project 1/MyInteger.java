package com.Osama;

public class MyInteger {

    private int value;

    public MyInteger() {
        this(0);
    }

    public MyInteger(int value) {
        this.value = value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public boolean isEven() {
        return value % 2 == 0;
    }

    public boolean isOdd() {
        return value % 2 != 0;
    }

    public boolean isPrime() {
        if (value <= 0)
            return false;

        for (int i = 2; i < value; i++) {
            if (value % i ==0)
                return false;
        }
        return true;
    }

    public static boolean isEven(int n) {
        return n % 2 == 0;
    }

    public static boolean isOdd(int n) {
        return n % 2 != 0;
    }

    public static boolean isPrime(int n) {
        if (n <= 0)
            return false;

        for (int i = 2; i < n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static boolean isEven(MyInteger n) {
        return n.value % 2 == 0;
    }

    public static boolean isOdd(MyInteger n) {
        return n.value % 2 != 0;
    }

    public static boolean isPrime(MyInteger n) {
        if (n.value <= 0)
            return false;

        for (int i = 2; i < n.value; i++) {
            if (n.value % i ==0)
                return false;
        }
        return true;
    }

    public MyInteger add(MyInteger n) {
        MyInteger result = new MyInteger();
        result.value = this.value + n.value;

        return result;
    }

    public MyInteger sub(MyInteger n) {
        MyInteger result = new MyInteger();
        result.value = this.value - n.value;

        return result;
    }

    public MyInteger mul(MyInteger n) {
        MyInteger result = new MyInteger();
        result.value = this.value * n.value;

        return result;
    }

    public MyInteger div(MyInteger n) {
        if (n.value == 0)
            return null;

        MyInteger result = new MyInteger();
        result.value = this.value / n.value;

        return result;
    }

    public boolean equals(int n) {
        return n == this.value;
    }

    public boolean equals(MyInteger n) {
        return n.value == this.value;
    }

}
