package panyaprasirtkit.chatchanan.lab6;

import panyaprasirtkit.chatchanan.lab5.Athlete;

public class AthleteV2 extends Athlete {
    public AthleteV2(String name, double weight, double height, Gender gender, String nationality,
            String birthdate) {
        super(name, weight, height, gender, nationality, birthdate);
    }

    void practice() {
        System.out.println(name + " runs for 10 km");
    }
}