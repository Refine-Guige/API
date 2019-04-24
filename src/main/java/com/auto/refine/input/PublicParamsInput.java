package com.auto.refine.input;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.TreeMap;

public class PublicParamsInput {


    public TreeMap<String,String> publicParams()

    {
        File file = new File("data/publicParameters.xml");
        DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;
        Document document = null;
        TreeMap<String,String> map=new TreeMap<>();
        try {
            documentBuilder = dbfactory.newDocumentBuilder();
            document = documentBuilder.parse(file);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        NodeList nodeList = document.getElementsByTagName("param");

        String url = document.getElementsByTagName("url").item(0).getFirstChild().getNodeValue();
        System.out.println(url);
        String merchantId = document.getElementsByTagName("merchantId").item(0).getFirstChild().getNodeValue();
        System.out.println(merchantId);
        String pkey = document.getElementsByTagName("pkey").item(0).getFirstChild().getNodeValue();
        System.out.println(pkey);

        map.put("url",url);
        map.put("merchantId",merchantId);
        map.put("pkey",pkey);

        return map;

    }


}
