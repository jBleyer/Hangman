import javax.swing.*;
import java.awt.*;
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
    private JLabel wrongCharacterLabel;
    private JLabel photoLabel;
    private JLabel endMessageLabel;

    //Arraylist and random gen.
    ArrayList <String> woerter = new ArrayList<String>();
    Random rand = new Random();

    //word that is used outside of getText in neustartBtn listener
    String wortG;
    //saved wort is what is with dashes and buchstaben
    StringBuffer savedWort = new StringBuffer();
    ArrayList <Character> incorrectBuchstaben = new ArrayList<Character>();

    //counter 4 photo
    int picCounter = 1;

    public hangman() {

        //start button pressed
        neustartBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                suchenBtn.setEnabled(true);
                StringBuffer stringBuffer = new StringBuffer();

                String wort = getWort();

                wortG = wort;

                //using stringbuffer to generate a new string based on the character count of wort

                for (int i = 0; i < wort.length(); i++) {
                    stringBuffer.insert(i, "-");
                }

                wortLabel.setText("");
                wortLabel.setText(stringBuffer.toString());
                savedWort = stringBuffer;
            }
        });


        //Suchen button
        suchenBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                char buchstabe = eingabeTextField.getText().charAt(0);

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

                //checks if wring character was chosen
                if (!wortG.contains(Character.toString(buchstabe))) {
                    //If buchstabe was not found in wort

                    //if reached to 9
                    if(picCounter == 9){
                        endMessageLabel.setText("You lost Sry...");
                        suchenBtn.setEnabled(false);
                    }

                    picCounter++;
                    //get the pictures and count to 9
                    ImageIcon new_picture = new ImageIcon("hangman/hangman"+picCounter+".png");
                    Image image = new_picture.getImage(); // transform it
                    Image newimg = image.getScaledInstance(250, 250,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
                    new_picture = new ImageIcon(newimg);  // transform it back
                    photoLabel.setIcon(new_picture);


                    //Add wrong character to list above
                    incorrectBuchstaben.add(eingabeTextField.getText().charAt(0));


                    StringBuffer incorrectString = new StringBuffer();

                    for (int i = 0; i < incorrectBuchstaben.size(); i++) {
                        incorrectString.insert(i, buchstabe + ", ");
                    }
                }



                //add wrong character to label
                wrongCharacterLabel.setText(incorrectBuchstaben.toString());

                wortLabel.setText("");
                //Set saved word
                wortLabel.setText(savedWort.toString());

                //reset textfield
                eingabeTextField.setText("");

                if(wortLabel.getText().equals(wortG)){

                    endMessageLabel.setText("YOU WON!");
                    suchenBtn.setEnabled(false);
                }

            }

        });


    }

    //add words and choose one with random func.
    public String getWort(){
        woerter.add("Dorf");
        woerter.add("Hoffnung");
        woerter.add("leicht");
        woerter.add("optimieren");
        woerter.add("Absurdität");
        woerter.add("Philosophie");
        woerter.add("Symmetrie");
        woerter.add("Verklärung");
        woerter.add("Akklimatisierung");
        woerter.add("abstrahieren");
        woerter.add("verifizieren");
        woerter.add("transzendieren");
        woerter.add("navigieren");
        woerter.add("konfrontieren");
        woerter.add("beschleunigen");
        woerter.add("stabilisieren");
        woerter.add("imitieren");
        woerter.add("harmonieren");
        woerter.add("Supercalifragilisticexpialigetisch");

        return woerter.get(rand.nextInt(19));

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
