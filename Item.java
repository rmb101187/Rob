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
    String mCategory;
    boolean mIsEquipabble;
    boolean mIsEquipped;
    static List<Item> itemList;
    Map<String, Item> itemMap;
    static List<Item> rareItems;



    public  Item(String name,int value, int str, int intl, int dex, int con, int hp, int mp, boolean isEquippable,
                 boolean isEquipped ,String category) {
        mName = name;
        mStr = str;
        mIntl = intl;
        mCon = con;
        mDex = dex;
        mHp = hp;
        mMp = mp;
        mValue = value;
        mIsEquipabble = isEquippable;
        mCategory = category;
        mIsEquipped = isEquipped;

    }



    public static List<Item> createItemList() {
        itemList = new ArrayList<>();
        Item sword = new Item("sword",15,1,1,1,1,5,5, true, false, "weapon");
        Item helmet = new Item("helmet",10,0,0,0,3,10,0, true, false, "head");
        Item chainMail = new Item("chain mail",20, 0, 0, 0, 4, 10, 0, true, false, "torso");
        Item leatherBoots = new Item("leather boots", 15, 2, 0, 0, 0, 3, 3, true, false, "feet");
        Item plateHelm = new Item("plate helmet", 30, 0, 0, 0, 4, 15, 0, true, false, "head");
        Item wizardShoes = new Item("wizard shoes", 50, 0, 4, 0, 2, 5, 10, true, false, "feet");

        itemList.add(sword);
        itemList.add(helmet);
        itemList.add(chainMail);
        itemList.add(plateHelm);
        itemList.add(leatherBoots);
        itemList.add(wizardShoes);

        return itemList; // static variable tp be passed to many classes
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
        Item ruby = new Item("ruby",100, 0, 0, 0, 0, 0, 0, false, false, "rare");
        Item largeRuby = new Item("large ruby", 150, 0, 0, 0, 0, 0, 0, false, false, "rare");
        Item GoldenSword = new Item("golden sword", 85, 10, 0, 4, 0, 20, 0,true, false, "weapon");
        rareItems.add(ruby);
        rareItems.add(largeRuby);
        rareItems.add(GoldenSword);

        return rareItems; // rare Item list that has a probability to drop after each combat
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
    boolean isEquippable() {
        return mIsEquipabble;
    }
    public String getCategory() {
        return mCategory;
    }
    public boolean isEquipped() {
        return mIsEquipped;
    }

}

