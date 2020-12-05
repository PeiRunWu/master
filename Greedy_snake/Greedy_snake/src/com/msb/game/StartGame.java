package com.msb.game;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class StartGame {
    public static void main(String[] args) {
        //创建窗体
        JFrame jFrame = new JFrame();
        //给窗体设置一个标题
        jFrame.setTitle("小游戏 大逻辑 by CaroLe");
        //设置窗体的坐标,对应窗体的宽和高
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        jFrame.setBounds((width - 800) / 2, (height - 800) / 2, 800, 800);
        //设置窗体大小不可调
        jFrame.setResizable(false);
        //关闭窗口时程序关闭
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //创建面板
        GamePanel gamePanel = new GamePanel();
        jFrame.add(gamePanel);
        //默认窗体是隐藏效果，必须将窗体显性
        jFrame.setVisible(true);

    }
}
