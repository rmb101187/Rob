package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Robert on 5/14/2015.
 */
public class CharacterInventory {
    static public List<Item> mCharacterInventory;
    static public List<Item> possessedItems;
    private Item mItem;
    static private double mGoldCount = 1000;
    static private Map<String, Item> characterSellableItems;


    List<Item> test;
    Item item;

    public CharacterInventory() {
        mGoldCount = 1000;

    }


    public void showCharacterIventory() {
        for (Item item: mCharacterInventory);
        System.out.printf("You have the following item : %s", mItem.getName());
    }

    public static List<Item> createItemList() {
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
    public static void printItemList() throws NullPointerException {


        try {
            if (possessedItems.isEmpty()) {
                System.out.println("You have no possessed items");
            }
            for (Item possessedItem : possessedItems) {
                System.out.printf("You have the following items %s \n", possessedItem.getName());
            }
        } catch (NullPointerException noItemsFound) {

        }
    }
    public static List<Item> getPlayersItems() {
        if (possessedItems == null) {
            possessedItems = new ArrayList<>();
        }
        return possessedItems;
    }

    public static Map<String, Item> characterItemsAsMap() {
        characterSellableItems = new HashMap<>();
        try {
            for (Item item : possessedItems) {
                characterSellableItems.put(item.getName(), item);
            }
            return characterSellableItems;
        } catch (NullPointerException noItems) {


        }
        return characterSellableItems;
    }



    public static void addPossessedItems(Item item) {
        possessedItems.add(item); // allows both the combat class and shop class to add the PossesedItems list

    }


}
