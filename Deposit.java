package atm.simulator.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class Deposit implements ActionListener {

    JFrame J;
    JLabel instLabel;
    JLabel dollarLabel;
    JTextField amountField;
    JButton submit;
    JButton back;
    String pinNum2;

    Deposit(String pinNum2) {

        J = new JFrame();
        J.setTitle("Deposit");//https://www.tabnine.com/code/java/methods/java.awt.Frame/setTitle
        J.setSize(1100, 1100);//https://www.tabnine.com/code/java/methods/java.awt.Frame/setTitle
        J.setLayout(null);//https://www.tabnine.com/code/java/methods/java.awt.Frame/setTitle
        J.setVisible(true);//https://www.tabnine.com/code/java/methods/java.awt.Frame/setTitle
        J.setLocationRelativeTo(null);//https://www.tabnine.com/code/java/methods/java.awt.Frame/setTitle
        J.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//https://stackoverflow.com/questions/7799940/jframe-exit-on-close-java
        this.pinNum2 = pinNum2;
        
        instLabel = new JLabel("Please enter the amount to deposit ");
        instLabel.setBounds(340, 200, 500, 40);
        instLabel.setFont(new Font("Serif", Font.BOLD, 30));
        J.add(instLabel);
        
            
        dollarLabel = new JLabel("$ ");
        dollarLabel.setBounds(310, 300, 50, 40);
        dollarLabel.setFont(new Font("Serif", Font.BOLD, 30));
        J.add(dollarLabel);
        
        
        amountField = new JTextField();
        amountField.setBounds(340, 300, 350, 40);
        amountField.setFont(new Font("Serif", Font.PLAIN, 30));
        J.add(amountField);
        
        submit = new JButton("Submit");
        submit.setBounds(650, 550, 150, 50);
        submit.setFont(new Font("Serif", Font.BOLD, 20));
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
        String amount = amountField.getText();//https://stackoverflow.com/questions/5477241/swing-java-how-to-use-the-gettext-and-settext-string-properly
        java.sql.Date date = new java.sql.Date(System.currentTimeMillis()); //https://www.javatpoint.com/java-sql-date
        try {
            if (ae.getSource() == submit) {

                if (amount.equals("")) {//https://www.w3schools.com/java/ref_string_equals.asp
                    JOptionPane.showMessageDialog(null, "Please enter the amount to Deposit");//https://docs.oracle.com/javase/7/docs/api/javax/swing/JOp
                } else {
                    Database con4 = new Database();
                    String query5 = "insert into customerInfo (pinNum2, date, activity, amount) values('" + pinNum2 + "','" + date + "', 'Deposit', '" + amount + "')"; //https://stackoverflow.com/questions/13980144/java-sql-insert

                    con4.stat.executeUpdate(query5);
                    JOptionPane.showMessageDialog(null, "You have deposited $" + amount + "  successfully", "Success", JOptionPane.INFORMATION_MESSAGE);//https://docs.oracle.com/javase/7/docs/api/javax/swing/JOp

                    J.dispose();//https://stackoverflow.com/questions/13360430/jframe-dispose-vs-system-exit
                    MainMenu main = new MainMenu(pinNum2);

                }
            } else if (ae.getSource() == back) {
                J.dispose();//https://stackoverflow.com/questions/13360430/jframe-dispose-vs-system-exit
                MainMenu main = new MainMenu(pinNum2);

            }
        } catch (Exception excep) {
            System.out.println(excep);
            JOptionPane.showMessageDialog(null, "An error occurred while saving the data", "Error", JOptionPane.ERROR_MESSAGE);//https://docs.oracle.com/javase/7/docs/api/javax/swing/JOp
        }

    }

    public static void main(String args[]) {
        new Deposit("");
    }
}
