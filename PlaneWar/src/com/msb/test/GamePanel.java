package com.msb.test;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel {
    //定义飞机的x y轴坐标
    int planeX;
    int planeY;
    //定义蜜蜂的x y轴坐标
    int[] beeX = new int[10];
    int[] beeY = new int[10];
    //定义游戏是否开始
    boolean isStart = false;
    //定义飞机的方向
    boolean left, right, up, down;
    //定义炮弹的幅度
    double[] degress = new double[10];
    //定义一个变量判断飞机是否炸毁
    boolean isDie = false;
    //定义开始和结束时间
    long startTime;
    long endTime;

    public void init() {
        //初始化飞机坐标
        planeX = 400;
        planeY = 650;
        //初始化蜜蜂坐标
        for (int i = 0; i < 10; i++) {
            beeX[i] = 100;
            beeY[i] = 100;
            //给每一个炮弹设计随机的弧度
            degress[i] = (int) (Math.random() * 2 * Math.PI);
        }
    }

    public GamePanel() {
        startTime = System.currentTimeMillis();
        init();
        //设置焦点在面板上
        this.setFocusable(true);
        //加入监听
        this.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                int keycode = e.getKeyCode();
                if (keycode == KeyEvent.VK_SPACE) {
                    if(isDie){
                        init();
                        isDie = false;
                    }else{
                        isStart = !isStart;
                    }
                    repaint();
                }
                if (keycode == KeyEvent.VK_DOWN) {
                    down = true;
                }
                if (keycode == KeyEvent.VK_UP) {
                    up = true;
                }
                if (keycode == KeyEvent.VK_LEFT) {
                    left = true;
                }
                if (keycode == KeyEvent.VK_RIGHT) {
                    right = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                int keycode = e.getKeyCode();
                if (keycode == KeyEvent.VK_DOWN) {
                    down = false;
                }
                if (keycode == KeyEvent.VK_UP) {
                    up = false;
                }
                if (keycode == KeyEvent.VK_LEFT) {
                    left = false;
                }
                if (keycode == KeyEvent.VK_RIGHT) {
                    right = false;
                }
            }
        });
        //初始定时器
        new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isStart && isDie ==false) {
                    if (left) {
                        planeX -= 7;
                    }
                    if (right) {
                        planeX += 7;
                    }
                    if (up) {
                        planeY -= 7;
                    }
                    if (down) {
                        planeY += 7;
                    }
                    //炮弹按弧度动
                    for (int i = 0; i < degress.length; i++) {
                        beeX[i] += Math.cos(degress[i]) * 7;
                        beeY[i] += Math.sin(degress[i]) * 7;
                        //炮弹跑到另一个边界从另一个边界过来
                        if (beeX[i] <= 0) {
                            beeX[i] = 700;
                        }
                        if (beeX[i] > 700) {
                            beeX[i] = 0;
                        }
                        if (beeY[i] <= 30) {
                            beeY[i] = 700;
                        }
                        if (beeY[i] > 700) {
                            beeY[i] = 30;
                        }

                        //每个蜜蜂和飞机进行检测
                        boolean intersects = new Rectangle(planeX, planeY, 50, 30).intersects(new Rectangle(beeX[i], beeY[i], 50, 40));
                        if (intersects) {
                            isDie =true;
                            endTime = System.currentTimeMillis();
                        }
                    }
                    repaint();
                }
            }
        }).start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //给背景设置背景图片
        Images.backgroundImages.paintIcon(this, g, 0, 0);
        //将飞机图片画上
        Images.planeImages.paintIcon(this, g, planeX, planeY);
        //画蜜蜂
        for (int i = 0; i < 10; i++) {
            Images.beeImages.paintIcon(this, g, beeX[i], beeY[i]);
        }
        //显示开始游戏界面
        if (isStart == false) {
            g.setColor(new Color(238, 106, 106));
            g.setFont(new Font("微软雅黑", Font.BOLD, 40));
            g.drawString("按下空格键开始游戏", 200, 400);
        }
        if (isDie){
            g.setColor(new Color(238, 106, 106));
            g.setFont(new Font("微软雅黑", Font.BOLD, 40));
            g.drawString("游戏结束，存活了"+(endTime- startTime) / 1000+"秒", 200, 400);
        }

    }
}
