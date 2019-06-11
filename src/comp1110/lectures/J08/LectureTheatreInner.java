package comp1110.lectures.J08;

public class LectureTheatreInner {
    public class Projector {
        String brand;

        Projector(String brand) {
            this.brand = brand;
        }

        @Override
        public String toString() {
            return brand + " in room " + name;
        }
        // can refer direcly to the instance field "name"
        //which is  the fields of its enclosing class
    }

    String name;
    Projector projector;

    LectureTheatreInner(String name, String projectorBrand) {
        this.name = name;
        this.projector = new Projector(projectorBrand);
    }

    @Override
    public String toString() {
        return name + " has a projector: " + projector.toString();
    }

}
