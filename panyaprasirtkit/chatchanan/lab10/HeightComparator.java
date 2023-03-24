/**
 * The HeightComparator class provides a method compare that returns -1 if the height of the first athlete is less than that of the second athlete,
 * 1 if it is greater, and 0 if they are equal.
 * @author Chatchanan Panyaprasirtkit
 * @version 1.0, 3/17/2023
 */
package panyaprasirtkit.chatchanan.lab10;

import java.util.Comparator;
import panyaprasirtkit.chatchanan.lab6.AthleteV2;

public class HeightComparator implements Comparator<AthleteV2> {
    @Override
    public int compare(AthleteV2 athlete1, AthleteV2 athlete2) {
        double height1 = athlete1.getHeight();
        double height2 = athlete2.getHeight();
        return height1 < height2 ? -1 : height1 > height2 ? 1 : 0;
    }
}
