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
    private String mDifficultRanking;
    List<Enemy> enemyList;


    public  Enemy(String name,String difficultyRanking, int hp, int Str) {
        mEnemyName = name;
        mDifficultRanking = difficultyRanking;
        mEnemyHp = hp;
        mEnemyStr = Str;
    }
    public Enemy() {

    }

    public List<Enemy> createListA() {
        enemyList = new ArrayList<>();
        Enemy bat = new Enemy("bat", "easy", 10, 3);
        enemyList.add(bat);
        Enemy slime = new Enemy("slime", "easy", 16, 5);
        enemyList.add(slime);
        Enemy troll = new Enemy("Troll", "easy", 20, 8);
        enemyList.add(troll);
        Enemy beholder = new Enemy("Beholder","hard", 30, 12);
        Enemy largeBat = new Enemy("Large Bat","hard", 27, 9);
        Enemy dragon = new Enemy("Dragon", "hard", 55, 16);
        enemyList.add(dragon);
        enemyList.add(beholder);
        enemyList.add(largeBat);



        return enemyList; // pass in values to



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
    public String getDifficulty() {
        return mDifficultRanking;
    }








}