package com.company;

import com.company.CharacterInventory;

import java.util.*;

/**
 * Created by Robert on 5/12/2015.
 */

public class Shop {

    Scanner sc = CharBuilder.sc;
    CharacterInventory charInv = new CharacterInventory();

    private double mGoldCount;
    List<Item> itemList;
    static List<Item> possessedItems;
    Map<String, Item> storeItems;
    Map<String, Item> characterItemList;
    Item item;
    String decision;
    Item itemToBuy;



    public Shop() {
        mGoldCount = CharacterInventory.getGold();
        itemList = new Item("Helmet",10,0,0,0,3,10,0,true, false, "head").createItemList();
        possessedItems = CharacterInventory.getPlayersItems();
    }


    public void buyItem  () throws NullPointerException  {


        System.out.println("The shop has the following items for sale at the current price");
        for (Item item : itemList) {
            System.out.printf("%s : %dgp \n", item.getName(), item.getValue());
            storeItems.put(item.getName(), item); // list items in the game that the shop can sell. Any general item
        }
        if (storeItems.containsKey("sword")) {
            System.out.println("Sword is contained");
        }
        else {
            System.out.println("Woah, we got a fucking problem here");
        }
        String buyChoice = sc.nextLine();
        String buyChoiceToLower = buyChoice.toLowerCase();
        try {
            itemToBuy = storeItems.get(buyChoiceToLower);

            System.out.printf("so you want to buy the %s for %d \n", itemToBuy.getName(), itemToBuy.getValue());
            decision = sc.nextLine();
        }catch(NullPointerException DoesNotExist){
            System.out.println("This item does not exist, please try again");
            buyItem();
        }


            if (decision.equalsIgnoreCase("yes")) {
                try {
                    CharacterInventory.addPossessedItems(itemToBuy);
                } catch (NullPointerException itemNotFound) {
                    System.out.println("That item was not found, please try again"); // error handling
                    buyItem();
                }
                if (mGoldCount <= itemToBuy.getValue()) {
                    System.out.printf("Sorry you do not have enough gold your current goldCount is %.2f gold \n",
                            mGoldCount);

                } else {
                    CharacterInventory.setGold(mGoldCount - itemToBuy.getValue());
                    System.out.printf("You bought the %s, this leaves you with %.2f gold \n", itemToBuy.getName(),
                            CharacterInventory.getGold());
                    try {
                        for (Item possedItem : possessedItems) {
                            System.out.printf("You have the following items %s \n", itemToBuy.getName());
                            System.out.println("Do you wish to remain in the shop?");
                            String remainInShop = CharBuilder.sc.nextLine();
                            String remainInShopAcceptable = "yes no";
                            boolean isAcceptableRemainInShop =remainInShop.contains(remainInShopAcceptable);
                            do {
                                if (remainInShop.equalsIgnoreCase("yes")) {
                                    enterShop();
                                }
                                else if (remainInShop.equalsIgnoreCase("no")) {
                                    Chapter1.playChapter1();
                                }
                                else {
                                    System.out.println("please choose yes or no");
                                    enterShop();
                                }

                            } while (!isAcceptableRemainInShop);

                        }
                    } catch (NullPointerException itemNotFound) {

                    }
                }
            } else  {
                System.out.println("I understand, maybe some other time");

            }


    }


    public void sellItem() {

        characterItemList = CharacterInventory.characterItemsAsMap();
        mGoldCount = CharacterInventory.getGold();

        try {
            if (possessedItems.isEmpty()) {
                System.out.println("Sorry you have no items to sell");
                enterShop();
            }
        } catch (NullPointerException noItems) {
            System.out.println("Sorry, you have no items to sell");
            enterShop();
        }
        System.out.println("You have the following items to sell");
        try {
            for (Item possessedItem : possessedItems) {
                    if (Item.mIsEquipped == false)
                    System.out.printf("%s \n", possessedItem.getName());

            }
        } catch (NullPointerException noItems) {

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
                CharacterInventory.setGold(mGoldCount + (item.getValue() * .75));
                System.out.printf("You sold the item %s, your current gold count is %.2f \n", item.getName(),
                        CharacterInventory.getGold());
                possessedItems.remove(item);
            } catch (NullPointerException error) {
                error.printStackTrace();
            }
            }
        else if (decision.equalsIgnoreCase("no")) {
            System.out.println("Very well, some other time");
            enterShop();
        }

        else {
            System.out.println("Sorry, please choose yes or no");
        }
    }
    public void enterShop() {
        possessedItems = CharacterInventory.getPlayersItems();
        storeItems = new HashMap<>();
        mGoldCount = CharacterInventory.getGold();
        String acceptableActions = "purchase shop sell leave exit equip";
        boolean isAcceptableAnswer;
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
                Chapter1.playChapter1();
                break;
            }
            else if (shopAnswer.equalsIgnoreCase("leave") || shopAnswer.equalsIgnoreCase("exit")) {
                System.out.println("You leave the shop");
                Chapter1.playChapter1();
                break;
            }

            else {
                System.out.println("Please choose buy, or sell, or leave to leave the shop");
                enterShop();



            }
        } while (isAcceptableAnswer);
    }



    public static List<Item> getPossessedItems() {
        return possessedItems;
    }


}
