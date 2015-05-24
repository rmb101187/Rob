package com.company;

import java.util.List;
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
    static double mGoldLooted;
    private List<Item> availableItems;
    private List<Item> possessedItems;
    Item mFoundItem;


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
         CharacterInventory.setGold(mGoldLooted);
         System.out.printf("The %s drops a chest in front of you, it contains %d gp \n", mEnemyName, randGold);
         lootItem();
    }

    public void lootItem() {
        availableItems = Item.createItemList();
        possessedItems = CharacterInventory.createPlayersItems();
        mFoundItem = availableItems.get(randNum.nextInt(availableItems.size()));
        possessedItems.add(mFoundItem);
        System.out.printf("Congratulations you found a %s \n", mFoundItem.getName());


        

    }

}
