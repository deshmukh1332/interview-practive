package com.example.lld.machine_coding.phonepe;


public class AiAnswer {
    public static void main(String[] args) {
        BattleShipGame game = new BattleShipGame();

        System.out.print("Enter battlefield size (N): ");
        game.initGame(6);

        System.out.print("Enter ship ID, size, xA, yA, xB, yB: ");
        game.addShip("1", 2, 1, 1, 4, 4);

        game.viewBattlefield();
        game.startGame();
    }
}
