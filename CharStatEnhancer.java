package com.company;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

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
    List<Item> mCharacterItems;
    List<Item> mEquippableItems;
    Map<String, String> mCategoryMap;
    private boolean headEquipped;
    private boolean weaponEquipped;
    private boolean torsoEquipped;
    private boolean feetEquipped;
    private Set headSet;
    private Set weaponSet;
    private Set torsoSet;
    private Set feetSet;






    public List<Item> createEquippableList() {
        mEquippableItems = new ArrayList<>();
        mCharacterItems = Item.createItemList();
        for (Item item : mCharacterItems) {
            if (item.isEquippable()) {
                mEquippableItems.add(item);

            }
        }

        return mEquippableItems;

    }



    public Map<String, String> setCategoryMap(String itemCategory) {


        for (Item item : mEquippableItems) {
            if (itemCategory.equalsIgnoreCase("head") && item.getCategory().equalsIgnoreCase("head")) {
                mCategoryMap.put(item.getCategory(), item.getName());
                System.out.printf("%s - ", item.getName());
            }
            else if (itemCategory.equalsIgnoreCase("weapon") && item.getCategory().equalsIgnoreCase("weapon")) {
                mCategoryMap.put(item.getCategory(), item.getName());
                System.out.printf("%s - ", item.getName());
            }
            else if (itemCategory.equalsIgnoreCase("torso") && item.getCategory().equalsIgnoreCase("torso")) {
                mCategoryMap.put(item.getCategory(), item.getName());
                System.out.printf("%s - ", item.getName());
            }
            else if (itemCategory.equalsIgnoreCase("feet") && item.getCategory().equalsIgnoreCase("feet")) {
                mCategoryMap.put(item.getCategory(), item.getName());
                System.out.printf("%s - ", item.getName());
            }

        }

        return mCategoryMap;
    }

    public void itemByCategory() {
        mEquippableItems = new ArrayList<>();
        mCharacterItems = Item.createItemList();
        mCategoryMap = new TreeMap<>();
        mEquippableItems = createEquippableList();
        createEquippableList();
        System.out.println("What equipment slot would you like to view ");
        String equipmentSlot = CharBuilder.sc.nextLine();
        if (equipmentSlot.equalsIgnoreCase("head")) {
            showList("head");
        }
        else if (equipmentSlot.equalsIgnoreCase("weapon")) {
            showList("weapon");
        }
        else if (equipmentSlot.equalsIgnoreCase("torso")) {
            showList("torso");
        }
        else if (equipmentSlot.equalsIgnoreCase("feet")) {
            showList("feet");
        }

    }

    public void showList(String itemType) {
        System.out.printf("Your %s equippable items are as follows \n", itemType);
        setCategoryMap(itemType);
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
