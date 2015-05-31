package com.company;

import java.util.*;


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
    Map<String, Item> mEquippedItems;
    List<Item> currentlyEquipped;
    private boolean headEquipped;
    private boolean weaponEquipped;
    private boolean torsoEquipped;
    private boolean feetEquipped;
    Item item;








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
        System.out.println("\n");
        return mCategoryMap;
    }

    public void itemByCategory() {
        mEquippableItems = new ArrayList<>();
        mCharacterItems = Item.createItemList();
        mCategoryMap = new TreeMap<>();
        mEquippableItems = createEquippableList();
        mEquippedItems = new HashMap<>();
        currentlyEquipped = new ArrayList<>();
        createEquippableList();
        System.out.println("What equipment slot would you like to view \n");
        String equipmentSlot = CharBuilder.sc.nextLine();
        if (equipmentSlot.equalsIgnoreCase("head")) {
            showList("head");
            equipItem();
        }
        else if (equipmentSlot.equalsIgnoreCase("weapon")) {
            showList("weapon");
            equipItem();
        }
        else if (equipmentSlot.equalsIgnoreCase("torso")) {
            showList("torso");
            equipItem();
        }
        else if (equipmentSlot.equalsIgnoreCase("feet")) {
            showList("feet");
            equipItem();
        }

    }

    public void showList(String itemType) {
        System.out.printf("Your %s equippable items are as follows \n", itemType);
        setCategoryMap(itemType);
    }

    public Map<String, Item> equipItem() {
        for (Item item : mEquippableItems) {
            mEquippedItems.put(item.getName(), item);
        }
        System.out.println("Would you like to equip one of these items? \n");
        String equipAnswer = CharBuilder.sc.nextLine();
        if (equipAnswer.equalsIgnoreCase("yes")) {
            System.out.println("Which item would you like to equip");
            String equipChoice = CharBuilder.sc.nextLine();
            String equipChoiceLower = equipChoice.toLowerCase();
            item = mEquippedItems.get(equipChoiceLower);
            mEquippedItems.put(item.getName(), item);
            currentlyEquipped.add(item);

        }
        else {
            System.out.println("Sorry, please choose yes or no");
            equipItem();
        }


        for (Item item : currentlyEquipped) {
            System.out.println("You currently have the following items equipped");
            System.out.printf("%s -", item.getName());

        }

        return mEquippedItems;
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
