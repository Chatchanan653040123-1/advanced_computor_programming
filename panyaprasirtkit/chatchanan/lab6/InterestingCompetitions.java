/**
* This is a Java program that defines three classes: InterestingCompetitions, Competition, and AFFChampionship.
* The InterestingCompetitions class is the main class of the program, which creates two instances of the AFFChampionship class,
* one with the name "AFF 2020" and the other with the name "AFF 2022". The program prints out the descriptions of these two instances 
* and sets the places and sponsorships of each championship.The Competition class is the parent class that provides basic properties of a competition, 
* such as the name and region. It also defines a method setSponsorship that takes a list of sponsors as an argument and prints out the sponsors of the competition.
* The AFFChampionship class is a subclass of the Competition class, which represents an Asian Football Federation Championship. 
* It adds the properties of two participating teams and the stadiums where the matches will be played. The class overrides the setSponsorship method 
* of the parent class and adds a toString method to describe the championship in a human-readable format. 
* @author Chatchanan Panyaprasirtkit
* @version 1.0, 2/2/2023
*/
package panyaprasirtkit.chatchanan.lab6;

import java.util.ArrayList;

/*
 * The InterestingCompetitions class is the main class of the program, which creates two instances of the AFFChampionship class, 
 * one with the name "AFF 2020" and the other with the name "AFF 2022". 
 * The program prints out the descriptions of these two instances and sets the places and sponsorships of each championship. 
 */
public class InterestingCompetitions {
	public static void main(String[] args) {
		AFFChampionship aff2022 = new AFFChampionship("AFF 2022", "Thailand", "Vietnam");
		AFFChampionship aff2020 = new AFFChampionship("AFF 2020", "Thailand", "Indonesia");
		System.out.println(aff2020);
		System.out.println(aff2022);

		ArrayList<String> places = new ArrayList<String>();

		places.add("Hanoi");
		places.add("Bangkok");
		aff2022.setPlaces(places);
		ArrayList<String> sponsors = new ArrayList<String>();
		sponsors.add("Mitsubishi Electronics");
		aff2022.setSponsorship(sponsors);

		places.remove("Hanoi");
		places.add("Kallang");
		aff2020.setPlaces(places);
		sponsors.remove("Mitsubishi Electronics");
		sponsors.add("Suzuki");
		sponsors.add("Yanmar");
		aff2020.setSponsorship(sponsors);
	}
}

/*
 * The Competition class is the parent class that provides basic properties of a
 * competition, such as the name and region.
 * It also defines a method setSponsorship that takes a list of sponsors as an
 * argument and prints out the sponsors of the competition.
 */
class Competition {
	protected String name;
	protected String region;

	public void setDescription() {

	}

	public void setSponsorship(ArrayList<String> sponsor) {
		if (sponsor.size() > 1) {
			System.out.println("Sponsors of " + name + " are " + sponsor);
		} else {

			System.out.println(sponsor.get(0) + " is a sponsor of " + name + "");
		}
	}
}

/*
 * The AFFChampionship class is a subclass of the Competition class, which
 * represents an Asian Football Federation Championship.
 * It adds the properties of two participating teams and the stadiums where the
 * matches will be played.
 * The class overrides the setSponsorship method of the parent class and adds a
 * toString method to describe the championship in a human-readable format.
 */
class AFFChampionship extends Competition {
	String teamA;
	String teamB;

	AFFChampionship(String name, String teamA, String teamB) {
		this.teamA = teamA;
		this.teamB = teamB;
		super.name = name;
	}

	void setPlaces(ArrayList<String> places) {
		System.out.println(name + " plays at these stadiums");
		System.out.println(places);
	}

	public void setSponsorship(ArrayList<String> sponsor) {
		super.setSponsorship(sponsor);
	}

	public String toString() {
		return (name + " in the final round was the game between " + teamA + " vs. " + teamB + ".");
	}
}