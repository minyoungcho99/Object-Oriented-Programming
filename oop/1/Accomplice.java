public class Accomplice extends PersonOfInterest {
    private boolean canCode;

    public Accomplice(Color hairColor, int proximity, RubberDuck rubberDuck, boolean canCode) {
        super(hairColor, proximity, rubberDuck);
        this.canCode = canCode;
    }
    @Override
    public String toString() {
        return "Possible Accomplice: " + super.toString() + String.format(" They %s have the "
                + "ability to hack doorbells.", canCode ? "do" : "do not");
    }
    @Override
    public boolean equals(Object o) {
        return super.equals(o) && this.canCode == ((Accomplice) o).canCode;
    }

    public boolean getCanCode() {
        return this.canCode;
    }
}
