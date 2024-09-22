package com.example.lld.machine_coding.phonepe;

import java.util.Random;

public class Battlefield {
    public int size;
    public String[][] grid;

    private CoordinateStrategy coordinateStrategy;

    public Battlefield(int size) {
        this.size = size+1;
        grid = new String[size + 1][size + 1];
        initializeGrid();
        this.coordinateStrategy = new RandomCoordinateStrategy(); // Default strategy
    }

    public void setCoordinateStrategy(CoordinateStrategy coordinateStrategy) {
        this.coordinateStrategy = coordinateStrategy;
    }

    public Coordinate randomUnhitCoordinate(Player player) {
        return coordinateStrategy.getCoordinate(this, player);
    }

    private void initializeGrid() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = ".";
            }
        }
    }

    public void placeShip(Ship ship, Player player) {
        for (Coordinate coord : ship.coordinate) {
            System.out.println("Placing ship " + ship.id + " at " + coord);
            if (player.name.equals("PlayerA")) {
                grid[coord.x][coord.y] = "A-" + ship.id;
            } else {
                grid[coord.x][coord.y] = "B-" + ship.id;
            }
        }
    }

    public Ship checkHit(Player player, int x, int y) {
        return player.ships.stream().filter(ship -> ship.isHit(x, y)).findFirst().orElse(null);
    }

    public void display() {
        for (int i = size - 1; i >= 0; i--) {
            for (int j = size - 1; j >= 0; j--) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}