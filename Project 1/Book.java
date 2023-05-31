package com.Osama;

public class Book {

    int ISBN;
    String author = "";
    String title = "";
    String genre = "";
    String refCode = "";
    int check;

    public Book() {
    }

    public Book(int ISBN, String author, String title, String genre) {
        this.ISBN = ISBN;
        this.author = author;
        this.title = title;
        this.genre = genre;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getISBN() {
        return ISBN;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getRefCode() {
        return refCode;
    }

    public void generateReference() {

        String authorUpper = author.toUpperCase();
        String genreUpper = genre.toUpperCase();

        char name1 = authorUpper.charAt(0);
        char name2 = authorUpper.charAt(1);

        char genre1 = genreUpper.charAt(0);
        char genre2 = genreUpper.charAt(1);

        refCode = "" + name1 + name2 + "--" + genre1 + genre2;

    }

    public boolean verifyISBN(int ISBN) {

        int b = 0;
        int n1 = 0;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;

        for (int i = 1; ISBN > 0; i++) {

            b = ISBN % 10;
            ISBN = ISBN / 10;

            if (i == 1)
                n4 = b;

            else if (i == 2)
                n3 = b;

            else if (i == 3)
                n2 = b;

            else
                n1 = b;

            //check++;

        }
        return (n1 * 3 + n2 * 2 + n3) % 4 == n4;
    }

    public void printBookInfo() {
        generateReference();

        String realISBN = "";

        /*while (check++ < 4)
            realISBN += "0";*/

        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " /*+ realISBN */+ ISBN + " - Reference Code: " + refCode);
        System.out.println("Genre: " + genre );
        System.out.println();
    }

    public boolean equals(Book b) {
        return ISBN == b.ISBN;
    }
}
