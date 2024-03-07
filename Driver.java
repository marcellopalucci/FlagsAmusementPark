package FlagsAmusementPark;

import java.io.FilterOutputStream;

public class Driver {
    public static void main(String[] args) {
        Group RealMadrid = new Group(new String []{"Ronaldo", "Messi", "Modric", "Benzema"});

        System.out.println(RealMadrid.toString());
    }
}
