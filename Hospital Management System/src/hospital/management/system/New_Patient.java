package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class New_Patient extends JFrame implements ActionListener {

    JComboBox<String> comboBox;
    JTextField textFieldNumber, textName, textFieldDiseases, textFieldDeposite;
    JRadioButton r1, r2;
    ButtonGroup genderGroup;
    JLabel date;
    JButton b1, b2;
    Choice c1;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            conn c = new conn();
            String gender = null;
            if (r1.isSelected()) {
                gender = "Male";
            } else if (r2.isSelected()) {
                gender = "Female";
            }

            String idType = (String) comboBox.getSelectedItem();
            String number = textFieldNumber.getText();
            String name = textName.getText();
            String disease = textFieldDiseases.getText();
            String room = c1.getSelectedItem();
            String time = date.getText();
            String deposit = textFieldDeposite.getText();

            try {
                String q = "INSERT INTO patient_info (ID, Number, Name, Gender, Patient_disease, Room_Number, Time, Deposite) " +
                        "VALUES ('" + idType + "','" + number + "','" + name + "','" + gender + "','" + disease + "','" + room + "','" + time + "','" + deposit + "')";
                String q1 = "UPDATE room SET availability = 'Occupied' WHERE room_no = '" + room + "'";
                c.statement.executeUpdate(q);
                c.statement.executeUpdate(q1);
                JOptionPane.showMessageDialog(null, "Added Successfully");
                setVisible(false);
            } catch (Exception E) {
                E.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error: " + E.getMessage());
            }

        } else {
            setVisible(false);
        }
    }

    public New_Patient() {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 1920, 1080);
        panel.setBackground(new Color(90, 156, 163));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/patient.jpg"));
        Image image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(800, 100, 150, 150);
        panel.add(label);

        JLabel labelTitle = new JLabel("New Patient Form");
        labelTitle.setBounds(100, 20, 400, 50);
        labelTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
        panel.add(labelTitle);

        JLabel labelID = new JLabel("ID :");
        labelID.setBounds(50, 100, 200, 30);
        labelID.setFont(new Font("Tahoma", Font.BOLD, 20));
        labelID.setForeground(Color.WHITE);
        panel.add(labelID);

        comboBox = new JComboBox<>(new String[]{"Aadhaar Card", "Voter ID", "Driving License"});
        comboBox.setBounds(250, 100, 300, 40);
        comboBox.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(comboBox);

        JLabel labelNumber = new JLabel("Number :");
        labelNumber.setBounds(50, 160, 200, 30);
        labelNumber.setFont(new Font("Tahoma", Font.BOLD, 20));
        labelNumber.setForeground(Color.WHITE);
        panel.add(labelNumber);

        textFieldNumber = new JTextField();
        textFieldNumber.setBounds(250, 160, 300, 40);
        textFieldNumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
        panel.add(textFieldNumber);

        JLabel labelName1 = new JLabel("Name :");
        labelName1.setBounds(50, 220, 200, 30);
        labelName1.setFont(new Font("Tahoma", Font.BOLD, 20));
        labelName1.setForeground(Color.WHITE);
        panel.add(labelName1);

        textName = new JTextField();
        textName.setBounds(250, 220, 300, 40);
        textName.setFont(new Font("Tahoma", Font.PLAIN, 18));
        panel.add(textName);

        JLabel labelGender = new JLabel("Gender :");
        labelGender.setBounds(50, 280, 200, 30);
        labelGender.setFont(new Font("Tahoma", Font.BOLD, 20));
        labelGender.setForeground(Color.WHITE);
        panel.add(labelGender);

        r1 = new JRadioButton("Male");
        r1.setBounds(250, 280, 100, 40);
        r1.setFont(new Font("Tahoma", Font.BOLD, 20));
        r1.setForeground(Color.WHITE);
        r1.setBackground(new Color(109, 164, 170));
        panel.add(r1);

        r2 = new JRadioButton("Female");
        r2.setBounds(370, 280, 120, 40);
        r2.setFont(new Font("Tahoma", Font.BOLD, 20));
        r2.setForeground(Color.WHITE);
        r2.setBackground(new Color(109, 164, 170));
        panel.add(r2);

        genderGroup = new ButtonGroup();
        genderGroup.add(r1);
        genderGroup.add(r2);

        JLabel labelDiseases = new JLabel("Diseases :");
        labelDiseases.setBounds(50, 340, 200, 30);
        labelDiseases.setFont(new Font("Tahoma", Font.BOLD, 20));
        labelDiseases.setForeground(Color.WHITE);
        panel.add(labelDiseases);

        textFieldDiseases = new JTextField();
        textFieldDiseases.setBounds(250, 340, 300, 40);
        textFieldDiseases.setFont(new Font("Tahoma", Font.PLAIN, 18));
        panel.add(textFieldDiseases);

        JLabel labelRoom = new JLabel("Room :");
        labelRoom.setBounds(50, 396, 200, 30);
        labelRoom.setFont(new Font("Tahoma", Font.BOLD, 20));
        labelRoom.setForeground(Color.WHITE);
        panel.add(labelRoom);

        c1 = new Choice();
        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("SELECT * FROM room");
            while (resultSet.next()) {
                c1.add(resultSet.getString("room_no"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        c1.setBounds(250, 396, 300, 40);
        c1.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(c1);

        JLabel labelTime = new JLabel("Time :");
        labelTime.setBounds(50, 432, 200, 30);
        labelTime.setFont(new Font("Tahoma", Font.BOLD, 20));
        labelTime.setForeground(Color.WHITE);
        panel.add(labelTime);

        Date date1 = new Date();
        date = new JLabel("" + date1);
        date.setBounds(250, 432, 300, 30);
        date.setForeground(Color.WHITE);
        date.setFont(new Font("Tahoma", Font.BOLD, 18));
        panel.add(date);

        JLabel labelDeposite = new JLabel("Deposit :");
        labelDeposite.setBounds(50, 489, 200, 30);
        labelDeposite.setFont(new Font("Tahoma", Font.BOLD, 20));
        labelDeposite.setForeground(Color.WHITE);
        panel.add(labelDeposite);

        textFieldDeposite = new JTextField();
        textFieldDeposite.setBounds(250, 489, 300, 40);
        textFieldDeposite.setFont(new Font("Tahoma", Font.PLAIN, 18));
        panel.add(textFieldDeposite);

        b1 = new JButton("Add");
        b1.setBounds(250, 550, 100, 40);
        b1.setBackground(new Color(0, 102, 204));
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("Tahoma", Font.BOLD, 16));
        b1.setOpaque(true);
        b1.setBorderPainted(false);
        b1.addActionListener(this);
        panel.add(b1);

        b2 = new JButton("Back");
        b2.setBounds(370, 550, 100, 40);
        b2.setBackground(new Color(192, 57, 43));
        b2.setForeground(Color.WHITE);
        b2.setFont(new Font("Tahoma", Font.BOLD, 16));
        b2.setOpaque(true);
        b2.setBorderPainted(false);
        b2.addActionListener(this);
        panel.add(b2);

        // Back Button Action
        b2.addActionListener(e -> {
            setVisible(false);
            new Reception(); // Ensure this class exists
        });

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new New_Patient();
    }
}
