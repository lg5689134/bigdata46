/**
 * @filename SaxDemo.java
 * @author lg
 * @date 2019��4��15�� ����10:22:21
 * @version 1.0
 * Copyright (C) 2019 
 */

package com.test;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SaxDemo {

    public static void main(String[] args) throws Exception {
        //1.��ȥSAXParserFactoryʵ��
        SAXParserFactory factory = SAXParserFactory.newInstance();
        //2.��ȡSAXparserʵ��
        SAXParser saxParser = factory.newSAXParser();
        //����Handel����
        SAXDemoHandel handel = new SAXDemoHandel();
        saxParser.parse("src/main/resources/demo.xml",handel);
    }
}

class SAXDemoHandel extends DefaultHandler {
    //����xml�ļ���ʼ��ǩ
    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        System.out.println("sax������ʼ");
    }

    //����xml�ļ�������ǩ
    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        System.out.println("sax��������");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        if (qName.equals("student")){
            System.out.println("============��ʼ����student=============");
            //System.out.println(attributes.getValue("rollno"));
        }
        else if (!qName.equals("student")&&!qName.equals("class")){
            System.out.print("�ڵ�����:"+qName+"----");
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if (qName.equals("student")){
            System.out.println(qName+"��������");
            System.out.println("============��������student=============");
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        String value = new String(ch,start,length).trim();
        if (!value.equals("")) {
            System.out.println(value);
        }
    }
}
