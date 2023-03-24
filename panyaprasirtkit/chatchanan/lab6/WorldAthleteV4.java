/**
 * This is a Java program that models a Badminton player. The program defines three classes and two interfaces. The first interface, BadmintonPlayable,
 *  defines getters and setters for two properties: racketLength and worldRanking. The second interface, Sprinter, defines getters and setters 
 * for a player's speed. The BadmintonPlayerV3 class extends the BadmintonPlayerV2 class and implements both interfaces. 
 * It contains instance variables for racketLength, worldRanking, and speed. The main method creates two BadmintonPlayerV3 objects 
 * and adds them to an ArrayList of Badminton players. The players' worldRanking and speed are set and their information is printed to the console.
 * @author Chatchanan Panyaprasirtkit
 * @version 1.0, 2/2/2023
 */
package panyaprasirtkit.chatchanan.lab6;

import java.util.*;

import panyaprasirtkit.chatchanan.lab5.Athlete;

interface BadmintonPlayable {
    double getRacketLength();

    int getWorldRanking();

    void setRacketLength(double racketLength);

    void setWorldRanking(int worldRanking);

}

interface Sprinter {
    void setSpeed(double speed);

    double getSpeed();
}

class BadmintonPlayerV3 extends BadmintonPlayerV2 implements BadmintonPlayable, Sprinter {
    protected double racketLength;
    protected int worldRanking;
    protected double speed;

    protected BadmintonPlayerV3(String name, double weight, double height, Gender gender, String nationality,
            String birthdate) {
        super(name, weight, height, gender, nationality, birthdate);
    }

    public String toString() {
        return super.toString() + name + " is a Badminton player whose world ranking is "
                + worldRanking + " and has sprint speed as " + speed;
    }

    @Override
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public double getSpeed() {
        return this.speed;
    }

    @Override
    public double getRacketLength() {
        return this.racketLength;
    }

    @Override
    public int getWorldRanking() {
        return this.worldRanking;
    }

    @Override
    public void setRacketLength(double racketLength) {
        this.racketLength = racketLength;
    }

    @Override
    public void setWorldRanking(int worldRanking) {
        this.worldRanking = worldRanking;
    }

}

public class WorldAthleteV4 {
    public static void main(String[] args) {
        BadmintonPlayerV3 akane = new BadmintonPlayerV3("Akane Yamaguchi", 55, 1.68, Athlete.Gender.FEMALE, "Japan",
                "05/02/1997");
        BadmintonPlayerV3 ratchanok = new BadmintonPlayerV3("Ratchanok Intanon", 55, 1.68, Athlete.Gender.FEMALE,
                "Thai", "05/02/1995");
        akane.setWorldRanking(1);
        ratchanok.setWorldRanking(6);
        akane.setSpeed(4);
        ratchanok.setSpeed(6);
        ArrayList<BadmintonPlayerV3> badmintonPlayers = new ArrayList<BadmintonPlayerV3>();
        badmintonPlayers.add(akane);
        badmintonPlayers.add(ratchanok);
        for (BadmintonPlayerV3 badmintonPlayer : badmintonPlayers) {
            System.out.println(badmintonPlayer);
        }
    }
}
