package com.msb.test;
/**
 * 小型敌机类
 */

import java.awt.*;
import java.util.Random;

public class SmallEnemy {
    //定义小型敌机的宽和高
    private int width;
    private int height;
    //定义小型敌机的坐标
    private int SmallEnemyX;
    private int SmallEnemyY;

    public SmallEnemy() {
        Random random = new Random();
        random.nextInt(10);
        this.width = Images.EnemyImages.getIconWidth();
        this.height = Images.EnemyImages.getIconHeight();
        this.SmallEnemyX = random.nextInt(StartGame.width - width / 2);
        this.SmallEnemyY = -random.nextInt(StartGame.height - height / 2);
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

    public int getSmallEnemyX() {
        return SmallEnemyX;
    }

    public void setSmallEnemyX(int smallEnemyX) {
        SmallEnemyX = smallEnemyX;
    }

    public int getSmallEnemyY() {
        return SmallEnemyY;
    }

    public void setSmallEnemyY(int smallEnemyY) {
        SmallEnemyY = smallEnemyY;
    }
    public void move(){
        this.SmallEnemyY +=1;
    }
    public void drawImage(Graphics g){
        g.drawImage(Images.EnemyImages.getImage(),this.SmallEnemyX,this.SmallEnemyY,null);
    }
}
