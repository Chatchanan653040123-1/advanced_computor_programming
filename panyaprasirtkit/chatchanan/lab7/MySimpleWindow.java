/**
this program called MySimpleWindow with the following properties.
This program MySimpleWindow extends from class JFrame
There are three variables for three buttons whose names are "Cancel", "Reset" and "Submit". These buttons should be protected.
There are two panels, the main panel and the panel for the button. Similarly, these panels should be protected.
Implement method protected void setFrameFeatures() which performs the following tasks
Set the window located at the center of the screen.
Set the window visible.
Exit the application using the System exit method when the user initiates a "close" on this frame.
Set the size of the window appropriate for all the components.
@author Chatchanan Panyaprasirtkit
@version 1.0, 2/9/2023
 */
package panyaprasirtkit.chatchanan.lab7;

import javax.swing.*;
import java.awt.*;

//This program MySimpleWindow extends from class JFrame
class MySimpleWindow extends JFrame {
    // There are three variables for three buttons whose names are “Cancel”, “Reset”
    // and “Submit”. These buttons should be protected.
    protected JButton cancelButton;
    protected JButton resetButton;
    protected JButton submitButton;
    protected JPanel mainPanel, buttonPanel;

    MySimpleWindow(String programName) {
        super(programName);
    }

    public static void createAndShowGUI() {
        MySimpleWindow myGui = new MySimpleWindow("My Simple Window");
        myGui.addComponents();
        myGui.setFrameFeatures();
    }

    protected void addComponents() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        buttonPanel = new JPanel();
        cancelButton = new JButton("Cancel");
        buttonPanel.add(cancelButton);
        resetButton = new JButton("Reset");
        buttonPanel.add(resetButton);
        submitButton = new JButton("Submit");
        buttonPanel.add(submitButton);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        add(mainPanel);
    }

    /*
     * Implement method protected void setFrameFeatures() which performs the
     * following tasks
     * Set the window located at the center of the screen.
     * Set the window visible.
     * Exit the application using the System exit method when the user initiates a
     * "close" on this frame.
     * Set the size of the window appropriate for all the components.
     */
    protected void setFrameFeatures() {
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
