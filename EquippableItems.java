package com.company;

import java.util.*;


/**
 * Created by Robert on 5/21/2015.
 */
public class EquippableItems {
    List<Item> characterItems;
    private int mStr;
    private int mDex;
    private int mCon;
    private int mInt;
    private int mHP;
    private int mMP;
    private int helmStats;
    List<Item> mCharacterItems;
    List<Item> mEquippableItems;
    Map<String, String> mCategoryMap;
    Map<String, Item> mEquippedItems;
    List<Item> mCurrentlyEquipped = new ArrayList<>();
    private boolean headEquipped;
    private boolean weaponEquipped;
    private boolean torsoEquipped;
    private boolean feetEquipped;
    Item item;








    public List<Item> createEquippableList() {
        try {
            for (Item item : mCharacterItems) {
                if (item.isEquippable()) {
                    mEquippableItems.add(item); /* creates a list to be passed in to setCategory Map so that only items that
                are equippable are tossed in */

                }
            }
        } catch (NullPointerException noItems) {

        }

        return mEquippableItems;

    }



    public Map<String, String> setCategoryMap(String itemCategory) {


        for (Item item : mEquippableItems) {
            if (itemCategory.equalsIgnoreCase("head") && item.getCategory().equalsIgnoreCase("head")) {
                mCategoryMap.put(item.getCategory(), item.getName());
                if (item.isEquipped()) {
                    System.out.printf("<E>%s - ", item.getName());
                }
                else if (!item.isEquipped()) {
                    System.out.printf("%s - ", item.getName());
                }

            }
            else if (itemCategory.equalsIgnoreCase("weapon") && item.getCategory().equalsIgnoreCase("weapon")) {
                mCategoryMap.put(item.getCategory(), item.getName());

                if (item.isEquipped()) {
                    System.out.printf("<E>%s - ", item.getName());
                }
                else if (!item.isEquipped()) {
                    System.out.printf("%s - ", item.getName());
                }

            }
            else if (itemCategory.equalsIgnoreCase("torso") && item.getCategory().equalsIgnoreCase("torso")) {
                mCategoryMap.put(item.getCategory(), item.getName());

                if (item.isEquipped()) {
                    System.out.printf("<E>%s - ", item.getName());
                }
                else if (!item.isEquipped()) {
                    System.out.printf("%s - ", item.getName());
                }

            }
            else if (itemCategory.equalsIgnoreCase("feet") && item.getCategory().equalsIgnoreCase("feet")) {
                mCategoryMap.put(item.getCategory(), item.getName());

                if (item.isEquipped()) {
                    System.out.printf("<E>%s - ", item.getName());
                }
                else if (!item.isEquipped()) {
                    System.out.printf("%s - ", item.getName());
                }

            }

        }
        System.out.println("\n");
        return mCategoryMap; /* this method simply takes a value passed in and sets mCategoryMap to only those items in
        the category */
    }

    public void itemByCategory() {

        createEquippableList();
        System.out.println("What equipment slot would you like to view \n"); // ask the user what category of equipment
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
            equipItem(); // equip the item and add it to list of equipped items
        }

    }

    public void showList(String itemType) {
        System.out.printf("Your %s equippable items are as follows \n", itemType);
        setCategoryMap(itemType); /* pulls only from the items that are equippable in that category of the item, so that
        there is no confusion of trying to equip a an item in the wrong slot */
    }

    public Map<String, Item> equipItem() throws NullPointerException {
        for (Item item : mEquippableItems) {
            mEquippedItems.put(item.getName(), item);
        }
        System.out.println("Would you like to equip one of these items? \n");
        String equipAnswer = CharBuilder.sc.nextLine();
        String validEquipAnswer = "yes no";
        boolean isValidEquipAnswer = validEquipAnswer.contains(validEquipAnswer.toLowerCase());
        do {
            if (equipAnswer.equalsIgnoreCase("yes")) {
                System.out.println("Which item would you like to equip");
                String equipChoice = CharBuilder.sc.nextLine();
                String equipChoiceLower = equipChoice.toLowerCase();
                try {
                    item = mEquippedItems.get(equipChoiceLower); // pulls the object from the map to retrieve the item
                    mEquippedItems.put(item.getName(), item);
                    mCurrentlyEquipped.add(item);
                    Item.equipItem(item);
                } catch (NullPointerException itemNotFound) {
                    System.out.println("Sorry this item was not found, please try again");

                }


            }
            else if (equipAnswer.equalsIgnoreCase("no")) {
                System.out.println("Very well, do you want to equip an item of another slot?");
                String continueToEquip = CharBuilder.sc.nextLine();
                String validContinueToEquipResponse = "yes no";
                boolean isValidContinueToEquipResponse =
                        validContinueToEquipResponse.contains(continueToEquip.toLowerCase());
                do {
                    if (continueToEquip.equalsIgnoreCase("yes")) {
                        setStats();
                    }
                    else if (continueToEquip.equalsIgnoreCase("no")) {

                        Chapter1.playChapter1();
                    }
                    else {
                        System.out.println("Sorry, please choose yes or no");
                        equipItem();

                    }
                } while(!isValidContinueToEquipResponse);
            }

            else {
                System.out.println("Sorry, please choose yes or no");
                equipItem();
            }
        } while (!isValidEquipAnswer);

        System.out.println("You currently have the following items equipped");
        for (Item item : mCurrentlyEquipped) {

            System.out.printf("%s -", item.getName());
        }
        System.out.println("\n");
        System.out.println("Would you like to equip another item?");
        String equipAgain = CharBuilder.sc.nextLine();
        String validDecision = "yes no";

        boolean isValidDecision =validDecision.contains(validDecision.toLowerCase());

        while (!isValidDecision) {
            if (equipAgain.equalsIgnoreCase("yes")) {
                itemByCategory();
            } else if (equipAgain.equalsIgnoreCase("no")) {
                Chapter1.playChapter1();
                break;
            } else {
                System.out.println("Sorry, please choose yes or no");
            }
        }
        return mEquippedItems;
    }

    public int adjustHP() {
        for (Item item: mCurrentlyEquipped) {
            mHP += item.getHp();
        }
        return mHP;
    }

    public int adjustMP() {
        for (Item item: mCurrentlyEquipped) {
            mMP += item.getMP();
        }
        return mMP;
    }
    public int adjustStr() {
        for (Item item: mCurrentlyEquipped) {
            mStr += item.getStr();
        }
        return mStr;
    }

    public void adjustStats() {
        adjustHP();
        adjustMP();
        adjustStr();
        System.out.printf("With your current equipment you have added %d hitpoints, %d manapoints, and %d strength",
                getHP(), getMP(), getStr()); // adjust the stats and ensure that they properly calculate
    }

    public void setStats() {
        mEquippableItems = new ArrayList<>();
        mCharacterItems = CharacterInventory.getPlayersItems();
        mCategoryMap = new TreeMap<>();
        mEquippableItems = createEquippableList();
        mEquippedItems = new HashMap<>();
        mEquippableItems = new ArrayList<>();
        mEquippableItems = new ArrayList<>();
        try {
            if (mCharacterItems.isEmpty()) {
                System.out.println("Sorry you have no equippable items");
                Chapter1.playChapter1();
            }
        } catch (NullPointerException noitems) {
            System.out.println("Sorry you have no equippable items");
            Chapter1.playChapter1();
        }
        itemByCategory();
        adjustStats();

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
