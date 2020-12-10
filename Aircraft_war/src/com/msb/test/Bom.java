package com.msb.test;

import java.awt.*;

public class Bom {
    private int width;
    private int height;
    private int bomX;
    private int bomY;
    private int count;
    Image[] boms ={Images.Enemy01Images.getImage(),Images.Enemy02Images.getImage(),Images.Enemy03Images.getImage(),Images.Enemy04Images.getImage()};
    public Bom( int bomX, int bomY) {
        this.width = Images.Enemy01Images.getIconWidth();
        this.height = Images.Enemy01Images.getIconHeight();
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
        for(int i =0;i<boms.length;i++) {
            g.drawImage(boms[i], bomX, bomY, null);
        }
    }
}
