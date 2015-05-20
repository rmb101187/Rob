package com.company;

import com.company.characterInventory;

import java.util.*;

/**
 * Created by Robert on 5/12/2015.
 */

public class Shop {

    Scanner sc = CharBuilder.sc;
    private double mGoldCount;
    List<Item> itemList;
    List<Item> possessedItems;
    Map<String, Item> storeItems;
    characterInventory characterInventory = new characterInventory();


    public Shop() {
        mGoldCount = Loot.getGold();
        itemList = new Item("Helmet",10,0,0,0,3,10,0).createItemList();
    }


    public void buyItem()  {

        System.out.println("The shop has the following items for sale at the current price");
        for (Item item : itemList) {
            System.out.printf("%s : %dgp \n", item.getName(), item.getValue());
            storeItems.put(item.getName(), item);
        }
        String buyChoice = sc.nextLine();
        String buyChoiceToLower = buyChoice.toLowerCase();
        Item item = storeItems.get(buyChoiceToLower);

        System.out.printf("so you want to buy the %s for %d \n", item.getName(), item.getValue());
        String decision = sc.nextLine();


            if (decision.equalsIgnoreCase("yes")) {

                possessedItems.add(item);
                mGoldCount -= item.getValue();
                System.out.printf("You bought the %s, this leaves you with %.2f gold \n", item.getName(), mGoldCount);
                for (Item possedItem : possessedItems) {
                    System.out.printf("You have the follow items %s \n", item.getName());
                }
            } else {
                System.out.println("I understand, maybe some other time");
            }


    }


    public void sellItem() {
        System.out.println("You have the follow items to sell");
        System.out.println("Which item would you like to sell?");
        String sellChoice = sc.nextLine();
        String sellChoiceToLower = sellChoice.toLowerCase();
        Item item = storeItems.get(sellChoiceToLower);
        System.out.printf("so you want to sell the %s for %.2f \n", item.getName(), item.getValue() * .75);
        String decision  = sc.nextLine();
        if (decision.equalsIgnoreCase("yes")) {
            possessedItems.add(item);
            mGoldCount += item.getValue();
            System.out.printf("You sold the %s, this leaves you with %.2f gold \n",item.getName(),mGoldCount);

        }
        else {
            System.out.println("I understand, maybe some other time");
        }
    }
    public void enterShop() {
        possessedItems = characterInventory.createPlayersItems();
        storeItems = new HashMap<>();
        mGoldCount = characterInventory.getGold();
        String acceptableActions = "purchase shop sell leave";
        System.out.println("You enter the shop, do you wish to browse items for purchase, " +
                "or sell items you no longer use?");
        String shopAnswer = sc.nextLine();
        boolean isAcceptableAnswer = acceptableActions.contains(shopAnswer);
        do {

            if (shopAnswer.equalsIgnoreCase("buy")) {
                buyItem();

            } else if (shopAnswer.equalsIgnoreCase("sell")) {
                sellItem();
            } else if (shopAnswer.equalsIgnoreCase("leave")) {
                System.out.println("You leave the shop");
                break;
            } else {
                System.out.println("Please choose buy, or sell, or leave to leave the shop");


            }
        } while (isAcceptableAnswer);
    }
}
