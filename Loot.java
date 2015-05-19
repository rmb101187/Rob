package com.company;

import java.util.Random;

/**
 * Created by Robert on 5/18/2015.
 */
public class Loot {
    private Random randNum = Combat.randNum;
    private int randGold = randNum.nextInt(100);
    private Enemy mEnemy;
    private String mEnemyName;

    public Loot(Enemy enemy,String enemyName) {
        mEnemy = enemy;
        mEnemyName = enemyName;
    }
    public void test() {
         System.out.printf("The %s drops a chest in front of you, it contains %d gp", mEnemyName, randGold);
    }
}
