package com.example.lld.machine_coding.phonepe;

import java.util.Random;

public class RandomCoordinateStrategy implements CoordinateStrategy {
    @Override
    public Coordinate getCoordinate(Battlefield battlefield, Player player) {
        Random random = new Random();
        Coordinate coord = null;
        Coordinate finalCoord = coord;
        do {
            int x = random.nextInt(battlefield.size);
            int y = random.nextInt(battlefield.size);
            coord = new Coordinate(x, y);
        } while (player.enemyMissiles.contains(coord) && player.ships.stream().noneMatch(ship -> ship.coordinate.contains(finalCoord)));
        player.enemyMissiles.add(coord);
        return coord;
    }
}