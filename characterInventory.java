package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Robert on 5/14/2015.
 */
public class CharacterInventory {
    public List<Item> mCharacterInventory;
    static public List<Item> possessedItems;
    private Item mItem;
    static private double mGoldCount;
    static private Map<String, Item> characterSellableItems;

    public CharacterInventory() {
        mGoldCount = 1000;
        possessedItems = new ArrayList<>();
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
    public static void printItemList() {
        for (Item possessedItem : possessedItems) {
            System.out.printf("You have the following items %s \n", possessedItem.getName());
        }
    }
    public static List<Item> getPlayersItems() {
        return possessedItems;
    }

    public static Map<String, Item> characterItemsAsMap() {
        characterSellableItems = new HashMap<>();
        for (Item item : possessedItems) {
            characterSellableItems.put(item.getName(), item);
        }
        return characterSellableItems;
    }
}
