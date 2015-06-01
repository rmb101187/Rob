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
    private List<Item> rareItems;
    Item mRareItem;
    Item mFoundItem;


    public  Loot(Enemy enemy,String enemyName, String enemyDifficulty ) {
        mEnemy = enemy;
        mEnemyName = enemyName;
        mEnemyDifficulty = enemyDifficulty;
    }
    public void loot() {
        if (mEnemyDifficulty.equalsIgnoreCase("hard")) {
            randGold = randNum.nextInt(100) + 50; // adjust the loot if the enemy is in the hard category

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
        rareItems = Item.rareItemList();
        mFoundItem = availableItems.get(randNum.nextInt(availableItems.size()));
        mRareItem = rareItems.get(randNum.nextInt(rareItems.size()));
        possessedItems.add(mFoundItem);
        int rareItemChance = randNum.nextInt(100);
        System.out.printf("Congratulations you found a %s \n", mFoundItem.getName());
        if (rareItemChance > 65) {
            System.out.printf("What luck!! You've found a rare item %s \n", mRareItem.getName());
            possessedItems.add(mRareItem); // if the enemy is from the hard class drop a rare item
        }






    }

}
