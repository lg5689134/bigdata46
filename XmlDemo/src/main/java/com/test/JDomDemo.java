/**
 * @filename JDomDemo.java
 * @author lg
 * @date 2019年4月15日 上午10:24:27
 * @version 1.0
 * Copyright (C) 2019 
 */

package com.test;
import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

public class JDomDemo {
	 public static void main(String[] args) throws Exception {
	        //1.创建SAXBuilder对象
	        SAXBuilder saxBuilder = new SAXBuilder();
	        //2.创建输入流
	        InputStream is = new FileInputStream(new File("src/main/resources/demo.xml"));
	        //3.将输入流加载到build中
	        Document document = saxBuilder.build(is);
	        //4.获取根节点
	        Element rootElement = document.getRootElement();
	        //5.获取子节点
	        List<Element> children = rootElement.getChildren();
	        for (Element child : children) {
	            System.out.println("通过rollno获取属性值:"+child.getAttribute("rollno"));
	            List<Attribute> attributes = child.getAttributes();
	            //打印属性
	            for (Attribute attr : attributes) {
	                System.out.println(attr.getName()+":"+attr.getValue());
	            }
	            List<Element> childrenList = child.getChildren();
	            System.out.println("======获取子节点-start======");
	            for (Element o : childrenList) {
	                System.out.println("节点名:"+o.getName()+"---"+"节点值:"+o.getValue());
	            }
	            System.out.println("======获取子节点-end======");
	        }
	    }

}
