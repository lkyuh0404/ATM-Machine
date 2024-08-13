package atm.simulator.management.system;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

public class ReportMonth {
    JFrame J;
    JTable table;
    JScrollPane scroll;
    String pinNum2;
 

    public ReportMonth(String pinNum2) {
        this.pinNum2 = pinNum2;

        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Date");//https://www.tabnine.com/code/java/methods/javax.swing.table.DefaultTableModel/addColumn
        model.addColumn("Activity");
        model.addColumn("Amount");

        try {
            Database con23 = new Database();
            String query23 = "select * from CustomerInfo where pinNum2='" + pinNum2 + "' and date between date_sub(curdate(), interval 30 day) and curdate()"; //https://stackabuse.com/how-to-get-current-date-and-time-in-java/
            ResultSet rel = con23.stat.executeQuery(query23);//https://docs.oracle.com/javase/7/docs/api/java/sql/ResultSet.html
            while (rel.next()) {
                model.addRow(new Object[]{//https://stackoverflow.com/questions/57771546/tablemodel-addrow-not-showing-anything-in-jtable-but-row-object-has-values
                    rel.getString(2),
                    rel.getString(3),
                    rel.getString(4),});
            }
        } catch (Exception e) {
            System.err.println(e);
        }

        table = new JTable(model);
        scroll = new JScrollPane(table);
        J = new JFrame();
        J.setSize(600, 400);
        J.setTitle("Monthly Report");
        J.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        J.getContentPane().removeAll();//https://stackoverflow.com/questions/20733755/jframe-getcontentpane-removeall-only-working-between-a-setvisiblefalse-and
        J.add(scroll, BorderLayout.CENTER);
        J.revalidate();//https://stackoverflow.com/questions/1097366/java-swing-revalidate-vs-repaint
        J.setLocationRelativeTo(null);
        J.repaint();//https://stackoverflow.com/questions/1097366/java-swing-revalidate-vs-repaint
        J.setVisible(true);
    }

    public static void main(String args[]) {
        new ReportMonth("");
    }
}
