/**

A class that extends AthleteFormV4 and adds additional components and menus to the GUI.
@author Chatchanan Panyaprasirtkit
@version 1.0, 2/17/2023
*/
package panyaprasirtkit.chatchanan.lab8;

import javax.swing.*;
import java.awt.*;

class AthleteFormV5 extends AthleteFormV4 {
    // Instance variables for fonts and colors
    protected Font labelFont, buttonFont, menuFont;
    protected Color setBackgroundColorOfTextField, textColorOfMenu;

    /**
     * Constructor for the AthleteFormV5 class.
     *
     * @param programName the name of the program
     */
    AthleteFormV5(String programName) {
        super(programName);
    }

    /**
     * A method to create and show the GUI.
     */
    public static void createAndShowGUI() {
        AthleteFormV5 myGui = new AthleteFormV5("Athlete Form V5");
        myGui.addComponents();
        myGui.addMenus();
        myGui.setFrameFeatures();
    }

    /**
     * A method to add the additional components to the GUI.
     */
    protected void addComponents() {
        super.addComponents();
        // Set background color of text fields
        setBackgroundColorOfTextField = new Color(167, 59, 36);
        nameTextField.setBackground(setBackgroundColorOfTextField);
        weightTextField.setBackground(setBackgroundColorOfTextField);
        heightTextField.setBackground(setBackgroundColorOfTextField);
        birthDateTextField.setBackground(setBackgroundColorOfTextField);
        // Set font for labels
        labelFont = new Font("Serif", Font.BOLD, 14);
        name.setFont(labelFont);
        weight.setFont(labelFont);
        height.setFont(labelFont);
        birthDate.setFont(labelFont);
        gender.setFont(labelFont);
        nationality.setFont(labelFont);
        sport.setFont(labelFont);
        bio.setFont(labelFont);
        hobbieLabel.setFont(labelFont);
        yearOfExpLabel.setFont(labelFont);
        // Set foreground color for sport list
        sportList.setForeground(new Color(35, 45, 222));
        // Set font for buttons
        buttonFont = new Font("Serif", Font.BOLD + Font.ITALIC, 16);
        cancelButton.setFont(buttonFont);
        resetButton.setFont(buttonFont);
        submitButton.setFont(buttonFont);
        // Set background color for bio text area
        bioTextArea.setBackground(new Color(200, 200, 200));
        // Set tooltips for buttons
        cancelButton.setToolTipText("Press the cancel button to cancel this form");
        resetButton.setToolTipText("Press the reset button to reset this form");
        submitButton.setToolTipText("Press the submit button to submit this form");
    }

    /**
     * A method to add the additional menus to the GUI.
     */
    protected void addMenus() {
        super.addMenus();
        // Set font for menus
        menuFont = new Font("SanSerif", Font.BOLD, 14);
        newItem.setFont(menuFont);
        openItem.setFont(menuFont);
        saveItem.setFont(menuFont);
        exitItem.setFont(menuFont);
        red.setFont(menuFont);
        green.setFont(menuFont);
        blue.setFont(menuFont);
        sixteen.setFont(menuFont);
        twenty.setFont(menuFont);
        twenty_four.setFont(menuFont);
        file.setFont(menuFont);
        config.setFont(menuFont);
        color.setFont(menuFont);
        size.setFont(menuFont);

        // Set foreground color for menus
        textColorOfMenu = new Color(6, 57, 112);
        newItem.setForeground(textColorOfMenu);
        openItem.setForeground(textColorOfMenu);
        saveItem.setForeground(textColorOfMenu);
        exitItem.setForeground(textColorOfMenu);
        red.setForeground(textColorOfMenu);
        green.setForeground(textColorOfMenu);
        blue.setForeground(textColorOfMenu);
        sixteen.setForeground(textColorOfMenu);
        twenty.setForeground(textColorOfMenu);
        twenty_four.setForeground(textColorOfMenu);
        color.setForeground(textColorOfMenu);
        size.setForeground(textColorOfMenu);

        file.setToolTipText("To create new, open, save form or exit");
        config.setToolTipText("To configure size and color of a component");
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