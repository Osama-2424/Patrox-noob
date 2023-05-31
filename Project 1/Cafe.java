package com.Osama;

public class Cafe {

    private double coffeeTotPrice;
    private double teaTotPrice;
    private double donutTotPrice;
    private int coffeeTotQty;
    private int teaTotQty;
    private int donutTotQty;
    private int discount;
    private double subtotal;
    private double discountedPrice;
    private double total;
    private double coffeePrice;
    private double teaPrice;
    private double donutPrice;

    public Cafe(double coffeePrice, double teaPrice, double donutPrice, int coffeeTotQty, int teaTotQty, int donutTotQty, int discount) {
        this.coffeePrice = coffeePrice;
        this.teaPrice = teaPrice;
        this.donutPrice = donutPrice;
        this.coffeeTotQty = coffeeTotQty;
        this.teaTotQty = teaTotQty;
        this.donutTotQty = donutTotQty;
        this.discount = discount;
    }

    public void setCoffeeTotPrice(double coffeeTotPrice) {
        if (coffeeTotPrice < 0)
            System.out.println("Price can not be negative");
        else
            this.coffeeTotPrice = coffeeTotPrice;
    }

    public void setTeaTotPrice(double teaTotPrice) {
        if (teaTotPrice < 0)
            System.out.println("Price can not be negative");
        else
        this.teaTotPrice = teaTotPrice;
    }

    public void setDonutTotPrice(double donutTotPrice) {
        if (donutTotPrice < 0)
            System.out.println("Price can not be negative");
        else
        this.donutTotPrice = donutTotPrice;
    }

    public void setCoffeeTotQty(int coffeeTotQty) {
        if (coffeeTotQty < 0)
            System.out.println("Price can not be negative");
        else
        this.coffeeTotQty = coffeeTotQty;
    }

    public void setTeaTotQty(int teaTotQty) {
        if (teaTotQty < 0)
            System.out.println("Quantity can not be negative");
        else
        this.teaTotQty = teaTotQty;
    }

    public void setDonutTotQty(int donutTotQty) {
        if (donutTotQty < 0)
            System.out.println("Quantity can not be negative");
        else
        this.donutTotQty = donutTotQty;
    }

    public void setDiscount(byte discount) {
        if (discount >= 0 && discount <= 100)
            System.out.println("Quantity can not be negative");
        else
        this.discount = discount;
    }

    public double getCoffeeTotPrice() {
        return coffeeTotPrice;
    }

    public double getTeaTotPrice() {
        return teaTotPrice;
    }

    public double getDonutTotPrice() {
        return donutTotPrice;
    }

    public int getCoffeeTotQty() {
        return coffeeTotQty;
    }

    public int getTeaTotQty() {
        return teaTotQty;
    }

    public int getDonutTotQty() {
        return donutTotQty;
    }

    public int getDiscount() {
        return discount;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getDiscountedPrice() {
        return discountedPrice;
    }

    public double getTotal() {
        return total;
    }

    private void calculateSubTotal(int coffeeQty, int teaQty, int donutQty) {
        coffeeTotPrice = coffeeQty * coffeePrice;
        teaTotPrice = teaQty * teaPrice;
        donutTotPrice = donutQty * donutPrice;
        subtotal = coffeeTotPrice + teaTotPrice + donutTotPrice;
    }

    private void calculateTotal(int coffeeQty, int teaQty, int donutQty) {
        calculateSubTotal(coffeeQty, teaQty, donutQty);
        total = subtotal * ((100 - discount) / 100.0);
        discountedPrice = subtotal * (discount / 100.0);
    }

    public double order(int coffeeQty, int teaQty, int donutQty) {
        if (coffeeQty > coffeeTotQty || teaQty > teaTotQty || donutQty > donutTotQty) {
            System.out.print("Error: no enough cups and/or donuts\n");
            return 0;
        }

        calculateTotal(coffeeQty, teaQty, donutQty);
        display(coffeeQty, teaQty, donutQty);

        coffeeTotQty -= coffeeQty;
        teaTotQty -= teaQty;
        donutTotQty -= donutQty;

        return total;
    }

    public void display(int coffeeQty, int teaQty, int donutQty) {

        System.out.println("-----------------------------------------------------------------------------------\n" +
                "Item\t\t\t\t\t\t\t\t Quantity\t\t\t\t\t\t\t Price\n" +
                "-----------------------------------------------------------------------------------\n" +
                "Coffee\t\t\t\t\t\t\t\t"+ coffeeQty + "\t\t\t\t\t\t\t\t\t" + coffeeTotPrice +"\n" +
                "Tea\t\t\t\t\t\t\t\t\t" + teaQty +  "\t\t\t\t\t\t\t\t\t" + teaTotPrice + "\n" +
                "Donuts\t\t\t\t\t\t\t\t" + donutQty + "\t\t\t\t\t\t\t\t\t" + donutTotPrice + "\n" +
                "-----------------------------------------------------------------------------------\n" +
                "Subtotal\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + subtotal +"\n" +
                "discount\t\t\t\t\t\t\t (%"+ discount +")\t\t\t\t\t\t\t\t" + discountedPrice + "\n" +
                "------------------------------------------------------------------------------------\n" +
                "Total\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + total + "\n" +
                "------------------------------------------------------------------------------------\n");
    }
}
