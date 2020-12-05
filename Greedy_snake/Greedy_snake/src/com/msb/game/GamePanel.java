package com.msb.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GamePanel extends JPanel {
    //定义两个数组存储X，Y轴坐标
    int[] snakex = new int[200];
    int[] snakey = new int[200];
    //定义蛇的长度
    int length;
    //定义蛇行走的方向
    String direction;
    //定义游戏状态
    boolean isStart = false;
    //定义食物的x,y坐标
    int foodx;
    int foody;
    //定义一个积分
    int score;
    //定义一个死亡状态
    boolean isDie = false;

    //定义初始化
    public void init() {
        //初始化蛇的长度
        length = 3;
        //初始化蛇头坐标
        snakex[0] = 175;
        snakey[0] = 275;
        //初始化第一节身子坐标
        snakex[1] = 150;
        snakey[1] = 275;
        //初始化第二节身子坐标
        snakex[2] = 125;
        snakey[2] = 275;
        //初始蛇头的方向
        direction = "R";
        foodx = 300;
        foody = 200;
    }

    public GamePanel() {
        init();
        //将焦点定位到当前操作面板上
        this.setFocusable(true);
        //定义监听
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                int keycode = e.getKeyCode();
                if (keycode == KeyEvent.VK_SPACE) {
                    if (isDie) {
                        //恢复到初始状态下
                        init();
                        isDie = false;
                    } else {
                        isStart = !isStart;
                        repaint();
                    }
                }
                if (keycode == KeyEvent.VK_UP) {
                    direction = "U";
                }
                if (keycode == KeyEvent.VK_DOWN) {
                    direction = "D";
                }
                if (keycode == KeyEvent.VK_LEFT) {
                    direction = "L";
                }
                if (keycode == KeyEvent.VK_RIGHT) {
                    direction = "R";
                }

            }
        });
        //对定时器初始化,定义一个定时器
        new Timer(100, new ActionListener() {
            /**
             * 事件监听，相当每100ms监听一下
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isStart && isDie == false) {//游戏开始时蛇开始动
                    //后一节身子走到前一个身子上
                    for (int i = length - 1; i > 0; i--) {
                        snakex[i] = snakex[i - 1];
                        snakey[i] = snakey[i - 1];
                    }
                    //动头
                    if (direction.equals("R")) {
                        snakex[0] += 25;
                    } else if (direction.equals("L")) {
                        snakex[0] -= 25;
                    } else if (direction.equals("U")) {
                        snakey[0] -= 25;
                    } else {
                        snakey[0] += 25;
                    }
                    //防止蛇超出界面
                    if (snakex[0] > 750 || snakex[0] < 25 || snakey[0] > 725 || snakey[0] < 100) {
                        isDie = true;
                    }
                    //检测蛇头和食物碰撞
                    if (snakex[0] == foodx && snakey[0] == foody) {
                        //蛇长度++
                        length++;
                        foodx = ((int) (Math.random() * 30) + 1) * 25;//[25,750]
                        foody = ((int) (Math.random() * 26) + 4) * 25;//[100,725]
                        score += 10; //吃上食物积分加10
                    }
                    //死亡判定
                    for (int i = 1; i < length; i++) {
                        if (snakey[i] == snakey[0] && snakex[i] == snakex[0]) {
                            isDie = true;
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
        //填充背景颜色
        this.setBackground(new Color(229, 211, 211));
        //画头部图片
        Image.headerImage.paintIcon(this, g, 10, 10);
        //调节画笔颜色
        g.setColor(new Color(233, 241, 223));
        //画一个矩形
        g.fillRect(10, 70, 770, 685);
        //画蛇头
        if (direction.equals("R")) {
            Image.rightImg.paintIcon(this, g, snakex[0], snakey[0]);
        } else if (direction.equals("L")) {
            Image.leftImg.paintIcon(this, g, snakex[0], snakey[0]);
        } else if (direction.equals("U")) {
            Image.upImg.paintIcon(this, g, snakex[0], snakey[0]);
        } else {
            Image.downImg.paintIcon(this, g, snakex[0], snakey[0]);
        }
        //画身子
        for (int i = 1; i < length; i++) {
            Image.bodyImg.paintIcon(this, g, snakex[i], snakey[i]);
        }
        //画食物
        Image.foodImg.paintIcon(this, g, foodx, foody);
        //画积分
        g.setColor(new Color(255, 255, 255));
        g.setFont(new Font("微软雅黑", Font.BOLD, 20));
        g.drawString("积分：" + score, 680, 40);
        //如果游戏是暂停的，界面当中有一条提示语
        if (isStart == false) {
            //设置一个文字
            g.setColor(new Color(114, 98, 255));
            g.setFont(new Font("微软雅黑", Font.BOLD, 40));
            g.drawString("点击空格开始游戏", 250, 330);
        }
        //如果游戏失败，出现提示语
        if (isDie) {
            //设置一个文字
            g.setColor(new Color(255, 82, 68));
            g.setFont(new Font("微软雅黑", Font.BOLD, 20));
            g.drawString("小蛇死亡,游戏停止,按下空格重新开始", 220, 330);
        }
    }
}
