package GuiPackage;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class mainpage extends  Canvas
{


     JFrame frame;
     JPanel panel;
     JButton a,b,c,d,e;

    public void paint(Graphics g) {

        Toolkit t = Toolkit.getDefaultToolkit();
        Image i = t.getImage("/Users/arunodhaiv/Downloads/1132045.jpg");

        g.drawImage(i, 0, 0, this);


    }


    public mainpage() {

        frame = new JFrame();
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setSize(1920,1080);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        JPanel panel2 = new JPanel();
        panel2.setBounds(0, 0, 1600, 100);
        panel2.setBackground(Color.black);

        a = new JButton("Developers");
        a.setFont(new Font("Serif", Font.PLAIN, 18));
        a.setBounds(460, 275, 150, 120);
        b = new JButton("Clients");
        b.setFont(new Font("Serif", Font.PLAIN, 18));
        b.setBounds(635, 275, 150, 120);
        c = new JButton("Software");
        c.setFont(new Font("Serif", Font.PLAIN, 18));
        c.setBounds(810, 275, 150, 120);
        d = new JButton("Tracking");
        d.setFont(new Font("Serif", Font.PLAIN, 18));
        d.setBounds(545, 415, 150, 120);
        e = new JButton("Finance");
        e.setFont(new Font("Serif", Font.PLAIN, 18));
        e.setBounds(725, 415, 150, 120);

        JLabel l2 = new JLabel("A-One Software Solutions");
        l2.setBounds(425,20, 600, 60);
        l2.setForeground(Color.white);
        l2.setFont(new Font("Serif", Font.PLAIN, 56));

        /*JLabel l3;
        l3 = new JLabel("Version 1.13");
        l3.setForeground(Color.black); 
        l3.setFont(new Font("Serif", Font.PLAIN, 15));
        l3.setBounds(1400,0, 80, 80);*/

        frame.add(l2);
        frame.add(panel2);
        frame.add(a);
        frame.add(b);
        frame.add(c);
        frame.add(d);
        frame.add(e);

    }
    public static void main(String args[])
    {

        mainpage mp = new mainpage();

        mp.setVisible(true);

    }
}
/*setLayout(new BorderLayout());
        JLabel background=new JLabel(new ImageIcon("C:\\Users\\asus\\Desktop\\bg.jpeg"));
        add(background);*/