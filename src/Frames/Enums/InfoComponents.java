package Frames.Enums;

public enum InfoComponents {
    SPEED ("speed"),
    LIMIT ("limit"),
    DISTANCE ("distance"),
    AMOUNT_OF_FUEL("amount_of_fuel"),
    COST("cost");

    private String representation;

    InfoComponents(String representation) {
        this.representation = representation;
    }

    public String getRepresentation() {
        return this.representation;
    }

    @Override
    public String toString() {
        return this.representation;
    }
}
