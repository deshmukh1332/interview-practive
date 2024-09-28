package com.example.lld.machine_coding.groww;

public class VehicleType {
    private final int fixed;
    private final int variable;
    private final String name;
    private int parkingLotId;

    int getFixed() {
        return fixed;
    }
    VehicleType(int fixed, int variable, String name) {
        this.fixed = fixed;
        this.name = name;
        this.variable = variable;
    }

    public int getVariable() {
        return variable;
    }

    public String getName() {
        return name;
    }
}
