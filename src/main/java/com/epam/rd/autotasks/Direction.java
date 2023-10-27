package com.epam.rd.autotasks;

import java.util.Optional;

public enum Direction {
    N(0),
    NE(45),
    E(90),
    SE(135),
    S(180),
    SW(225),
    W(270),
    NW(315);

    Direction(final int degrees) {
        this.degrees = degrees;
    }

    public int getDegrees() {
        return degrees;
    }

    private final int degrees;

    public static Direction ofDegrees(int degrees) {
        for (Direction direction : Direction.values()) {
            if(degrees == direction.degrees || degrees % 360 == direction.degrees || degrees + 360 == direction.degrees)
                return direction;
        }return null;
    }

    public static Direction closestToDegrees(int degrees) {
        degrees = degrees % 360;
        int deg1 = degrees / 45;
        int deg2 = degrees % 45;
        if(deg2 <= 23) return ofDegrees(45*deg1);
        else return ofDegrees(45*(deg1+1));
    }

    public Direction opposite() {
        switch (this){
            case N: return S;
            case NE: return SW;
            case E: return W;
            case SE: return NW;
            case S: return N;
            case SW: return NE;
            case W: return E;
            case NW: return SE;
        }
        return null;
    }

    public int differenceDegreesTo(Direction direction) {
        if(this == N && direction.degrees> 180) {
            return Math.abs(360 - direction.degrees);
        }
        if(direction ==N && this.degrees>180){
            return Math.abs(360 - this.degrees);

        }
        return Math.abs(this.degrees - direction.degrees);
    }
}
