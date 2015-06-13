package com.company;

/**
 * Created by Robert on 6/12/2015.
 */
public class EnterCave {

    boolean choice1leftExplored;
    boolean choice1rightExplored;
    boolean choice1center;
    Combat combat = new Combat();

    public void enterCave() {
        System.out.printf("You enter the cave, there appears to be just enough to light to see that that there is a " +
                "path that leads to the left, and one to the right \nthere also appears to be a " +
                "large room down a center path, but this blocked by a large door. which way do you take? \n" +
                "You may also leave the cave and head back to town to shop or equip items");
        String firstChoice = CharBuilder.sc.nextLine();

        if (firstChoice.equalsIgnoreCase("left")) {
            firstRoomleft();

        }
        else if (firstChoice.equalsIgnoreCase("right")) {
            firstRoomright();
        }
        else if (firstChoice.equalsIgnoreCase("center")) {
            firstRoomCenter();
        }
        else if (firstChoice.equalsIgnoreCase("exit") || firstChoice.equalsIgnoreCase("leave")
         || firstChoice.equalsIgnoreCase("town")) {
            Chapter1.playChapter1();
        }

        else {
            System.out.println("Sorry, please choose left, right center or exit");
        }
    }

    public void firstRoomleft() {
        if (choice1leftExplored) {
            System.out.println("You have already explored the left room, please choose another room");
            enterCave();
        }

        System.out.println("Oh no you run into some monters!");
        combat.combat();
        choice1leftExplored = true;
        headtoMainRoom();
        enterCave();

    }

    public void firstRoomright() {
        if (choice1rightExplored) {
            System.out.println("You have already explored the  right room");
            enterCave();
        }
        System.out.println("You found an empty room with a skeleton with a arrow stick in it's check YIKES! \n");
        System.out.println("There also appears to be a key clutched in his hand, you rip it off, but a combat ensues!");
        combat.combat();
        choice1rightExplored = true;
        headtoMainRoom();
        enterCave();

    }

    public void firstRoomCenter() {
        if (choice1center) {
            System.out.println("You have already explored this center room");
            enterCave();
        }
        else if (!choice1rightExplored  || !choice1leftExplored) {
            System.out.println("There is a large door with 2 keyholes, you cannot enter any further");
            enterCave();
        }
        System.out.println("You arrive at the door, and gently enter both keys, the room unlocks and you move forward");
        System.out.println("You are quickly attacked by monsters!");
        combat.combat();
        System.out.println("This room is very large, you stare in wonder at it");
        enterCave();
    }

    public void headtoMainRoom() {
        System.out.println("Having explored this room, you head back to the main cave");
    }



    }


