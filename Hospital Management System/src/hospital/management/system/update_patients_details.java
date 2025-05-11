package hospital.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class update_patients_details extends JFrame implements ActionListener {

    Choice patientName;
    JTextField roomField, timeField, paidField, pendingField;
    JButton update, back, check;

    update_patients_details() {
        // Panel
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 940, 490);
        panel.setBackground(new Color(90, 156, 163));
        panel.setLayout(null);
        add(panel);

        // Heading
        JLabel heading = new JLabel("Update Patient Details");
        heading.setBounds(300, 20, 400, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 25));
        heading.setForeground(Color.WHITE);
        panel.add(heading);

        // Name
        JLabel nameLabel = new JLabel("Name :");
        nameLabel.setBounds(50, 100, 120, 30);
        nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        nameLabel.setForeground(Color.WHITE);
        panel.add(nameLabel);

        patientName = new Choice();
        patientName.setBounds(200, 100, 200, 25);
        panel.add(patientName);

        // Load names from DB
        try {
            conn c = new conn();
            ResultSet rs = c.statement.executeQuery("SELECT Name FROM patient_info");
            while (rs.next()) {
                patientName.add(rs.getString("Name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Room Number
        JLabel roomLabel = new JLabel("Room Number :");
        roomLabel.setBounds(50, 150, 150, 30);
        roomLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        roomLabel.setForeground(Color.WHITE);
        panel.add(roomLabel);

        roomField = new JTextField();
        roomField.setBounds(200, 150, 200, 25);
        panel.add(roomField);

        // In-Time
        JLabel timeLabel = new JLabel("In-Time :");
        timeLabel.setBounds(50, 200, 150, 30);
        timeLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        timeLabel.setForeground(Color.WHITE);
        panel.add(timeLabel);

        timeField = new JTextField();
        timeField.setBounds(200, 200, 200, 25);
        panel.add(timeField);

        // Amount Paid
        JLabel paidLabel = new JLabel("Amount Paid (Rs) :");
        paidLabel.setBounds(50, 250, 180, 30);
        paidLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        paidLabel.setForeground(Color.WHITE);
        panel.add(paidLabel);

        paidField = new JTextField();
        paidField.setBounds(200, 250, 200, 25);
        panel.add(paidField);

        // Pending Amount
        JLabel pendingLabel = new JLabel("Pending Amount (Rs) :");
        pendingLabel.setBounds(50, 300, 220, 30);
        pendingLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        pendingLabel.setForeground(Color.WHITE);
        panel.add(pendingLabel);

        pendingField = new JTextField();
        pendingField.setBounds(250, 300, 150, 25);
        panel.add(pendingField);

        // Buttons
        update = new JButton("UPDATE");
        update.setBounds(80, 370, 100, 30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        panel.add(update);

        back = new JButton("BACK");
        back.setBounds(200, 370, 100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        panel.add(back);

        check = new JButton("CHECK");
        check.setBounds(320, 370, 100, 30);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.addActionListener(this);
        panel.add(check);

        // Frame setup
        setUndecorated(false);
        setSize(950, 550);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String name = patientName.getSelectedItem();

        if (ae.getSource() == check) {
            try {
                conn c = new conn();
                String query = "SELECT * FROM patient_info WHERE Name = '" + name + "'";
                ResultSet rs = c.statement.executeQuery(query);
                if (rs.next()) {
                    roomField.setText(rs.getString("Room_Number"));
                    timeField.setText(rs.getString("Time"));
                    paidField.setText(rs.getString("Deposite"));
                    pendingField.setText(""); // Optional: calculate and set pending
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == update) {
            try {
                conn c = new conn();
                String room = roomField.getText();
                String time = timeField.getText();
                String deposit = paidField.getText();
                String query = "UPDATE patient_info SET Room_Number = '" + room + "', Time = '" + time + "', Deposite = '" + deposit + "' WHERE Name = '" + name + "'";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Patient Details Updated Successfully");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Reception(); // Go back to Reception screen
        }
    }

    public static void main(String[] args) {
        new update_patients_details();
    }
}
