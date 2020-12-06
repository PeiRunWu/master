package com.msb.test;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class StartGame {
    public static void main(String[] args) {
        //构建一个窗体
        JFrame jFrame = new JFrame();
        //给窗体加一个标题
        jFrame.setTitle("小游戏 大逻辑 by 裴润悟");
        //将窗体弹出设为中间,窗体大小
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        jFrame.setBounds((width - 800) / 2, (height - 800) / 2, 800, 800);
        //将窗体设为不可以调节
        jFrame.setResizable(false);
        //窗体关闭程序随之关闭
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //将图片信息加入进来
        GamePanel gamePanel = new GamePanel();
        jFrame.add(gamePanel);
        //将窗体显现出来
        jFrame.setVisible(true);
    }
}
