package DeveloperAndSoftwareDetails;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.event.*;
import java.lang.String;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class ViewDetails extends JFrame {
    static ViewDetails frame;
    public ViewDetails() throws SQLException {
        String data[][] = {};
        String columnNames[] = {"Id", "Name", "Currently Working Software", "Finished Softwares"};
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
        JTable jt = new JTable(tableModel);
        java.sql.Connection c = null;
        Statement stmt = null;
        ResultSet rs = null;
        String id,name, workingsoftware_name, finished_software;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            rs = stmt.executeQuery("SELECT * FROM DeveloperAndRespectiveSoftwareDetails;");
            int row1 = 0;
            while (rs.next()) {
                id = rs.getString("Id");
                name = rs.getString("Name");
                workingsoftware_name = rs.getString("Currently_Working_Software");
                finished_software = rs.getString("Finished_Softwares");
                tableModel.insertRow(row1, new Object[]{id, name, workingsoftware_name, finished_software});
                row1++;
            }
            JScrollPane sp = new JScrollPane(jt);
            add(sp);

            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setBounds(100, 100, 800, 400);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

        public static void main (String[]args){
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        frame = new ViewDetails();
                        frame.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }