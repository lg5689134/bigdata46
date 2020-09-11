/**
 * @filename Dom4JDemo.java
 * @author lg
 * @date 2019年4月15日 上午10:25:12
 * @version 1.0
 * Copyright (C) 2019 
 */

package com.test;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.Iterator;
import java.util.List;

public class Dom4JDemo {
	 public static void main(String[] args) throws Exception {
	        //1.创建Reader对象
	        SAXReader reader = new SAXReader();
	        //2.加载xml
	        Document document = reader.read(new File("src/main/resources/demo.xml"));
	        //3.获取根节点
	        Element rootElement = document.getRootElement();
	        Iterator iterator = rootElement.elementIterator();
	        while (iterator.hasNext()){
	            Element stu = (Element) iterator.next();
	            List<Attribute> attributes = stu.attributes();
	            System.out.println("======获取属性值======");
	            for (Attribute attribute : attributes) {
	                System.out.println(attribute.getValue());
	            }
	            System.out.println("======遍历子节点======");
	            Iterator iterator1 = stu.elementIterator();
	            while (iterator1.hasNext()){
	                Element stuChild = (Element) iterator1.next();
	                System.out.println("节点名："+stuChild.getName()+"---节点值："+stuChild.getStringValue());
	            }
	        }
	    }
}
