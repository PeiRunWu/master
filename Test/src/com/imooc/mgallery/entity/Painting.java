package com.imooc.mgallery.entity;

public class Painting {
    private int id; //油画id
    private String pname; //油画名字
    private int category; //油画分类
    private int price; //价格
    private String preview; // 油画图片地址
    private String description; //描述

    public Painting() {
    }

    public Painting(int id, String pname, int category, int price, String preview, String description) {
        this.id = id;
        this.pname = pname;
        this.category = category;
        this.price = price;
        this.preview = preview;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
