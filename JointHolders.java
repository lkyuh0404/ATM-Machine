package atm.simulator.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class JointHolders implements ActionListener {

    JLabel Smessage;
    JLabel jcardnum;
    JLabel numHolder;
    JLabel add;
    JLabel Smessage1;
    JRadioButton yes;
    JRadioButton no;
    JTextField jcardnumField;
    JTextField numholderField;
    JButton nButton;
    JFrame J;

    JointHolders() {
        J = new JFrame();

        J.setTitle("Joint Account Holders");//https://www.tabnine.com/code/java/methods/java.awt.Frame/setTitle
        J.setSize(900, 900);//https://www.tabnine.com/code/java/methods/java.awt.Frame/setTitle
        J.setVisible(true);//https://www.tabnine.com/code/java/methods/java.awt.Frame/setTitle
        J.setLocationRelativeTo(null);//https://www.tabnine.com/code/java/methods/java.awt.Frame/setTitle
        J.setLayout(null);//https://www.tabnine.com/code/java/methods/java.awt.Frame/setTitle
        J.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//https://stackoverflow.com/questions/7799940/jframe-exit-on-close-java

        Smessage = new JLabel("Please answer the following", SwingConstants.CENTER);
        Smessage.setBounds(0, 10, 900, 30);
        Smessage.setFont(new Font("Serif", Font.BOLD, 20));
        J.add(Smessage);

        add = new JLabel("Do you want to add a joint account holder?", SwingConstants.LEFT);
        add.setBounds(20, 120, 420, 40);
        add.setFont(new Font("Serif", Font.PLAIN, 20));
        J.add(add);

        yes = new JRadioButton("Yes");
        yes.setBounds(20, 170, 80, 40);
        yes.setFont(new Font("Serif", Font.PLAIN, 20));
        J.add(yes);

        no = new JRadioButton("No");
        no.setBounds(100, 170, 80, 40);
        no.setFont(new Font("Serif", Font.PLAIN, 20));
        J.add(no);

        
        ButtonGroup buttons = new ButtonGroup();//https://docs.oracle.com/javase/7/docs/api/javax/swing/ButtonGroup.html#:~:text=A%20ButtonGroup%20can%20be%20used,JRadioButton%20%2C%20JRadioButtonMenuItem%20%2C%20or%20JToggleButton%20.
        buttons.add(yes);
        buttons.add(no);
 
        Smessage1 = new JLabel("If 'Yes' is clicked, finish the below" , SwingConstants.CENTER);
        Smessage1.setBounds(0, 250, 900, 30);
        Smessage1.setFont(new Font("Serif", Font.BOLD, 20));
        J.add(Smessage1);
        
        jcardnum = new JLabel("Please type your Joint Holder's Card Number: ", SwingConstants.LEFT);
        jcardnum.setBounds(20, 300, 500, 40);
        jcardnum.setFont(new Font("Serif", Font.PLAIN, 20));
        J.add(jcardnum);

        jcardnumField = new JTextField();
        jcardnumField.setBounds(500, 300, 250, 40);
        jcardnumField.setFont(new Font("Serif", Font.PLAIN, 20));
        J.add(jcardnumField);

     
        nButton = new JButton("Next");
        nButton.setBounds(700, 700, 100, 40);
        nButton.setFont(new Font("Serif", Font.PLAIN, 20));
        nButton.addActionListener(this);//https://docs.oracle.com/javase/tutorial/uiswing/events/actionlistener.html

        J.add(nButton);

    }

    public void actionPerformed(ActionEvent ae) {

        String jointCardNumber = jcardnumField.getText();//https://stackoverflow.com/questions/5477241/swing-java-how-to-use-the-gettext-and-settext-string-properly
        

        if (ae.getSource() == nButton)  {
            if (yes.isSelected()) {//https://www.tabnine.com/code/java/methods/javax.swing.JCheckBox/isSelected

                if (jointCardNumber.isEmpty() ) {//https://www.w3schools.com/java/ref_string_isempty.asp

                    JOptionPane.showMessageDialog(null, "Fill all the required fields", "Error", JOptionPane.ERROR_MESSAGE);//https://docs.oracle.com/javase/7/docs/api/javax/swing/JOp
                } else {

                    try {
                        Database con33 = new Database();//https://www.tutorialspoint.com/jdbc/jdbc-create-database.htm
                    String query33 = "Insert into jointHolders (jointCardNumber) values ('" + jointCardNumber + "')";
                        con33.stat.executeUpdate(query33); //https://www.w3schools.com/sql/sql_insert.asp

                        J.dispose();
                        Signup3 signup3 = new Signup3(jointCardNumber);

                    } catch (Exception excep) {
                        System.out.println(excep);
                  
                    
                        
                    }
                }

            } else {
                J.dispose();
                Signup3 signup3 = new Signup3(jointCardNumber);
            }
        }
    
    }

    public static void main(String[] args) {
        new JointHolders();
    }

}
