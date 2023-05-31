package com.Osama;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class TestLibrary {

    public static void main(String[] args) throws InterruptedException {

        Library library = new Library();

        while (true){

            System.out.println("**********************************************************************\n" +
                "* \t\t\t\t\t\tWelcome to Silver Bullet Library :)\n" +
                "* \t\t\t\t\t---------------------------------------------\n" +
                "* \t\tPlease enter one of the following options:\n" +
                "* \t\t1) Add a book\n" +
                "* \t\t2) Delete a book\n" +
                "* \t\t3) Find a book\n" +
                "* \t\t4) List all books\n" +
                "* \t\t5) List books for a given genre\n" +
                "* \t\t6) Number of books for a given author\n" +
                "* \t\t7) Total number of books\n" +
                "* \t\t8) Exit\n" +
                "*\n" +
                "**********************************************************************\n");

            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter your option:> ");
            int option = scanner.nextInt();

            if (option == 1) {
                System.out.print("Please, enter the book details #ISBN, author, title and genre: ");
                int ISBN = scanner.nextInt();
                String author = scanner.next();
                String title = scanner.next();
                String genre = scanner.next();
                if (library.addBook(ISBN, author, title, genre))
                    System.out.println("Book was added successfully.");
                else
                    System.out.println("There was an error adding the book.");
            }

            if (option == 2) {
                System.out.print("Please, enter the ISBN of the book you want to delete: ");
                int ISBN = scanner.nextInt();
                System.out.println(library.delBook(ISBN));
            }

            if (option == 3) {
                System.out.print("Please, enter the ISBN of the book you want to find: ");
                int ISBN = scanner.nextInt();
                System.out.println(library.findBook(ISBN));
            }

            if (option == 4) {
                library.printAll();
            }

            if (option == 5) {
                System.out.print("Please, enter the genre to list all books of this genre: ");
                String genre = scanner.next();
                library.printGenre(genre);
            }

            if (option == 6) {
                System.out.print("Please, enter the name of the author to list all books if this author: ");
                String author = scanner.next();
                System.out.println(library.getNumberOfBooksByAuthor(author));
            }

            if (option == 7) {
                System.out.println("Total number of books: " + library.getNumberOfBooks());
            }

            if (option == 8) {
                System.out.println("Love you, bye");
                break;
            }

            TimeUnit.SECONDS.sleep(3);
        }

    }

}
