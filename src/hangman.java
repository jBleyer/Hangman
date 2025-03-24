import javax.swing.*;
import java.awt.*;

public class hangman {
    private JPanel mainPanel;
    private JTextField eingabeTextField;
    private JButton suchenBtn;
    private JLabel wortLabel;
    private JButton neustartBtn;



    public static void main(String[] args) {
        JFrame frame = new JFrame("hanfman gui");
        frame.setContentPane(new hangman().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(500, 300);
        frame.setForeground(new Color(238, 130, 238));
    }
}
