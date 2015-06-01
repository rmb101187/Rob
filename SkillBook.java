package com.company;

/**
 * Created by Robert on 5/10/2015.
 */
public class SkillBook {
    private String mSkillList;

    public SkillBook createSkillList(String charClass) {
        String skillBook;

        if (charClass.equalsIgnoreCase("warrior")) {
            skillBook = "Bash Slam ";
            mSkillList = skillBook;
        }
        else if(charClass.equalsIgnoreCase("wizard")) {
            skillBook = "Fireball, Icicle ";
            mSkillList = skillBook;
        }
        else {
            skillBook = "Stab Knife ";
            mSkillList = skillBook;
        }
        return this;
    }
    public String getSkillList() {
        return mSkillList;
    }  // returns a string of each skill available to the class
}
