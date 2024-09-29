package com.example.lld.machine_coding.battleship;

import java.util.Random;

public class RandomCoordinateStrategy implements CoordinateStrategy {
    @Override
    public Coordinate getCoordinate(Battlefield battlefield, Player player) {
        Random random = new Random();
        Coordinate coord = null;
        Coordinate finalCoord = coord;
        int startY = player.getPlayersYCoordinatesBoundary().stream().min(Integer::compareTo).orElse(0);
        int endY = player.getPlayersYCoordinatesBoundary().stream().max(Integer::compareTo).orElse(0);
        do {
            int x = random.nextInt(battlefield.size);
            int y = player.getName().equals("PlayerA") ? random.ints(endY + 1, battlefield.size).findFirst().orElse(0) :
                    random.ints(0, startY).findFirst().orElse(0);
            coord = new Coordinate(x, y);
        } while (player.getEnemyMissiles().contains(coord) && player.getShips().stream().noneMatch(ship -> ship.coordinate.contains(finalCoord)));
        player.getEnemyMissiles().add(coord);
        return coord;
    }
}