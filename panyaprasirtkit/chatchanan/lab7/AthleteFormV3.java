/**
this program called AthleteFormV3FormV3  which extends from AthleteFormV2 
The program should have the following properties:
The title of the program should be "Athlete Form V3"
Add method addMenus() in creatAndShowGUI() to add all components in the menu.
Implement addMenus() to add the menu bar with these two following menus 
Menu "File" has four menu items which are "New", "Open", "Save", and "Exit" 
The menu items "New", "Open", and "Save" should have icon pictures. You can choose your own picture or use these provided pictures from here. 
Make sure that you use relative path when set the image icon. That is use methods getClass() and getResource() to locate your image files.
Menu "Config" has two menu items which are "Color", and "Size". Menu Color has three menu items Red, Green, and Blue. 
Menu Size also has three menu items 16, 20, and 24.
@author Chatchanan Panyaprasirtkit
@version 1.0, 2/9/2023
 */
package panyaprasirtkit.chatchanan.lab7;

import javax.swing.*;

public class AthleteFormV3 extends AthleteFormV2 {
    protected JMenu file, config, color, size;
    protected JMenuBar menuBar;
    protected JMenuItem newItem, openItem, saveItem, exitItem, red, green, blue, sixteen, twenty, twenty_four;
    protected ImageIcon newImage, openImage, saveImage;

    protected AthleteFormV3(String programName) {
        super(programName);
    }

    public static void createAndShowGUI() {
        AthleteFormV3 myGui = new AthleteFormV3("Athlete Form V3");
        myGui.addComponents();
        myGui.addMenus();
        myGui.setFrameFeatures();
    }

    /*
     * Implement addMenus() to add the menu bar with these two following menus
     * Menu “File” has four menu items which are “New”, “Open”, “Save”, and “Exit”
     * as shown in Figure 8. The menu items “New”, “Open”, and “Save” should have
     * icon pictures. You can choose your own picture or use these provided pictures
     * from here. Make sure that you use relative path when set the image icon. That
     * is use methods getClass() and getResource() to locate your image files.
     * Menu “Config” has two menu items which are “Color”, and “Size” as shown in
     * Menu Color has three menu items Red, Green, and Blue as shown in
     * Menu Size also has three menu items 16, 20, and 24 as shown in
     */
    protected void addMenus() {
        // new
        menuBar = new JMenuBar();
        file = new JMenu("File");
        config = new JMenu("Config");
        newImage = new ImageIcon("panyaprasirtkit/chatchanan/lab7/images_lab7/New-icon.png");
        openImage = new ImageIcon("panyaprasirtkit/chatchanan/lab7/images_lab7/Open-icon.png");
        saveImage = new ImageIcon("panyaprasirtkit/chatchanan/lab7/images_lab7/Save-icon.png");
        newItem = new JMenuItem("New", newImage);
        openItem = new JMenuItem("Open", openImage);
        saveItem = new JMenuItem("Save", saveImage);
        exitItem = new JMenuItem("Exit");
        color = new JMenu("Color");
        size = new JMenu("Size");
        red = new JMenuItem("Red");
        green = new JMenuItem("Green");
        blue = new JMenuItem("Blue");
        sixteen = new JMenuItem("16");
        twenty = new JMenuItem("20");
        twenty_four = new JMenuItem("24");
        // add
        color.add(red);
        color.add(green);
        color.add(blue);
        size.add(sixteen);
        size.add(twenty);
        size.add(twenty_four);
        config.add(color);
        config.add(size);
        file.add(newItem);
        file.add(openItem);
        file.add(saveItem);
        file.addSeparator();
        file.add(exitItem);
        menuBar.add(file);
        menuBar.add(config);
        setJMenuBar(menuBar);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

}
