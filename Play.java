package com.company;

import java.util.Scanner;

/**
 * Created by Robert on 5/8/2015.
 */
public class Play {
    Scanner sc = CharBuilder.sc;
    String mCharName;

    public void Begin() {
        System.out.println("Greetings hero, what is your name?");
        String name = sc.nextLine();
        mCharName = name;
        System.out.printf("I see, your name is %s very well \n", name);
        Shop shop = new Shop();
        shop.enterShop();

        Enemy enemy = new Enemy();
        enemy.createListA();

        Combat combat = new Combat();
        combat.combat();

    }
}
