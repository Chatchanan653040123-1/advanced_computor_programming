/**

A class that represents the athlete form version 6, which extends AthleteFormV5.
This version adds an Olympic symbol to the GUI using a JPanel and a custom
OlympicSymbol class.
@author Chatchanan Panyaprasirtkit
@version 1.0, 2/17/2023
*/
package panyaprasirtkit.chatchanan.lab8;

import java.awt.*;
import javax.swing.*;

public class AthleteFormV6 extends AthleteFormV5 {
    OlympicSymbol olympic;
    JPanel olympicPanel;

    /**
     * Constructs an AthleteFormV6 with a given program name.
     * 
     * @param programName the name of the program
     */
    protected AthleteFormV6(String programName) {
        super(programName);
    }

    /**
     * Creates and shows an instance of AthleteFormV6.
     */
    public static void createAndShowGUI() {
        AthleteFormV6 myGui = new AthleteFormV6("Athlete Form V6");
        myGui.addComponents();
        myGui.addMenus();
        myGui.setFrameFeatures();
    }

    /**
     * Adds components to the GUI. Overrides the method in AthleteFormV5 and
     * adds an Olympic symbol to the GUI using a JPanel and OlympicSymbol class.
     */
    protected void addComponents() {
        super.addComponents();
        olympic = new OlympicSymbol();
        olympicPanel = new JPanel();
        olympicPanel.setBackground(new Color(255, 255, 255));
        olympicPanel.setLayout(new BorderLayout());
        olympic.setPreferredSize(new Dimension(200, 100));
        olympicPanel.add(olympic, BorderLayout.NORTH);
        olympicPanel.add(myPanel, BorderLayout.CENTER);
        mainPanel.add(olympicPanel, BorderLayout.NORTH);
    }

    /**
     * The main method creates and shows an instance of AthleteFormV6.
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
 * A custom JPanel class that draws the Olympic symbol.
 */
class OlympicSymbol extends JPanel {
    /**
     * Draws the Olympic symbol using Graphics and Graphics2D.
     * 
     * @param g the Graphics object to be drawn
     */
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(5));
        g.setColor(Color.BLUE);
        g.drawOval(25, 10, 50, 50);
        g.setColor(Color.RED);
        g.drawOval(75, 10, 50, 50);
        g.setColor(Color.YELLOW);
        g.drawOval(125, 10, 50, 50);
        g.setColor(Color.GREEN);
        g.drawOval(50, 35, 50, 50);
        g.setColor(Color.BLACK);
        g.drawOval(100, 35, 50, 50);

    }
}
