package com.imooc.mgallery.controller;

import com.imooc.mgallery.entity.Painting;
import com.imooc.mgallery.service.PaintingService;
import com.imooc.mgallery.utils.PageModel;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;

import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

@WebServlet("/management")
public class ManagementController extends HttpServlet {
    private PaintingService paintingService = new PaintingService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        String method = req.getParameter("method");
        if (method.equals("list")) {
            this.list(req, resp);
        } else if (method.equals("delete")) {
            this.deletePage(req,resp);
        } else if (method.equals("show_create")) {
            this.showCreatePage(req, resp);
        } else if (method.equals("create")) {
            this.create(req, resp);
        } else if (method.equals("show_update")) {
            this.showUpdate(req, resp);
        } else if (method.equals("update")) {
            this.updatePage(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("p");
        String rows = request.getParameter("r");
        if (page == null) {
            page = "1";
        }
        if (rows == null) {
            rows = "6";
        }
        PageModel pageModel = paintingService.pagination(Integer.parseInt(page), Integer.parseInt(rows));
        request.setAttribute("pageModel", pageModel);
        request.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(request, response);
    }

    private void updatePage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int isPreviewModified = 0;
        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload sf = new ServletFileUpload(factory);
        try {
            List<FileItem> formData = sf.parseRequest(req);
            Painting painting = new Painting();
            for (FileItem fi : formData) {
                if (fi.isFormField()) {
                    switch (fi.getFieldName()) {
                        case "pname":
                            painting.setPname(fi.getString("UTF-8"));
                            break;
                        case "category":
                            painting.setCategory(Integer.parseInt(fi.getString("UTF-8")));
                            break;
                        case "price":
                            painting.setPrice(Integer.parseInt(fi.getString("UTF-8")));
                            break;
                        case "description":
                            painting.setDescription(fi.getString("UTF-8"));
                            break;
                        case "id":
                            painting.setId(Integer.parseInt(fi.getString("UTF-8")));
                            break;
                        case "isPreviewModified":
                            isPreviewModified = Integer.parseInt(fi.getString("UTF-8"));
                            break;
                        default:
                            break;
                    }
                } else {
                    if (isPreviewModified == 1) {
                        System.out.println("文件上传项:" + fi.getFieldName());
                        //3.文件保存到服务器目录
                        String path = req.getServletContext().getRealPath("/upload");
                        System.out.println("上传文件目录:" + path);
                        //String fileName = "test.jpg";
                        String fileName = UUID.randomUUID().toString();
                        //fi.getName()得到原始文件名,截取最后一个.后所有字符串,例如:wxml.jpg->.jpg
                        String suffix = fi.getName().substring(fi.getName().lastIndexOf("."));
                        //fi.write()写入目标文件
                        fi.write(new File(path, fileName + suffix));
                        painting.setPreview("/upload/" + fileName + suffix);
                    }
                }
            }
            paintingService.upadate(painting, isPreviewModified);
            resp.sendRedirect("/management?method=list");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showCreatePage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/create.jsp").forward(req, resp);
    }

    private void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.初始化FileUpload组件
        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload sf = new ServletFileUpload(factory);
        //2.遍历所有的FileItem
        try {
            List<FileItem> items = sf.parseRequest(req);
            Painting painting = new Painting();
            for (FileItem fileItem : items) {
                if (!fileItem.isFormField()) {
                    String realPath = req.getServletContext().getRealPath("/upload");
                    String fileName = UUID.randomUUID().toString();
                    String suffix = fileItem.getName().substring(fileItem.getName().lastIndexOf("."));
                    fileItem.write(new File(realPath, fileName + suffix));
                    painting.setPreview("/upload/" + fileName + suffix);
                } else {
                    switch (fileItem.getFieldName()) {
                        case "pname":
                            painting.setPname(fileItem.getString("UTF-8"));
                            break;
                        case "category":
                            painting.setCategory(Integer.parseInt(fileItem.getString("UTF-8")));
                            break;
                        case "price":
                            painting.setPrice(Integer.parseInt(fileItem.getString("UTF-8")));
                            break;
                        case "description":
                            painting.setDescription(fileItem.getString("UTF-8"));
                            break;
                        default:
                            break;
                    }
                }
            }
            paintingService.create(painting);
            resp.sendRedirect("/management?method=list");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Painting painting = paintingService.findById(Integer.parseInt(id));
        req.setAttribute("painting", painting);
        req.getRequestDispatcher("/WEB-INF/jsp/update.jsp").forward(req, resp);
    }

    private void deletePage(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        PrintWriter out = resp.getWriter();
        try {
            paintingService.delete(Integer.parseInt(id));
            out.println("{\"result\":\"ok\"}");
        }catch(Exception e) {
            e.printStackTrace();
            out.println("{\"result\":\"" + e.getMessage() + "\"}");
        }
    }
}
