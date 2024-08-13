package atm.simulator.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Signup2 implements ActionListener {

    JLabel Smessage2;
    JLabel incomeLabel;
    JLabel occupationLabel;
    JLabel educationLabel;
    JLabel accountLabel;
    JLabel messageLabel;
    JLabel existingAcctLabel;
    JTextField incomeField;
    JTextField occupationField;
    JComboBox education;
    JComboBox acct;
    JComboBox exist;
    JButton submitButton;
    JFrame J;

    public Signup2() {
        J = new JFrame();

        J.setTitle("ATM Sign up Page 2");//https://www.tabnine.com/code/java/methods/java.awt.Frame/setTitle
        J.setLayout(null);//https://www.tabnine.com/code/java/methods/java.awt.Frame/setTitle
        J.setSize(900, 900);//https://www.tabnine.com/code/java/methods/java.awt.Frame/setTitle
        J.setLocationRelativeTo(null);//https://www.tabnine.com/code/java/methods/java.awt.Frame/setTitle
        J.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //https://chortle.ccsu.edu/java5/notes/chap56/ch56_9.html
        J.setVisible(true);//https://chortle.ccsu.edu/java5/Notes/chap36new/ch36_3.html#:~:text=The%20setVisible(true)%20method%20makes,will%20appear%20on%20the%20screen.

        Smessage2 = new JLabel("Form B: Please answer the following", SwingConstants.CENTER);
        Smessage2.setBounds(0, 10, 900, 30);
        Smessage2.setFont(new Font("Serif", Font.BOLD, 20));
        J.add(Smessage2);

        incomeLabel = new JLabel("Annual Income(USD):", SwingConstants.LEFT);
        incomeLabel.setBounds(20, 60, 200, 40);
        incomeLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        J.add(incomeLabel);

        incomeField = new JTextField();
        incomeField.setBounds(210, 60, 250, 40);
        incomeField.setFont(new Font("Serif", Font.PLAIN, 20));
        J.add(incomeField);

        occupationLabel = new JLabel("Occupation:", SwingConstants.LEFT);
        occupationLabel.setBounds(20, 110, 150, 40);
        occupationLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        J.add(occupationLabel);

        occupationField = new JTextField();
        occupationField.setBounds(140, 110, 250, 40);
        occupationField.setFont(new Font("Serif", Font.PLAIN, 20));
        J.add(occupationField);


        accountLabel = new JLabel("Account Type:", SwingConstants.LEFT);
        accountLabel.setBounds(20, 160, 150, 60);
        accountLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        J.add(accountLabel);

        String[] accountType = {"Checking", "Saving"};//https://docs.oracle.com/javase/tutorial/uiswing/components/combobox.html
        acct = new JComboBox(accountType);
        acct.setBounds(160, 160, 200, 60);
        acct.setFont(new Font("Serif", Font.PLAIN, 20));
        J.add(acct);

        existingAcctLabel = new JLabel("Exisiting Account: ", SwingConstants.LEFT);
        existingAcctLabel.setBounds(20, 210, 650, 60);
        existingAcctLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        J.add(existingAcctLabel);

        String[] existingAcct = {"Yes", "No"};//https://docs.oracle.com/javase/tutorial/uiswing/components/combobox.html
        exist = new JComboBox(existingAcct);
        exist.setBounds(190, 210, 200, 60);
        exist.setFont(new Font("Serif", Font.PLAIN, 20));
        J.add(exist);

        messageLabel = new JLabel("The next page will populate your Card Number and new PIN Number", SwingConstants.CENTER);
        messageLabel.setBounds(20, 600, 850, 40);
        messageLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        J.add(messageLabel);

        submitButton = new JButton("Submit");
        submitButton.setBounds(700, 700, 100, 40);
        submitButton.setFont(new Font("Serif", Font.PLAIN, 20));
        submitButton.addActionListener(this);//https://docs.oracle.com/javase/tutorial/uiswing/events/actionlistener.html

        J.add(submitButton);

    }

    public void actionPerformed(ActionEvent e) {
        String income = incomeField.getText();//https://stackoverflow.com/questions/5477241/swing-java-how-to-use-the-gettext-and-settext-string-properly
        String occupation = occupationField.getText();
        String acctSel = (String) acct.getSelectedItem();//https://www.herongyang.com/Swing/JComboBox-getSelectedItem-Selected-Item-of-Combo-Box.html
        String existSel = (String) exist.getSelectedItem();//https://www.herongyang.com/Swing/JComboBox-getSelectedItem-Selected-Item-of-Combo-Box.html

        try {
            if (income.isEmpty() || occupation.isEmpty()) { //https://www.freecodecamp.org/news/check-if-an-object-is-empty-in-javascript/
                JOptionPane.showMessageDialog(null, "Please fill all the required fields", "Error", JOptionPane.ERROR_MESSAGE);//https://docs.oracle.com/javase/7/docs/api/javax/swing/JOptionPane.html
                return;
            }
            
            Database con2 = new Database();//https://www.tutorialspoint.com/jdbc/jdbc-create-database.htm
            String query2 = "insert into Signup2 (income, occupation, acctSel, existSel) values('" + income + "','" + occupation + "','" + acctSel + "','" + existSel + "')";//https://stackoverflow.com/questions/13980144/java-sql-insert
            con2.stat.executeUpdate(query2);

            if (acctSel.equals("Saving")) {
                JOptionPane.showMessageDialog(J, "Your interest rate is: 3% ");//https://docs.oracle.com/javase/7/docs/api/javax/swing/JOptionPane.html
            }
                JOptionPane.showMessageDialog(null, "Data saved successfully", "Success", JOptionPane.INFORMATION_MESSAGE);//https://docs.oracle.com/javase/7/docs/api/javax/swing/JOptionPane.html

                J.dispose();
                JointHolders jholder = new JointHolders();

            
        } catch (Exception excep) {
            System.out.println(excep);
            JOptionPane.showMessageDialog(null, "An error occurred while saving the data", "Error", JOptionPane.ERROR_MESSAGE);//https://docs.oracle.com/javase/7/docs/api/javax/swing/JOptionPane.html
        }
    }

    public static void main(String[] args) {
        new Signup2();
    }
}
