/**
 * The AthleteFormV12 class has a method addMenus that creates an ArrayList of comparators and JMenuItem array for each sorting option. 
 * It uses IntStream.range to add an ActionListener to each menu item. When a menu item is clicked, 
 * it sorts the athlete data using the corresponding comparator and calls displayMenu to update the GUI.
 * @author Chatchanan Panyaprasirtkit
 * @version 1.0, 3/17/2023
 */
package panyaprasirtkit.chatchanan.lab10;

import java.util.*;
import java.util.stream.IntStream;
import javax.swing.*;
import panyaprasirtkit.chatchanan.lab6.AthleteV2;

public class AthleteFormV12 extends AthleteFormV11 {
    AthleteFormV12(String programName) {
        super(programName);
    }

    public static void createAndShowGUI() {
        AthleteFormV12 myGui = new AthleteFormV12("Athlete Form V12");
        myGui.addComponents();
        myGui.addMenus();
        myGui.initValues();
        myGui.setFrameFeatures();
        myGui.onChange();
        myGui.addListeners();
    }

    // There are several methods in the class such as "addMenus()" which adds the
    // menu items to the menu bar, "searchMenu()"
    // which prompts the user to search for an athlete by name, "clearMenu()" which
    // clears the athlete database, and "displayMenu()" which displays all the
    // athletes in the database.
    // The addMenus() method has been modified to add an ActionListener to each menu
    @Override
    protected void addMenus() {
        super.addMenus();
        ArrayList<Comparator<AthleteV2>> comparators = new ArrayList<>(
                Arrays.asList(new NameComparator(), new HeightComparator(), new HeightWeightComparator()));
        JMenuItem[] menuItems = { byName, byHeight, byHeightAndWeight };
        IntStream.range(0, comparators.size()).forEach(i -> {
            menuItems[i].addActionListener(e -> {
                athleteData.sort(comparators.get(i));
                displayMenu();
            });
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
}
