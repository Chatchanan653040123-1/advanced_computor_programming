/** 
 * This is a Java class called AthleteFormV13 in the package panyaprasirtkit.chatchanan.lab10. It extends the AthleteFormV12 class and overrides some of its methods. 
 * It also imports classes from the java.text and javax.swing packages as well as the panyaprasirtkit.chatchanan.lab5.Athlete.Gender and panyaprasirtkit.chatchanan.lab6.AthleteV2 classes.
 * The constructor of AthleteFormV13 calls the constructor of AthleteFormV12 with the argument programName and the createAndShowGUI() 
 * method creates a new AthleteFormV13 object and initializes its components, menus, values, and features. It then calls the onChange() and addListeners() 
 * methods to add listeners to the text fields to handle text field.
 * @author Chatchanan Panyaprasirtkit
 * @version 1.0, 3/17/2023
 * */
package panyaprasirtkit.chatchanan.lab10;

import java.text.*;
import javax.swing.*;
import panyaprasirtkit.chatchanan.lab5.Athlete.Gender;
import panyaprasirtkit.chatchanan.lab6.AthleteV2;

public class AthleteFormV13 extends AthleteFormV12 {
    protected AthleteFormV13(String programName) {
        super(programName);
    }

    public static void createAndShowGUI() {
        AthleteFormV13 myGui = new AthleteFormV13("Athlete Form V13");
        myGui.addComponents();
        myGui.addMenus();
        myGui.initValues();
        myGui.setFrameFeatures();
        myGui.onChange();
        myGui.addListeners();
    }

    /**
     * The addListeners() method overrides the method of the same name in
     * AthleteFormV12. It first calls the addListeners() method of the super class
     * and then removes the existing action listener of each text field and adds a
     * new one that checks the validity of the user input when the user presses
     * Enter. If the user input is invalid, a message dialog is displayed.
     */
    @Override
    protected void addListeners() {
        super.addListeners();
        textFields.forEach(textField -> {
            textField.removeActionListener(textField.getActionListeners()[0]);
            textField.addActionListener(e -> {
                if (textField == nameTextField && nameTextField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(AthleteFormV13.this, "Please enter a name");
                } else if (textField == birthDateTextField && !isValidDate(birthDateTextField.getText())) {
                    JOptionPane.showMessageDialog(AthleteFormV13.this,
                            "Please enter a valid birthdate in the format dd/MM/yyyy");
                } else if (textField == weightTextField
                        && getValidNumber(weightTextField.getText(), "Weight", 200) == -1) {
                    return;
                } else if (textField == heightTextField
                        && getValidNumber(heightTextField.getText(), "Height", 300) == -1) {
                    return;
                } else {
                    showChangeMessage(textField.getName(), textField.getText());
                }
            });
        });
    }

    /**
     * The addMenuItem() method overrides the method of the same name in
     * AthleteFormV12. It first checks if the name, birthdate, weight, and height
     * fields contain valid inputs. If any of them are invalid, a message dialog is
     * displayed and the method returns. Otherwise, a new AthleteV2 object is
     * created and added to the list of athletes.
     */
    @Override
    protected void addMenuItem() {
        if (nameTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(AthleteFormV13.this, "Please enter a name");
            return;
        }
        if (!isValidDate(birthDateTextField.getText())) {
            JOptionPane.showMessageDialog(AthleteFormV13.this,
                    "Please enter a valid birthdate in the format dd/MM/yyyy");
            return;
        }
        if (getValidNumber(weightTextField.getText(), "Weight", 200) == -1) {
            return;
        }
        if (getValidNumber(heightTextField.getText(), "Height", 300) == -1) {
            return;
        }
        athlete = new AthleteV2(
                nameTextField.getText(),
                getValidNumber(weightTextField.getText(), "Weight", 200),
                getValidNumber(heightTextField.getText(), "Height", 300),
                male.isSelected() ? Gender.MALE : Gender.FEMALE,
                nationalityComboBox.getSelectedItem().toString(),
                birthDateTextField.getText());
        super.addMenuItem();
    }

    /**
     * The getValidNumber() method checks if a given string input represents a valid
     * number between 0 and a specified maximum value. If it is, the method returns
     * the number. Otherwise, a message dialog is displayed and the method returns
     * -1.
     */
    protected double getValidNumber(String input, String fieldName, double max) {
        try {
            if (Double.parseDouble(input) > 0 && Double.parseDouble(input) <= max) {
                return Double.parseDouble(input);
            } else if (Double.parseDouble(input) < 0) {
                JOptionPane.showMessageDialog(AthleteFormV13.this,
                        fieldName + " should be greater than " + 0);
            } else {
                JOptionPane.showMessageDialog(AthleteFormV13.this,
                        fieldName + " should be less than " + max);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(AthleteFormV13.this, "Please enter a valid number for " + fieldName);
        }
        return -1;
    }

    /**
     * The isValidDate() method checks if a given string input represents a valid
     * date in the format "dd/MM/yyyy". If it is, the method returns true.
     * Otherwise, it returns false.
     */
    protected boolean isValidDate(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(date.trim());
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
}
