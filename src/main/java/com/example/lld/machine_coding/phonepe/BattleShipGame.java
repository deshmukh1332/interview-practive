package com.example.lld.machine_coding.phonepe;


import java.util.ArrayList;
import java.util.Arrays;

public class BattleShipGame {
    public Player playerA;
    public Player playerB;
    public Battlefield battlefield;

    public BattleShipGame() {
        playerA = new Player("PlayerA");
        playerB = new Player("PlayerB");
    }

    public void initGame(int size) {
        battlefield = new Battlefield(size);
        playerA.setPlayersYCoordinatesBoundary(Arrays.asList(0, ((size) / 2) - 1));
        playerB.setPlayersYCoordinatesBoundary(Arrays.asList(((size) / 2), size-1));
        System.out.println("Initialized battlefield of size " + size + "x" + size);
    }

    public void addShip(String id, int size, int xA, int yA, int xB, int yB) {
        Ship shipA = new Ship(id, size, xA, yA);
        Ship shipB = new Ship(id, size, xB, yB);
        playerA.addShip(shipA);
        playerB.addShip(shipB);
        battlefield.placeShip(shipA, playerA);
        viewBattlefield();
        battlefield.placeShip(shipB, playerB);
        viewBattlefield();
    }

    public void viewBattlefield() {
        System.out.println("Battlefield Layout:");
        battlefield.display();
    }

    public void startGame() {
        Player currentPlayer = playerA;
        Ship hit = null;
        while (!playerA.isDefeated() && !playerB.isDefeated()) {
            if (currentPlayer == playerA) {
                hit = playerA.fireMissile(playerB, battlefield);
                currentPlayer = (hit == null) ? playerB : playerA;
            } else {
                hit = playerB.fireMissile(playerA, battlefield);
                currentPlayer = (hit == null) ? playerA : playerB;
            }
        }
        System.out.println("hit.coordinate " + hit.coordinate);
        if (hit != null) {
            hit.coordinate.forEach(coord -> battlefield.grid[coord.x][coord.y] = "D");
            System.out.println("Battlefield Layout:");
        }
        if (playerA.isDefeated()) {
            System.out.println("GameOver. PlayerB wins.");
        } else {
            System.out.println("GameOver. PlayerA wins.");
        }
    }
}
