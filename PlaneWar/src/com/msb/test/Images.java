package com.msb.test;

import javax.swing.*;
import java.net.URL;

public class Images {
     //将背景图片封装为一个对象
     static URL backgroundURL = Images.class.getResource("/images/background.png");
     static ImageIcon backgroundImages = new ImageIcon(backgroundURL);
    //将炸弹图片封装为一个对象
     static URL beeURL = Images.class.getResource("/images/bee.png");
     static ImageIcon beeImages = new ImageIcon(beeURL);
    //将飞机图片封装为一个对象
     static URL planeURL = Images.class.getResource("/images/plane.png");
     static ImageIcon planeImages = new ImageIcon(planeURL);
}
