/**
This class represents the GUI for the Athlete Form version 15, which is an extension of version 14.
It includes methods for creating and showing the GUI, adding components and menus, initializing values,
setting frame features, handling save and open menus, and adding listeners to components.
It also overrides the saveMenu and openMenu methods from the superclass to provide functionality for
saving and opening data to and from a binary file.
@author Chatchanan Panyaprasirtkit
@version 1.0, 24/3/2023
 */
package panyaprasirtkit.chatchanan.lab11;

import panyaprasirtkit.chatchanan.lab10.AthleteFormV13;
import javax.swing.*;
import java.io.*;
import java.nio.file.Files;

public class AthleteFormV14 extends AthleteFormV13 {
    JFileChooser fileChooser;

    AthleteFormV14(String programName) {
        super(programName);
    }

    public static void createAndShowGUI() {
        AthleteFormV14 myGui = new AthleteFormV14("Athlete Form V14");
        myGui.addComponents();
        myGui.addMenus();
        myGui.initValues();
        myGui.setFrameFeatures();
        myGui.onChange();
        myGui.addListeners();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    // Override the addMenus method from the superclass to remove the action
    // listeners
    @Override
    protected void addMenus() {
        super.addMenus();
        menuItemsList.forEach(menuItem -> menuItem.removeActionListener(menuItem.getActionListeners()[0]));
        saveItem.addActionListener(e -> saveMenu());
        openItem.addActionListener(e -> openMenu());
    }

    // Override the saveMenu method from the superclass to provide functionality
    protected void saveMenu() {
        fileChooser = new JFileChooser("C://Java/lab/chatchanan-1231-java-labs/panyaprasirtkit/chatchanan/lab11");
        if (fileChooser.showSaveDialog(this) != JFileChooser.APPROVE_OPTION) {
            JOptionPane.showMessageDialog(this, "Save file cancelled by the user");
            return;
        }
        File filePath = fileChooser.getSelectedFile();
        if (!filePath.getName().toLowerCase().endsWith(".txt")) {
            filePath = new File(filePath.getParentFile(), filePath.getName() + ".txt");
        }
        try (PrintWriter writer = new PrintWriter(filePath)) {
            writer.write(nameTextField.getText() + "\n" + getHobbie());
            JOptionPane.showMessageDialog(this,
                    "Saving hobbies in file " + filePath.toPath());
            writer.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving file: " + e.getMessage());
        }
    }

    // Override the openMenu method from the superclass to provide functionality
    protected void openMenu() {
        fileChooser = new JFileChooser("C://Java/lab/chatchanan-1231-java-labs/panyaprasirtkit/chatchanan/lab11");
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                String fileContent = Files.readString(fileChooser.getSelectedFile().toPath());
                String hobbyString = (fileContent.split("\n").length == 1) ? " doesn't have any hobby "
                        : ((fileContent.indexOf(",") != -1 || fileContent.indexOf("and") != -1) ? " has hobbies as "
                                : " has a hobby as ");
                bioTextArea.append(fileContent.replace("\n", hobbyString) + "\n");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error reading file");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Open file cancelled by the user");
        }
    }
}
