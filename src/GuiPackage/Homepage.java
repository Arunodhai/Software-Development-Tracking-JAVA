package GuiPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Homepage extends  Canvas {


    public void paint(Graphics g) {

        Toolkit t=Toolkit.getDefaultToolkit();
        Image i=t.getImage("/Users/arunodhaiv/Downloads/1132045.jpg");

        g.drawImage(i, 0,0,this);


    }
    public static void main(String[] args) {
        Homepage m=new Homepage();
        JFrame f=new JFrame();
        f.add(m);
        f.setSize(1920,1080);
        f.setVisible(true);
    }

}
