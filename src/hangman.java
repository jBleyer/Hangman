import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;


public class hangman {
    private JPanel mainPanel;
    private JTextField eingabeTextField;
    private JButton suchenBtn;
    private JLabel wortLabel;
    private JButton neustartBtn;
    private JPanel labelPanel;

    //Arraylist and random gen.
    ArrayList <String> woerter = new ArrayList<String>();
    Random rand = new Random();

    //dashed string and word
    String wortG;
    String dashedWort;
    StringBuffer savedWort = new StringBuffer();

    public hangman() {

        //start button pressed
        neustartBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                StringBuffer stringBuffer = new StringBuffer();

                String wort = getWort();

                wortG = wort;

                System.out.println(wort);

                //using stringbuffer to generate a new string based on the character count of wort

                for (int i = 0; i < wort.length(); i++) {
                    stringBuffer.insert(i, "-");
                }

                System.out.println(stringBuffer);

                wortLabel.setText("");
                wortLabel.setText(stringBuffer.toString());
                savedWort = stringBuffer;
            }
        });


        suchenBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                char buchstabe = eingabeTextField.getText().charAt(0);

                System.out.println(wortG);

                for (int i = 0; i < wortG.length(); i++) {

                    //Check if found buchstabe is already buchstabe

                    //replace the dashed character in position where buchstabe was found in wort
                    if(wortG.charAt(i) == buchstabe){
                        //If first character is to upper
                        if(Character.toUpperCase(wortG.charAt(0)) == buchstabe){
                            savedWort.replace(i,i+1, Character.toString(Character.toUpperCase(buchstabe)));

                        } else {
                            savedWort.replace(i,i+1, Character.toString(buchstabe));

                        }

                    }

                }

                wortLabel.setText("");
                wortLabel.setText(savedWort.toString());
            }
        });
    }

    //add words and choose one with random func.
    public String getWort(){
        woerter.add("gay");
        woerter.add("leicht");
        woerter.add("toll");
        woerter.add("Supercalifragilisticexpialigetisch");

        return woerter.get(rand.nextInt(4));

    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("hanfman gui");
        frame.setContentPane(new hangman().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(600, 500);
    }

}
