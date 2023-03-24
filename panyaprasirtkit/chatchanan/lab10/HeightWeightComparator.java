/**
 * The HeightWeightComparator class provides a method compare that first compares the height of the two athletes. 
 * If they have the same height, it compares their weights. It returns -1 if the first athlete has a smaller height or weight, 
 * 1 if it is larger, and 0 if they are equal.
 * @author Chatchanan Panyaprasirtkit
 * @version 1.0, 3/17/2023
 */
package panyaprasirtkit.chatchanan.lab10;

import panyaprasirtkit.chatchanan.lab6.AthleteV2;
import java.util.Comparator;

public class HeightWeightComparator implements Comparator<AthleteV2> {
        @Override
        public int compare(AthleteV2 athlete1, AthleteV2 athlete2) {
                if (athlete1.getHeight() < athlete2.getHeight()) {
                        return -1;
                } else if (athlete1.getHeight() == athlete2.getHeight()) {
                        if (athlete1.getWeight() < athlete2.getWeight()) {
                                return -1;
                        } else if (athlete1.getWeight() == athlete2.getWeight()) {
                                return 0;
                        } else {
                                return 1;
                        }
                } else {
                        return 1;
                }
        }

}