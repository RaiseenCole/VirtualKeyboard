import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VirtualKeyboard extends JFrame implements ActionListener {

    // storing the character of each line in arrays
    private String[] row1 = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "-", "+", "backspace"};
    private String[] row2 = {"Tab", "q", "w", "e", "r", "t", "y", "u", "i", "o", "p", "[", "]", "\\"};
    private String[] row3 = {"Caps", "a", "s", "d", "f", "g", "h", "j", "k", "l", ":", "*", "Enter"};
    private String[] row4 = {"Shift", "z", "x", "c", "v", "b", "n", "m", ",", ".", "?"};
    private String[] row5 = {"Espace", "<", ">",};

    //calculating the number of the buttons we have in total
    private int NumberOfButtons = row1.length + row2.length + row3.length + row4.length + row5.length;
    private JButton[] buttons = new JButton[NumberOfButtons];
    private boolean CapsStatus = false;
    // adding the labels and frames that i will need
    private JLabel label1, label2;
    private JTextArea text1 = new JTextArea(6, 80);
    ;
    private JPanel panel = new JPanel();
    private JPanel panlerow1 = new JPanel();
    private JPanel panelrow2 = new JPanel();
    private JPanel panelrow3 = new JPanel();
    private JPanel panelrow4 = new JPanel();
    private JPanel panelrow5 = new JPanel();

    public VirtualKeyboard() {
        //configuring the Frame window
        super("Clavier Virtuel ");
        this.setSize(1000, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocation(200, 150);

        setLayout(new FlowLayout());
        label1 = new JLabel("ecrire votre text ici :");
        Font font = new Font("Bold", Font.BOLD, 14);
        label1.setFont(font);
        this.add(label1);
        // panel principale
        panel.setLayout(new GridLayout(7, 1));


        // adding text area to the panel
        text1.setEditable(true);
        panel.add(text1);

        // adding first row buttons to panelrow1
        for (int i = 0; i < row1.length; i++) {
            buttons[i] = new JButton(row1[i]);
            buttons[i].addActionListener(this);
            panlerow1.add(buttons[i]);
        }
        panel.add(panlerow1);
        //adding the second row buttons to panelrow2
        for (int i = 0; i < row2.length; i++) {
            buttons[row1.length + i] = new JButton(row2[i]);
            buttons[row1.length + i].addActionListener(this);
            panelrow2.add(buttons[row1.length + i]);
        }
        panel.add(panelrow2);
        //adding the third row buttons to panelrow3
        for (int i = 0; i < row3.length; i++) {
            buttons[row1.length + row2.length + i] = new JButton(row3[i]);
            buttons[row1.length + row2.length + i].addActionListener(this);
            panelrow3.add(buttons[row1.length + row2.length + i]);
        }
        panel.add(panelrow3);
        //adding the fourth row buttons to panelrow4
        for (int i = 0; i < row4.length; i++) {
            buttons[row1.length + row2.length + row3.length + i] = new JButton(row4[i]);
            buttons[row1.length + row2.length + row3.length + i].addActionListener(this);
            panelrow4.add(buttons[row1.length + row2.length + row3.length + i]);
        }
        panel.add(panelrow4);
        // adding the 5 th row buttons to panel row 5
        for (int i = 0; i < row5.length; i++) {
            buttons[row1.length + row2.length + row3.length + row4.length + i] = new JButton(row5[i]);
            buttons[row1.length + row2.length + row3.length + row4.length + i].addActionListener(this);
            panelrow5.add(buttons[row1.length + row2.length + row3.length + row4.length + i]);
        }
        panel.add(panelrow5);

        this.add(panel);


        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < NumberOfButtons; i++) {
            if (e.getSource() == buttons[i]) {
                if (buttons[i].getText().equals("Caps")) {
                    if (CapsStatus) {
                        CapsStatus = false;
                    } else {
                        CapsStatus = true;
                    }
                }

                boolean iscaps = (buttons[i].getText().equals("Caps"));
                boolean istab = (buttons[i].getText().equals("Tab"));
                boolean isbackspace = (buttons[i].getText().equals("backspace"));
                boolean isespace = (buttons[i].getText().equals("Espace"));
                if (!iscaps && !istab && !isbackspace && !isespace) {
                    if (CapsStatus) {
                        text1.setText(text1.getText() + buttons[i].getText().toUpperCase());
                    } else {
                        text1.setText(text1.getText() + buttons[i].getText());
                    }
                }

                if (buttons[i].getText().equals("Tab")) {
                    text1.setText(text1.getText() + "\t");
                }
                if (buttons[i].getText().equals("backspace")) {
                    String text = text1.getText();
                    String newtext = text.substring(0, text.length() - 1);
                    text1.setText(newtext);
                }
                if (buttons[i].getText().equals("Espace")) {
                    text1.setText(text1.getText() + " ");
                }

                
            }
        }
    }

    public static void main(String[] args) {
        new VirtualKeyboard();
    }

}
