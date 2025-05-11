package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.net.URL;
import net.proteanit.sql.DbUtils;

public class Room extends JFrame {

    JTable table;

    Room() {
        // Create panel
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 890, 590);
        panel.setBackground(new Color(90, 156, 163));
        panel.setLayout(null);
        add(panel);

        // Safely load and scale the image
        URL imageUrl = getClass().getResource("/icon/roomm.png"); // Ensure 'icon' is under 'src'
        if (imageUrl != null) {
            ImageIcon imageIcon = new ImageIcon(imageUrl);
            Image image = imageIcon.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(image);

            // Add image to JLabel
            JLabel label = new JLabel(scaledIcon);
            label.setBounds(600, 150, 250, 250);
            panel.add(label);
        } else {
            System.out.println("⚠️ Image '/icon/roomm.png' not found!");
        }

        // Create table
        table = new JTable();
        table.setBackground(new Color(90, 156, 163));
        table.setRowHeight(30);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 40, 560, 400); // Adjust as needed
        panel.add(scrollPane);

        // Populate table from database
        try {
            conn c = new conn();
            String q = "select * from room";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

            table.getColumnModel().getColumn(0).setPreferredWidth(80);  // Room No
            table.getColumnModel().getColumn(1).setPreferredWidth(100); // Availability
            table.getColumnModel().getColumn(2).setPreferredWidth(80);  // Price
            table.getColumnModel().getColumn(3).setPreferredWidth(120); // Bed Type

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Back Button
        JButton back = new JButton("Back");
        back.setBounds(240, 460, 100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma", Font.BOLD, 14));
        back.setFocusPainted(false);
        back.setBorderPainted(false);
        back.setOpaque(true);
        panel.add(back);

        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
            }
        });

        // JFrame settings
        setUndecorated(true);
        setSize(900, 600);
        setLayout(null);
        setLocation(300, 230);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Room();
    }
}
