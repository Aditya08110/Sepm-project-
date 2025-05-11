package hospital.management.system;

import java.awt.*;
import javax.swing.*;

public class Reception extends JFrame {

    Reception() {

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5, 160, 1525, 670);
        panel.setBackground(new Color(109, 164, 170));
        add(panel);

        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(5, 5, 1525, 150);
        panel1.setBackground(new Color(109, 164, 170));
        add(panel1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/dr.png"));
        Image image = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(image);
        JLabel label = new JLabel(i2);
        label.setBounds(1250, -30, 250, 250);
        panel1.add(label);

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icon/reception.jpg"));
        Image image1 = i11.getImage().getScaledInstance(300, 100, Image.SCALE_DEFAULT);
        ImageIcon i22 = new ImageIcon(image1);
        JLabel label1 = new JLabel(i22);
        label1.setBounds(1000, 20, 300, 100);
        panel1.add(label1);

        JButton bt1 = new JButton("Add New Patient");
        bt1.setBounds(30, 15, 200, 30);
        bt1.setBackground(new Color(246, 215, 118));
        panel1.add(bt1);
        bt1.addActionListener(e -> {
            setVisible(false);
            new New_Patient();
        });

        JButton bt2 = new JButton("Room");
        bt2.setBounds(30, 58, 200, 30);
        bt2.setBackground(new Color(246, 215, 118));
        panel1.add(bt2);
        bt2.addActionListener(e -> new Room());

        JButton bt3 = new JButton("Department");
        bt3.setBounds(30, 100, 200, 30);
        bt3.setBackground(new Color(246, 215, 118));
        panel1.add(bt3);
        bt3.addActionListener(e -> new Department());

        JButton bt4 = new JButton("All Employee Info");
        bt4.setBounds(270, 15, 200, 30);
        bt4.setBackground(new Color(246, 215, 118));
        panel1.add(bt4);
        bt4.addActionListener(e -> new Employee_info());

        JButton bt5 = new JButton("Patient Info");
        bt5.setBounds(270, 58, 200, 30);
        bt5.setBackground(new Color(246, 215, 118));
        panel1.add(bt5);
        bt5.addActionListener(e -> {
            setVisible(false);
            new All_Patient_Info();
        });

        JButton bt6 = new JButton("Patient Discharge");
        bt6.setBounds(270, 100, 200, 30);
        bt6.setBackground(new Color(246, 215, 118));
        panel1.add(bt6);
        bt6.addActionListener(e -> {
            setVisible(false);
            new patient_discharge();
        });

        JButton bt7 = new JButton("Update Patient Details");
        bt7.setBounds(510, 15, 200, 30);
        bt7.setBackground(new Color(246, 215, 118));
        panel1.add(bt7);
        bt7.addActionListener(e -> {
            setVisible(false);
            new update_patients_details();
        });

        JButton bt8 = new JButton("Hospital Ambulance");
        bt8.setBounds(510, 58, 200, 30);
        bt8.setBackground(new Color(246, 215, 118));
        panel1.add(bt8);

        JButton bt10 = new JButton("Logout");
        bt10.setBounds(750, 15, 200, 30);
        bt10.setBackground(new Color(246, 215, 118));
        panel1.add(bt10);
        bt10.addActionListener(e -> {
            setVisible(false);
        });

        setTitle("Reception");
        setSize(1280, 832);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Reception();
    }
}

