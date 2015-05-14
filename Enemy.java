package com.company;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Robert on 5/1/2015.
 */
public class Enemy {
    private int mEnemyHp;
    private String mEnemyName;
    private int mEnemyStr;
    List<Enemy> enemyList;


    public  Enemy(String name, int hp, int Str) {
        mEnemyName = name;

        mEnemyHp = hp;
        mEnemyStr = Str;
    }
    public Enemy() {

    }

    public List<Enemy> createListA() {
        enemyList = new ArrayList<>();
        Enemy bat = new Enemy("bat", 10, 3);
        enemyList.add(bat);
        Enemy slime = new Enemy("slime", 16, 5);
        enemyList.add(slime);
        Enemy troll = new Enemy("Troll", 20, 8);
        enemyList.add(troll);
        Enemy dragon = new Enemy("Dragon", 55, 16);
        enemyList.add(dragon);

        return enemyList; // pass in values to



    }

    public List<Enemy> createListB() {
        enemyList = new ArrayList<>();
        Enemy beholder = new Enemy("Beholder", 30, 12);
        Enemy largeBat = new Enemy("Large Bat", 27, 9);
        enemyList.add(beholder);
        enemyList.add(largeBat);
        return enemyList;
    }
    public void printEnemyList() {
        for (Enemy enemy : enemyList) {
            System.out.printf("This list contains the enemies %s \n", enemy.getName());
        }
    }
    public  String getName() {
        return mEnemyName;
    }

    public  int getHP() {
        return mEnemyHp;
    }

    public int getStr() {
        return mEnemyStr;
    }








}