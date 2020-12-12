package com.msb.test;

import java.awt.*;

public class EnemyBom {
    private int width;
    private int height;
    private int bomX;
    private int bomY;
    private int count;
    Image[] EnemyBom ={Images.Enemy_plane01Images.getImage(),Images.Enemy_plane02Images.getImage(),Images.Enemy_plane03Images.getImage(),Images.Enemy_plane04Images.getImage()};
    public EnemyBom( int bomX, int bomY) {
        this.width = Images.Enemy_plane01Images.getIconWidth();
        this.height = Images.Enemy_plane01Images.getIconHeight();
        this.bomX = bomX;
        this.bomY = bomY;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
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

    public int getBomX() {
        return bomX;
    }

    public void setBomX(int bomX) {
        this.bomX = bomX;
    }

    public int getBomY() {
        return bomY;
    }

    public void setBomY(int bomY) {
        this.bomY = bomY;
    }
    public void move(){
        count ++;
    }
    public void drawImage(Graphics g) {
        for(int i =0;i<EnemyBom.length;i++) {
            g.drawImage(EnemyBom[i], bomX, bomY, null);
        }
    }
}
