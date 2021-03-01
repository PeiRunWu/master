package com.imooc.mgallery.service;

import com.imooc.mgallery.dao.PaintingDao;
import com.imooc.mgallery.entity.Painting;
import com.imooc.mgallery.utils.PageModel;


public class PaintingService {
    private PaintingDao paintingDao = new PaintingDao();

    public PageModel pagination(int page, int rows,String...category) {
        if (rows == 0) {
            throw new RuntimeException("无效的rows参数");
        }
        if(category.length == 0 || category[0] == null) {
            return paintingDao.pagination(page, rows);
        }else {
            return paintingDao.pagination(Integer.parseInt(category[0]),page,rows);
        }
    }

    public void create(Painting painting){
        paintingDao.create(painting);
    }

    public Painting findById(Integer id){
        Painting p  =paintingDao.findById(id);
        if(p == null){
            throw new RuntimeException("[id="+id+"]油画不存在");
        }
        return p;
    }

    public void upadate(Painting newPainting,int isPriviewModified){
        Painting oldID = this.findById(newPainting.getId());
        oldID.setPname(newPainting.getPname());
        oldID.setPrice(newPainting.getPrice());
        oldID.setCategory(newPainting.getCategory());
        oldID.setDescription(newPainting.getDescription());
        if(isPriviewModified == 1){
            oldID.setPreview(newPainting.getPreview());
        }
        paintingDao.update(oldID);
    }

    public void delete(Integer id){
        paintingDao.delete(id);
    }

}
