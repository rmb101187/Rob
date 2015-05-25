package com.company;

import java.util.List;
import java.util.Scanner;

/**
 * Created by Robert on 5/8/2015.
 */
public class Play {
    Scanner sc = CharBuilder.sc;
    String mCharName;
    List<Item> possedItems = CharacterInventory.possessedItems;

    public void Begin() {
        System.out.println("Greetings hero, what is your name?");
        String name = sc.nextLine();
        mCharName = name;
        System.out.printf("I see, your name is %s very well \n", name);
        Shop shop = new Shop();




        Enemy enemy = new Enemy();
        enemy.createListA();

        Combat combat = new Combat();
        combat.combat();
        shop.enterShop();




    }
}
