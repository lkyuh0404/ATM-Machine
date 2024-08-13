package atm.simulator.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Report implements ActionListener {

    JFrame J;
    JLabel message;
    JButton day;
    JButton week;
    JButton month;
    JButton range;
    JButton back;
    String pinNum2;


    Report(String pinNum2) {
        this.pinNum2 = pinNum2;
     
        J = new JFrame();
        J.setTitle("Report");//https://www.tabnine.com/code/java/methods/java.awt.Frame/setTitle
        J.setSize(1100, 1100);//https://www.tabnine.com/code/java/methods/java.awt.Frame/setTitle
        J.setLayout(null);//https://www.tabnine.com/code/java/methods/java.awt.Frame/setTitle
        J.setVisible(true);//https://www.tabnine.com/code/java/methods/java.awt.Frame/setTitle
        J.setLocationRelativeTo(null);//https://www.tabnine.com/code/java/methods/java.awt.Frame/setTitle
        J.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//https://www.tabnine.com/code/java/methods/java.awt.Frame/setTitle

        message = new JLabel("Customer Report");
        message.setBounds(450, 180, 500, 30);
        message.setFont(new Font("Serif", Font.BOLD, 30));
        J.add(message);

        day = new JButton("Daily Report");
        day.setBounds(250, 250, 250, 50);
        day.setFont(new Font("Serif", Font.BOLD, 20));
        day.addActionListener(this);
        J.add(day);

        week = new JButton("Weekly Report");
        week.setBounds(250, 350, 250, 50);
        week.setFont(new Font("Serif", Font.BOLD, 20));
        week.addActionListener(this);
        J.add(week);

        month = new JButton("Monthly Report");
        month.setBounds(250, 450, 250, 50);
        month.setFont(new Font("Serif", Font.BOLD, 20));
        month.addActionListener(this);
        J.add(month);

        range = new JButton("Selected Range Report");
        range.setBounds(250, 550, 250, 50);
        range.setFont(new Font("Serif", Font.BOLD, 20));
        range.addActionListener(this);
        J.add(range);

        back = new JButton("Back");
        back.setBounds(700, 550, 150, 50);
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

        if (ae.getSource() == day) {//https://www.oreilly.com/library/view/java-for-dummies/9781118239742/a2_08_9781118239742-ch05.html
            J.dispose();
            ReportDay rday = new ReportDay(pinNum2);
        } else if (ae.getSource() == week) {
            J.dispose();
            ReportWeek rweek = new ReportWeek(pinNum2);

        } else if (ae.getSource() == month) {
            J.dispose();
            ReportMonth rmonth = new ReportMonth(pinNum2);

        } else if (ae.getSource() == range) {
            J.dispose();
            ReportRange rrange = new ReportRange(pinNum2);
        } else if (ae.getSource() == back) {
            J.dispose();
            MainMenu main = new MainMenu(pinNum2);
        }
    }

    public static void main(String args[]) {
        new Report("");
    }

}
