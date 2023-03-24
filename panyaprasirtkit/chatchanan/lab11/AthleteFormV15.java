/**
this class also overrides the saveMenu and openMenu methods to provide new functionality for 
saving and opening files. The saveMenu method opens a JFileChooser dialog for the user to select a file to save,
checks if the file has a .txt extension, writes the text from the nameTextField and getHobbie method to the file 
and displays a message dialog to confirm that the file has been saved. The openMenu method opens 
a JFileChooser dialog for the user to select a file to open, reads the contents of the file, 
replaces the new line character with appropriate hobby strings, and displays the text in the bioTextArea.
@author Chatchanan Panyaprasirtkit
@version 1.0, 24/3/2023
 */
package panyaprasirtkit.chatchanan.lab11;

import javax.swing.*;
import java.io.*;

public class AthleteFormV15 extends AthleteFormV14 {
    AthleteFormV15(String programName) {
        super(programName);
    }

    // Override the addMenus method from the superclass to remove the action
    public static void createAndShowGUI() {
        AthleteFormV15 myGui = new AthleteFormV15("Athlete Form V15");
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

    // Override the saveMenu method from the superclass to provide functionality
    @Override
    protected void saveMenu() {
        super.saveMenu();
        fileChooser = new JFileChooser("C://Java/lab/chatchanan-1231-java-labs/panyaprasirtkit/chatchanan/lab11");
        if (fileChooser.showSaveDialog(this) != JFileChooser.APPROVE_OPTION) {
            JOptionPane.showMessageDialog(this, "Save file cancelled by the user");
            return;
        }
        File binaryFile = new File(fileChooser.getSelectedFile().getParentFile(), "years");
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(binaryFile))) {
            dataOutputStream.writeUTF(nameTextField.getText());
            dataOutputStream.writeInt(yearOfExpSlider.getValue());
            JOptionPane.showMessageDialog(this,
                    yearOfExpSlider.getValue() > 1 ? ("Saving experience years in binary file " + binaryFile.toPath())
                            : ("Saving experience year in binary file " + binaryFile.toPath()));
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
            try (DataInputStream dataInputStream = new DataInputStream(
                    new FileInputStream(fileChooser.getSelectedFile()))) {
                String name = dataInputStream.readUTF();
                int experience = dataInputStream.readInt();
                String yearString = (experience == 1) ? " has 1 year of experience"
                        : (experience == 0 ? "has no experiences" : " has " + experience + " years of experience");
                bioTextArea.append(name + yearString + "\n");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error opening binary file: " + e.getMessage());
            }
        }
    }
}
