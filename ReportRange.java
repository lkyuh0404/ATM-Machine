package atm.simulator.management.system;

import java.util.Date;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.table.DefaultTableModel;

public class ReportRange implements ActionListener {

    JFrame J;
    JLabel sDate;
    JLabel eDate;
    JButton submit;
    JButton back;
    JTable table;
    JScrollPane scroll;
    String pinNum2;
    JTextField sdCalendar;
    JTextField edCalendar;

    public ReportRange(String pinNum2) {
        J = new JFrame();
        this.pinNum2 = pinNum2;

        J.setTitle("Select Date Range");////https://www.tabnine.com/code/java/methods/java.awt.Frame/setTitle
        J.setSize(1000, 1000);//https://www.tabnine.com/code/java/methods/java.awt.Frame/setSize
        J.setLayout(new BorderLayout());//https://www.tabnine.com/code/java/methods/java.awt.Frame/setTitle
        J.setVisible(true);//https://www.tabnine.com/code/java/methods/java.awt.Frame
        J.setLocationRelativeTo(null);//https://www.tabnine.com/code/java/methods/java.awt.Frame
        J.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//https://www.tabnine.com/code/java/methods/java.awt.Frame/setTitle

        JPanel panel = new JPanel(new GridLayout(2, 2));

        sDate = new JLabel("Start Date (yyyy-MM-dd):", SwingConstants.LEFT);
        sDate.setBounds(200, 120, 300, 40);
        sDate.setFont(new Font("Serif", Font.PLAIN, 20));
        J.add(sDate);

        sdCalendar = new JTextField();
        sdCalendar.setBounds(420, 120, 250, 40);
        sdCalendar.setFont(new Font("Serif", Font.PLAIN, 20));
        J.add(sdCalendar);

        eDate = new JLabel("End Date (yyyy-MM-dd):", SwingConstants.LEFT);
        eDate.setBounds(200, 170, 300, 40);
        eDate.setFont(new Font("Serif", Font.PLAIN, 20));
        J.add(eDate);

        edCalendar = new JTextField();
        edCalendar.setBounds(420, 170, 250, 40);
        edCalendar.setFont(new Font("Serif", Font.PLAIN, 20));
        J.add(edCalendar);

        submit = new JButton("Submit");
        submit.setBounds(600, 500, 100, 40);
        submit.setFont(new Font("Serif", Font.PLAIN, 20));
        submit.addActionListener(this);

        J.add(submit);

        ImageIcon logo1 = new ImageIcon(getClass().getResource("/icon/ATM.png"));//https://docs.oracle.com/javase/7/docs/api/javax/swing/ImageIcon.html
        Image logoImage = logo1.getImage().getScaledInstance(1100, 1100, Image.SCALE_DEFAULT);
        JLabel logoLabel = new JLabel(new ImageIcon(logoImage));
        logoLabel.setBounds(0, 0, 1000, 1000);
        J.add(logoLabel);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String sd = sdCalendar.getText();
            String ed = edCalendar.getText();

            DefaultTableModel mo = new DefaultTableModel();

            mo.addColumn("Date");//https://www.tabnine.com/code/java/methods/javax.swing.table.DefaultTableModel/addColumn
            mo.addColumn("Activity");
            mo.addColumn("Amount");

            try {
                Database con12 = new Database();
                String query18 = "select * from CustomerInfo where pinNum2='" + pinNum2 + "' and date between '" + sd + "' and '" + ed + "'";//https://www.w3schools.com/sql/sql_between.asp
                ResultSet rel = con12.stat.executeQuery(query18);
                while (rel.next()) {
                    mo.addRow(new Object[]{//https://stackoverflow.com/questions/57771546/tablemodel-addrow-not-showing-anything-in-jtable-but-row-object-has-values

                        rel.getString(2),
                        rel.getString(3),
                        rel.getString(4),});
                }

            } catch (Exception excep) {
                System.out.println(excep);
            }

            table = new JTable(mo);
            scroll = new JScrollPane(table);
            J.getContentPane().removeAll();//https://stackoverflow.com/questions/20733755/jframe-getcontentpane-removeall-only-working-between-a-setvisiblefalse-and
            J.add(scroll, BorderLayout.CENTER);
            J.revalidate();//https://www.tabnine.com/code/java/methods/javax.swing.JComponent/revalidate
            J.repaint();//https://www.tabnine.com/code/java/methods/javax.swing.JComponent/revalidate

        }
    }

    public static void main(String args[]) {
        new ReportRange("");
    }
}
