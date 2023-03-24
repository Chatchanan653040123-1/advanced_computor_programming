/** 
 * The NameComparator class provides a method compare that sorts the two athletes by name using Collections.sort and returns -1 if the first athlete comes first,
 * 1 if the second athlete comes first, and 0 if they have the same name.
 * @author Chatchanan Panyaprasirtkit
 * @version 1.0, 3/17/2023
 * */
package panyaprasirtkit.chatchanan.lab10;

import java.util.*;
import panyaprasirtkit.chatchanan.lab6.AthleteV2;

public class NameComparator implements Comparator<AthleteV2> {
    @Override
    public int compare(AthleteV2 athlete1, AthleteV2 athlete2) {
        List<AthleteV2> people = Arrays.asList(athlete1, athlete2);
        Collections.sort(people, (a, b) -> a.getName().compareTo(b.getName()));
        return people.get(0) == athlete1 ? -1 : people.get(0) == athlete2 ? 1 : 0;
    }
}