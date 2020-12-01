package com.wowowo.model;

import javax.swing.*;

//扑克标签类
public class PokerLabel extends JLabel {
    private int id;
    private String name;
    private int num;
    private boolean isout;
    private boolean isup;

    public PokerLabel() {
        this.setSize(105,150);
    }

    public PokerLabel(int id, String name, int num) {
        this.id = id;
        this.name = name;
        this.num = num;
    }

    public PokerLabel(int id, String name, int num, boolean isout, boolean isup) {
        this.id = id;
        this.name = name;
        this.num = num;
        this.isout = isout;
        this.isup = isup;

        if(isup){
            turnUp();
        }else{
            turndown();
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public boolean isIsout() {
        return isout;
    }

    public void setIsout(boolean isout) {
        this.isout = isout;
    }

    public boolean isIsup() {
        return isup;
    }

    public void setIsup(boolean isup) {
        this.isup = isup;
    }

    public void turnUp() {
        this.setIcon(new ImageIcon("C:\\java\\Landlord\\images\\poker" + id + ".jpg"));
    }

    public void turndown() {
        this.setIcon(new ImageIcon("C:\\java\\Landlord\\images\\poker\\down.jpg"));
    }
}
