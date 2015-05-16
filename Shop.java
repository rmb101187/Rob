package com.company;

import com.company.characterInventory;

import java.util.*;

/**
 * Created by Robert on 5/12/2015.
 */

public class Shop {

    Scanner sc = CharBuilder.sc;
    private int mGoldCount;
    List<Item> itemList;
    List<Item> possessedItems;
    Map<String, Item> storeItems;
    characterInventory characterInventory = new characterInventory();

    public Shop() {
        mGoldCount = characterInventory.getGold();
        itemList = new Item("Helmet",10,0,0,0,3,10,0).createItemList();
    }
    public void buyItem() {
        possessedItems = characterInventory.createPlayersItems();
        storeItems = new HashMap<>();
        mGoldCount = characterInventory.getGold();
        System.out.println("The shop has the following items for sale at the current price");
        for (Item item : itemList) {
            System.out.printf("%s : %dgp \n", item.getName(), item.getValue());
            storeItems.put(item.getName(), item);
        }
        String buyChoice = sc.nextLine();
        String buyChoiceToLower = buyChoice.toLowerCase();
        Item item = storeItems.get(buyChoiceToLower);
        System.out.printf("so you want to buy the %s for %d \n", item.getName(), item.getValue());
        String decision  = sc.nextLine();
        if (decision.equalsIgnoreCase("yes")) {
            possessedItems.add(item);
            mGoldCount -= item.getValue();
            System.out.printf("You bought the %s, this leaves you with %d gold \n",item.getName(),mGoldCount);
            for (Item possedItem : possessedItems) {
                System.out.printf("You have the follow items %s \n", item.getName());
            }
        }
        else {
            System.out.println("I understand, maybe some other time");
        }

    }
}
