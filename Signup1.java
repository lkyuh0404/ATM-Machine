package atm.simulator.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Signup1 implements ActionListener {
    
    JLabel Smessage;
    JLabel nameLabel;
    JLabel dobLabel;
    JLabel emLabel;
    JLabel streetLabel;
    JLabel cityLabel;
    JLabel genderLabel;
    JLabel marrLabel;
    JTextField nameField;
    JTextField dobField;
    JTextField emField;
    JTextField streetField;
    JTextField cityField;
    JComboBox gender;
    JComboBox marr;
    JButton nButton;
    JFrame J;

    Signup1() {
        J = new JFrame();

        J.setTitle("ATM Sign Up Page");//https://www.tabnine.com/code/java/methods/java.awt.Frame/setTitle
        J.setSize(900, 900);//https://www.tabnine.com/code/java/methods/java.awt.Frame/setTitle
        J.setVisible(true);//https://www.tabnine.com/code/java/methods/java.awt.Frame/setTitle
        J.setLocationRelativeTo(null);//https://stackoverflow.com/questions/7799940/jframe-exit-on-close-java
        J.setLayout(null);//https://www.tabnine.com/code/java/methods/java.awt.Frame/setTitle
        J.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//https://www.tabnine.com/code/java/methods/java.awt.Frame/setTitle


        Smessage = new JLabel("Form A: Please answer the following", SwingConstants.CENTER);
        Smessage.setBounds(1, 10, 900, 31);////https://www.tabnine.com/code/java/methods/javax.swing.JFrame/setBounds
        Smessage.setFont(new Font("Serif", Font.BOLD, 20));////https://www.tabnine.com/code/java/methods/javax.swing.JFrame/setBounds
        J.add(Smessage);

       
        nameLabel = new JLabel("Name:", SwingConstants.LEFT);
        nameLabel.setBounds(21, 170, 100, 40);
        nameLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        J.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(110, 170, 250, 40);
        nameField.setFont(new Font("Serif", Font.PLAIN, 20));
        J.add(nameField);
        
  
      
        dobLabel = new JLabel("Date of Birth:", SwingConstants.LEFT);
        dobLabel.setBounds(20, 220, 150, 40);
        dobLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        J.add(dobLabel);

        dobField = new JTextField();
        dobField.setBounds(140, 220, 250, 40);
        dobField.setFont(new Font("Serif", Font.PLAIN, 20));
        J.add(dobField);

        emLabel = new JLabel("Email:", SwingConstants.LEFT);
        emLabel.setBounds(20, 270, 100, 40);
        emLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        J.add(emLabel);

        emField = new JTextField();
        emField.setBounds(120, 270, 350, 40);
        emField.setFont(new Font("Serif", Font.PLAIN, 20));
        J.add(emField);

        streetLabel = new JLabel("Street:", SwingConstants.LEFT);
        streetLabel.setBounds(20, 320, 200, 40);
        streetLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        J.add(streetLabel);

        streetField = new JTextField();
        streetField.setBounds(120, 320, 350, 40);
        streetField.setFont(new Font("Serif", Font.PLAIN, 20));
        J.add(streetField);

        cityLabel = new JLabel("City, State:", SwingConstants.LEFT);
        cityLabel.setBounds(20, 380, 200, 40);
        cityLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        J.add(cityLabel);

        cityField = new JTextField();
        cityField.setBounds(120, 380, 350, 40);
        cityField.setFont(new Font("Serif", Font.PLAIN, 20));
        J.add(cityField);

        String[] genderChoice = {"Male", "Female", "Other"};//https://docs.oracle.com/javase/tutorial/uiswing/components/combobox.html
        gender = new JComboBox(genderChoice);
        gender.setBounds(120, 420, 200, 40);
        gender.setFont(new Font("Serif", Font.PLAIN, 20));
        J.add(gender);

        genderLabel = new JLabel("Gender:", SwingConstants.LEFT);
        genderLabel.setBounds(20, 420, 100, 40);
        genderLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        J.add(genderLabel);

        String[] maritalStat = {"Married", "Unmarried"};//https://docs.oracle.com/javase/tutorial/uiswing/components/combobox.html
        marr = new JComboBox(maritalStat);
        marr.setBounds(145, 460, 200, 40);
        marr.setFont(new Font("Serif", Font.PLAIN, 20));
        J.add(marr);

        marrLabel = new JLabel("Marital Status:", SwingConstants.LEFT);
        marrLabel.setBounds(20, 460, 150, 40);
        marrLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        J.add(marrLabel);
        

        nButton = new JButton("Next");
        nButton.setBounds(690, 690, 110, 42);
        nButton.setFont(new Font("Serif", Font.BOLD, 22));
        nButton.addActionListener(this);//https://docs.oracle.com/javase/tutorial/uiswing/events/actionlistener.html

        J.add(nButton);

    }

    public void actionPerformed(ActionEvent e) {

        String name = nameField.getText();//https://stackoverflow.com/questions/5477241/swing-java-how-to-use-the-gettext-and-settext-string-properly
        String dob = dobField.getText();
        String email = emField.getText();
        String street = streetField.getText();
        String city = cityField.getText();
        String genderSel = (String) gender.getSelectedItem();//https://www.herongyang.com/Swing/JComboBox-getSelectedItem-Selected-Item-of-Combo-Box.html
        String marriageSel = (String) marr.getSelectedItem();//https://www.herongyang.com/Swing/JComboBox-getSelectedItem-Selected-Item-of-Combo-Box.html

        try {

            if (name.isEmpty() ||  dob.isEmpty() || email.isEmpty() || street.isEmpty() || city.isEmpty()) { //https://www.javatpoint.com/java-string-isempty
                JOptionPane.showMessageDialog(null, "Fill all the required fields", "Error", JOptionPane.ERROR_MESSAGE); //https://docs.oracle.com/javase/7/docs/api/javax/swing/JOptionPane.html
            } else {
                Database con1 = new Database();//https://www.tutorialspoint.com/jdbc/jdbc-create-database.htm
            String query1 = "insert into Signup1 (name, dob, email, street, city, genderSel, marriageSel) values('" + name + "', '" + dob + "','" + email + "','" + street + "','" + city + "','" + genderSel + "','" + marriageSel + "')";
                con1.stat.executeUpdate(query1); //https://www.w3schools.com/sql/sql_insert.asp

        
                if (e.getSource() == nButton) {

                    J.dispose();
                    Signup2 signup2 = new Signup2();

                }

            }

        } catch (Exception excep) {
            System.out.println(excep);

        }

    }

    public static void main(String[] args) {
        new Signup1();
    }

}
