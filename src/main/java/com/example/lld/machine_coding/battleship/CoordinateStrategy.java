package com.example.lld.machine_coding.battleship;

public interface CoordinateStrategy {
    Coordinate getCoordinate(Battlefield battlefield, Player player);
}