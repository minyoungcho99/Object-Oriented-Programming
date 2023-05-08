import java.util.ArrayList;

public class PoliceStation {
    private String name;
    private ArrayList<Suspect> suspects;
    private ArrayList<Accomplice> accomplices;

    public PoliceStation(String name) {
        if (name == null) {
            this.name = "Station 1331";
        } else {
            this.name = name;
        }
        this.suspects = new ArrayList<Suspect>();
        this.accomplices = new ArrayList<Accomplice>();
    }

    public void addPersonOfInterest(PersonOfInterest poi) {
        if (poi instanceof Suspect) {
            suspects.add((Suspect) poi);
        } else {
            accomplices.add((Accomplice) poi);
        }
    }

    public void sortSuspects() {
        for (int i = 0; i < suspects.size(); i++) {
            int index = i;
            for (int j = i + 1; j < suspects.size(); j++) {
                if (suspects.get(j).compareTo(suspects.get(index)) < 0) {
                    index = j;
                }
            }
            Suspect saved = suspects.get(i);
            Suspect saved2 = suspects.get(index);
            suspects.remove(i);
            suspects.add(i, saved2);
            suspects.remove(index);
            suspects.add(index, saved);
        }
    }

    public ArrayList<Suspect> removeDuplicates() {
        ArrayList<Suspect> duplicates = new ArrayList<Suspect>();
        for (int i = 0; i < suspects.size(); i++) {
            while (i != suspects.lastIndexOf(suspects.get(i))) {
                suspects.remove(suspects.lastIndexOf(suspects.get(i)));
                if (!duplicates.contains(suspects.get(i))) {
                    duplicates.add(suspects.get(i));
                }
            }
        }
        this.sortSuspects();
        return duplicates;
    }

    public Suspect findSuspect(Suspect s) {
        this.sortSuspects();
        this.removeDuplicates();
        int minIndex = 0;
        int midIndex = 0;
        int maxIndex = suspects.size() - 1;
        boolean isFound = false;
        while (minIndex <= maxIndex && !isFound) {
            midIndex = (minIndex + maxIndex) / 2;
            if (suspects.get(midIndex).compareTo(s) == 0) {
                isFound = true;
            } else if (s.compareTo(suspects.get(midIndex)) < 0) {
                maxIndex = midIndex - 1;
            } else {
                minIndex = midIndex + 1;
            }
        }
        if (isFound) {
            return suspects.get(midIndex);
        }
        return null;
    }

    public Accomplice findMastermind(Suspect s) {
        for (int i = 0; i < accomplices.size(); i++) {
            if (accomplices.get(i).getCanCode() && accomplices.get(i).getRubberDuck().equals(s.getRubberDuck())) {
                return accomplices.get(i);
            }
        }
        return null;
    }
 
    public static void main(String[] args) {
        RubberDuck r1 = new RubberDuck(Color.BLUE, true);
        RubberDuck r2 = new RubberDuck(Color.DARKGRAY, false);
        Suspect s1 = new Suspect(Color.GREEN, 30, r1, 180);
        Suspect s2 = new Suspect(Color.BLUE, 60, r1, 180);
        Suspect s3 = new Suspect(Color.GREEN, 30, r2, 160);
        Accomplice a1 = new Accomplice(Color.BLONDE, 30, r1, true);
        Accomplice a2 = new Accomplice(Color.BLONDE, 30, r2, true);
        PoliceStation p1 = new PoliceStation("Minyoung's PS");
        p1.suspects.add(s3);
        p1.suspects.add(s2);
        p1.suspects.add(s2);
        p1.suspects.add(s1);
        p1.suspects.add(s2);
        p1.accomplices.add(a1);
        p1.accomplices.add(a2);
        p1.accomplices.add(a2);
        /**
        System.out.println("Before Add");
        for (int i = 0; i < p1.suspects.size(); i++) {
            System.out.println(p1.suspects.get(i));
        }
        p1.addPersonOfInterest(s1);
        System.out.println("After Add");
        for (int i = 0; i < p1.suspects.size(); i++) {
            System.out.println(p1.suspects.get(i));
        }
        */
        /** System.out.println("Before Sort");
        for (int i = 0; i < p1.suspects.size(); i++) {
            System.out.println(p1.suspects.get(i));
        }
        p1.sortSuspects();
        System.out.println("After Sort");
        for (int i = 0; i < p1.suspects.size(); i++) {
            System.out.println(p1.suspects.get(i));
        }
        System.out.println("Sort Done!");
         */
        
        System.out.println("Before");
        for (int i = 0; i < p1.suspects.size(); i++) {
            System.out.println(p1.suspects.get(i));
        }
        System.out.println("*");
        System.out.println(p1.removeDuplicates());
        System.out.println("*");
        for (int i = 0; i < p1.suspects.size(); i++) {
            System.out.println(p1.suspects.get(i));
        }
        /**
        System.out.println(p1.findMastermind(s3));
        System.out.println(p1.findSuspect(s2));
         */
    }

}
