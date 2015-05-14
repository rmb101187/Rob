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
    List<Item> itemList;
    Map<Item, Integer> itemMap;


    public  Item(String name,int value, int str, int intl, int dex, int con, int hp, int mp) {
        mName = name;
        mStr = str;
        mIntl = intl;
        mCon = con;
        mDex = dex;
        mHp = hp;
        mMp = mp;
        mValue = value;

    }

    public List<Item> createItemList() {
        itemList = new ArrayList<>();
        Item sword = new Item("Sword",15,1,1,1,1,5,5);
        Item helmet = new Item("Helmet",10,0,0,0,3,10,0);
        Item ruby = new Item("Ruby",100, 0, 0, 0, 0, 0, 0);
        itemList.add(sword);
        itemList.add(helmet);
        itemList.add(ruby);

        return itemList;
    }

    public Map<Item, Integer> shopItems() {
        itemMap = new HashMap<>();
        for (Item item : itemList) {
            itemMap.put(item, item.getValue());
        }
        return itemMap;
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

}

