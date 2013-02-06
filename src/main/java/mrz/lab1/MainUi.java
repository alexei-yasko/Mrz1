package mrz.lab1;

import javax.swing.JFrame;

import mrz.lab1.ui.MainFrame;

/**
 * @author Q-YAA
 */
public class MainUi {

    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }
}
