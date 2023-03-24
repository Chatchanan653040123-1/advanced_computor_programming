/**
 * 
 * This Athlete class that satisfies these requirements.
 * 1.The class has protected instance variables to record the following information: name, weight, height, gender, nationality, birthdate. 
 * Please think about the appropriate data types and name for each variable. 
 * 2.Instances of class Athlete will be created in a program called WorldAthlete. 
 * 3.Create an enum called Gender that contains two values: MALE and FEMALE to be used as a value of the variable gender.
 * 4.Use the java class LocalDate for your birthdate variable. Figure 4 shows an example of how to accept and parse String to LocalDate.
 * 5.The class has a public constructor which accepts values for the fields name, height, gender, nationality, birthdate described in a. as parameters.
 * 6.Create public setter and getter methods for each instance attribute of an athlete.
 * 7.Override a method called java.lang.Object.toString() to display the information of an athlete.
 * 8.Create a method called compareAge() that accepts another athlete then compares the age of an instance athlete to that of the other athlete input as a parameter.
 * The method should compare birthdate then output as shown at lines
 * @author Chatchanan Panyaprasirtkit
 * @version 1.0, 19/1/2023
 */
package panyaprasirtkit.chatchanan.lab5;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;
import java.io.Serializable;
import java.lang.Math;

public class Athlete implements Serializable {
    public enum Gender {
        MALE,
        FEMALE
    }

    protected String name, nationality;
    protected double weight, height;
    protected Gender gender;
    protected String dobString;
    // protected DateTimeFormatter formatter;
    protected LocalDate birthdate, dob;

    // Class contructure
    protected Athlete(String name, double weight, double height, Gender gender, String nationality, String dobString) {
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.gender = gender;
        this.nationality = nationality;
        this.dobString = dobString;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.dob = LocalDate.parse(dobString, formatter);
    }

    // toString Method
    public String toString() {
        return String.format("Athlete [ %s, %.1fkg, %.1fm, %s, %s, %s]", name, weight, height, gender, nationality,
                dob);
    }

    // get methods
    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public Gender getGender() {
        return gender;
    }

    // set methods
    public void setName(String name) {
        this.name = name;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    // public void setBirthdate(String birthdate) {
    // this.birthdate = LocalDate.parse(birthdate, formatter);
    // }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    // compareAge method is to compare between 2 peoples age.
    void compareAge(Athlete ageOfWhomCompare) {
        LocalDate dateBefore = ageOfWhomCompare.getBirthdate();
        LocalDate dateAfter = birthdate;
        long year = ChronoUnit.YEARS.between(dateBefore, dateAfter);
        if (year < 0) {
            System.out.printf("%s is %d years older than %s\n", ageOfWhomCompare.getName(), year, name);
        } else if (year > 0) {
            System.out.printf("%s is %d years younger than %s\n", ageOfWhomCompare.getName(), Math.abs(year), name);
        } else {
            System.out.printf("%s has the same ags as %s\n", ageOfWhomCompare.getName(), name);
        }
    }

}