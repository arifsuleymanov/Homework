package Homework12.enums;

public enum Species {
    DOG(false,4,true),
    DOMESTIC_CAT(false,4,true),
    FISH(false, 0, false),
    ROBO_CAT(false, 4, false),
    UNKNOWN;

    private boolean canFly;
    private int numberOfLegs;
    private boolean hasFur;

    Species() {
    }

    Species(boolean canFly, int numberOfLegs, boolean hasFur) {
        this.canFly = canFly;
        this.numberOfLegs = numberOfLegs;
        this.hasFur = hasFur;
    }

    @Override
    public String toString() {
        return "{" +
                "canFly=" + canFly +
                ", numberOfLegs=" + numberOfLegs +
                ", hasFur=" + hasFur + "}";
    }

}
