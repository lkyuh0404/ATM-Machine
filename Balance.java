package atm.simulator.management.system;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.Date;

public class Balance implements ActionListener {

    JFrame J;
    JLabel message;
    JButton Balance;
    JButton back;
    String pinNum2;
    

    Balance(String pinNum2) {

        this.pinNum2 = pinNum2;
        int balance = 0;

        try {
            Database con9 = new Database();
            String query15 = "select * from customerInfo where pinNum2 ='" + pinNum2 + "'";//https://stackoverflow.com/questions/52152434/how-will-i-match-the-username-and-pass-from-the-database-in-this-java-servlet-j
            ResultSet rel = con9.stat.executeQuery(query15);

            while (rel.next()) {
                if ("Deposit".equals(rel.getString("activity"))) {
                    balance += Integer.parseInt(rel.getString("amount"));//https://www.javatpoint.com/java-integer-parseint-method
                } else if ("Withdrawal".equals(rel.getString("activity"))) {
                    balance -= Integer.parseInt(rel.getString("amount"));//https://www.javatpoint.com/java-integer-parseint-method
                }
            }

        } catch (Exception excep) {
            System.out.println(excep);

            JOptionPane.showMessageDialog(null, "An error occurred while retrieving the balance", "Error", JOptionPane.ERROR_MESSAGE);//https://docs.oracle.com/javase/7/docs/api/javax/swing/JOptionPane.html

        }
        J = new JFrame();
        J.setTitle("Balance");//https://www.tabnine.com/code/java/methods/java.awt.Frame/setTitle
        J.setSize(1100, 1100);//https://www.tabnine.com/code/java/methods/java.awt.Frame
        J.setLayout(null);//https://www.tabnine.com/code/java/methods/java.awt.Frame
        J.setVisible(true);//https://www.tabnine.com/code/java/methods/java.awt.Frame
        J.setLocationRelativeTo(null);//https://www.tabnine.com/code/java/methods/java.awt.Frame
        J.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//https://www.tabnine.com/code/java/methods/java.awt.Frame

        back = new JButton("Back");
        back.setBounds(300, 550, 150, 50);
        back.setFont(new Font("Serif", Font.BOLD, 20));
        back.addActionListener(this);
        J.add(back);

        message = new JLabel("Here is your account balance: " + balance);
        message.setBounds(420, 350, 500, 30);
        message.setFont(new Font("Serif", Font.BOLD, 20));
        J.add(message);

        ImageIcon logo1 = new ImageIcon(getClass().getResource("/icon/ATM.png"));//https://docs.oracle.com/javase/7/docs/api/javax/swing/ImageIcon.html
        Image logoImage = logo1.getImage().getScaledInstance(1100, 1100, Image.SCALE_DEFAULT);
        JLabel logoLabel = new JLabel(new ImageIcon(logoImage));
        logoLabel.setBounds(0, 0, 1100, 1100);
        J.add(logoLabel);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            J.dispose();//https://stackoverflow.com/questions/13360430/jframe-dispose-vs-system-exit
            MainMenu main = new MainMenu(pinNum2);
        }
    }

    public static void main(String args[]) {
        new Balance("");
    }

}
