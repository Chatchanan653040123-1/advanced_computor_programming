/**
AthleteFormV8 is a GUI program for inputting athlete's information,
including name, weight, height, date of birth, gender, hobbies, nationality,
sport, and experience years.
It extends AthleteFormV6.
It contains methods for initializing GUI components, adding listeners,
getting input values, handling button events, and resetting/clearing input data.
@author Chatchanan Panyaprasirtkit
@version 1.0, 3/3/2023
*/
package panyaprasirtkit.chatchanan.lab9;

import panyaprasirtkit.chatchanan.lab8.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class AthleteFormV8 extends AthleteFormV6 {
    ArrayList<JCheckBox> selectedHobbie = new ArrayList<>();
    ArrayList<String> selectedSport = new ArrayList<>();
    protected ArrayList<JTextField> textFields;
    String genderCheck, result;
    String[] defaultText = { "Manee", "50", "170", "01/01/2000" };
    boolean isCancelOrReset;

    AthleteFormV8(String programName) {
        super(programName);
    }

    public static void createAndShowGUI() {
        AthleteFormV8 myGui = new AthleteFormV8("Athlete Form V8");
        myGui.addComponents();
        myGui.addListeners();
        myGui.initValues();
        myGui.setFrameFeatures();
        myGui.addMenus();
    }

    // Method for initializing default values of the JTextFields
    protected void initValues() {
        female.setSelected(true);
        yearOfExpSlider.setValue(10);
        textFields = new ArrayList<>(
                Arrays.asList(nameTextField, weightTextField, heightTextField, birthDateTextField));
        textFields.forEach(textField -> {
            textField.setBackground(Color.PINK);
            textField.setText(defaultText[textFields.indexOf(textField)]);
        });
    }

    /*
     * When the submitButton is clicked, the handleSubmitButton() method is called
     * to process and display the user's input. When the cancelButton is clicked,
     * the handleCancelButton() method is called to clear all fields and reset them
     * to default values. Finally, when the resetButton is clicked, the
     * handleResetButton() method is called to clear all fields without changing any
     * default values.
     */
    protected void addListeners() {
        Arrays.asList(submitButton, resetButton, cancelButton).forEach(button -> button.addActionListener(e -> {
            isCancelOrReset = true;
            Object srcObject = e.getSource();
            if (srcObject == submitButton) {
                handleSubmitButton();
            } else if (srcObject == cancelButton) {
                handleCancelButton();
            } else if (srcObject == resetButton) {
                handleResetButton();
            }
        }));
    };

    // Method for getting the input values of the JTextFields and other components
    protected void getValues() {
        result = String.format(
                "Name: %s\nWeight: %s\nHeight: %s\nDate of birth: %s\nGender: %s\nHobbies: %s\nNationality: %s\nSport: %s\nExperience years: %d",
                nameTextField.getText(),
                weightTextField.getText(),
                heightTextField.getText(),
                birthDateTextField.getText(),
                getGender(),
                getHobbie(),
                nationalityComboBox.getSelectedItem(),
                getSport(),
                yearOfExpSlider.getValue());
    }

    /**
     * This method retrieves the selected checkboxes in the hobby section of the
     * form and returns a string with the text of the selected hobbies, separated by
     * commas.
     * 
     * @return the hobbies as a String
     */
    protected String getHobbie() {
        selectedHobbie.clear();
        StringBuilder buildText = new StringBuilder();
        for (Component component : checkBox.getComponents()) {
            if (component instanceof JCheckBox checkBox && checkBox.isSelected()) {
                selectedHobbie.add(checkBox);
            }
        }
        for (int i = 0; i < selectedHobbie.size(); i++) {
            JCheckBox checkBox = selectedHobbie.get(i);
            buildText.append(i == 0 ? "" : (i == selectedHobbie.size() - 1 ? " and " : ", "))
                    .append(checkBox.getText());
        }
        return buildText.toString();
    }

    // This method gets the selected sports from a JList component and returns them
    // as a comma-separated string.
    protected String getSport() {
        selectedSport.clear();
        sportList.getSelectedValuesList().forEach(sport -> selectedSport.add(sport.toString()));
        return selectedSport.toString();
    }

    // This method gets the selected gender from a JRadioButton component and
    // returns them as a String
    protected String getGender() {
        return !male.isSelected() && !female.isSelected() ? "" : (male.isSelected() ? "Male" : "Female");
    }

    // This method clears the data in all the text fields of the form, sets the
    // value of a slider to zero, unchecks all the checkboxes except for a specific
    // one, clears the selection of two combo boxes, and clears the selection of a
    // group of radio buttons.
    protected void clearData() {
        textFields.forEach(textField -> textField.setText(""));
        yearOfExpSlider.setValue(0);
        genderGroup.clearSelection();
        bioTextArea.setText("");
        isCancelOrReset = false;
    }

    // This method gets the values entered by the user in the form, processes them
    // to obtain a result, and sets the text of a text area with the result.
    protected void handleSubmitButton() {
        getValues();
        bioTextArea.setText(result);
    }

    // This method clears all the data in the form and sets some specific values for
    // some components.
    protected void handleCancelButton() {
        clearData();
        textFields.forEach(textField -> textField.setBackground(new Color(167, 59, 36)));
    }

    // This method clears all the data in the form and sets the background color of
    // all the text fields to white.
    protected void handleResetButton() {
        clearData();
        isCancelOrReset = true;
        Arrays.asList(readingCheckBox, gardeningCheckBox, watchMvCheckBox, shoppingCheckBox, otherCheckBox)
                .forEach(checkBox -> checkBox.setSelected(false));
        sportList.clearSelection();
        nationalityComboBox.setSelectedIndex(-1);
        isCancelOrReset = false;
        textFields.forEach(textField -> textField.setBackground(Color.WHITE));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
}
