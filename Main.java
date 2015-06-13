package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String mCharName;
        Scanner sc = CharBuilder.sc;

        System.out.println("Greetings hero, what is your name?");
        String name = sc.nextLine();
        mCharName = name;
        System.out.printf("I see, your name is %s very well \n", name);

        Play playGame = new Play();
        playGame.Begin(); // begin the game
}
}