package com.msb.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class GamePanel extends JPanel implements KeyListener {
    //定义飞机方向
    boolean left, right, up, down;
    //定义游戏是否开始
    boolean isStart = true;
    //定义游戏界面是否显示
    boolean isShow = true;
    //定义飞机的坐标
    int planeX = 200;
    int planeY = 690;

    public GamePanel() {
        this.setFocusable(true);
        addKeyListener(this);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //绘制背景图片
        Images.backgroundImages.paintIcon(this, g, 0, 0);
        //绘制飞机
        Images.PlaneImages.paintIcon(this, g, planeX, planeY);
        //绘制开始界面标题
        if (isShow) {
            Images.Aircraft_warImages.paintIcon(this, g, 40, 60);
        }
        //绘制pause界面
        if (isStart && isShow == false) {
            Images.PauseImages.paintIcon(this, g, 40, 60);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keycode = e.getKeyCode();
        if (keycode == KeyEvent.VK_SPACE) {
            isStart = !isStart;
            isShow = false;
        }
        if (keycode == KeyEvent.VK_DOWN) {
            planeY += 5;
        }
        if (keycode == KeyEvent.VK_UP) {
            planeY -= 5;
        }
        if (keycode == KeyEvent.VK_LEFT) {
            planeX -= 5;
        }
        if (keycode == KeyEvent.VK_RIGHT) {
            planeX += 5;
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) { }
    @Override
    public void keyTyped(KeyEvent e) { }
}
