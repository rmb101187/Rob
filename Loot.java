package com.company;

import java.util.Random;

/**
 * Created by Robert on 5/18/2015.
 */
public class Loot {
    private Random randNum = Combat.randNum;
    private int randGold;
    private Enemy mEnemy;
    private String mEnemyName;
    private String mEnemyDifficulty;

    public Loot(Enemy enemy,String enemyName, String enemyDifficulty ) {
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
         System.out.printf("The %s drops a chest in front of you, it contains %d gp", mEnemyName, randGold);
    }
}
