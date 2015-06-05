package com.company;

/**
 * Created by Robert on 6/4/2015.
 */
public class EquipItem {

    private int mHeadStr;
    private int mHeadHp;
    private int mHeadMP;
    private int mWeaponStr;
    private int mWeaponHp;
    private int mWeaponMP;
    private int mTorsoStr;
    private int mTorsoHp;
    private int mTorsoMP;
    private int mFeetStr;
    private int mFeetHP;
    private int mFeetMP;
    private boolean headEquipped;
    private boolean weaponEquipped;
    private boolean torsoEquipped;
    private boolean feetEquipped;
    private Item item;

    public void adjustStats(String itemCatagory) {
        if (itemCatagory.equalsIgnoreCase("head")) {
            mHeadStr = item.getStr();
            mHeadHp = item.getHp();
            mHeadMP = item.getMP();

        }
        else if (itemCatagory.equalsIgnoreCase("weapon")) {
            mWeaponStr = item.getStr();
            mWeaponHp = item.getHp();
            mWeaponHp = item.getMP();
        }
        else if (itemCatagory.equalsIgnoreCase("torso")) {
            mTorsoStr = item.getStr();
            mTorsoHp = item.getHp();
            mTorsoMP = item.getMP();
        }
        else if (itemCatagory.equalsIgnoreCase("feet")) {
            mFeetStr = item.getStr();
            mFeetHP = item.getHp();
            mFeetMP = item.getMP();
        }
    }

    public void alreadyEquipped() {
        System.out.println("You already have an item equipped, and are not able to equip another in this slot");
    }
}


