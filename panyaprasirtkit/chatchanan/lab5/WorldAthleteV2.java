/**
 * This WorldAthleteV2 program is to do these requirements.
 * 3.1 BadmintonPlayer
 * Write a Java class called BadmintonPlayer that satisfies the following.
 * Class BadmintonPlayer is a subclass of Athlete (class BadmintonPlayer extends Athlete)
 * Add private instance variables 
 * static String variable called sport that is set to "Badminton".
 * private double variable called racketLength.
 * private int variable called worldRanking.
 * Create the constructor that accepts name, weight, height, gender, nationality, birthdate,  racketLength and worldRanking. 
 * Override method toString() such that it gives the output of the program.
 * 
 * 3.2 Boxer
 *  		Write a Java class called Boxer that satisfies the following.
 * Class Boxer is a subclass of Athlete.
 * Add private instance variables
 * static String variable called sport that is set to "Boxing".
 * private String variable called division.
 * private String variable called golveSize. (size can be a letter Y, S, M, L and XL).
 * Create a constructor that accepts name, weight, height, gender, nationality, birthdate,  division and golveSize. 
 * Override method toString() such that it gives the output of the program.
 * 
 * 3.3 Footballer
 * 	Write a Java class called Footballer that satisfies the following.
 * Class Footballer is a subclass of Athlete.
 * Add private instance variables
 * static String variable called sport that is set to "American Football".
 * private String variable called position.
 * private String variable called team.
 * Create the constructor that accepts name, weight, height, gender, nationality, birthdate,  position and team. 
 * Override method toString() such that it gives the output of the program.
 * WorldAthleteV2
 * Write a Java class called WorldAthleteV2 that has the main method.
 * 
 * Implement a method called isTaller() in WorldAthleteV2. 
 * 
 * 	For the method isTaller(athleteA, athleteB), if athleteA is taller than athleteB, the output is "athleteA is taller than athleteB"    
 *     If athleteA is not taller than athleteA, the output is "athleteA is not taller than athleteB"  
 * @author Chatchanan Panyaprasirtkit
 * @version 1.0, 19/1/2023
 */
package panyaprasirtkit.chatchanan.lab5;

// extend Athlete to BadmintonPlayer subclass
class BadmintonPlayer extends Athlete {
    static String sport = "Badminton";
    private double racketLength;
    private int worldRanking;

    static String getSport() {
        return sport;
    }

    // BadmintonPlayer contructer
    BadmintonPlayer(String name, double weight, double height, Gender gender, String nationality,
            String birthdate, double racketLength, int worldRanking) {
        super(name, weight, height, gender, nationality, birthdate);
        this.racketLength = racketLength;
        this.worldRanking = worldRanking;

    }

    // overwrite toString Method
    public String toString() {
        return String.format("%s, %.1fkg, %.2fm, %s, %s, %s, %s, %.1fcm, rank:%s", name, weight, height, gender,
                nationality,
                birthdate, sport, racketLength, worldRanking);
    }
}

// extend Athlete to Boxer subclass
class Boxer extends Athlete {
    static String sport = "Boxing";
    private String division;
    private String golveSize;

    // Boxer contructer
    Boxer(String name, double weight, double height, Gender gender, String nationality,
            String birthdate, String division, String golveSize) {
        super(name, weight, height, gender, nationality, birthdate);
        this.division = division;
        this.golveSize = golveSize;
    }

    // overwrite toString Method
    public String toString() {
        return String.format("%s, %.1fkg, %.2fm, %s, %s, %s, %s, %s, %s", name, weight, height, gender,
                nationality,
                birthdate, sport, division, golveSize);
    }
}

// extend Athlete to Footballer subclass
class Footballer extends Athlete {
    static String sport = "American Football";
    private String position;
    private String team;

    // Footballer contructer
    Footballer(String name, double weight, double height, Gender gender, String nationality,
            String birthdate, String position, String team) {
        super(name, weight, height, gender, nationality, birthdate);
        this.position = position;
        this.team = team;
    }

    // overwrite toString Method
    public String toString() {
        return String.format("%s, %.1fkg, %.2fm, %s, %s, %s, %s, %s, %s", name, weight, height, gender,
                nationality,
                birthdate, sport, position, team);
    }
}/*
  * This WorldAthlete2 program is to contains main method and creates instances
  * of BadmintonPlayer ,Footballer and Boxer class.
  */

public class WorldAthleteV2 {
    public static void main(String[] args) {
        BadmintonPlayer ratchanok = new BadmintonPlayer("Ratchanok Intanon", 55, 1.68, Athlete.Gender.FEMALE, "Thai",
                "05/02/1995", 66.5, 4);
        Footballer tom = new Footballer("Tom Brady", 102, 1.93, Athlete.Gender.MALE, "American", "03/08/1977",
                "Quarterback",
                "New England Patriots");
        Boxer wisaksil = new Boxer("Wisaksil Wangek", 51.5, 1.60, Athlete.Gender.MALE, "Thai", "08/12/1986",
                "Super Flyweight",
                "M");
        System.out.println(ratchanok);
        System.out.println(tom);
        System.out.println(wisaksil);
        BadmintonPlayer nitchaon = new BadmintonPlayer("Nitchaon Jindapol", 52, 1.63, Athlete.Gender.FEMALE, "Thailand",
                "31/03/1991", 67, 11);
        System.out.println(
                "Both " + ratchanok.getName() + " and " + nitchaon.getName() + " play " + BadmintonPlayer.getSport());
        ratchanok.compareAge(tom);
        ratchanok.compareAge(nitchaon);
        if (isTaller(wisaksil, tom)) {
            System.out.println(wisaksil.getName() + " is taller than " + tom.getName());
        } else {
            System.out.println(wisaksil.getName() + " is not taller than " + tom.getName());
        }
    }

    // isTaller Method is to check is person 1 taller than person2 or not? then
    // return it to Boolean
    static boolean isTaller(Boxer nameOfPersonOne, Footballer nameOfPersonTwo) {
        if (nameOfPersonOne.getHeight() > nameOfPersonTwo.getHeight()) {
            return true;
        } else {
            return false;
        }
    }
}
