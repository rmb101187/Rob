package com.company;

/**
 * Created by Robert on 6/6/2015.
 */
public class Chapter1 {
    static Shop shop = new Shop();
    static EquippableItems statEnhancer = new EquippableItems();


    public static void playChapter1() {
        System.out.println("Welcome, adventurer, you enter the town, there is your home  where you may equip your items, " +
                " a shop where you may sell and buy gear, and a cave to to begin your adventure, where would you like " +
                "to go?");
        String decision1 = CharBuilder.sc.nextLine();
        String acceptableDecision1 = "shop cave";
        boolean decision1Accpetable = decision1.contains(acceptableDecision1);

        while (!decision1Accpetable) {
            if (decision1.equalsIgnoreCase("shop") || decision1.equalsIgnoreCase("purchase")) {

                shop.enterShop();
            }

            else if (decision1.equalsIgnoreCase("cave") || decision1.equalsIgnoreCase("adventure")) {
                //enterCave();
            }
            else if (decision1.equalsIgnoreCase("equip") || decision1.equalsIgnoreCase("home")) {
                statEnhancer.setStats();

            }
            else {
                System.out.println("Sorry, please choose to either explore the cave, enter the shop, or equip items at " +
                        "your home");
            }


        }
    }
}
