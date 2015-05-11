package com.company;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Combat  {
    Scanner sc = CharBuilder.sc;
    static Random randNum = new Random();

    List<Enemy> enemyList = new Enemy().createList();
    Enemy enemy = enemyList.get(randNum.nextInt(enemyList.size()));

    CharBuilder character = new CharBuilder("warrior", 6, 6, 6, 6, 40, 30).createHero();
    SkillBook skillBook = new SkillBook().createSkillList(character.getCharClass());
    private int mCharStrength = character.getStrength();
    private  int mCharHitpoints = character.getHP();
    private  int mEnemyHitpoints = enemy.getHP();
    private  int mEnemyStr = enemy.getStr();
    private int mCharManaPoints = character.getMP();
    String mEnemyName = enemy.getName();
    private String mSkillList = skillBook.getSkillList();
    private int mManaCost;








    public void initiateCombat() {



        System.out.printf("A %s appears, it has %d hitpoints, and it's strength is %s \n",
                mEnemyName, mEnemyHitpoints, mEnemyStr);
    }
    public void playersTurn() {

        System.out.println("It is your turn, your available actions are attack, or use a skill");
        String actionAnswer = sc.nextLine();
        if (actionAnswer.equalsIgnoreCase("attack")) {
            charAttack();


        }
        else if (actionAnswer.equalsIgnoreCase("skill")) {
            pickSkill();
        }


        else {
            System.out.println("Sorry, please choose attack or skill ");
            playersTurn();
        }
    }
    public void enemyTurn() {

        enemyAttack();


    }
    public void combat() {

        initiateCombat();
        do {


            playersTurn();
            if (enemyIsDead()) {
                System.out.println("You have defeated the enemy, congratulations");

                break;


            }
            enemyTurn();
            if (characterIsDead()) {
                System.out.println("You have fallen...");
                System.exit(0);

            }
        } while (!enemyIsDead() && !characterIsDead());

    }

    private int enemyAttack() {

        mCharHitpoints -= mEnemyStr;
        System.out.printf("It is the enemy's turn, it attacks doing %s damage, your current hp is %s and your current" +
                        "mp is %d \n",
                mEnemyStr, mCharHitpoints, mCharManaPoints);
        return mEnemyStr;
    }

    public int charAttack() {

        mEnemyHitpoints -= mCharStrength;
        System.out.printf("You attack the enemy, doing %s damage, the enemy currently has %s hp left \n", mCharStrength,
                mEnemyHitpoints);
        return mCharStrength;


    }

    public void pickSkill() {
        System.out.printf("Your current skill list is: %s \n", mSkillList);
        System.out.println("Which would you like to use");
        String skillAnswer = sc.nextLine();
        boolean isKnownSkill = mSkillList.contains(skillAnswer);
        int skillDamage;
        while (isKnownSkill) {
            if (skillAnswer.toLowerCase().equals("bash")) {
                mManaCost = 10;
                if (isManaInSufficent()) {
                    System.out.println("You do not have enough mana for this skill, please choose another");
                    pickSkill();
                }
                depleteMana();

                skillDamage = mCharStrength + 3;
                mEnemyHitpoints -= skillDamage;
                System.out.printf("You use your bash skill, hitting the enemy and doing %d damage \n", skillDamage);
                break;
            } else if (skillAnswer.equalsIgnoreCase("slam")) {
                mManaCost = 5;
                if (isManaInSufficent()) {
                    System.out.println("You do not have enough mana for this skill, please choose another");
                    pickSkill();
                }
                depleteMana();
                skillDamage = mCharStrength + 2;
                mEnemyHitpoints -= skillDamage;
                System.out.printf("You use your slam skill, hitting the enemy and doing %d damage \n", skillDamage);
                break;
            }

        }
    }



    public boolean enemyIsDead() {
        if (mEnemyHitpoints <= 0) {
            return true;
        }
        return false;
    }

    public boolean characterIsDead() {
        if (mCharHitpoints <= 0) {
            return true;
        }
        return false;
    }

    public Enemy slainEnemy() {
        return this.enemy;
    }



    public boolean isManaInSufficent() {
        if (mManaCost > mCharManaPoints ) {
            return true;
        }
        return false;
    }

    public int depleteMana() {
        mCharManaPoints -= mManaCost;
        return mManaCost;
    }







}
