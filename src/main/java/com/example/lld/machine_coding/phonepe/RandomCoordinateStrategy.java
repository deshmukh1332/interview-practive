package com.example.lld.machine_coding.phonepe;

import java.util.Random;

public class RandomCoordinateStrategy implements CoordinateStrategy {
    @Override
    public Coordinate getCoordinate(Battlefield battlefield, Player player) {
        Random random = new Random();
        Coordinate coord;
        do {
            int x = random.nextInt(battlefield.size);
            int y = random.nextInt(battlefield.size);
            coord = new Coordinate(x, y);
        } while (player.enemyMissiles.contains(coord));
        player.enemyMissiles.add(coord);
        return coord;
    }
}