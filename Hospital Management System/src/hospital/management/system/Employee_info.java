package hospital.management.system;

import java.awt.Color;
import java.sql.ResultSet;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class Employee_info extends JFrame {

    Employee_info() {

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 990, 590);
        panel.setBackground(new Color(109, 164, 170));
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBounds(10, 34, 960, 450); // Slightly smaller to fit in panel
        table.setBackground(Color.WHITE); // Easier to see rows
        panel.add(table);

        JButton back = new JButton("Back");
        back.setBounds(850, 500, 100, 30);
        panel.add(back);
        back.addActionListener(e -> setVisible(false));

        try {
            conn c = new conn();
            String q = "SELECT * FROM Employee_info";
            ResultSet rs = c.statement.executeQuery(q);

            if (!rs.isBeforeFirst()) {
                JOptionPane.showMessageDialog(null, "No data found in Employee_info table.");
            }

            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            e.printStackTrace();
        }

        setTitle("Employee Information");
        setSize(1000, 600);
        setLocation(300, 200);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Employee_info();
    }
}
