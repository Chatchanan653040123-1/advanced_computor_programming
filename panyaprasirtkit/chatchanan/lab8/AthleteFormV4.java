/**

The AthleteFormV4 class extends the AthleteFormV3 class and adds additional components
such as JCheckBoxes, JSlider and JLabels for hobbies and years of experience in sports.
It provides a GUI for the user to enter athlete's personal details including nationality, sport and hobbies.
This class contains a main method that creates and shows the GUI on the event dispatch thread.
@author Chatchanan Panyaprasirtkit
@version 1.0, 2/17/2023
*/
package panyaprasirtkit.chatchanan.lab8;

import javax.swing.*;
import panyaprasirtkit.chatchanan.lab7.AthleteFormV3;
import java.awt.*;

public class AthleteFormV4 extends AthleteFormV3 {
    protected JCheckBox readingCheckBox, gardeningCheckBox, watchMvCheckBox, shoppingCheckBox, otherCheckBox;
    protected JSlider yearOfExpSlider;
    protected JLabel hobbieLabel, yearOfExpLabel;
    protected JPanel checkBox, hobbieCheckBox, yearOfExp;

    /**
     * Constructor for the AthleteFormV5 class.
     *
     * @param programName the name of the program
     */
    AthleteFormV4(String programName) {
        super(programName);
    }

    /**
     * Creates an AthleteFormV4 object, adds all components, menus and sets the
     * JFrame features.
     */
    public static void createAndShowGUI() {
        AthleteFormV4 myGui = new AthleteFormV4("Athlete Form V4");
        myGui.addComponents();
        myGui.addMenus();
        myGui.setFrameFeatures();
    }

    /**
     * Adds additional components to the GUI such as JLabels, JCheckBoxes, and
     * JSlider for hobbies
     * and years of experience in sports.
     */
    protected void addComponents() {
        super.addComponents();
        hobbieLabel = new JLabel("Hobbies : ");
        yearOfExpLabel = new JLabel("Year of experience in this sport : ");
        checkBox = new JPanel();
        hobbieCheckBox = new JPanel();
        readingCheckBox = new JCheckBox("Reading");
        gardeningCheckBox = new JCheckBox("Gardening");
        watchMvCheckBox = new JCheckBox("Watching movies", true);
        shoppingCheckBox = new JCheckBox("Shopping");
        otherCheckBox = new JCheckBox("Others");
        yearOfExpSlider = new JSlider(JSlider.HORIZONTAL, 0, 20, 0);
        yearOfExp = new JPanel();

        yearOfExp.setLayout(new BorderLayout());
        hobbieCheckBox.setLayout(new BorderLayout());
        yearOfExpSlider.setMinorTickSpacing(1);
        yearOfExpSlider.setMajorTickSpacing(5);
        yearOfExpSlider.setPaintTicks(true);
        yearOfExpSlider.setPaintLabels(true);

        checkBox.add(readingCheckBox);
        checkBox.add(gardeningCheckBox);
        checkBox.add(watchMvCheckBox);
        checkBox.add(shoppingCheckBox);
        checkBox.add(otherCheckBox);
        yearOfExp.add(yearOfExpLabel, BorderLayout.NORTH);
        yearOfExp.add(yearOfExpSlider, BorderLayout.CENTER);
        hobbieCheckBox.add(hobbieLabel, BorderLayout.NORTH);
        hobbieCheckBox.add(checkBox, BorderLayout.CENTER);
        nationalitySportBio.add(hobbieCheckBox, BorderLayout.NORTH);
        nationalitySportBio.add(yearOfExp, BorderLayout.SOUTH);

    }

    /**
     * Creates and shows the GUI on the event dispatch thread.
     * 
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

}
