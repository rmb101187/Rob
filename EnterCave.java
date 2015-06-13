package com.company;

/**
 * Created by Robert on 6/12/2015.
 */
public class EnterCave {

    boolean choice1leftExplored;
    boolean choice1rightExplored;
    Combat combat = new Combat();

    public void enterCave() {
        System.out.println("You enter teh cave, there appears to be just enough to light to see that that there is a " +
                "path that leads to the left, and one to the right which way do you take");
        String firstChoice = CharBuilder.sc.nextLine();

        if (firstChoice.equalsIgnoreCase("left")) {
            if (choice1leftExplored) {
                System.out.println("You have already explored this area, please choose another room");
                enterCave();
            }
            firstRoomleft();

        }
        else if (firstChoice.equalsIgnoreCase("right")) {
            if (choice1rightExplored) {
                System.out.println("You have already explored this room");
                enterCave();
            }
            firstRoomright();
        }

        else {
            System.out.println("Sorry, please choose left or right");
        }
    }

    public void firstRoomleft() {

        System.out.println("Oh no you run into some monters!");
        combat.combat();
        choice1leftExplored = true;

    }

    public void firstRoomright() {
        System.out.println("You found an empty room with a skeleton with a arrow stick in it's check YIKES! \n");
        System.out.println("There also appears to be a key clutched in his hand, you rip it off, but a combat ensues!");
        combat.combat();
        choice1rightExplored = true;

    }



    }


