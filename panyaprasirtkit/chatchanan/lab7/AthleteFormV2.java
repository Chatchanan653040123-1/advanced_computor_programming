/**
this program called AthleteFormV2 which extends from AthleteForm 
The program should have the following properties
The title of the program should be "Athlete Form V2" 
Override the method addComponent() to add the following components.
Add a label called "Nationality : " and the combo box of nationalities which includes "American", "Chinese", "Indonesian", "Japanese", "Thai", and "Vietnamese". The combo box should be set to "Thai" as a default.
Add a label called "Sport : " and the JList which includes "Badminton", "Boxing", "Football", and "Running". The result should be set as "Football".
Add a label called "Bio : " and underneath create a text area with a scroll pane. Your text area should be wrapped by word.
Reuse the code as much as possible.   Your code should only create new components and add components in this window. 

@author Chatchanan Panyaprasirtkit
@version 1.0, 2/9/2023
 */
package panyaprasirtkit.chatchanan.lab7;

import javax.swing.*;
import java.awt.*;

//AthleteFormV2 which extends from AthleteForm
public class AthleteFormV2 extends AthleteForm {
    protected JLabel nationality, sport, bio;
    protected JComboBox<String> nationalityComboBox;
    protected JList<String> sportList;
    protected JPanel nationalitySportBio, nationalityPanel, sportPanel, bioPanel, combinePanel;
    protected JTextArea bioTextArea;
    protected String[] nationalityArray = { "American", "Chinese", "Indonesian", "Japanese", "Thai", "Vietnamese" };
    protected String[] sportListArray = { "Badminton", "Boxing", "Football", "Running" };
    protected JScrollPane scrollBar;

    AthleteFormV2(String programName) {
        super(programName);
    }

    public static void createAndShowGUI() {
        AthleteFormV2 myGui = new AthleteFormV2("Athlete Form V2");
        myGui.addComponents();
        myGui.setFrameFeatures();
    }

    protected void addComponents() {
        super.addComponents();
        // new
        nationality = new JLabel("Nationality : ");
        sport = new JLabel("Sport : ");
        bio = new JLabel("Bio : ");
        nationalitySportBio = new JPanel();
        nationalitySportBio.setLayout(new BorderLayout());
        nationalityComboBox = new JComboBox<String>(nationalityArray);
        sportList = new JList<String>(sportListArray);
        bioTextArea = new JTextArea(5, 20);
        nationalityPanel = new JPanel();
        sportPanel = new JPanel();
        bioPanel = new JPanel();
        scrollBar = new JScrollPane(bioTextArea);
        combinePanel = new JPanel();
        // set
        bioPanel.setLayout(new BorderLayout());
        combinePanel.setLayout(new BorderLayout());
        bioTextArea.setLineWrap(true);
        bioTextArea.setWrapStyleWord(true);
        nationalityPanel.setLayout(gridLayout);
        sportPanel.setLayout(gridLayout);
        nationalityComboBox.setSelectedIndex(4);
        sportList.setSelectedIndex(2);
        // add
        nationalityPanel.add(nationality);
        nationalityPanel.add(nationalityComboBox);
        sportPanel.add(sport);
        sportPanel.add(sportList);
        bioPanel.add(bio, BorderLayout.NORTH);
        bioPanel.add(scrollBar, BorderLayout.CENTER);
        combinePanel.add(nationalityPanel, BorderLayout.NORTH);
        combinePanel.add(sportPanel, BorderLayout.CENTER);
        combinePanel.add(bioPanel, BorderLayout.SOUTH);
        nationalitySportBio.add(combinePanel, BorderLayout.CENTER);
        mainPanel.add(nationalitySportBio);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

}
