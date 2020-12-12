package com.msb.test;

import java.awt.*;
import java.util.Random;

/**
 * 大型敌机类
 */
public class Enemy {
    //定义大型敌机的宽和高
    private int width;
    private int height;
    //定义大型敌机的坐标
    private int EnemyX;
    private int EnemyY;

    public Enemy() {
        //定义图片的高
        this.height = Images.Enemy_planeImages.getIconHeight();
        this.width = Images.Enemy_planeImages.getIconWidth();
        //定义敌机的xy轴，创建随机
        Random random = new Random();
        random.nextInt(10);
        this.EnemyX = random.nextInt(StartGame.width - width / 2);
        this.EnemyY = 10;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getEnemyX() {
        return EnemyX;
    }

    public void setEnemyX(int enemyX) {
        EnemyX = enemyX;
    }

    public int getEnemyY() {
        return EnemyY;
    }

    public void setEnemyY(int enemyY) {
        EnemyY = enemyY;
    }

    public void move(){
        this.EnemyY +=1;
    }
    public void drawImage(Graphics g){
        g.drawImage(Images.Enemy_planeImages.getImage(),this.EnemyX,this.EnemyY,null);
    }

}
