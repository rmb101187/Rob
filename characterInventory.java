package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robert on 5/14/2015.
 */
public class CharacterInventory {
    public List<Item> mCharacterInventory;
    static public List<Item> possessedItems;
    private Item mItem;
    static private double mGoldCount;

    public CharacterInventory() {
        mGoldCount = 1000;
    }


    public void showCharacterIventory() {
        for (Item item: mCharacterInventory);
        System.out.printf("You have the following item : %s", mItem.getName());
    }

    public List<Item> createItemList() {
        mCharacterInventory = new ArrayList<Item>();
        return mCharacterInventory;
    }

    public static double getGold() {
        return mGoldCount;
    }
    public static double setGold(double gold) {
        mGoldCount =gold;
        return mGoldCount;
    }
    public static List<Item> createPlayersItems() {
        possessedItems = new ArrayList<>();
        return possessedItems;
    }
}
