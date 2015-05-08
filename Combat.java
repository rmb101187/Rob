package com.company;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.company.CharBuilder;

public class Combat  {
    Scanner sc = CharBuilder.sc;
    Random randNum = new Random();

    List<Enemy> enemyList = new Enemy().createList();
    Enemy enemy = enemyList.get(randNum.nextInt(enemyList.size()));

    CharBuilder character = new CharBuilder("warrior", 6, 6, 6, 6, 40, 30).createHero();

    int charStrength = character.getStrength();
    int charHp = character.getHP();
    int enemyHp = enemy.getHP();
    int enemyStr = enemy.getStr();
    String enemyName = enemy.getName();





    public void initiateCombat() {



        System.out.printf("A %s appears, it has %d hitpoints, and it's strength is %s \n", enemyName, enemyHp, enemyStr);
    }
    public void playersTurn() {

        System.out.println("It is your turn, your available actions are attack, or use a skill");
        String actionAnswer = sc.nextLine();
        if (actionAnswer.equalsIgnoreCase("attack")) {
            enemyHp -= charStrength;
            System.out.printf("You attack the enemy, doing %s damage, the enemy currently has %s hp left \n", charStrength,
                    enemyHp);

        }


        else {
            System.out.println("Sorry, please choose attack or skill ");
            playersTurn();
        }
    }
    public void enemyTurn() {

        charHp -= enemyStr;
        System.out.printf("It is the enemy's turn, it attacks doing %s damage, your current hp is %s \n", enemyStr, charHp);

    }
    public void combat() {


        do {
            initiateCombat();

            playersTurn();
            if (enemyHp <= 0) {
                System.out.println("You have defeated the enemy, congratulations");
                break;

            }
            enemyTurn();
        } while (enemyHp > 0 && charHp > 0);
    }
}
