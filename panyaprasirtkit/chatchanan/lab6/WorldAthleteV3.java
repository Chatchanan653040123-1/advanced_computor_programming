/**
 * This program is a Java implementation of the World Athlete concept, version 3. The program defines four classes: 
 * AthleteV2, BadmintonPlayerV2, FootballerV2, and BoxerV2. The AthleteV2 class extends the Athlete class from lab5 
 * and adds a practice() method. The three other classes (BadmintonPlayerV2, FootballerV2, and BoxerV2) 
 * also extend AthleteV2 and override the practice() method to provide a custom implementation for each type of athlete.
 * @author Chatchanan Panyaprasirtkit
 * @version 1.0, 2/2/2023
 */
package panyaprasirtkit.chatchanan.lab6;

import java.util.ArrayList;

import panyaprasirtkit.chatchanan.lab5.Athlete;

class BadmintonPlayerV2 extends AthleteV2 {

    protected BadmintonPlayerV2(String name, double weight, double height, Gender gender, String nationality,
            String birthdate) {
        super(name, weight, height, gender, nationality, birthdate);
    }

    void practice() {
        System.out.println(name + " runs for 10 km and plays half court singles");
    }

}

class FootballerV2 extends AthleteV2 {

    protected FootballerV2(String name, double weight, double height, Gender gender, String nationality,
            String birthdate) {
        super(name, weight, height, gender, nationality, birthdate);
    }

    void practice() {
        System.out.println(name + "  runs for 10 km and swings arms");
    }

}

class BoxerV2 extends AthleteV2 {

    protected BoxerV2(String name, double weight, double height, Gender gender, String nationality, String birthdate) {
        super(name, weight, height, gender, nationality, birthdate);
    }

    void practice() {
        System.out.println(name + "  runs for 10 km and catches a football");
    }

}

/*
 * In the WorldAthleteV3 class, an ArrayList of AthleteV2 is created and
 * populated with three athletes (ratchanok, tom, and wisaksil).
 * The list of athletes is then iterated through and the details of each athlete
 * are printed along with their practice routine.
 */
public class WorldAthleteV3 {
    public static void main(String[] args) {
        ArrayList<AthleteV2> athletes = new ArrayList<AthleteV2>();
        BadmintonPlayerV2 ratchanok = new BadmintonPlayerV2("Ratchanok Intanoon", 55, 1.68, Athlete.Gender.FEMALE,
                "Thai",
                "05/02/1995");
        FootballerV2 tom = new FootballerV2("Tom Brady", 102, 1.93, Athlete.Gender.MALE, "American", "03/08/1977");
        BoxerV2 wisaksil = new BoxerV2("Wisaksil Wangek", 51.5, 1.60, Athlete.Gender.MALE, "Thai", "08/12/1986");
        athletes.add(ratchanok);
        athletes.add(tom);
        athletes.add(wisaksil);
        for (AthleteV2 athlete : athletes) {
            System.out.println(athlete);
            athlete.practice();
        }
    }
}