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


    public CharStatEnhancer(int str, int dex, int con, int intl, int hp, int mp) {
        characterItems = CharacterInventory.createPlayersItems();

    }

    public List<Item> createEquippableList() {
        mEquippableItems = new ArrayList<>();
        for (Item item : mEquippableItems) {
            if (item.isEquippable()) {
                mEquippableItems.add(item);
            }
        }
        return mEquippableItems;
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
