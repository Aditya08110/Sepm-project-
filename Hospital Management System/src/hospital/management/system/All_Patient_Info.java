package hospital.management.system;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class All_Patient_Info extends JFrame {

    public All_Patient_Info() {

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 990, 590);
        panel.setBackground(new Color(90, 156, 163));
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBackground(Color.WHITE);

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(10, 40, 960, 450);
        panel.add(jsp);

        // BACK Button
        JButton backButton = new JButton("Back");
        backButton.setBounds(400, 500, 150, 40);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        panel.add(backButton);

        // Correct Back Button Action
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false); // hide this window
                new Reception();   // open Reception
            }
        });

        try {
            conn c = new conn();
            String q = "SELECT * FROM patient_info";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        setTitle("All Patient Information");
        setSize(1000, 600);
        setLayout(null);
        setLocation(430, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new All_Patient_Info();
    }
}
