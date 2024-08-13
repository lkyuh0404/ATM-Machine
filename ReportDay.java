package atm.simulator.management.system;

import java.util.Date;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

public class ReportDay implements ActionListener {

    JFrame J;
    JTable table;
    JScrollPane scroll;
    JButton back;
    String pinNum2;

    public ReportDay(String pinNum2) {
        this.pinNum2 = pinNum2;

        DefaultTableModel model = new DefaultTableModel();//https://docs.oracle.com/javase/7/docs/api/javax/swing/table/DefaultTableModel.html
        model.addColumn("Date");//https://www.tabnine.com/code/java/methods/javax.swing.table.DefaultTableModel/addColumn
        model.addColumn("Activity");
        model.addColumn("Amount");

        try {

            Database con20 = new Database();
            String query20 = "select * from CustomerInfo where (pinNum2 = '" + pinNum2 + "') AND date = curdate()"; //https://stackoverflow.com/questions/52152434/how-will-i-match-the-username-and-pass-from-the-database-in-this-java-servlet-j

            ResultSet result = con20.stat.executeQuery(query20);
            while (result.next()) {
                model.addRow(new Object[]{//https://stackoverflow.com/questions/57771546/tablemodel-addrow-not-showing-anything-in-jtable-but-row-object-has-values
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),});
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        table = new JTable(model);//https://docs.oracle.com/javase/tutorial/uiswing/components/table.html
        scroll = new JScrollPane(table);//https://docs.oracle.com/javase/tutorial/uiswing/components/table.html
        scroll.setBounds(0, 0, 540, 460);//https://docs.oracle.com/javase/tutorial/uiswing/components/table.html
        J = new JFrame();
        J.setSize(600, 400);
        J.setTitle("Daily Report");
        J.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//https://chortle.ccsu.edu/java5/notes/chap56/ch56_9.html
        J.getContentPane().removeAll();//https://www.tabnine.com/code/java/methods/java.awt.Container/removeAll
        J.add(scroll, BorderLayout.CENTER);
        J.revalidate();//https://www.tabnine.com/code/java/methods/javax.swing.JComponent/revalidate
        J.setLocationRelativeTo(null);

        J.repaint();//https://www.javatpoint.com/repaint-method-in-java
        J.setVisible(true);

        back = new JButton("Back");
        back.setBounds(300, 300, 150, 50);
        back.setFont(new Font("Serif", Font.BOLD, 20));
        back.addActionListener(this);
        J.add(back);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            J.dispose();
            Report rt = new Report(pinNum2);
        }
    }

    public static void main(String args[]) {
        new ReportDay("");
    }
}
