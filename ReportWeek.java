package atm.simulator.management.system;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

public class ReportWeek {
    JFrame J;
    JTable table;
    JScrollPane scrollPane;
    String pinNum2;


    public ReportWeek(String pinNum2) {
        this.pinNum2 = pinNum2;
        
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Date");//https://www.tabnine.com/code/java/methods/javax.swing.table.DefaultTableModel/addColumn
        model.addColumn("Activity");
        model.addColumn("Amount");
        
        try {
            Database con = new Database();
            String query21 = "select * from CustomerInfo where pinNum2='" + pinNum2 +  "' and date between date_sub(curdate(), interval 7 day) and curdate()";//https://www.w3schools.com/sql/func_mysql_date_sub.asp
            ResultSet rel = con.stat.executeQuery(query21);
            while (rel.next()) {
                model.addRow(new Object[] {//https://stackoverflow.com/questions/57771546/tablemodel-addrow-not-showing-anything-in-jtable-but-row-object-has-values
            
                    rel.getString(2),
                    rel.getString(3),
                    rel.getString(4),
                });
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        
        table = new JTable(model);
        scrollPane = new JScrollPane(table);
        J = new JFrame();
        J.setSize(600, 400);//https://www.tabnine.com/code/java/methods/java.awt.Frame/setTitle
        J.setTitle("Weekly Report");//https://www.tabnine.com/code/java/methods/java.awt.Frame/setTitle
        J.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//https://www.tabnine.com/code/java/methods/java.awt.Frame/setTitle
        J.getContentPane().removeAll();//https://www.tabnine.com/code/java/methods/java.awt.Frame/setTitle
        J.add(scrollPane, BorderLayout.CENTER);//https://www.tabnine.com/code/java/methods/java.awt.Frame/setTitle
        J.revalidate();//https://www.tabnine.com/code/java/methods/javax.swing.JComponent/revalidate
        J.setLocationRelativeTo(null);
        J.repaint();//https://www.javatpoint.com/repaint-method-in-java
        J.setVisible(true);
    }

    public static void main(String args[]) {
        new ReportWeek("");
    }
}
