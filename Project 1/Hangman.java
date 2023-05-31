package com.Osama;

import javax.swing.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Hangman {

    String[] words = {"program","obama", "silver", "squad", "youtube"};
    char[] hiddenWord;
    char[] guessedWord;
    String theWord;
    Scanner scanner = new Scanner(System.in);

    Hangman(){
        hiddenWord = null;
        guessedWord = null;
        theWord = null;
    }

    private int indexOf(char c) {

        for (int i = 0; i < hiddenWord.length; i++) {
            if (c == hiddenWord[i])
                return i;
        }
        return -1;
    }

    private void setCharAt(int i, char c, char[] arr) {
        arr[i] = c;
    }

    private String pickWord() { // picks a random word
        Random random = new Random();
        int wordIndex = random.nextInt(words.length);
        return words[wordIndex];
    }

    private char[] copyStringToArray(String s) {
        return s.toCharArray();
    }

    private void printWord() {
        System.out.println(theWord);
    }

    private boolean isComplete() { // checks if its complete
        for (int i = 0; i < guessedWord.length; i++) {
            if (guessedWord[i] == '*')
                return false;
        }
        return true;
    }

    private boolean playerLost(int misses) {
        return (misses > 8);
    }

    private void playOneRound() {

        int misses = 0;

        theWord = pickWord(); // initializes theWord from pickWord
        hiddenWord = copyStringToArray(this.theWord); // initializes hiddenWord from theWord
        guessedWord = new char[hiddenWord.length];

        Arrays.fill(guessedWord, '*'); // fills guessedWord with *

        while (true) {
            if (isComplete()) {
                System.out.print("Correct! The word was: ");
                printWord();
                System.out.println("You missed " + misses + " times.");//prints the number of misses
                break;
            }

            if (playerLost(misses)) {
                System.out.println("Sorry, you lost.");
                System.out.print("The word was: ");
                printWord();
                System.out.println("You missed " + misses + " times.");//prints the number of misses
                break;
            }

            System.out.print("(Guess) Enter a letter in word" + Arrays.toString(guessedWord) + ">");
            String c = scanner.next();

            if (indexOf(c.charAt(0)) == -1) {
                misses++;
                System.out.println("Oops, that was wrong");
                System.out.println("You have " + (9 - misses) + " misses left.");
            } else {
                for (int i = 0; i < hiddenWord.length; i++) {
                    if (indexOf(c.charAt(0)) == -1)
                        break;
                    System.out.println("The letter was correct!");
                    setCharAt(indexOf(c.charAt(0)), c.charAt(0), guessedWord);
                    setCharAt(indexOf(c.charAt(0)), '$', hiddenWord);
                }
            }
        }
    }

     public void play(){
        System.out.print("Welcome to Hangman game. Are you ready? y>yes, n>no: ");
        String answer = scanner.next();

        if (answer.equals("y")) {
            System.out.println("Alright, lets start! If you miss 9 times you will lose.");
            playOneRound();
        }
    }

    public String[] getWords() {
        return words;
    }

    public char[] getHiddenWord() {
        return hiddenWord;
    }
}
