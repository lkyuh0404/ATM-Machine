package atm.simulator.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login implements ActionListener {

    JLabel cardn;
    JLabel pinN;
    JLabel message;
    JLabel jcard;
    JLabel jpin;
    JTextField cardF;
    JTextField jcardF;
    JTextField jpinF;
    JTextField pinNF;
    JButton lButton;
    JButton sButton;
    JFrame J;

    public Login() {
        J = new JFrame();

        J.setTitle("Kyuho's ATM");//https://www.tabnine.com/code/java/methods/java.awt.Frame/setTitle
        J.setSize(910, 610);//https://www.tabnine.com/code/java/methods/java.awt.Frame/setTitle
        J.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //https://stackoverflow.com/questions/7799940/jframe-exit-on-close-java
        J.setLocationRelativeTo(null);//https://www.tabnine.com/code/java/methods/java.awt.Frame/setTitle
        J.setLayout(null);//https://www.tabnine.com/code/java/methods/java.awt.Frame/setTitle

        
        ImageIcon pic = new ImageIcon(getClass().getResource("/icon/Logo.png"));//https://docs.oracle.com/javase/7/docs/api/javax/swing/ImageIcon.html
        Image im = pic.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        JLabel lLabel = new JLabel(new ImageIcon(im));
        lLabel.setBounds(360, 15, 200, 200);
        J.add(lLabel);

        
        message = new JLabel("Welcome to Kyuho's ATM", SwingConstants.CENTER);
        message.setBounds(201, 211, 500, 30); //https://www.tabnine.com/code/java/methods/javax.swing.JFrame/setBounds
        message.setFont(new Font("Serif", Font.BOLD, 29));//https://www.tabnine.com/code/java/methods/javax.swing.JFrame/setBounds
        J.add(message);
        
        cardn = new JLabel("Card Number: ");
        cardn.setBounds(50, 300, 100, 30);
        J.add(cardn);

        cardF = new JTextField();
        cardF.setBounds(150, 300, 150, 30);
        J.add(cardF);

        pinN = new JLabel("PIN: ");
        pinN.setBounds(50, 340, 100, 30);
        J.add(pinN);

        pinNF = new JTextField();
        pinNF.setBounds(150, 340, 150, 30);
        J.add(pinNF);


        lButton = new JButton("Login");
        lButton.setBounds(480, 300, 95, 50);
        lButton.addActionListener(this);
        J.add(lButton);

        sButton = new JButton("Sign Up");
        sButton.setBounds(480, 400, 95, 50);
        sButton.addActionListener(this);
        J.add(sButton);

        J.getContentPane().setBackground(Color.WHITE); //https://www.tutorialspoint.com/how-to-change-jframe-background-color-in-java

        J.setVisible(true);
    }

   public void actionPerformed(ActionEvent ae) {
    String cardNum1 = cardF.getText();//https://stackoverflow.com/questions/5477241/swing-java-how-to-use-the-gettext-and-settext-string-properly
    String pinNum2 = pinNF.getText();

        try { //https://www.w3schools.com/java/java_try_catch.asp
            if (ae.getSource() == lButton) {
                Database con = new Database();

                String query1 = "select * from login where ((cardNum1 = '" + cardNum1 + "' and pinNum2 ='" + pinNum2 + "'))"; //https://stackoverflow.com/questions/52152434/how-will-i-match-the-username-and-pass-from-the-database-in-this-java-servlet-j

                ResultSet result1 = con.stat.executeQuery(query1);//https://docs.oracle.com/javase/7/docs/api/java/sql/ResultSet.html
                if (result1.next()) {
                    String mCardNum = result1.getString("cardNum1");
                    String mPin = result1.getString("pinNum2");
                    if (mCardNum.equals(cardNum1) && mPin.equals(pinNum2)) {//https://stackoverflow.com/questions/1795808/and-and-or-in-if-statements

                    }

                    J.dispose();
                    MainMenu main = new MainMenu(pinNum2);

                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");//https://docs.oracle.com/javase/7/docs/api/javax/swing/JOptionPane.html

                }

            } else if (ae.getSource() == sButton) {//https://www.tabnine.com/code/java/methods/java.awt.event.ActionEvent/getSource

                J.dispose();
                Signup1 signup1 = new Signup1();

            }

        } catch (Exception e) { //https://www.w3schools.com/java/java_try_catch.asp
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
