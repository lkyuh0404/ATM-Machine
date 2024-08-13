
package atm.simulator.management.system;

import java.sql.*;

public class Database {
        Connection con;
        Statement stat;
   
    public Database () {
        try {
            Class.forName("com.mysql.jdbc.Driver");//https://dev.mysql.com/doc/connector-j/8.0/en/connector-j-usagenotes-connect-drivermanager.html
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atmdata?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "david117423");
            stat = con.createStatement();
        } catch (Exception a) {
            System.out.println(a);
        }

    }
}
