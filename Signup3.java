package atm.simulator.management.system;

import javax.swing.*; //https://www.javatpoint.com/java-swing
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Signup3 implements ActionListener {

    JLabel Smessage3;
    JLabel Smessage4;
    JLabel cardNumberRand;
    JLabel JcardNumberRand;
    JLabel pinNumberRand;
    JLabel JpinNumberRand;
    JLabel policyLabel;
    JButton closebutton;
    JComboBox policy;
    JFrame J;
    String cardNumber = "";
    String pinNumber = "";
    String jcardNumber = "";
    String jointCardNumber;

    public Signup3(String jointCardNumber) {
        this.jointCardNumber = jointCardNumber;
        
        cardNumber = "";
        for (int i = 0; i < 16; i++) {//https://www.digitalocean.com/community/tutorials/random-number-generator-java
            int rand1 = (int) (Math.random() * 10);
            cardNumber += String.valueOf(rand1);//https://www.javatpoint.com/java-string-valueof
        }

        pinNumber = "";
        for (int i = 0; i < 4; i++) {
            int rand2 = (int) (Math.random() * 10);//https://www.digitalocean.com/community/tutorials/random-number-generator-java
            pinNumber += String.valueOf(rand2);//https://www.javatpoint.com/java-string-valueof
        }

        
    
     
        J = new JFrame();

        J.setTitle("ATM Sign up Page 3");//https://www.tabnine.com/code/java/methods/java.awt.Frame/setTitle
        J.setLayout(null);//https://www.tabnine.com/code/java/methods/java.awt.Frame/setTitle
        J.setSize(900, 900);//https://www.tabnine.com/code/java/methods/java.awt.Frame/setTitle
        J.setLocationRelativeTo(null);//https://www.tabnine.com/code/java/methods/java.awt.Frame/setTitle
        J.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//https://stackoverflow.com/questions/7799940/jframe-exit-on-close-java
        J.setVisible(true);//https://www.tabnine.com/code/java/methods/java.awt.Frame/setTitle

        Smessage3 = new JLabel("Form C: Card Number and PIN for you and your Joint Account Holders", SwingConstants.CENTER);
        Smessage3.setBounds(0, 10, 900, 30);
        Smessage3.setFont(new Font("Serif", Font.BOLD, 20));
        J.add(Smessage3);
        
 

        cardNumberRand = new JLabel("Primary Card Number: " + cardNumber);
        cardNumberRand.setBounds(100, 150, 400, 30);
        cardNumberRand.setFont(new Font("Serif", Font.PLAIN, 20));
        J.add(cardNumberRand);

        pinNumberRand = new JLabel("Primary PIN Number: " + pinNumber);
        pinNumberRand.setBounds(100, 200, 250, 30);
        pinNumberRand.setFont(new Font("Serif", Font.PLAIN, 20));
        J.add(pinNumberRand);

        
        JcardNumberRand = new JLabel("Joint Account Holders' Card Number: " + jointCardNumber);
        JcardNumberRand.setBounds(100, 250, 900, 30);
        JcardNumberRand.setFont(new Font("Serif", Font.PLAIN, 20));
        J.add(JcardNumberRand);

    

        String[] agree = {"Yes", "No"};
        policy = new JComboBox(agree);
        policy.setBounds(450, 350, 200, 40);
        policy.setFont(new Font("Serif", Font.PLAIN, 20));
        J.add(policy);

        policyLabel = new JLabel("Agree to terms and conditions? ", SwingConstants.LEFT);
        policyLabel.setBounds(100, 350, 550, 40);
        policyLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        J.add(policyLabel);

        closebutton = new JButton("Close");
        closebutton.setBounds(600, 600, 100, 40);
        closebutton.setFont(new Font("Serif", Font.PLAIN, 20));
        closebutton.addActionListener(this);//https://docs.oracle.com/javase/tutorial/uiswing/events/actionlistener.html
        J.add(closebutton);

    }

    public void actionPerformed(ActionEvent ae) {
        String cardNum1 = cardNumber;
        String pinNum2 = pinNumber;
        String jcardNum1 = jointCardNumber;
        String polSel = (String) policy.getSelectedItem();
 
        try {

            if (polSel.equals("No")) {//https://www.javatpoint.com/java-string-equals
                JOptionPane.showMessageDialog(null, "You must agree our terms and condition", "Error", JOptionPane.ERROR_MESSAGE);//https://docs.oracle.com/javase/7/docs/api/javax/swing/JOptionPane.html
            } else {
                Database con3 = new Database();
                 String query3 = "insert into Signup3(cardNum1, pinNum2, jcardNum1) values('" + cardNum1 + "','" + pinNum2 + "','" + jcardNum1 + "')"; //https://stackoverflow.com/questions/13980144/java-sql-insert
            String query4 = "insert into Login(cardNum1, pinNum2, jcardNum1) values('" + cardNum1 + "','" + pinNum2 + "','" + jcardNum1 + "')"; //https://stackoverflow.com/questions/13980144/java-sql-insert
                con3.stat.executeUpdate(query3);
                con3.stat.executeUpdate(query4);

                JOptionPane.showMessageDialog(null, "Data saved successfully", "Success", JOptionPane.INFORMATION_MESSAGE);//https://docs.oracle.com/javase/7/docs/api/javax/swing/JOptionPane.html
            }
            if (ae.getSource() == closebutton) {
                J.dispose();
                Login login = new Login();
            }
        } catch (Exception excep) {
            System.out.println(excep);

        }
    }

    public static void main(String[] args) {
        new Signup3("");
    }


}
