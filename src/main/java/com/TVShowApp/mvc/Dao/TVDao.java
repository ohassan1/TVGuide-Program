package com.TVShowApp.mvc.Dao;


import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import com.TVShowApp.mvc.Models.Channel;
import com.TVShowApp.mvc.Models.Show;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class TVDao {

    String path = "xmltv.xml";
    Show show;
    ArrayList<Channel> channelList = new ArrayList<Channel>();
    ArrayList<Show> showList = new ArrayList<Show>();
    File xmlFile = new File("xmltv.xml");

    public ArrayList<Channel> getChannels() {

        try {

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            NodeList nList = doc.getElementsByTagName("channel");

            for (int i = 0; i < nList.getLength(); i++) {

                Node n = nList.item(i);

                if (n.getNodeType() == Node.ELEMENT_NODE) {

                    Element e = (Element) n;

                    NodeList displayNames = e.getElementsByTagName("display-name");

                    Channel channel = new Channel(displayNames.item(0).getTextContent(),
                            displayNames.item(1).getTextContent(),
                            displayNames.item(2).getTextContent(), "", e.getAttribute("id"));

                    channelList.add(channel);
                }
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return channelList;

    }




    public ArrayList<Show> getPrograms(){

        try {
            File XmlFile = new File(path);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(XmlFile);

            NodeList shows = doc.getElementsByTagName("programme");

            for (int i=0; i<shows.getLength(); i++) {

                Node n = shows.item(i);

                show = new Show();

                if (n.getNodeType() == Node.ELEMENT_NODE){

                    Element e = (Element) n;

                    show.setPlayTime(e.getAttribute("start"));
                    show.setEndTime(e.getAttribute("stop"));
                    show.setChannel(e.getAttribute("channel"));
                    show.setName(e.getElementsByTagName("title").item(0).getTextContent());
                    if (e.getElementsByTagName("desc").getLength() >= 1) {
                        show.setDescription(e.getElementsByTagName("desc").item(0).getTextContent());
                    }
                    if (e.getElementsByTagName("icon").getLength() >= 1) {

                        String s = e.getElementsByTagName("icon").item(0).getAttributes().getNamedItem("src").toString();
                        int len = s.length();
                        s = s.substring(5, len -1);
                    }
                }

                showList.add(show);
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return showList;
    }

}
