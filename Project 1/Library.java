package com.Osama;

public class Library {

    Book[] libraryBooks;
    int numOfBooks;
    static final int MAX_SIZE = 10;

    Library() {
        this.libraryBooks = new Book[MAX_SIZE];
        numOfBooks = 0;
    }

    public boolean addBook(int ISBN, String author, String title, String genre) {
        //checks if its full
        if (numOfBooks == libraryBooks.length)
            return false;



        Book book = new Book(ISBN, author, title, genre);

        if(!(findBook(ISBN) == -1) || !(book.verifyISBN(ISBN)))
            return false;

        libraryBooks[numOfBooks] = book;
        numOfBooks++;
        return true;
    }

    public boolean addBook(Book b) {
        //checks if its full
        if (numOfBooks == libraryBooks.length)
            return false;

        if(!(findBook(b.ISBN) == -1 || b.verifyISBN(b.ISBN)))
            return false;

        libraryBooks[numOfBooks] = b;
        numOfBooks++;

        return true;
    }

    public boolean delBook(int ISBN) {

        for (int i = 0; i < numOfBooks; i++) {

            if (ISBN == libraryBooks[i].ISBN) {
                libraryBooks[i] = libraryBooks[numOfBooks - 1];
                numOfBooks--;
                libraryBooks[numOfBooks] = null;
                return true;
            }

        }
        return false;
    }

    public int findBook(int ISBN) {
        for (int i = 0; i < numOfBooks; i++) {
            if (ISBN == libraryBooks[i].ISBN) {
                libraryBooks[i].printBookInfo();
                return i;
            }
        }
        return -1;
    }

    public void printAll() {
        for (int i = 0; i < numOfBooks; i++) {
            System.out.println("Book " + (i+1) + ":");
            libraryBooks[i].printBookInfo();
        }
    }

    public void printGenre(String genre) {
        for (int i = 0; i < numOfBooks; i++) {
            if (libraryBooks[i].genre.equals(genre)) {
                System.out.println("Book " + (i+1) + ":");
                libraryBooks[i].printBookInfo();
            }
        }
    }

    public int getNumberOfBooksByAuthor(String author) {
        int g = 0;
        for (int i = 0; i < numOfBooks; i++) {
            if (libraryBooks[i].author.equals(author))
                g++;
        }
        return g;
    }

    public int getNumberOfBooks() {
        return numOfBooks;
    }

    public Book[] getLibraryBooks() {
        return libraryBooks;
    }

    public void setNumOfBooks(int numOfBooks) {
        this.numOfBooks = numOfBooks;
    }
}
