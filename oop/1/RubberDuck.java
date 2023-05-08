public class RubberDuck {
    private final Color color;
    private final boolean hasHat;

    public RubberDuck(Color color, boolean hasHat) {
        if (color == null) {
            this.color = Color.YELLOW;
        } else {
            this.color = color;
        }
        this.hasHat = hasHat;
    }

    public RubberDuck() {
        this.color = Color.YELLOW;
        this.hasHat = true;
    }
    @Override
    public String toString() {
        return String.format("a %s rubber duck %s a hat.", this.color.name().toLowerCase(),
                this.hasHat ? "with" : "without");
    }
    @Override
    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        } else {
            return this.color == ((RubberDuck) o).color && this.hasHat == ((RubberDuck) o).hasHat;
        }
    }
}
