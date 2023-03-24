/**
This program called AthleteFormV10 that allows the user to input various details about an athlete. 
which has the list election model that can be handled by ListSelectionListener
and the change in the JSlider component  that can be handled by ChangeListener
@author Chatchanan Panyaprasirtkit
@version 1.0, 3/3/2023
*/
package panyaprasirtkit.chatchanan.lab9;

import javax.swing.*;

public class AthleteFormV10 extends AthleteFormV9 {
    protected AthleteFormV10(String programName) {
        super(programName);
    }

    public static void createAndShowGUI() {
        AthleteFormV10 myGui = new AthleteFormV10("Athlete Form V10");
        myGui.addComponents();
        myGui.addMenus();
        myGui.initValues();
        myGui.setFrameFeatures();
        myGui.onChange();
        myGui.addListeners();
    }

    @Override
    protected void onChange() {
        super.onChange();
        // List on change
        sportList.addListSelectionListener(e -> {
            if (!isCancelOrReset) {
                StringBuilder sportBuilder = new StringBuilder();
                sportList.getSelectedValuesList().forEach(value -> sportBuilder.append(value.toString() + " "));
                JOptionPane.showMessageDialog(AthleteFormV10.this, "Selected sports are " + sportBuilder.toString());
            }
        });
        // JSlider on change
        yearOfExpSlider.addChangeListener(e -> {
            if (!yearOfExpSlider.getValueIsAdjusting() && !isCancelOrReset) {
                JOptionPane.showMessageDialog(AthleteFormV10.this,
                        "# of experience years is " + yearOfExpSlider.getValue());
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
}