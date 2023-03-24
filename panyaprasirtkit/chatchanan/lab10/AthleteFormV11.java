/**
This code is a Java class called "AthleteFormV11" which extends the "AthleteFormV10" class. It creates a GUI (graphical user interface) 
for an athlete database program with several functionalities such as adding, displaying, sorting, and searching for athletes.
The class contains a menu bar with various menu items such as "Data" (which has sub-menu items such as "Add", "Display", "Clear", and "Search"),
 "Sort" (which has sub-menu items for sorting by name, height, and height and weight), and a few others.
The class also has several instance variables such as "athleteData" (an ArrayList of AthleteV2 objects), 
"valueOfAdd" (an integer that keeps track of the number of athletes added to the database), and 
"athlete" (an AthleteV2 object that is created when a new athlete is added to the database).
@author Chatchanan Panyaprasirtkit
@version 1.0, 3/17/2023
*/
package panyaprasirtkit.chatchanan.lab10;

import panyaprasirtkit.chatchanan.lab9.*;
import panyaprasirtkit.chatchanan.lab5.Athlete.Gender;
import panyaprasirtkit.chatchanan.lab6.*;
import java.util.*;
import java.util.stream.*;
import java.awt.*;
import javax.swing.*;

public class AthleteFormV11 extends AthleteFormV10 {
    protected JMenu data, sort;
    protected JMenuItem byName, byHeight, byHeightAndWeight, add, display, clear, search;
    protected ArrayList<AthleteV2> athleteData = new ArrayList<>();
    protected int valueOfAdd = 0;
    protected AthleteV2 athlete;
    String text, nameOfAthlete;

    AthleteFormV11(String programName) {
        super(programName);
    }

    public static void createAndShowGUI() {
        AthleteFormV11 myGui = new AthleteFormV11("Athlete Form V11");
        myGui.addComponents();
        myGui.addMenus();
        myGui.initValues();
        myGui.setFrameFeatures();
        myGui.onChange();
        myGui.addListeners();
    }

    /*
     * There are several methods in the class such as "addMenus()" which adds the
     * menu items to the menu bar, "searchMenu()" which prompts the user to search
     * for an athlete by name, "clearMenu()" which clears the athlete database, and
     * "displayMenu()" which displays all the athletes in the database.
     */
    @Override
    protected void addMenus() {
        super.addMenus();
        data = new JMenu("Data");
        add = new JMenuItem("Add");
        display = new JMenuItem("Display");
        clear = new JMenuItem("Clear");
        search = new JMenuItem("Search");
        sort = new JMenu("Sort");
        byName = new JMenuItem("By Name");
        byHeight = new JMenuItem("By Height");
        byHeightAndWeight = new JMenuItem("By Height and Weight");
        Arrays.asList(add, display, clear, search).forEach(item -> data.add(item));
        data.add(sort);
        data.setFont(new Font("SanSerif", Font.BOLD, 14));
        Arrays.asList(byName, byHeight, byHeightAndWeight).forEach(item -> sort.add(item));
        menuBar.add(data);
        Arrays.asList(byName, byHeight, byHeightAndWeight, add, display, clear, search, sort).forEach(item -> {
            item.setFont(new Font("SanSerif", Font.BOLD, 14));
            item.setForeground(new Color(6, 57, 112));
        });
        add.addActionListener(e -> addMenuItem());
        display.addActionListener(e -> displayMenu());
        clear.addActionListener(e -> clearMenu());
        search.addActionListener(e -> searchMenu());
    }

    // serachMenu() method
    protected void searchMenu() {
        nameOfAthlete = JOptionPane.showInputDialog(AthleteFormV11.this, "Please enter athlete name:\n");
        if (nameOfAthlete != null && valueOfAdd != 0) {
            String result = athleteData.stream()
                    .filter(athlete -> athlete.getName().equalsIgnoreCase(nameOfAthlete))
                    .map(athlete -> athlete.toString())
                    .collect(Collectors.joining(" ,"));
            JOptionPane.showMessageDialog(AthleteFormV11.this,
                    athlete.getName().equalsIgnoreCase(nameOfAthlete) ? result + " is found"
                            : (("Athlete " + nameOfAthlete + " is NOT found")));
        } else {
            JOptionPane.showMessageDialog(AthleteFormV11.this, ("Athlete " + nameOfAthlete + " is NOT found"));
        }
    }

    // clearMenu() method
    protected void clearMenu() {
        athleteData.clear();
        valueOfAdd = 0;
    }

    // displayMenu() method
    protected void displayMenu() {
        text = (valueOfAdd != 0) ? ("There are " + valueOfAdd + " athletes as follows:\n" +
                IntStream.range(0, athleteData.size())
                        .mapToObj(i -> (i + 1) + ". " + athleteData.get(i) + "\n")
                        .collect(Collectors.joining()))
                : "There is no athlete in the list\n";
        JOptionPane.showMessageDialog(AthleteFormV11.this, text);
    }

    // addMenuItem() method
    protected void addMenuItem() {
        athlete = new AthleteV2(
                nameTextField.getText(),
                Double.parseDouble(weightTextField.getText()),
                Double.parseDouble(heightTextField.getText()),
                male.isSelected() ? Gender.MALE : Gender.FEMALE,
                nationalityComboBox.getSelectedItem().toString(),
                birthDateTextField.getText());
        athleteData.add(athlete);
        valueOfAdd++;
        JOptionPane.showMessageDialog(AthleteFormV11.this, athlete.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
}
