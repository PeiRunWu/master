package com.imooc.mgallery.utils;

import com.imooc.mgallery.entity.Painting;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

/**
 * 数据源类,用于将XML文件解析为java对象
 */
public class XmlDataSource {
    //通过static静态关键字保证数据全局唯一
    private static List<Painting> data = new ArrayList();
    private static String dataFile;

    static {
        dataFile = XmlDataSource.class.getResource("/painting.xml").getPath();
        reload();
    }

    private static void reload() {
        try {
            dataFile = URLDecoder.decode(dataFile, "UTF-8");
            SAXReader reader = new SAXReader();
            //获取Document文档对象
            Document document = reader.read(dataFile);
            // Xpatch 获取XML节点集合
            List<Node> nodes = document.selectNodes("/root/painting");
            data.clear();
            for (Node node : nodes) {
                Element element = (Element) node;
                String id = element.attributeValue("id");
                String pname = element.elementText("pname");
                Painting painting = new Painting();
                painting.setId(Integer.parseInt(id));
                painting.setPname(pname);
                painting.setCategory(Integer.parseInt(element.elementText("category")));
                painting.setPrice(Integer.parseInt(element.elementText("price")));
                painting.setPreview(element.elementText("preview"));
                painting.setDescription(element.elementText("description"));
                data.add(painting);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Painting> getRawData() {
        return data;
    }

    public static void append(Painting painting) {
        SAXReader reader = new SAXReader();
        Writer writer = null;
        try {
            Document document = reader.read(dataFile);
            Element rootElement = document.getRootElement();
            Element p = rootElement.addElement("painting");
            p.addAttribute("id", String.valueOf(data.size() + 1));
            p.addElement("pname").setText(painting.getPname());
            p.addElement("category").setText(String.valueOf(painting.getCategory()));
            p.addElement("price").setText(String.valueOf(painting.getPrice()));
            p.addElement("preview").setText(painting.getPreview());
            p.addElement("description").setText(painting.getDescription());
            writer = new OutputStreamWriter(new FileOutputStream(dataFile), "UTF-8");
            document.write(writer);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            reload();
        }
    }

    public static void update(Painting painting) {
        SAXReader reader = new SAXReader();
        Writer writer = null;
        try {
            Document document = reader.read(dataFile);
            List<Node> nodes = document.selectNodes("/root/painting[@id=" + painting.getId() + "]");
            if (nodes.size() == 0) {
                throw new RuntimeException("id=" + painting.getId() + "编号油画不存在");
            }
            Element p = (Element) nodes.get(0);
            p.selectSingleNode("pname").setText(painting.getPname());
            p.selectSingleNode("category").setText(String.valueOf(painting.getCategory()));
            p.selectSingleNode("price").setText(String.valueOf(painting.getPrice()));
            p.selectSingleNode("description").setText(painting.getDescription());
            p.selectSingleNode("preview").setText(painting.getPreview());
            writer = new OutputStreamWriter(new FileOutputStream(dataFile), "UTF-8");
            document.write(writer);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            reload();
        }
    }
    public static void delete (Integer id){
        SAXReader reader = new SAXReader();
        Writer writer = null;
        try {
            Document document = reader.read(dataFile);
            List<Node> nodes = document.selectNodes("/root/painting[@id=" + id + "]");
            if (nodes.size() == 0) {
                throw new RuntimeException("id=" + id + "编号油画不存在");
            }
            Element p = (Element) nodes.get(0);
            p.getParent().remove(p);
            writer = new OutputStreamWriter(new FileOutputStream(dataFile), "UTF-8");
            document.write(writer);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            reload();
        }
    }
}
