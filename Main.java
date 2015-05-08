package com.company;

public class Main {

    public static void main(String[] args) {

        Enemy enemy = new Enemy();
        enemy.createList();
        Combat combat = new Combat();
        combat.combat();
}
}