package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robert on 5/14/2015.
 */
public class characterInventory {
    public List<Item> mCharacterInventory;
    private Item item;


    public void showCharacterIventory() {
        for (Item item: mCharacterInventory);
        System.out.printf("You have the following item : %s", item.getName());
    }

    public List<Item> createItemList() {
        mCharacterInventory = new ArrayList<Item>();
        return mCharacterInventory;
    }
}
