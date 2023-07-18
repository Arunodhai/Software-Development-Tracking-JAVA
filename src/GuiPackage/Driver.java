package GuiPackage;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.event.*;
import java.lang.String;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class Driver extends JFrame {
    JFrame f;
    Driver() throws SQLException{

        String data[][]={};
        String column[]={"ID","SOFTWARE NAME","CLIENT NAME","CREATED DATE"};

        DefaultTableModel tableModel = new DefaultTableModel(data,column);
        DefaultTableModel tableModel1 = new DefaultTableModel(data,column);
        DefaultTableModel tableModel2 = new DefaultTableModel(data,column);
        DefaultTableModel tableModel3 = new DefaultTableModel(data,column);

        JTable jt=new JTable(tableModel);
        JTable jt1=new JTable(tableModel1);
        JTable jt2=new JTable(tableModel2);
        JTable jt3=new JTable(tableModel3);

        JScrollPane sp=new JScrollPane(jt);
        JScrollPane sp1=new JScrollPane(jt1);
        JScrollPane sp2=new JScrollPane(jt2);
        JScrollPane sp3=new JScrollPane(jt3);

        jt.setRowHeight(30);
        jt1.setRowHeight(30);
        jt2.setRowHeight(30);
        jt3.setRowHeight(30);

        sp.setBounds(260,130,1180,630);
        sp1.setBounds(260,130,1180,630);
        sp2.setBounds(260,130,1180,630);
        sp3.setBounds(260,130,1180,630);


        Connection c = null;
        Statement stmt = null;
        ResultSet rs = null;

        String  id,software_name,client_name,created_date;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            rs = stmt.executeQuery( "SELECT * FROM NEWTABLE;");
            int row=0;
            while ( rs.next() ) {
                id = rs.getString("id");
                software_name = rs.getString("software_name");
                client_name = rs.getString("client_name");
                created_date = rs.getString("created_date");
                tableModel.insertRow(row, new Object[]{id, software_name, client_name, created_date});
                row++;
            }
            rs = stmt.executeQuery( "SELECT * FROM PENDINGTABLE;" );
            row=0;
            while ( rs.next() ) {
                id = rs.getString("id");
                software_name = rs.getString("software_name");
                client_name = rs.getString("client_name");
                created_date = rs.getString("created_date");
                tableModel1.insertRow(row, new Object[]{id, software_name, client_name, created_date});
                row++;
            }
            rs = stmt.executeQuery( "SELECT * FROM INPROGRESSTABLE;" );
            row=0;
            while ( rs.next() ) {
                id = rs.getString("id");
                software_name = rs.getString("software_name");
                client_name = rs.getString("client_name");
                created_date = rs.getString("created_date");
                tableModel2.insertRow(row, new Object[]{id, software_name, client_name, created_date});
                row++;
            }
            rs = stmt.executeQuery( "SELECT * FROM COMPLETEDTABLE;" );
            row=0;
            while ( rs.next() ) {
                id = rs.getString("id");
                software_name = rs.getString("software_name");
                client_name = rs.getString("client_name");
                created_date = rs.getString("created_date");
                tableModel3.insertRow(row, new Object[]{id, software_name, client_name, created_date});
                row++;
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }

        ((DefaultTableCellRenderer) jt.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        ((DefaultTableCellRenderer) jt1.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        ((DefaultTableCellRenderer) jt2.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        ((DefaultTableCellRenderer) jt3.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        DefaultTableCellRenderer render = new DefaultTableCellRenderer();
        render.setHorizontalAlignment(JLabel.CENTER);

       for (int i =0;i<4;i++) {
            jt.getColumnModel().getColumn(i).setCellRenderer(render);
            jt1.getColumnModel().getColumn(i).setCellRenderer(render);
            jt2.getColumnModel().getColumn(i).setCellRenderer(render);
            jt3.getColumnModel().getColumn(i).setCellRenderer(render);
        }

        JTableHeader tableHeader = jt.getTableHeader();
        JTableHeader tableHeader1 = jt1.getTableHeader();
        JTableHeader tableHeader2 = jt2.getTableHeader();
        JTableHeader tableHeader3 = jt3.getTableHeader();

        Font headerFont = new Font("Verdana", Font.PLAIN, 18);

        tableHeader.setFont(headerFont);
        tableHeader1.setFont(headerFont);
        tableHeader2.setFont(headerFont);
        tableHeader3.setFont(headerFont);


        add(sp);


        JPanel leftPanel1 = new JPanel();
        JPanel leftPanel = new JPanel();
        JPanel topPanel = new JPanel();

        JPanel bottomPanel = new JPanel();
        JPanel bottomPanel1 = new JPanel();
        JPanel bottomPanel2 = new JPanel();
        JPanel bottomPanel3 = new JPanel();

        JLabel l1=new JLabel("NEWLY ADDED PROJECTS");
        JLabel l2=new JLabel("PENDING PROJECTS");
        JLabel l3=new JLabel("IN-PROGRESS PROJECTS");
        JLabel l4=new JLabel("COMPLETED PROJECTS");

        leftPanel1.setBounds(0,65,260,240);
        leftPanel.setBounds(0,305,260,1021);
        topPanel.setBounds(260,65,1180,66);

        bottomPanel1.setBounds(260,760,1180,66);
        bottomPanel2.setBounds(260,760,1180,66);
        bottomPanel3.setBounds(260,760,1180,66);
        bottomPanel.setBounds(260,825,1180,30);

        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        leftPanel1.setBackground(Color.black);
        leftPanel.setBackground(Color.black);
        topPanel.setBackground(Color.black);

        bottomPanel1.setBackground(Color.black);
        bottomPanel2.setBackground(Color.black);
        bottomPanel3.setBackground(Color.black);

        bottomPanel.setBackground(Color.decode("#FF7121"));

        add(leftPanel1);
        add(leftPanel);
        add(topPanel);
        add(bottomPanel1);
        bottomPanel.add(l1);
        add(bottomPanel);

        JLabel L= new JLabel("Software Name");
        JLabel U= new JLabel("User's Name ");

        L.setForeground (Color.BLACK);
        L.setBounds(13,15,250,40);
        L.setFont(new Font("Serif", Font.PLAIN, 37));
        add(L);
        U.setForeground (Color.black);
        U.setBounds(1280,15,250,40);
        U.setFont(new Font("Serif", Font.PLAIN, 27));
        add(U);
        topPanel.setLayout(new GridLayout());

        JButton B1 = new JButton("New");
        B1.setBackground(Color.decode("#00FFF0"));
        B1.setOpaque(true);
        B1.setBorder(BorderFactory.createLineBorder(Color.black));
        topPanel.add(B1);

        JButton B2 = new JButton("Pending");
        B2.setBackground(Color.decode("#00FFF0"));
        B2.setOpaque(true);
        B2.setBorder(BorderFactory.createLineBorder(Color.black));
        topPanel.add(B2);


        JButton B3 = new JButton("In Progress");
        B3.setBackground(Color.decode("#00FFF0"));
        B3.setOpaque(true);
        B3.setBorder(BorderFactory.createLineBorder(Color.black));
        topPanel.add(B3);


        JButton B4 = new JButton("Completed");
        B4.setBackground(Color.decode("#00FFF0"));
        B4.setOpaque(true);
        B4.setBorder(BorderFactory.createLineBorder(Color.black));
        topPanel.add(B4);

        JButton homeButton = new JButton("Home");
        JButton LB1 = new JButton("Developers");
        JButton LB2 = new JButton("Clients");
        JButton LB3 = new JButton("Softwares");
        JButton LB4 = new JButton("Tracking");
        JButton LB5 = new JButton("Finance");

        homeButton.setPreferredSize(new Dimension(260, 60));

        LB1.setPreferredSize(new Dimension(260, 50));
        LB2.setPreferredSize(new Dimension(260, 50));
        LB3.setPreferredSize(new Dimension(260, 50));
        LB4.setPreferredSize(new Dimension(260, 50));
        LB5.setPreferredSize(new Dimension(260, 50));

        LB1.setForeground(Color.white);
        LB2.setForeground(Color.white);
        LB3.setForeground(Color.white);
        LB4.setForeground(Color.white);
        LB5.setForeground(Color.white);

        homeButton.setForeground(Color.white);

        LB1.setBackground(Color.black);
        LB2.setBackground(Color.black);
        LB3.setBackground(Color.black);
        LB4.setBackground(Color.black);
        LB5.setBackground(Color.black);

        homeButton.setBackground(Color.black);

        LB1.setBorderPainted(false);
        LB2.setBorderPainted(false);
        LB3.setBorderPainted(false);
        LB4.setBorderPainted(false);
        LB5.setBorderPainted(false);

        homeButton.setBorderPainted(false);

        LB1.setFont(new Font("",Font.PLAIN,19));
        LB2.setFont(new Font("",Font.PLAIN,19));
        LB3.setFont(new Font("",Font.PLAIN,19));
        LB4.setFont(new Font("",Font.PLAIN,19));
        LB5.setFont(new Font("",Font.PLAIN,19));

        homeButton.setFont(new Font("",Font.PLAIN,19));
        homeButton.setIcon(new ImageIcon(this.getClass().getResource("IMG_20210408_094116_750.png")));

        leftPanel1.add(homeButton);
        leftPanel.add(LB1);
        leftPanel.add(LB2);
        leftPanel.add(LB3);
        leftPanel.add(LB4);
        leftPanel.add(LB5);

        bottomPanel1.setLayout(new GridLayout());

        JButton bottomPanelB1 = new JButton("ADD NEW");
        bottomPanelB1.setBackground(Color.black);
        bottomPanelB1.setForeground(Color.white);
        bottomPanelB1.setOpaque(true);
        bottomPanelB1.setBorder(BorderFactory.createLineBorder(Color.white));
        bottomPanel1.add(bottomPanelB1);

        JButton bottomPanelB2 = new JButton("PROMOTE");
        bottomPanelB2.setBackground(Color.black);
        bottomPanelB2.setForeground(Color.white);
        bottomPanelB2.setOpaque(true);
        bottomPanelB2.setBorder(BorderFactory.createLineBorder(Color.white));
        bottomPanel1.add(bottomPanelB2);

        JButton bottomPanelB3 = new JButton("DELETE");
        bottomPanelB3.setBackground(Color.black);
        bottomPanelB3.setForeground(Color.white);
        bottomPanelB3.setOpaque(true);
        bottomPanelB3.setBorder(BorderFactory.createLineBorder(Color.white));
        bottomPanel1.add(bottomPanelB3);

        JButton bottomPanelB4 = new JButton("DEMOTE");
        bottomPanelB4.setBackground(Color.black);
        bottomPanelB4.setForeground(Color.white);
        bottomPanelB4.setOpaque(true);
        bottomPanelB4.setBorder(BorderFactory.createLineBorder(Color.white));
        bottomPanel2.add(bottomPanelB4);

        bottomPanel2.setLayout(new GridLayout());
        bottomPanel3.setLayout(new GridLayout());



        B1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                add(sp);
                bottomPanel.add(l1);
                l1.setVisible(true);
                l2.setVisible(false);
                l3.setVisible(false);
                l4.setVisible(false);
                sp.setVisible(true);
                sp1.setVisible(false);
                sp2.setVisible(false);
                sp3.setVisible(false);
                bottomPanel1.setVisible(true);
                bottomPanel2.setVisible(false);
                bottomPanel3.setVisible(false);
                bottomPanel1.add(bottomPanelB1);
                bottomPanel1.add(bottomPanelB2);
                bottomPanel1.add(bottomPanelB3);
            }
        });

        B2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                add(sp1);
                bottomPanel.add(l2);
                l1.setVisible(false);
                l2.setVisible(true);
                l3.setVisible(false);
                l4.setVisible(false);
                sp1.setVisible(true);
                sp.setVisible(false);
                sp2.setVisible(false);
                sp3.setVisible(false);
                add(bottomPanel2);
                bottomPanel2.add(bottomPanelB4);
                bottomPanel2.add(bottomPanelB2);
                bottomPanel2.add(bottomPanelB3);
                bottomPanel1.setVisible(false);
                bottomPanel2.setVisible(true);
                bottomPanel3.setVisible(false);
            }
        });

        B3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                add(sp2);
                bottomPanel.add(l3);
                l1.setVisible(false);
                l2.setVisible(false);
                l3.setVisible(true);
                l4.setVisible(false);
                sp2.setVisible(true);
                sp.setVisible(false);
                sp1.setVisible(false);
                sp3.setVisible(false);
                add(bottomPanel2);
                bottomPanel2.add(bottomPanelB4);
                bottomPanel2.add(bottomPanelB2);
                bottomPanel2.add(bottomPanelB3);
                bottomPanel1.setVisible(false);
                bottomPanel2.setVisible(true);
                bottomPanel3.setVisible(false);
            }
        });

        B4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                add(sp3);
                bottomPanel.add(l4);
                l1.setVisible(false);
                l2.setVisible(false);
                l3.setVisible(false);
                l4.setVisible(true);
                sp3.setVisible(true);
                sp.setVisible(false);
                sp1.setVisible(false);
                sp2.setVisible(false);
                add(bottomPanel3);
                bottomPanel3.add(bottomPanelB3);
                bottomPanel1.setVisible(false);
                bottomPanel2.setVisible(false);
                bottomPanel3.setVisible(true);
            }
        });

        JTextField ID = new JTextField();
        JTextField SoftwareName = new JTextField();
        JTextField ClientName = new JTextField();
        JTextField CreatedDate = new JTextField();

        Object[] message = {
                "ID:",ID,
                "Software Name:", SoftwareName,
                "Client Name: ", ClientName,
                "Created Date",CreatedDate
        };

        bottomPanelB1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null, message, "Add new Project", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {

                    String idVal = ID.getText();
                    String softwareVal = SoftwareName.getText();
                    String clientVal = ClientName.getText();
                    String dateVal = CreatedDate.getText();
                    String q;
                     Connection c = null;
                        try{
                            Class.forName("org.postgresql.Driver");
                            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
                            q="insert into newtable(id,software_name,client_name,created_date) values(?,?,?,?);";

                            PreparedStatement preparedStatement = c.prepareStatement(q);
                            preparedStatement.setInt(1,Integer.parseInt(idVal));
                            preparedStatement.setString(2,softwareVal);
                            preparedStatement.setString(3,clientVal);
                            preparedStatement.setString(4,dateVal);
                            preparedStatement.executeUpdate();
                            c.close();

                            System.out.println("Successfully Inserted");
                            ID.setText("");
                            SoftwareName.setText("");
                            ClientName.setText("");
                            CreatedDate.setText("");

                    }catch (Exception ex){
                        System.out.println(ex);
                    }
                    tableModel.insertRow(0, new Object[]{idVal, softwareVal, clientVal, dateVal});
                }else {
                    ID.setText("");
                    SoftwareName.setText("");
                    ClientName.setText("");
                    CreatedDate.setText("");
                }
            }
        });

        bottomPanelB2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                    int getSelectedRowForDeletion = jt.getSelectedRow();
                    int getSelectedRowForDeletion1 = jt1.getSelectedRow();
                    int getSelectedRowForDeletion2 = jt2.getSelectedRow();
                    String IdCell,NameSoftware,NameClient,DateCreated,q1,q;
                    Connection c = null;

                    try{
                        Class.forName("org.postgresql.Driver");
                        c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");

                        if (getSelectedRowForDeletion >= 0) {
                            Object[] selectedRow = tableModel.getDataVector().elementAt(jt.getSelectedRow()).toArray();
                            tableModel2.insertRow(0, selectedRow);
                            JOptionPane.showMessageDialog(null, "Row Promoted");

                            IdCell = (String)jt.getValueAt(getSelectedRowForDeletion,0);
                            NameSoftware = (String)jt.getValueAt(getSelectedRowForDeletion,1);
                            NameClient = (String)jt.getValueAt(getSelectedRowForDeletion,2);
                            DateCreated = (String)jt.getValueAt(getSelectedRowForDeletion,3);
                            q1="insert into inprogresstable(id,software_name,client_name,created_date) values(?,?,?,?);";

                            PreparedStatement preparedStatement1 = c.prepareStatement(q1);
                            preparedStatement1.setInt(1,Integer.parseInt(IdCell));
                            preparedStatement1.setString(2,NameSoftware);
                            preparedStatement1.setString(3,NameClient);
                            preparedStatement1.setString(4,DateCreated);
                            preparedStatement1.executeUpdate();
                            q="delete from newtable where id=?";
                            PreparedStatement preparedStatement = c.prepareStatement(q);
                            preparedStatement.setInt(1,Integer.parseInt(IdCell));
                            preparedStatement.executeUpdate();
                            tableModel.removeRow(getSelectedRowForDeletion);

                        }else if (getSelectedRowForDeletion1>= 0) {
                            Object[] selectedRow = tableModel1.getDataVector().elementAt(jt1.getSelectedRow()).toArray();
                            tableModel2.insertRow(0, selectedRow);
                            JOptionPane.showMessageDialog(null, "Row Promoted");

                            IdCell = (String)jt1.getValueAt(getSelectedRowForDeletion1,0);
                            NameSoftware = (String)jt1.getValueAt(getSelectedRowForDeletion1,1);
                            NameClient = (String)jt1.getValueAt(getSelectedRowForDeletion1,2);
                            DateCreated = (String)jt1.getValueAt(getSelectedRowForDeletion1,3);
                            q1="insert into inprogresstable(id,software_name,client_name,created_date) values(?,?,?,?);";

                            PreparedStatement preparedStatement1 = c.prepareStatement(q1);
                            preparedStatement1.setInt(1,Integer.parseInt(IdCell));
                            preparedStatement1.setString(2,NameSoftware);
                            preparedStatement1.setString(3,NameClient);
                            preparedStatement1.setString(4,DateCreated);
                            preparedStatement1.executeUpdate();
                            q="delete from pendingtable where id=?";
                            PreparedStatement preparedStatement = c.prepareStatement(q);
                            preparedStatement.setInt(1,Integer.parseInt(IdCell));
                            preparedStatement.executeUpdate();
                            tableModel1.removeRow(getSelectedRowForDeletion1);

                        }else if (getSelectedRowForDeletion2 >= 0) {
                            Object[] selectedRow = tableModel2.getDataVector().elementAt(jt2.getSelectedRow()).toArray();
                            tableModel3.insertRow(0, selectedRow);
                            JOptionPane.showMessageDialog(null, "Row Promoted");

                            IdCell = (String)jt2.getValueAt(getSelectedRowForDeletion2,0);
                            NameSoftware = (String)jt2.getValueAt(getSelectedRowForDeletion2,1);
                            NameClient = (String)jt2.getValueAt(getSelectedRowForDeletion2,2);
                            DateCreated = (String)jt2.getValueAt(getSelectedRowForDeletion2,3);
                            q1="insert into completedtable(id,software_name,client_name,created_date) values(?,?,?,?);";

                            PreparedStatement preparedStatement1 = c.prepareStatement(q1);
                            preparedStatement1.setInt(1,Integer.parseInt(IdCell));
                            preparedStatement1.setString(2,NameSoftware);
                            preparedStatement1.setString(3,NameClient);
                            preparedStatement1.setString(4,DateCreated);
                            preparedStatement1.executeUpdate();
                            q="delete from inprogresstable where id=?";
                            PreparedStatement preparedStatement = c.prepareStatement(q);
                            preparedStatement.setInt(1,Integer.parseInt(IdCell));
                            preparedStatement.executeUpdate();
                            tableModel2.removeRow(getSelectedRowForDeletion2);

                        }else {
                            JOptionPane.showMessageDialog(null, "Unable To Promote");
                        }
                        System.out.println("Successfully Inserted");
                        c.close();
                    }catch (Exception ex){
                        System.out.println(ex);
                    }
            }

        });

        bottomPanelB3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int getSelectedRowForDeletion = jt.getSelectedRow();
                int getSelectedRowForDeletion1 = jt1.getSelectedRow();
                int getSelectedRowForDeletion2 = jt2.getSelectedRow();
                int getSelectedRowForDeletion3 = jt3.getSelectedRow();
                String IdCell,q;
                Connection c = null;

            try{
                Class.forName("org.postgresql.Driver");
                c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");

                if (getSelectedRowForDeletion >=  0) {

                    IdCell = (String)jt.getValueAt(getSelectedRowForDeletion,0);
                    q="delete from newtable where id=?";

                    PreparedStatement preparedStatement = c.prepareStatement(q);
                    preparedStatement.setInt(1,Integer.parseInt(IdCell));
                    preparedStatement.executeUpdate();
                    c.close();
                    System.out.println("Successfully Deleted");
                    tableModel.removeRow(getSelectedRowForDeletion);
                    JOptionPane.showMessageDialog(null, "Row Deleted");

                } else if (getSelectedRowForDeletion1>=  0) {

                    IdCell = (String)jt1.getValueAt(getSelectedRowForDeletion1,0);
                    q="delete from pendingtable where id=?";

                    PreparedStatement preparedStatement = c.prepareStatement(q);
                    preparedStatement.setInt(1,Integer.parseInt(IdCell));
                    preparedStatement.executeUpdate();
                    c.close();
                    System.out.println("Successfully Deleted");
                    tableModel1.removeRow(getSelectedRowForDeletion1);
                    JOptionPane.showMessageDialog(null, "Row Deleted");

                }else if (getSelectedRowForDeletion2 >= 0) {

                    IdCell = (String)jt2.getValueAt(getSelectedRowForDeletion2,0);
                    q="delete from inprogresstable where id=?";

                    PreparedStatement preparedStatement = c.prepareStatement(q);
                    preparedStatement.setInt(1,Integer.parseInt(IdCell));
                    preparedStatement.executeUpdate();
                    c.close();
                    System.out.println("Successfully Deleted");
                    tableModel2.removeRow(getSelectedRowForDeletion2);
                    JOptionPane.showMessageDialog(null, "Row Deleted");

                }else if (getSelectedRowForDeletion3 >=  0) {
                     IdCell = (String)jt3.getValueAt(getSelectedRowForDeletion3,0);
                     q="delete from completedtable where id=?";

                     PreparedStatement preparedStatement = c.prepareStatement(q);
                     preparedStatement.setInt(1,Integer.parseInt(IdCell));
                     preparedStatement.executeUpdate();
                     c.close();
                     System.out.println("Successfully Deleted");
                     tableModel3.removeRow(getSelectedRowForDeletion3);
                     JOptionPane.showMessageDialog(null, "Row Deleted");

                }else {
                    JOptionPane.showMessageDialog(null, "Unable To Delete");
                }
                }catch (Exception ex){
                    System.out.println(ex);
                }

            }

        });

        bottomPanelB4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int getSelectedRowForDeletion1 = jt1.getSelectedRow();
                int getSelectedRowForDeletion2 = jt2.getSelectedRow();
                String IdCell,NameSoftware,NameClient,DateCreated,q1,q;
                Connection c = null;

                try{
                    Class.forName("org.postgresql.Driver");
                    c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");

                    if (getSelectedRowForDeletion1>=  0) {

                    Object[] selectedRow = tableModel1.getDataVector().elementAt(jt1.getSelectedRow()).toArray();
                    tableModel.insertRow(0, selectedRow);
                    JOptionPane.showMessageDialog(null, "Row Demoted");

                    IdCell = (String)jt1.getValueAt(getSelectedRowForDeletion1,0);
                    NameSoftware = (String)jt1.getValueAt(getSelectedRowForDeletion1,1);
                    NameClient = (String)jt1.getValueAt(getSelectedRowForDeletion1,2);
                    DateCreated = (String)jt1.getValueAt(getSelectedRowForDeletion1,3);
                    q1="insert into newtable(id,software_name,client_name,created_date) values(?,?,?,?);";

                    PreparedStatement preparedStatement1 = c.prepareStatement(q1);
                    preparedStatement1.setInt(1,Integer.parseInt(IdCell));
                    preparedStatement1.setString(2,NameSoftware);
                    preparedStatement1.setString(3,NameClient);
                    preparedStatement1.setString(4,DateCreated);
                    preparedStatement1.executeUpdate();
                    q="delete from pendingtable where id=?";
                    PreparedStatement preparedStatement = c.prepareStatement(q);
                    preparedStatement.setInt(1,Integer.parseInt(IdCell));
                    preparedStatement.executeUpdate();
                    tableModel1.removeRow(getSelectedRowForDeletion1);

                }else  if (getSelectedRowForDeletion2 >= 0) {

                    Object[] selectedRow = tableModel2.getDataVector().elementAt(jt2.getSelectedRow()).toArray();
                    tableModel1.insertRow(0, selectedRow);

                    IdCell = (String)jt2.getValueAt(getSelectedRowForDeletion2,0);
                    NameSoftware = (String)jt2.getValueAt(getSelectedRowForDeletion2,1);
                    NameClient = (String)jt2.getValueAt(getSelectedRowForDeletion2,2);
                    DateCreated = (String)jt2.getValueAt(getSelectedRowForDeletion2,3);
                    q1="insert into pendingtable(id,software_name,client_name,created_date) values(?,?,?,?);";

                    PreparedStatement preparedStatement1 = c.prepareStatement(q1);
                    preparedStatement1.setInt(1,Integer.parseInt(IdCell));
                    preparedStatement1.setString(2,NameSoftware);
                    preparedStatement1.setString(3,NameClient);
                    preparedStatement1.setString(4,DateCreated);
                    preparedStatement1.executeUpdate();
                    q="delete from inprogresstable where id=?";
                    PreparedStatement preparedStatement = c.prepareStatement(q);
                    preparedStatement.setInt(1,Integer.parseInt(IdCell));
                    preparedStatement.executeUpdate();
                    tableModel2.removeRow(getSelectedRowForDeletion2);
                    JOptionPane.showMessageDialog(null, "Row Demoted");

                }else {
                    JOptionPane.showMessageDialog(null, "Unable To Demote");
                }
                }catch (Exception ex){
                    System.out.println(ex);
                }
            }
        });

        rs.close();
        stmt.close();
        c.close();
        setLayout(null);
        setSize(1920,1080);
        setVisible(true);
    }

    public static void main(String[] args) {
        try{
            new Driver();
        }catch (SQLException ex){
            System.out.println(ex);
        }

    }
}

