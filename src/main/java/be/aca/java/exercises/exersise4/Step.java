package be.aca.java.exercises.exersise4;

public class Step {
    private final Rotation rotation;
    private final int amount;

    public Step(Rotation rotation, int amount) {
        this.rotation = rotation;
        this.amount = amount;
    }

    public Rotation getRotation() {
        return rotation;
    }

    public int getAmount() {
        return amount;
    }
}