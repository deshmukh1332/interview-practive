package com.example.lld.machine_coding.phonepe;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Player {

    public String name;
    public ArrayList<Ship> ships;
    public Set<Coordinate> enemyMissiles;

    public Player(String name) {
        this.name = name;
        this.ships = new ArrayList<>();
        this.enemyMissiles = new HashSet<>();
    }

    public void addShip(Ship ship) {
        ships.add(ship);
    }

    public boolean isDefeated() {
        for (Ship ship : ships) {
            if (!ship.isDestroyed()) {
                return false;
            }
        }
        return true;
    }

    public Ship fireMissile(Player enemy, Battlefield battlefield) {
        Coordinate target = battlefield.randomUnhitCoordinate(this);
        Ship hitShip = battlefield.checkHit(enemy, target.x, target.y);
        if (hitShip != null) {
            System.out.println(name + "'s turn: Missile fired at " + target + ". Hit! " + hitShip.id + " destroyed.");
            hitShip.destroy();
        } else {
            System.out.println(name + "'s turn: Missile fired at " + target + ". Miss.");
        }
        System.out.println("Ships remaining for " + enemy.name + ": " + (int) enemy.ships.stream().filter(ship -> !ship.isDestroyed()).count() +
                           "," + this.name + ": " + (int) this.ships.stream().filter(ship -> !ship.isDestroyed()).count());
        return hitShip;
    }
}
