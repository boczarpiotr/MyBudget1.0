package MyBudget;

import static MyBudget.GUI.createAndShowGUI;

public class App
{
    public static void main( String[] args ) {
        javax.swing.SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
}
