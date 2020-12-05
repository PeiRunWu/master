package com.msb.game;

import javax.swing.*;
import java.net.URL;

/**
 * 专门用来获取游戏中所涉及的图片
 */
public class Image {
    //将图片的路径封装为路径
    public  static URL bodyURL= Image.class.getResource("/images/body.png");
    //将图片封装为程序中一个对象
    public static ImageIcon bodyImg = new ImageIcon(bodyURL);
    //将图片的路径封装为路径
    public  static URL downURL= Image.class.getResource("/images/down.png");
    //将图片封装为程序中一个对象
    public static ImageIcon downImg = new ImageIcon(downURL);
    //将图片的路径封装为路径
    public  static URL foodURL= Image.class.getResource("/images/food.png");
    //将图片封装为程序中一个对象
    public static ImageIcon foodImg = new ImageIcon(foodURL);
    //将图片的路径封装为路径
    public  static URL headerURL= Image.class.getResource("/images/header.png");
    //将图片封装为程序中一个对象
    public static ImageIcon headerImage = new ImageIcon(headerURL);
    //将图片的路径封装为路径
    public  static URL leftURL= Image.class.getResource("/images/left.png");
    //将图片封装为程序中一个对象
    public static ImageIcon leftImg = new ImageIcon(leftURL);
    //将图片的路径封装为路径
    public  static URL rightURL= Image.class.getResource("/images/right.png");
    //将图片封装为程序中一个对象
    public static ImageIcon rightImg = new ImageIcon(rightURL);
    //将图片的路径封装为路径
    public  static URL upURL= Image.class.getResource("/images/up.png");
    //将图片封装为程序中一个对象
    public static ImageIcon upImg = new ImageIcon(upURL);
}
