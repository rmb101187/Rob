package com.company;

import java.util.*;

/**
 * Created by Robert on 5/12/2015.
 */
public class Shop {

    Scanner sc = CharBuilder.sc;
    private int goldCount;
    List<Item> itemList;
    Map<String, Integer> storeItems;

    public Shop() {
        goldCount = 0;
        itemList = new Item("Helmet",10,0,0,0,3,10,0).createItemList();
    }
    public void buyItem() {
        storeItems = new HashMap<>();
        System.out.println("The shop has the following items for sale at the current price");
        for (Item item : itemList) {
            System.out.printf("%s : %dgp \n", item.getName(), item.getValue());
        }
        String buyChoice = sc.nextLine();
        storeItems.get(buyChoice);



    }
}
