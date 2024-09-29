package com.example.lld.machine_coding.battleship;

import java.util.HashSet;
import java.util.Set;

public class Ship {
    public String id;
    public int size;
    public Set<Coordinate> coordinate;
    public boolean destroyed;

    public Ship(String id, int size, int x, int y) {
        this.id = id;
        this.size = size;
        this.coordinate = generateCoordinates(x, y, size);
        this.destroyed = false;
    }

    private Set<Coordinate> generateCoordinates(int x, int y, int size) {
        Set<Coordinate> coords = new HashSet<>();
        int half = size/2;
        int start = size - half;
        for (int i = x - start; i <= x + half; i++) {
            for (int j = y - start; j <= y + half; j++) {
                coords.add(new Coordinate(i, j));
            }
        }
        return coords;
    }

    public boolean isHit(int x, int y) {
        return coordinate.contains(new Coordinate(x, y));
    }

    public void destroy(Set<Coordinate> id) {
        this.destroyed = true;

    }

    public boolean isDestroyed() {
        return destroyed;
    }
}
