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
    Item item;
    String decision;



    public Shop() {
        mGoldCount = 1000; //CharacterInventory.getGold();
        itemList = new Item("Helmet",10,0,0,0,3,10,0).createItemList();
    }


    public void buyItem  () throws NullPointerException  {
        possessedItems = CharacterInventory.createPlayersItems();
        System.out.println("The shop has the following items for sale at the current price");
        for (Item item : itemList) {
            System.out.printf("%s : %dgp \n", item.getName(), item.getValue());
            storeItems.put(item.getName(), item);
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
                    System.out.println("That item was not found, please try again");
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
        if (possessedItems.isEmpty()) {
            System.out.println("Sorry you have no items to sell");
            enterShop();
        }
        System.out.println("You have the following items to sell");
        System.out.println("Which item would you like to sell?");
        String sellChoice = sc.nextLine();
        String sellChoiceToLower = sellChoice.toLowerCase();
        try {
            Item item = storeItems.get(sellChoiceToLower);

        System.out.printf("so you want to sell the %s for %.2f \n", item.getName(), item.getValue() * .75);
        } catch (NullPointerException itemNotFound) {
        System.out.println("Sorry, this item was not found, please try again");
        sellItem();
        }
        decision  = sc.nextLine();

        if (decision.equalsIgnoreCase("yes")) {

            try {
                possessedItems.add(item);
            } catch (NullPointerException itemNotFound) {
                System.out.println("Sorry item not found please try again");
                sellItem();
            }
            mGoldCount += item.getValue();
            System.out.printf("You sold the %s, this leaves you with %.2f gold \n",item.getName(),mGoldCount);

        }
        else {
            System.out.println("I understand, maybe some other time");
        }
    }
    public void enterShop() {
        possessedItems = CharacterInventory.createPlayersItems();
        storeItems = new HashMap<>();
        mGoldCount = 1000; //CharacterInventory.getGold();
        String acceptableActions = "purchase shop sell leave exit";
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
                break;
            }
            else if (shopAnswer.equalsIgnoreCase("leave") || shopAnswer.equalsIgnoreCase("exit")) {
                System.out.println("You leave the shop");
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
