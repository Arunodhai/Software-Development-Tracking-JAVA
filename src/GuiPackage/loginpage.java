package GuiPackage;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class loginpage extends JFrame
{

    private JFrame frame;
    private JPanel panel;
    private JButton button;

    public loginpage() {

        frame = new JFrame();
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setSize(1920,1080);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        panel = new JPanel();
        panel.setBounds(470, 250, 450, 270);
        panel.setBorder(BorderFactory.createLineBorder(Color.cyan,5));
        Color blue= new Color(0, 0, 60);
        panel.setBackground(blue);

        JPanel panel2 = new JPanel();
        panel2.setBounds(0, 0, 1600, 100);
        panel2.setBackground(Color.black);

        button = new JButton("Login");
        button.setBounds(640, 420, 70, 20);
        JTextField t = new JTextField("");
        t.setBounds(640,330,90,25);
        JLabel l;
        l = new JLabel("UserName : ");
        l.setForeground(Color.white);
        l.setFont(new Font("Serif", Font.PLAIN, 17));
        l.setBounds(550, 330, 90, 20);

        JTextField t1 = new JTextField("");
        t1.setBounds(640,360,90,25);
        JLabel l1;
        l1 = new JLabel("Password :");
        l1.setBounds(550, 355, 90, 35);
        l1.setForeground(Color.white);
        l1.setFont(new Font("Serif", Font.PLAIN, 17));
        JLabel l2 = new JLabel("A-One Software Solutions");
        l2.setBounds(425,20, 600, 60);
        l2.setForeground(Color.white);
        l2.setFont(new Font("Serif", Font.PLAIN, 56));

        JLabel l3;
        l3 = new JLabel("Version 1.13");
        l3.setForeground(Color.black);
        l3.setFont(new Font("Serif", Font.PLAIN, 15));
        l3.setBounds(1400,0, 80, 80);

        frame.add(l2);
        frame.add(panel2);
        frame.add(l1);
        frame.add(l3);
        frame.add(t1);
        frame.add(t);
        frame.add(l);
        frame.add(button);
        frame.add(panel);

        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                String username = l.getText();
                String password = l1.getText();
                String q;
                Connection c = null;
                try{
                    Class.forName("org.postgresql.Driver");
                    c = DriverManager.getConnection("jdbc:postgresql://localhost:5133/loginpage", "postgres", "postgres");
                    q="insert into logininformation(username,password) values(?,?);";
                    PreparedStatement preparedStatement = c.prepareStatement(q);
                    preparedStatement.setString(1,username);
                    preparedStatement.setString(2,password);
                    preparedStatement.executeUpdate();
                    c.close();
                    System.out.println("Successfully Inserted");
                }catch (Exception ex){
                System.out.println(ex);
            }

        }
        });
    }
    public static void main(String[] args)
    {
        loginpage lp = new loginpage();
        lp.setVisible(true);

    }

}