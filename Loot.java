package com.company;

import java.util.Random;

/**
 * Created by Robert on 5/18/2015.
 */
public class Loot {
    private Random randNum = Combat.randNum;
    private int randGold = randNum.nextInt(100);

    public void test() {
        System.out.printf("You find a chest in front of you, it contains %d gp", randGold);
    }
}
