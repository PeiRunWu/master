package com.imooc.mgallery.utils;

import java.util.List;

public class PageModel {
    private int page; //页号
    private int totalPages; //总页数
    private int rows; //每页记录
    private int totoRows; //总记录数
    private int pageStartRow; //当前页从第n行开始
    private int pageEndRow; //当前页到n行结束
    private boolean hasNextPage; //是否存在下一页
    private boolean hasPreviousPage; //是否存在上一页
    private List pageData; //当前页面数据

    public PageModel() {

    }

    public PageModel(List data, int page, int rows) {
        this.page = page;
        this.rows = rows;
        totoRows = data.size();
        totalPages = new Double(Math.ceil(totoRows / (rows * 1f))).intValue();
        pageStartRow = (page - 1) * rows;
        pageEndRow = page * rows;
        if (pageEndRow > totoRows) {
            pageEndRow = totoRows;
        }
        pageData = data.subList(pageStartRow, pageEndRow);//得到分页数据
        if (page > 1) {
            hasPreviousPage = true;
        } else {
            hasPreviousPage = false;
        }
        if(page < totalPages){
            hasNextPage = true;
        }else {
            hasNextPage = false;
        }
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getTotoRows() {
        return totoRows;
    }

    public void setTotoRows(int totoRows) {
        this.totoRows = totoRows;
    }

    public int getPageStartRow() {
        return pageStartRow;
    }

    public void setPageStartRow(int pageStartRow) {
        this.pageStartRow = pageStartRow;
    }

    public int getPageEndRow() {
        return pageEndRow;
    }

    public void setPageEndRow(int pageEndRow) {
        this.pageEndRow = pageEndRow;
    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public boolean isHasPreviousPage() {
        return hasPreviousPage;
    }

    public void setHasPreviousPage(boolean hasPreviousPage) {
        this.hasPreviousPage = hasPreviousPage;
    }

    public List getPageData() {
        return pageData;
    }

    public void setPageData(List pageData) {
        this.pageData = pageData;
    }

}
