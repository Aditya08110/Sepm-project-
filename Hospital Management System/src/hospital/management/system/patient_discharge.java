package hospital.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
import javax.swing.*;

public class patient_discharge extends JFrame {

    Choice choice;
    JLabel RNO, InTime, OutTime;

    public patient_discharge() {

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 790, 390);
        panel.setBackground(new Color(90, 156, 163));
        panel.setLayout(null);
        add(panel);

        JLabel label = new JLabel("CHECK OUT");
        label.setBounds(100, 20, 200, 30);
        label.setFont(new Font("Tahoma", Font.BOLD, 20));
        label.setForeground(Color.WHITE);
        panel.add(label);

        JLabel label2 = new JLabel("Customer ID");
        label2.setBounds(30, 80, 150, 20);
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        label2.setForeground(Color.WHITE);
        panel.add(label2);

        choice = new Choice();
        choice.setBounds(200, 80, 200, 25);
        panel.add(choice);

        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("SELECT * FROM Patient_Info");
            while (resultSet.next()) {
                choice.add(resultSet.getString("ID") + " - " + resultSet.getString("Number"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel label3 = new JLabel("Room Number");
        label3.setBounds(30, 130, 150, 20);
        label3.setFont(new Font("Tahoma", Font.BOLD, 14));
        label3.setForeground(Color.WHITE);
        panel.add(label3);

        RNO = new JLabel();
        RNO.setBounds(200, 130, 150, 20);
        RNO.setFont(new Font("Tahoma", Font.BOLD, 14));
        RNO.setForeground(Color.WHITE);
        panel.add(RNO);

        JLabel label4 = new JLabel("IN Time");
        label4.setBounds(30, 180, 150, 20);
        label4.setFont(new Font("Tahoma", Font.BOLD, 14));
        label4.setForeground(Color.WHITE);
        panel.add(label4);

        InTime = new JLabel();
        InTime.setBounds(200, 180, 250, 20);
        InTime.setFont(new Font("Tahoma", Font.BOLD, 14));
        InTime.setForeground(Color.WHITE);
        panel.add(InTime);

        JLabel label5 = new JLabel("Out Time");
        label5.setBounds(30, 230, 150, 20);
        label5.setFont(new Font("Tahoma", Font.BOLD, 14));
        label5.setForeground(Color.WHITE);
        panel.add(label5);

        Date date = new Date();
        OutTime = new JLabel("" + date);
        OutTime.setBounds(200, 230, 300, 20);
        OutTime.setFont(new Font("Tahoma", Font.BOLD, 14));
        OutTime.setForeground(Color.WHITE);
        panel.add(OutTime);

        Color btnColor = new Color(70, 130, 180); // Steel Blue

        // CHECK Button
        JButton checkButton = new JButton("CHECK");
        checkButton.setBounds(50, 300, 120, 30);
        checkButton.setBackground(btnColor);
        checkButton.setForeground(Color.WHITE);
        checkButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        checkButton.setToolTipText("Check patient details");
        panel.add(checkButton);

        checkButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    conn c = new conn();
                    String selected = choice.getSelectedItem();
                    String[] parts = selected.split(" - ");
                    String id = parts[0];
                    String number = parts[1];

                    PreparedStatement pst = c.connection.prepareStatement(
                        "SELECT * FROM Patient_Info WHERE ID = ? AND Number = ?"
                    );
                    pst.setString(1, id);
                    pst.setString(2, number);
                    ResultSet rs = pst.executeQuery();
                    if (rs.next()) {
                        RNO.setText(rs.getString("Room_Number"));
                        InTime.setText(rs.getString("Time"));
                    } else {
                        JOptionPane.showMessageDialog(null, "Patient not found.");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        // DISCHARGE Button
        JButton dischargeButton = new JButton("DISCHARGE");
        dischargeButton.setBounds(200, 300, 150, 30);
        dischargeButton.setBackground(btnColor);
        dischargeButton.setForeground(Color.WHITE);
        dischargeButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        dischargeButton.setToolTipText("Discharge patient");
        panel.add(dischargeButton);

        dischargeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String room = RNO.getText();
                String inTime = InTime.getText();

                if (room.equals("") || inTime.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please check patient details first.");
                    return;
                }

                try {
                    conn c = new conn();
                    String selected = choice.getSelectedItem();
                    String[] parts = selected.split(" - ");
                    String id = parts[0];
                    String number = parts[1];

                    PreparedStatement pst = c.connection.prepareStatement(
                        "DELETE FROM Patient_Info WHERE ID = ? AND Number = ?"
                    );
                    pst.setString(1, id);
                    pst.setString(2, number);
                    pst.executeUpdate();

                    PreparedStatement pst2 = c.connection.prepareStatement(
                        "UPDATE Room SET Availability = 'Available' WHERE Room_Number = ?"
                    );
                    pst2.setString(1, room);
                    pst2.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Patient Discharged Successfully");
                    setVisible(false);
                    new Reception();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        // BACK Button
        JButton backButton = new JButton("BACK");
        backButton.setBounds(380, 300, 120, 30);
        backButton.setBackground(btnColor);
        backButton.setForeground(Color.WHITE);
        backButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        backButton.setToolTipText("Go back");
        panel.add(backButton);

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Reception();
            }
        });

        setSize(800, 400);
        setLayout(null);
        setLocation(400, 250);
        setVisible(true);
    }

    public static void main(String[] args) {
        new patient_discharge();
    }
}
