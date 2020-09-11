/**
 * @filename JDomDemo.java
 * @author lg
 * @date 2019��4��15�� ����10:24:27
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
	        //1.����SAXBuilder����
	        SAXBuilder saxBuilder = new SAXBuilder();
	        //2.����������
	        InputStream is = new FileInputStream(new File("src/main/resources/demo.xml"));
	        //3.�����������ص�build��
	        Document document = saxBuilder.build(is);
	        //4.��ȡ���ڵ�
	        Element rootElement = document.getRootElement();
	        //5.��ȡ�ӽڵ�
	        List<Element> children = rootElement.getChildren();
	        for (Element child : children) {
	            System.out.println("ͨ��rollno��ȡ����ֵ:"+child.getAttribute("rollno"));
	            List<Attribute> attributes = child.getAttributes();
	            //��ӡ����
	            for (Attribute attr : attributes) {
	                System.out.println(attr.getName()+":"+attr.getValue());
	            }
	            List<Element> childrenList = child.getChildren();
	            System.out.println("======��ȡ�ӽڵ�-start======");
	            for (Element o : childrenList) {
	                System.out.println("�ڵ���:"+o.getName()+"---"+"�ڵ�ֵ:"+o.getValue());
	            }
	            System.out.println("======��ȡ�ӽڵ�-end======");
	        }
	    }

}
