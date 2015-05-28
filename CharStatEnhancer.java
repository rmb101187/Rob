package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Robert on 5/21/2015.
 */
public class CharStatEnhancer {
    Shop shop = new Shop();
    List<Item> characterItems;
    private int mStr;
    private int mDex;
    private int mCon;
    private int mInt;
    private int mHP;
    private int mMP;
    List<Item> mEquippableItems;
    Map<String, Item> mCategoryMap;




    public List<Item> createEquippableList() {
        mEquippableItems = CharacterInventory.getPlayersItems();
        for (Item item : mEquippableItems) {
            if (item.isEquippable()) {
                mEquippableItems.add(item);

            }
        }
        return mEquippableItems;

    }

    public void printEquippables() {
        createEquippableList();
        for (Item item : mEquippableItems) {
            createEquippableList();
            System.out.printf("You can equip the following items %s", item.getName());
        }
    }

    public Map<String, Item> setCategoryMap() {
        mCategoryMap = new TreeMap<>();

        for (Item item : mEquippableItems) {
            mCategoryMap.put(item.getCategory(), item);
        }
        return mCategoryMap;
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
