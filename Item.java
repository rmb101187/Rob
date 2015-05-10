package com.company;

import com.company.CharBuilder;

/**
 * Created by Robert on 5/2/2015.
 */

import java.util.List;
import java.util.ArrayList;

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
        Item sword = new Item("sword",5,1,1,1,1,5,5);
        itemList.add(sword);
        return itemList;
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

}

