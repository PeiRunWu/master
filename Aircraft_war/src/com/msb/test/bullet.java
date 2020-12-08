package com.msb.test;

import java.awt.*;

public class bullet {
    //定义子弹的高宽
    private int width;
    private int height;
    //定义子弹的坐标
    private int bulletX;
    private int bulletY;

    public bullet(int bulletX,int bulletY) {
        this.bulletX=bulletX;
        this.bulletY=bulletY;
        this.width=Images.bulletImages.getIconWidth();
        this.height = Images.bulletImages.getIconHeight();
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

    public int getBulletX() {
        return bulletX;
    }

    public void setBulletX(int bulletX) {
        this.bulletX = bulletX;
    }

    public int getBulletY() {
        return bulletY;
    }

    public void setBulletY(int bulletY) {
        this.bulletY = bulletY;
    }

    public void move(){
        this.bulletY -=7;
    }
    public void drawImage(Graphics g){
        g.drawImage(Images.bulletImages.getImage(),this.bulletX,this.bulletY,null);
    }
}
