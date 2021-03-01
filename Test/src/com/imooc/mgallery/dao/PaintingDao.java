package com.imooc.mgallery.dao;

import com.imooc.mgallery.entity.Painting;
import com.imooc.mgallery.utils.PageModel;
import com.imooc.mgallery.utils.XmlDataSource;

import java.util.ArrayList;
import java.util.List;

public class PaintingDao {
    /**
     * 分页查询油画数据
     * @param page 页号
     * @param rows 每页记录书
     * @return PageModel分页对象
     */
    public PageModel pagination(int page, int rows) {
        List<Painting> list = XmlDataSource.getRawData();
        PageModel pageModel = new PageModel(list, page, rows);
        return pageModel;
    }

    public  PageModel pagination(int category,int page,int rows){
        List<Painting> list = XmlDataSource.getRawData();
        List<Painting> categoryList = new ArrayList<>();
        for(Painting painting :list){
            if(painting.getCategory() == category){
                categoryList.add(painting);
            }
        }
        PageModel pageModel = new PageModel(categoryList, page, rows);
        return pageModel;
    }

    public void create(Painting painting){
        XmlDataSource.append(painting);
    }

    public Painting findById(Integer id){
        List<Painting> data = XmlDataSource.getRawData();
        Painting painting = null;
        for(Painting p : data){
            if(p.getId() == id){
                painting =p;
                break;
            }
        }
        return painting;
    }

    public void update(Painting painting){
        XmlDataSource.update(painting);
    }

    public  void delete(Integer id){
        XmlDataSource.delete(id);
    }
}
