package GuiPackage;
import javax.swing.*;
import java.awt.*;

public class GUIExample extends JFrame  {
    JFrame f;
    GUIExample(){
        JPanel leftPanel = new JPanel();
        JPanel topPanel = new JPanel();
        JPanel bottomPanel = new JPanel();
        JPanel bottomPanel1 = new JPanel();

        leftPanel.setBounds(0,65,260,1021);
        topPanel.setBounds(260,65,1180,66);
        bottomPanel1.setBounds(260,760,1180,66);
        bottomPanel.setBounds(0,825,1500,30);

        leftPanel.setBackground(Color.black);
        topPanel.setBackground(Color.black);
        bottomPanel1.setBackground(Color.black);
        bottomPanel.setBackground(Color.decode("#FF7121"));

        add(leftPanel);
        add(topPanel);
        add(bottomPanel1);
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

        JButton homeButton = new JButton("Home");
        JButton LB1 = new JButton("Developers");
        JButton LB2 = new JButton("Clients");
        JButton LB3 = new JButton("Softwares");
        JButton LB4 = new JButton("Tracking");

        leftPanel.setLayout(new BoxLayout(leftPanel,BoxLayout.Y_AXIS));
        leftPanel.add(homeButton);
        leftPanel.add(LB1);
        leftPanel.add(LB2);
        leftPanel.add(LB3);
        leftPanel.add(LB4);

        setLayout(null);
        setSize(1920,1080);
        setVisible(true);

    }

    public static void main(String[] args) {
        new GUIExample();
    }
}
