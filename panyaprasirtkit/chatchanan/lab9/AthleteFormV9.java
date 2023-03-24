/**
This is a Java program named AthleteFormV9 that extends the AthleteFormV8 class.
It adds menus to the GUI, handles menu item events, and listens to changes 
made to text fields, checkboxes, combobox, and radio buttons.
@author Chatchanan Panyaprasirtkit
@version 1.0, 3/3/2023
*/
package panyaprasirtkit.chatchanan.lab9;

import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.util.stream.IntStream;

public class AthleteFormV9 extends AthleteFormV8 {
    String[] textName = { "Name", "Weight", "Height", "Date of birth" };
    protected ArrayList<JMenuItem> menuItemsList;
    String[] accelerators = { "N", "O", "S", "Q" };
    int[] mnemonicKeys = { KeyEvent.VK_N, KeyEvent.VK_O, KeyEvent.VK_S, KeyEvent.VK_Q };

    AthleteFormV9(String programName) {
        super(programName);
    }

    public static void createAndShowGUI() {
        AthleteFormV9 myGui = new AthleteFormV9("Athlete Form V9");
        myGui.addComponents();
        myGui.addMenus();
        myGui.initValues();
        myGui.setFrameFeatures();
        myGui.onChange();
        myGui.addListeners();
    }

    // The menus include File > New, File > Open, File > Save, and File > Exit.
    // Accelerators and mnemonic keys are set for each menu item.
    protected void addMenus() {
        super.addMenus();
        menuItemsList = new ArrayList<>(
                Arrays.asList(newItem, openItem, saveItem, exitItem));
        menuItemsList.forEach(menuItem -> menuItem.addActionListener(
                e -> JOptionPane.showMessageDialog(AthleteFormV9.this, ("You clicked menu " + menuItem.getText()))));
        IntStream.range(0, menuItemsList.size()).forEach(i -> {
            menuItemsList.get(i).setAccelerator(KeyStroke.getKeyStroke("control " + accelerators[i]));
            menuItemsList.get(i).setMnemonic(mnemonicKeys[i]);
        });
    }

    protected void onChange() {
        // Text fields on change
        textFields.forEach(textField -> {
            textField.setName(textName[textFields.indexOf(textField)]);
            textField.addActionListener(e -> showChangeMessage(textField.getName(), textField.getText()));
        });
        // ComboBox on change
        Arrays.asList(readingCheckBox, gardeningCheckBox, watchMvCheckBox, shoppingCheckBox, otherCheckBox)
                .forEach(checkBox -> checkBox.addItemListener(
                        e -> {
                            if (!isCancelOrReset) {
                                SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(AthleteFormV9.this,
                                        checkBox.getText()
                                                + (e.getStateChange() == ItemEvent.SELECTED ? " is also your hobby"
                                                        : " is no longer your hobby")));
                            }
                        }));
        // ComboBox on change (nationality)
        nationalityComboBox.addActionListener(e -> showChangeMessage("Nationality",
                nationalityComboBox.getSelectedItem() != null ? nationalityComboBox.getSelectedItem().toString()
                        : ""));
        // Radio buttons on change
        Arrays.asList(male, female).forEach(gender -> {
            gender.addActionListener(e -> {
                if (!isCancelOrReset) {
                    JOptionPane.showMessageDialog(AthleteFormV9.this,
                            getGender() + " is selected");
                }
            });
        });
    }

    // show message when text is changed
    protected void showChangeMessage(String text, String newText) {
        if (!isCancelOrReset && !newText.equals(text)) {
            JOptionPane.showMessageDialog(AthleteFormV9.this, text + " is changed to " + newText);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
}
