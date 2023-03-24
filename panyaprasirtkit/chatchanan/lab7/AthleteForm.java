/**
this program called AthleteForm which extends from MySimpleWindow 
The program should have the following properties:   
The title of the program is set to "Athlete Form".
The main() and the createAndShowGUI()
use JLabel for all your text on the left and JTextField for the right. All text areas' length should be 15.
There is one row of radio buttons. The label is on the left as "Gender : ". On the right are radio buttons : "Male" and "Female". 
You need to use the class ButtonGroup to group two radio buttons together and allow a user to choose only one radio button at a time.
The bottom line contains three buttons which should be named "Cancel", "Reset", and "Submit" respectively. These buttons are created in MySimpleWindow.
You need to override the method andComponents () to add more components to the interface looks like in Figure 4. You should also call addComponents() 
method of the superclass to get all the previously created components. 
Reuse the code as much as possible. If there are some repeated codes, you should consider creating a method to group some codes together and reuse the method. 
You can also create a class to group a label and a field if you want to.
@author Chatchanan Panyaprasirtkit
@version 1.0, 2/9/2023
 */
package panyaprasirtkit.chatchanan.lab7;

import javax.swing.*;
import java.awt.*;

//AthleteForm which extends from MySimpleWindow
public class AthleteForm extends MySimpleWindow {
    /*
     * use JLabel for all your text on the left and JTextField for the right. All
     * text areas’ length should be 15.
     * There is one row of radio buttons. The label is on the left as “Gender : “.
     * On the right are radio buttons : “Male” and “Female”. You need to use the
     * class ButtonGroup to group two radio buttons together and allow a user to
     * choose only one radio button at a time.
     * The bottom line contains three buttons which should be named “Cancel”,
     * “Reset”, and “Submit” respectively. These buttons are created in
     * MySimpleWindow.
     */
    protected JLabel name, weight, height, birthDate, gender;
    protected JTextField nameTextField;
    protected JTextField weightTextField;
    protected JTextField heightTextField;
    protected JTextField birthDateTextField;
    protected ButtonGroup genderGroup;
    protected JPanel myPanel, buttonGroup;
    protected GridLayout gridLayout;
    protected JRadioButton male, female;

    protected AthleteForm(String programName) {
        super(programName);
    }
    // The title of the program is set to “Athlete Form”.

    public static void createAndShowGUI() {
        AthleteForm myGui = new AthleteForm("Athlete Form");
        myGui.addComponents();
        myGui.setFrameFeatures();
    }

    // override the method andComponents ()
    protected void addComponents() {
        super.addComponents();
        myPanel = new JPanel();
        gridLayout = new GridLayout(0, 2);
        // setLayout
        myPanel.setLayout(gridLayout);
        // Label and textField
        name = new JLabel("Name : ");
        weight = new JLabel("Weight : ");
        height = new JLabel("Height : ");
        birthDate = new JLabel("Date of Birth (dd-mm-yyyy) : ");
        gender = new JLabel("Gender : ");
        nameTextField = new JTextField(15);
        weightTextField = new JTextField(15);
        heightTextField = new JTextField(15);
        birthDateTextField = new JTextField(15);
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        genderGroup = new ButtonGroup();
        buttonGroup = new JPanel();
        buttonGroup.setLayout(gridLayout);
        male.setHorizontalAlignment(SwingConstants.CENTER);
        female.setHorizontalAlignment(SwingConstants.CENTER);
        // Add textFeild and label
        myPanel.add(name);
        myPanel.add(nameTextField);
        myPanel.add(weight);
        myPanel.add(weightTextField);
        myPanel.add(height);
        myPanel.add(heightTextField);
        myPanel.add(birthDate);
        myPanel.add(birthDateTextField);
        myPanel.add(gender);
        genderGroup.add(male);
        genderGroup.add(female);
        buttonGroup.add(male);
        buttonGroup.add(female);
        myPanel.add(buttonGroup);
        // to add everthing in main
        mainPanel.add(myPanel, BorderLayout.NORTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
