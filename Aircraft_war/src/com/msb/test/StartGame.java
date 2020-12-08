package com.msb.test;

import javax.swing.*;
import java.awt.*;

public class StartGame {
    static int width = 480;
    static int height = 852;
    public static void main(String[] args) {
        JFrame jFrame =new JFrame();
        jFrame.setTitle("飞机大战小游戏");
        //设置图片大小
        jFrame.setSize(width,height);
        //将图片设置到中间
        jFrame.setLocationRelativeTo(null);
        //设置窗口不可以调节
        jFrame.setResizable(false);
        //设置窗口关闭程序随之关闭
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        GamePanel gamePanel =new GamePanel();
        jFrame.add(gamePanel);
        //设置窗口
        jFrame.setVisible(true);
    }
}
