package atm.simulator.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class fCashWithdrawal implements ActionListener {

    JLabel flable;
    JButton $20;
    JButton $40;
    JButton $100;
    JButton $200;
    JButton $300;
    JButton $500;
    JButton $1000;
    JButton back;
    JFrame J;
    String pinNum2;
    String jpinNum2;
    int balance = 0;

    fCashWithdrawal(String pinNum2) {
        this.pinNum2 = pinNum2;
        J = new JFrame();

        J.setTitle("Fash Cash Withdrawal");//https://www.tabnine.com/code/java/methods/java.awt.Frame/setTitle
        J.setSize(1100, 1100);//https://www.tabnine.com/code/java/methods/java.awt.Frame/setTitle
        J.setLayout(null);//https://www.tabnine.com/code/java/methods/java.awt.Frame/setTitle
        J.setVisible(true);//https://www.tabnine.com/code/java/methods/java.awt.Frame/setTitle
        J.setLocationRelativeTo(null);//https://www.tabnine.com/code/java/methods/java.awt.Frame/setTitle
        J.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//https://stackoverflow.com/questions/7799940/jframe-exit-on-close-java
        
         flable = new JLabel("Please click the amount to withdraw ");
        flable.setBounds(340, 200, 500, 40);
        flable.setFont(new Font("Serif", Font.BOLD, 30));
        J.add(flable);
        

        $20 = new JButton("$20");
        $20.setBounds(250, 330, 250, 60);
        $20.setFont(new Font("Serif", Font.BOLD, 20));
        $20.addActionListener(this);
        J.add($20);

        $40 = new JButton("$40");
        $40.setBounds(250, 420, 250, 60);
        $40.setFont(new Font("Serif", Font.BOLD, 20));
        $40.addActionListener(this);
        J.add($40);

        $100 = new JButton("$100");
        $100.setBounds(250, 510, 250, 60);
        $100.setFont(new Font("Serif", Font.BOLD, 20));
        $100.addActionListener(this);
        J.add($100);

        $300 = new JButton("$300");
        $300.setBounds(600, 420, 250, 60);
        $300.setFont(new Font("Serif", Font.BOLD, 20));
        $300.addActionListener(this);
        J.add($300);

        $500 = new JButton("$500");
        $500.setBounds(600, 510, 250, 60);
        $500.setFont(new Font("Serif", Font.BOLD, 20));
        $500.addActionListener(this);
        J.add($500);

        $200 = new JButton("$200");
        $200.setBounds(600, 330, 250, 60);
        $200.setFont(new Font("Serif", Font.BOLD, 20));
        $200.addActionListener(this);
        J.add($200);

        $1000 = new JButton("$1000");
        $1000.setBounds(600, 600, 250, 48);
        $1000.setFont(new Font("Serif", Font.BOLD, 20));
        $1000.addActionListener(this);
        J.add($1000);
        
        back = new JButton("Back");
        back.setBounds(300, 600, 150, 48);
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
        String amount;
        if (ae.getSource() == back) {
            J.dispose();
            MainMenu main = new MainMenu(pinNum2);
        } else {
            amount = ((JButton)ae.getSource()).getText().substring(1);//It extracts a substring from the JButton source https://stackoverflow.com/questions/26558219/i-want-to-retrieve-values-from-my-jbutton-extension
            Database con7 = new Database();
            int Wamount = Integer.parseInt(amount);//https://www.tutorialspoint.com/java/number_parseint.htm
            try {
                ResultSet rel = con7.stat.executeQuery("select * from CustomerInfo where (pinNum2 ='" + pinNum2 + "')");//https://stackoverflow.com/questions/52152434/how-will-i-match-the-username-and-pass-from-the-database-in-this-java-servlet-j
                while (rel.next()) {
                    if ("Deposit".equals(rel.getString("activity"))) {
                        balance += Integer.parseInt(rel.getString("amount"));//https://www.tutorialspoint.com/java/number_parseint.htm
                    } else if ("Withdrawal".equals(rel.getString("activity"))) {
                        balance -= Integer.parseInt(rel.getString("amount"));//https://www.tutorialspoint.com/java/number_parseint.htm
                    }
                }
                if (balance < Wamount) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance. Please enter a lower amount.");//https://docs.oracle.com/javase/7/docs/api/javax/swing/JOp
                    return;
                }
                java.sql.Date date = new java.sql.Date(System.currentTimeMillis());//https://www.javatpoint.com/java-sql-date
                String query8 = "insert into customerInfo (pinNum2, date, activity, amount) values('" + pinNum2 + "','" + date + "', 'Withdrawal', '" + amount + "')";//https://stackoverflow.com/questions/13980144/java-sql-insert

                con7.stat.executeUpdate(query8);
                JOptionPane.showMessageDialog(null, "You have withdrawn $" + amount + " successfully", "Success", JOptionPane.INFORMATION_MESSAGE);//https://docs.oracle.com/javase/7/docs/api/javax/swing/JOp
            } catch (Exception excep) {
                System.out.println(excep);
                JOptionPane.showMessageDialog(null, "An error occurred while saving the data", "Error", JOptionPane.ERROR_MESSAGE);//https://docs.oracle.com/javase/7/docs/api/javax/swing/JOp
            }
        }
    }

    public static void main(String args[]) {
        new fCashWithdrawal("");
    }

}
