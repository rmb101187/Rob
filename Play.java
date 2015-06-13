package com.company;

import java.util.List;
import java.util.Scanner;

/**
 * Created by Robert on 5/8/2015.
 */
public class Play {
    Scanner sc = CharBuilder.sc;
    String mCharName;
    CharBuilder character;


    public void Begin() {
        System.out.println("Greetings hero, what is your name?");
        String name = sc.nextLine();
        mCharName = name;
        System.out.printf("I see, your name is %s very well \n", name);
        character = new CharBuilder("warrior", 6, 6, 6, 6, 40, 30).createHero();


        Chapter1.playChapter1();




        Enemy enemy = new Enemy();
        enemy.createListA();







    }

    public CharBuilder returnHero() {
        return character;
    }
}