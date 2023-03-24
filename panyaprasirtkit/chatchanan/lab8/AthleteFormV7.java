/**

AthleteFormV7 extends AthleteFormV6 and adds the ability to display an image on the form.
@author Chatchanan Panyaprasirtkit
@version 1.0, 2/17/2023
*/
package panyaprasirtkit.chatchanan.lab8;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.imageio.*;
import java.awt.image.BufferedImage;

/**
 * 
 * AthleteFormV7 class creates a form with additional image capabilities.
 */
class AthleteFormV7 extends AthleteFormV6 {
    ReadImage image;
    JPanel imagePanel;

    /**
     * 
     * Constructor for AthleteFormV7.
     * 
     * @param programName the name of the program to display in the frame.
     */
    AthleteFormV7(String programName) {
        super(programName);
    }

    /**
     * 
     * Creates and shows the GUI.
     */
    public static void createAndShowGUI() {
        AthleteFormV7 myGui = new AthleteFormV7("Athlete Form V7");
        myGui.addComponents();
        myGui.addMenus();
        myGui.setFrameFeatures();
    }

    /**
     * 
     * Adds components to the form, including an image panel with an image loaded
     * from a file.
     */
    protected void addComponents() {
        super.addComponents();
        image = new ReadImage();
        imagePanel = new JPanel();
        imagePanel.setLayout(new BorderLayout());
        image.setPreferredSize(new Dimension(400, 300));
        imagePanel.add(yearOfExp, BorderLayout.NORTH);
        imagePanel.add(image, BorderLayout.CENTER);
        imagePanel.add(buttonPanel, BorderLayout.SOUTH);
        mainPanel.add(imagePanel, BorderLayout.SOUTH);
    }

    /**
     * 
     * Main method to create and show the GUI.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}

/**
 * 
 * ReadImage class is a JPanel that reads an image file and displays it on the
 * form.
 */
class ReadImage extends JPanel {
    BufferedImage img;
    String fileName = "Athlete.png";

    /**
     * 
     * Paints the image on the panel.
     */
    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }

    /**
     * 
     * Constructor for ReadImage class that reads an image file and stores it in a
     * BufferedImage object.
     */
    public ReadImage() {
        try {
            img = ImageIO.read(new File(fileName));
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
}