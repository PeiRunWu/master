package com.wowowo.view;

import javax.swing.*;
import java.awt.*;

public class Mypanel extends JPanel {
    public Mypanel(){
        this.setLayout(null);
    }
    @Override
    protected void paintComponent(Graphics g) {
        Image image =new ImageIcon("C:\\java\\Landlord\\images\\bg\\bg1.png").getImage();
        g.drawImage(image,0,0,this.getWidth(),this.getHeight(),null);
    }
}
