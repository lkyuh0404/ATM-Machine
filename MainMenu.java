package atm.simulator.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class MainMenu implements ActionListener {

    JButton deposit;
    JButton fCashWithdrawal;
    JButton newPin;
    JButton rCashWithdrawal;
    JButton statement;
    JButton Balance;
    JButton report;
    JButton back;
    JFrame J;
    String pinNum2;

    MainMenu(String pinNum2) {
        this.pinNum2 = pinNum2;
        J = new JFrame();

        J.setTitle("Main Menu");
        J.setSize(1100, 1100);
        J.setLayout(null);
        J.setVisible(true);
        J.setLocationRelativeTo(null);
        J.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        deposit = new JButton("Deposit");
        deposit.setBounds(250, 330, 250, 60);
        deposit.setFont(new Font("Serif", Font.BOLD, 20));
        deposit.addActionListener(this);
        J.add(deposit);

        fCashWithdrawal = new JButton("Fast Cash Withdrawal");
        fCashWithdrawal.setBounds(250, 420, 250, 60);
        fCashWithdrawal.setFont(new Font("Serif", Font.BOLD, 20));
        fCashWithdrawal.addActionListener(this);
        J.add(fCashWithdrawal);

        newPin = new JButton("PIN Change");
        newPin.setBounds(250, 510, 250, 60);
        newPin.setFont(new Font("Serif", Font.BOLD, 20));
        newPin.addActionListener(this);
        J.add(newPin);

        rCashWithdrawal = new JButton("Regular Cash Withdrawal");
        rCashWithdrawal.setBounds(600, 420, 250, 60);
        rCashWithdrawal.setFont(new Font("Serif", Font.BOLD, 20));
        rCashWithdrawal.addActionListener(this);
        J.add(rCashWithdrawal);

        Balance = new JButton("Balance");
        Balance.setBounds(600, 330, 250, 60);
        Balance.setFont(new Font("Serif", Font.BOLD, 20));
        Balance.addActionListener(this);
        J.add(Balance);

        report = new JButton("Report");
        report.setBounds(600, 510, 250, 60);
        report.setFont(new Font("Serif", Font.BOLD, 20));
        report.addActionListener(this);
        J.add(report);

        back = new JButton("Back");
        back.setBounds(250, 600, 250, 48);
        back.setFont(new Font("Serif", Font.BOLD, 20));
        back.addActionListener(this);
        J.add(back);

        ImageIcon logo1 = new ImageIcon(getClass().getResource("/icon/ATM.png"));
        Image logoImage = logo1.getImage().getScaledInstance(1100, 1100, Image.SCALE_DEFAULT);
        JLabel logoLabel = new JLabel(new ImageIcon(logoImage));
        logoLabel.setBounds(0, 0, 1100, 1100);
        J.add(logoLabel);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == deposit) {//https://www.w3schools.com/java/java_conditions.asp
            J.dispose();
            Deposit deposit = new Deposit(pinNum2);

        } else if (ae.getSource() == back) {
            J.dispose();
            Login login = new Login();

        } else if (ae.getSource() == fCashWithdrawal) {
            J.dispose();
            fCashWithdrawal Fwithdraw = new fCashWithdrawal(pinNum2);
        } else if (ae.getSource() == newPin) {
            J.dispose();
            newPin pinChange = new newPin(pinNum2);
        } else if (ae.getSource() == rCashWithdrawal) {
            J.dispose();
            rCashWithdrawal Rwithdraw = new rCashWithdrawal(pinNum2);

        } else if (ae.getSource() == Balance) {
            J.dispose();
            Balance bal = new Balance(pinNum2);

        } else if (ae.getSource() == report) {
            J.dispose();
            Report rep = new Report(pinNum2);
        }
    }

    public static void main(String args[]) {

        new MainMenu("");
    }

}
