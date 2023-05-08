public abstract class PersonOfInterest implements Comparable<PersonOfInterest> {
    private Color hairColor;
    private int proximity;
    private RubberDuck rubberDuck;

    public PersonOfInterest(Color hairColor, int proximity, RubberDuck rubberDuck) {
        if (hairColor == null) {
            this.hairColor = Color.BLACK;
        } else {
            this.hairColor = hairColor;
        }
        if (proximity < 0) {
            this.proximity = Math.abs(proximity);
        } else {
            this.proximity = proximity;
        }
        if (rubberDuck == null) {
            this.rubberDuck = new RubberDuck(Color.YELLOW, true);
        } else {
            this.rubberDuck = rubberDuck;
        }
    }

    public PersonOfInterest(int proximity, RubberDuck rubberDuck) {
        this(Color.BLONDE, proximity, rubberDuck);
    }
    @Override
    public String toString() {
        return String.format("A POI with %s hair was last seen %d miles away holding ", this.hairColor, this.proximity)
                + this.rubberDuck.toString();
    }
    @Override
    public boolean equals(Object o) {
        if (o != null && o instanceof PersonOfInterest) {
            return hairColor == ((PersonOfInterest) o).hairColor && proximity == ((PersonOfInterest) o).proximity
                    && this.rubberDuck.equals(((PersonOfInterest) o).rubberDuck);

        } else {
            return false;
        }
    }
    @Override
    public int compareTo(PersonOfInterest poi) {
        if (poi == null) {
            return -1;
        } else {
            if (this.proximity < poi.proximity) {
                return -1;
            } else if (this.proximity > poi.proximity) {
                return 1;
            } else {
                if (this.hairColor == poi.hairColor) {
                    return 0;
                } else {
                    return this.hairColor.compareTo(poi.hairColor);
                }
            }
        }
    }

    public RubberDuck getRubberDuck() {
        return this.rubberDuck;
    }
}
