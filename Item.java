package com.company;

import com.company.CharBuilder;

/**
 * Created by Robert on 5/2/2015.
 */

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class Item {


    String mName;
    int mStr;
    int mIntl;
    int mDex;
    int mHp;
    int mMp;
    int mCon;
    int mValue;
    private boolean mEquippable;
    static List<Item> itemList;
    Map<String, Item> itemMap;
    static List<Item> rareItems;


    public  Item(String name,int value, int str, int intl, int dex, int con, int hp, int mp, boolean equipable) {
        mName = name;
        mStr = str;
        mIntl = intl;
        mCon = con;
        mDex = dex;
        mHp = hp;
        mMp = mp;
        mValue = value;
        mEquippable = equipable;

    }

    public static List<Item> createItemList() {
        itemList = new ArrayList<>();
        Item sword = new Item("sword",15,1,1,1,1,5,5, true);
        Item helmet = new Item("helmet",10,0,0,0,3,10,0, true);
        itemList.add(sword);
        itemList.add(helmet);
        return itemList;
    }

    public Map<String, Item> shopItems() {
        itemMap = new HashMap<>();
        for (Item item : itemList) {
            itemMap.put(item.getName(), item);
        }
        return itemMap;
    }

     static List<Item> rareItemList() {
        rareItems = new ArrayList<>();
        Item ruby = new Item("ruby",100, 0, 0, 0, 0, 0, 0, false);
        Item largeRuby = new Item("large ruby", 150, 0, 0, 0, 0, 0, 0, false);
        Item GoldenSword = new Item("Golden Sword", 85, 10, 0, 4, 0, 20, 0, true );
        rareItems.add(ruby);
        rareItems.add(largeRuby);
        rareItems.add(GoldenSword);

        return rareItems;
    }







    public String getName() {
        return mName;
    }
    public int getStr() {
        return mStr;
    }
    public int getIntl() {
        return mIntl;
    }
    public int getCon() {
        return mCon;
    }
    public int getDex() {
        return mDex;
    }
    public int getHp() {
        return mHp;
    }
    public int getMP() {
        return mMp;
    }
    public int getValue() {
        return mValue;
    }
    public boolean isEquipable() {
        return mEquippable;
    }

}

