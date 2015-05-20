package com.company;

import java.util.Random;

/**
 * Created by Robert on 5/18/2015.
 */
public class Loot {
    private Random randNum = Combat.randNum;
    static int randGold;
    static Enemy mEnemy;
    static String mEnemyName;
    static String mEnemyDifficulty;
    static double mGoldLooted;

    public  Loot(Enemy enemy,String enemyName, String enemyDifficulty ) {
        mEnemy = enemy;
        mEnemyName = enemyName;
        mEnemyDifficulty = enemyDifficulty;
    }
    public void loot() {
        if (mEnemyDifficulty.equalsIgnoreCase("hard")) {
            randGold = randNum.nextInt(100) + 50;
        }
        else {
            randGold = randNum.nextInt(100);
        }
         mGoldLooted += randGold;
         System.out.printf("The %s drops a chest in front of you, it contains %d gp", mEnemyName, randGold);
    }
}
