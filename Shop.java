package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robert on 5/12/2015.
 */
public class Shop {


    private int goldCount;
    List<Item> itemList;

    public Shop() {
        goldCount = 0;
        itemList = new Item("Helmet",10,0,0,0,3,10,0).createItemList();
    }
    public void buyItem() {
        System.out.println("The shop has the following items for sale at the current price");
        for (Item item : itemList) {
            System.out.printf("%s : %dgp \n", item.getName(), item.getValue());
        }
    }
}
