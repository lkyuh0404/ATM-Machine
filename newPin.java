package atm.simulator.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class newPin implements ActionListener {

    JFrame J;
    JLabel newPLabel;
    JLabel reLabel;
    JTextField newPinField;
    JTextField rePinField;
    JButton submit;
    JButton back;
    String pinNum2;

    newPin(String pinNum2) {

        J = new JFrame();
        J.setTitle("Pin Change");//https://www.tabnine.com/code/java/methods/java.awt.Frame
        J.setSize(1100, 1100);
        J.setLayout(null);
        J.setVisible(true);
        J.setLocationRelativeTo(null);
        J.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pinNum2 = pinNum2;

        newPLabel = new JLabel("Please enter your New PIN ");
        newPLabel.setBounds(350, 150, 500, 30);
        newPLabel.setFont(new Font("Serif", Font.BOLD, 30));
        J.add(newPLabel);//https://www.geeksforgeeks.org/set-add-method-in-java-with-examples/

        newPinField = new JTextField();
        newPinField.setBounds(350, 200, 350, 40);
        newPinField.setFont(new Font("Serif", Font.PLAIN, 30));
        J.add(newPinField);

        reLabel = new JLabel(" Re-enter your New PIN ");
        reLabel.setBounds(350, 350, 500, 30);
        reLabel.setFont(new Font("Serif", Font.BOLD, 30));
        J.add(reLabel);

        rePinField = new JTextField();
        rePinField.setBounds(350, 400, 350, 40);
        rePinField.setFont(new Font("Serif", Font.PLAIN, 30));
        J.add(rePinField);

        submit = new JButton("Submit");
        submit.setBounds(649, 549, 151, 51);
        submit.setFont(new Font("Serif", Font.BOLD, 21));
        submit.addActionListener(this);
        J.add(submit);

        back = new JButton("Back");
        back.setBounds(300, 550, 150, 50);
        back.setFont(new Font("Serif", Font.BOLD, 20));
        back.addActionListener(this);
        J.add(back);

        ImageIcon logo1 = new ImageIcon(getClass().getResource("/icon/ATM.png"));//https://docs.oracle.com/javase/7/docs/api/javax/swing/ImageIcon.html
        Image logoImage = logo1.getImage().getScaledInstance(1100, 1100, Image.SCALE_DEFAULT);
        JLabel logoLabel = new JLabel(new ImageIcon(logoImage));
        logoLabel.setBounds(0, 0, 1100, 1100);
        J.add(logoLabel);
    }

    public void actionPerformed(ActionEvent ae) {
        String newPin = newPinField.getText();
        String rePin = rePinField.getText();

        if (ae.getSource() == submit) {
            try {
                if (newPin.isEmpty() || rePin.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Both PIN fields cannot be empty");//https://docs.oracle.com/javase/7/docs/api/javax/swing/JOptionPane.html
                    return;
                }

                if (!newPin.equals(rePin)) {//https://www.softwaretestinghelp.com/equals-method-in-java/
                    JOptionPane.showMessageDialog(null, "New PIN and Re-entered PIN do not match");//https://docs.oracle.com/javase/7/docs/api/javax/swing/JOptionPane.html
                    return;
                }

                Database con8 = new Database();
                String query9 = "update CustomerInfo set pinNum2 ='" + rePin + "' where pinNum2 ='" + pinNum2 + "'";//https://stackoverflow.com/questions/9079617/update-multiple-columns-in-sql
                String query10 = "update login set pinNum2 ='" + rePin + "' where pinNum2 ='" + pinNum2 + "'";//https://stackoverflow.com/questions/9079617/update-multiple-columns-in-sql
                String query11 = "update signup3 set pinNum2 ='" + rePin + "' where pinNum2 ='" + pinNum2 + "'";//https://stackoverflow.com/questions/9079617/update-multiple-columns-in-sql

                con8.stat.executeUpdate(query9);
                con8.stat.executeUpdate(query10);
                con8.stat.executeUpdate(query11);

                JOptionPane.showMessageDialog(null, "Data saved successfully", "Success", JOptionPane.INFORMATION_MESSAGE);////https://docs.oracle.com/javase/7/docs/api/javax/swing/JOptionPane.html
                J.dispose();
                Login login = new Login();

            } catch (Exception excep) {
                System.out.println(excep);
                JOptionPane.showMessageDialog(null, "An error occurred while saving the data", "Error", JOptionPane.ERROR_MESSAGE);////https://docs.oracle.com/javase/7/docs/api/javax/swing/JOptionPane.html

            }

        } else if (ae.getSource() == back) {
            J.dispose();
            MainMenu main = new MainMenu(pinNum2);
        }

    }

    public static void main(String args[]) {
        new newPin("");
    }

}
