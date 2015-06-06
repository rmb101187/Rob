package com.company;

import com.company.CharacterInventory;

import java.util.*;

/**
 * Created by Robert on 5/12/2015.
 */

public class Shop {

    Scanner sc = CharBuilder.sc;
    private double mGoldCount;
    List<Item> itemList;
    static List<Item> possessedItems;
    Map<String, Item> storeItems;
    Map<String, Item> characterItemList;
    EquippableItems statEnhancer = new EquippableItems();
    Item item;
    String decision;



    public Shop() {
        mGoldCount = CharacterInventory.getGold();
        itemList = new Item("Helmet",10,0,0,0,3,10,0,true, false, "head").createItemList();
        possessedItems = CharacterInventory.getPlayersItems();
    }


    public void buyItem  () throws NullPointerException  {
        possessedItems = CharacterInventory.getPlayersItems();

        System.out.println("The shop has the following items for sale at the current price");
        for (Item item : itemList) {
            System.out.printf("%s : %dgp \n", item.getName(), item.getValue());
            storeItems.put(item.getName(), item); // list items in the game that the shop can sell. Any general item
        }
        String buyChoice = sc.nextLine();
        String buyChoiceToLower = buyChoice.toLowerCase();
        try {
            item = storeItems.get(buyChoiceToLower);

            System.out.printf("so you want to buy the %s for %d \n", item.getName(), item.getValue());
            decision = sc.nextLine();
        }catch(NullPointerException DoesNotExist){
            System.out.println("This item does not exist, please try again");
            buyItem();
        }


            if (decision.equalsIgnoreCase("yes")) {
                try {
                    possessedItems.add(item);
                } catch (NullPointerException itemNotFound) {
                    System.out.println("That item was not found, please try again"); // error handling
                    buyItem();
                }
                if (mGoldCount <= item.getValue()) {
                    System.out.printf("Sorry you do not have enough gold your current goldCount is %.2f gold \n",
                            mGoldCount);

                } else {
                    mGoldCount -= item.getValue();
                    System.out.printf("You bought the %s, this leaves you with %.2f gold \n", item.getName(),
                            mGoldCount);
                    for (Item possedItem : possessedItems) {
                        System.out.printf("You have the following items %s \n", item.getName());
                    }
                }
            } else {
                System.out.println("I understand, maybe some other time");
            }


    }


    public void sellItem() {
        possessedItems = CharacterInventory.getPlayersItems();
        characterItemList = CharacterInventory.characterItemsAsMap();
        mGoldCount = CharacterInventory.getGold();


        if (possessedItems.isEmpty()) {
            System.out.println("Sorry you have no items to sell");
            enterShop();
        }
        System.out.println("You have the following items to sell");
        for (Item possessedItem : possessedItems) {
            if (!item.isEquipped()) {
                System.out.printf("%s \n", possessedItem.getName());
            }
        }
        System.out.println("Which item would you like to sell?");
        String sellChoice = sc.nextLine();
        String sellChoiceToLower = sellChoice.toLowerCase();
        try {
            item = characterItemList.get(sellChoiceToLower); // get the item from the String represenation of it

        System.out.printf("so you want to sell the %s for %.2f \n", item.getName(), item.getValue() * .75);
        } catch (NullPointerException itemNotFound) {
        System.out.println("Sorry, this item was not found, please try again");
        sellItem();
        }
        decision  = sc.nextLine();

        if (decision.equalsIgnoreCase("yes")) {

            try {
                mGoldCount += item.getValue();
                System.out.printf("You sold the item %s, your current gold count is %.2f \n", item.getName(), mGoldCount);
                possessedItems.remove(item);
            } catch (NullPointerException error) {
                error.printStackTrace();
            } // sell the item for .75 worth of value, remove the item from the list of Possessed items







        }
        else {
            System.out.println("I understand, maybe some other time");
        }
    }
    public void enterShop() {
        possessedItems = CharacterInventory.getPlayersItems();
        storeItems = new HashMap<>();
        mGoldCount = CharacterInventory.getGold();
        String acceptableActions = "purchase shop sell leave exit equip";
        boolean isAcceptableAnswer;
        CharacterInventory.printItemList();
        do {

            System.out.println("You enter the shop, do you wish to browse items for purchase, " +
                    "or sell items you no longer use?");
            String shopAnswer = sc.nextLine();
            isAcceptableAnswer = acceptableActions.contains(shopAnswer);

            if (shopAnswer.equalsIgnoreCase("buy")) {
                buyItem();

            } else if (shopAnswer.equalsIgnoreCase("sell")) {
                sellItem();
            } else if (shopAnswer.equalsIgnoreCase("leave")) {
                System.out.println("You leave the shop");
                break;
            }
            else if (shopAnswer.equalsIgnoreCase("leave") || shopAnswer.equalsIgnoreCase("exit")) {
                System.out.println("You leave the shop");
                Chapter1.playChapter1();
                break;
            }
            else if (shopAnswer.equalsIgnoreCase("equip")) {
                System.out.println("Very well, you want to equip some items");
                statEnhancer.setStats();
            }
            else {
                System.out.println("Please choose buy, or sell, or leave to leave the shop");



            }
        } while (isAcceptableAnswer);
    }



    public static List<Item> getPossessedItems() {
        return possessedItems;
    }


}
