package hospital.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.sql.*;

import net.proteanit.sql.DbUtils;

public class Department extends JFrame {

    public Department() {
        setTitle("Department Details");
        setSize(520, 330); // adjusted to tightly fit content
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Panel Setup
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 520, 330); // match frame
        panel.setLayout(null);
        panel.setBackground(new Color(90, 156, 163));
        add(panel);

        // Table Setup
        JTable table = new JTable();
        table.setFont(new Font("SansSerif", Font.PLAIN, 14));
        table.setRowHeight(25);
        table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 14));
        table.getTableHeader().setBackground(new Color(180, 220, 220));
        table.setBackground(new Color(200, 230, 230));

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 20, 480, 200);
        panel.add(scrollPane);

        // Back Button
        JButton back = new JButton("Back");
        back.setBounds(20, 240, 100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("SansSerif", Font.BOLD, 14));
        panel.add(back);

        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // closes the current window
            }
        });

        // Load data
        try {
            conn c = new conn();
            String q = "SELECT * FROM department";
            ResultSet resultset = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultset));
        } catch (Exception e) {
            e.printStackTrace();
        }

        setUndecorated(true); // Removes the default window border (optional)
        setVisible(true);
    }

    public static void main(String[] args) {
        new Department();
    }
}
