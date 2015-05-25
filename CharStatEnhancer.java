package com.company;

import java.util.List;
import java.util.Set;

/**
 * Created by Robert on 5/21/2015.
 */
public class CharStatEnhancer {
    Shop shop = new Shop();
    List<Item> characterItems;
    Set<Item> playerEquipable;
    private int mStr;
    private int mDex;
    private int mCon;
    private int mInt;
    private int mHP;
    private int mMP;


    public CharStatEnhancer(int str, int dex, int con, int intl, int hp, int mp) {
        characterItems = CharacterInventory.getPlayersItems();


    }
    public Set<Item> setCharacterEquipable () {
        for (Item item : characterItems) {
            if (item.isEquipable()) {
                playerEquipable.add(item);
                System.out.printf("You have the following equippable items %s", item.getName());
            }
        }
        return playerEquipable;
    }


    public int getStr() {
        return mStr;
    }
    public int getDex() {
        return mDex;
    }
    public int getCon() {
        return mCon;
    }
    public int getInt() {
        return mInt;
    }
    public int getHP() {
        return mHP;
    }
    public int getMP() {
        return mMP;
    }
}
