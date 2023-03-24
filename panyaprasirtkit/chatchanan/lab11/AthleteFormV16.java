
/**
AthleteFormV16 is a class that extends AthleteFormV15 and provides functionality to save and open AthleteV2 objects in
binary files. It overrides the saveMenu and openMenu methods to provide this functionality. It also provides its own
implementation of createAndShowGUI method to create and show the GUI of the program.
@author Chatchanan Panyaprasirtkit
@version 1.0, 24/3/2023
*/
package panyaprasirtkit.chatchanan.lab11;

import javax.swing.*;
import panyaprasirtkit.chatchanan.lab6.AthleteV2;
import java.io.*;

public class AthleteFormV16 extends AthleteFormV15 {

    AthleteFormV16(String programName) {
        super(programName);
    }

    // Override the saveMenu method from the superclass to provide functionality
    @Override
    protected void saveMenu() {
        super.saveMenu();
        fileChooser = new JFileChooser("C://Java/lab/chatchanan-1231-java-labs/panyaprasirtkit/chatchanan/lab11");
        if (fileChooser.showSaveDialog(this) != JFileChooser.APPROVE_OPTION) {
            JOptionPane.showMessageDialog(this, "Save file cancelled by the user");
            return;
        }
        File binaryFile = new File(fileChooser.getSelectedFile().getParentFile(), "athlete");
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(binaryFile));
            addMenuItem();
            objectOutputStream.writeObject(athlete);
            objectOutputStream.flush();
            JOptionPane.showMessageDialog(this, "Saving the athlete in the file " + binaryFile.toPath());
            objectOutputStream.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving binary file: " + e.getMessage());
        }
    }

    // Override the openMenu method from the superclass to provide functionality
    @Override
    protected void openMenu() {
        super.openMenu();
        fileChooser = new JFileChooser("C://Java/lab/chatchanan-1231-java-labs/panyaprasirtkit/chatchanan/lab11");
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try (ObjectInputStream objectInputStream = new ObjectInputStream(
                    new FileInputStream(fileChooser.getSelectedFile()))) {
                AthleteV2 inputStream = (AthleteV2) objectInputStream.readObject();
                JOptionPane.showMessageDialog(this,
                        "Saving the athlete in the file " + fileChooser.getSelectedFile().toPath());
                bioTextArea.append(inputStream.toString());
                objectInputStream.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error saving binary file: " + e.getMessage());
            }
        }
    }

    public static void createAndShowGUI() {
        AthleteFormV16 myGui = new AthleteFormV16("Athlete Form V16");
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
}
