package com.company;

import java.util.Random;
import java.util.Scanner;



public class CharBuilder {

    static public Scanner sc = new Scanner(System.in);

     private String mCharacterName;
     private int mStrength;
     private int mIntelligence;
     private int mConstitution;
     private int mDexterity;
     private int mHitPoints;
     private int mManaPoints;
     private String mCharClass;





    public CharBuilder(String charClass,int str, int intl, int con, int dex, int hp, int mp) {
        mCharClass = charClass;
        mStrength = str;
        mIntelligence = intl;
        mConstitution = con;
        mDexterity = dex;
        mHitPoints = hp;
        mManaPoints = mp;

    }







    public CharBuilder createHero() {



    String acceptedAnswers = "warrior wizard thief";

        System.out.printf("Greetings adventurer would you say you are more of a warrior, wizard or more of the thievery type \n", mCharacterName);
        String classAnswer = sc.nextLine();
        boolean isAcceptableClass = classAnswer.contains(acceptedAnswers);
        do  {
            if (classAnswer.equalsIgnoreCase("warrior")) {
                mCharClass = "warrior";
                setStr(6 + 3);
                setIntelligence(6 - 1);
                setmConstitution(6 + 4);
                setmDexterity(6 + 1);
                setHitPoints(40 + 20);
                setManaPoints(40 - 10);

            } else if (classAnswer.equalsIgnoreCase("Wizard")) {
                mCharClass = "wizard";
                setStr(6 -1);
                setIntelligence(6 + 3);
                setmConstitution(6 + 2);
                setmDexterity(6);
                setHitPoints(40 - 10);
                setManaPoints(40 + 30);
            } else if (classAnswer.equalsIgnoreCase("thief") || classAnswer.equalsIgnoreCase("thievery")) {
                mCharClass = "thief";
                setStr(6 + 2);
                setIntelligence(6 + 1);
                setmConstitution(6 + 1);
                setmDexterity(6 + 5);
                setHitPoints(40 + 10);
                setManaPoints(mManaPoints + 10);

            } else {
                System.out.println("I'm sorry, that is not an acceptable class, please pick warrior, wizard, or thief");
                createHero();
            }
        }while (isAcceptableClass);
        return this; // return the instance and values that have been created for the character into the combat Class
    }



    public int getStrength() {
        return mStrength;
    }
    public  int getIntelligence() {
        return mIntelligence;
    }
    public int getConsitution() {
        return mConstitution;
    }
    public int getDex() {
        return mDexterity;
    }
    public int getHP() {
        return mHitPoints;
    }
    public int getMP() {
        return mManaPoints;
    }
    public String getCharClass() {
        return mCharClass;
    }





    public void setStr(int str) {
        mStrength = str;

    }
    public void setIntelligence(int intl) {
        mIntelligence = intl;
    }
    public void setmConstitution(int con) {
        mConstitution = con;
    }
    public void setmDexterity(int dex) {
        mDexterity = dex;
    }
    public void setHitPoints( int hitPoints) {
        mHitPoints = hitPoints;
    }
    public void setManaPoints( int manaPoints) {
        mManaPoints = manaPoints;
    }
    public void setmCharClass(String charClass) {
        mCharClass = charClass;
    }







}
