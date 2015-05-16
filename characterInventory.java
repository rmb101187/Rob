package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robert on 5/14/2015.
 */
public class characterInventory {
    public List<Item> mCharacterInventory;
    public List<Item> possessedItems;
    private Item mItem;
    private int mGoldCount;

    public characterInventory() {
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

    public int getGold() {
        return mGoldCount;
    }
    public int setGold(int gold) {
        mGoldCount =gold;
        return mGoldCount;
    }
    public List<Item> createPlayersItems() {
        possessedItems = new ArrayList<>();
        return possessedItems;
    }
}
