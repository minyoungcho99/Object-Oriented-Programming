public class Suspect extends PersonOfInterest {
    private int height;
   
    public Suspect(Color hairColor, int proximity, RubberDuck rubberDuck, int height) {
        super(hairColor, proximity, rubberDuck);
        if (height < 150) {
            this.height = 150;
        } else {
            this.height = height;
        }
    }
   
    public Suspect(int proximity, RubberDuck rubberDuck) {
        super(proximity, rubberDuck);
        this.height = 160;
    }
    @Override
    public String toString() {
        return "Possible Suspect: " + super.toString() + String.format(" They were observed to be %d cm tall.", height);
    }
    @Override
    public boolean equals(Object o) {
        return super.equals(o) && this.height == ((Suspect) o).height;
    }
}
