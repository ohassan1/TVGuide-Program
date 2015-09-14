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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

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

                    String s = e.getElementsByTagName("icon").item(0).getAttributes().getNamedItem("src").toString();
                    int len = s.length();

                    Channel channel = new Channel(displayNames.item(0).getTextContent(),
                            displayNames.item(1).getTextContent(),
                            displayNames.item(2).getTextContent(), s.substring(5, len - 1), e.getAttribute("id"));

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

                    if (e.getAttribute("start").contains("20150914")) {

                        String start = e.getAttribute("start");
                        int startLen = start.length();
                        String realStart = start.substring(8, startLen - 8);

                        if (realStart.equals("0000")) {
                            show.setPlayTime("1200 AM");
                        } else if (realStart.equals("0030")) {
                            show.setPlayTime("1230 AM");
                        } else if (Integer.parseInt(realStart) >= 1300) {

                            int startInt = Integer.parseInt(realStart);
                            startInt = startInt - 12;

                            show.setPlayTime(Integer.toString(startInt) + " PM");
                        } else {
                            show.setPlayTime(realStart + " AM");
                        }

                        show.setStartTime(Integer.parseInt(show.getPlayTime().substring(0, 4)));


                        String stop = e.getAttribute("stop");
                        int stopLen = stop.length();
                        String realStop = stop.substring(8, stopLen - 8);

                        if (realStop.equals("0000")) {
                            show.setEndTime("1200 AM");
                        } else if (realStop.equals("0030")) {
                            show.setEndTime("1230 AM");
                        } else if (Integer.parseInt(realStop) >= 1300) {

                            int stopInt = Integer.parseInt(realStop);
                            stopInt = stopInt - 12;

                            show.setEndTime("0" + Integer.toString(stopInt) + " PM");
                        } else {
                            show.setEndTime(realStop + " AM");
                        }

                        show.setStopTime(Integer.parseInt(show.getEndTime().substring(0, 4)));


                        show.setChannel(e.getAttribute("channel"));
                        show.setName(e.getElementsByTagName("title").item(0).getTextContent());
                        if (e.getElementsByTagName("desc").getLength() >= 1) {
                            show.setDescription(e.getElementsByTagName("desc").item(0).getTextContent());
                        }
                        if (e.getElementsByTagName("icon").getLength() >= 1) {

                            String s = e.getElementsByTagName("icon").item(0).getAttributes().getNamedItem("src").toString();
                            int len = s.length();
                            s = s.substring(5, len - 1);
                        }

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

    public ArrayList<String> currentTime() {

        ArrayList<String> realTimes = new ArrayList<String>();

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm a");

        int unroundedMinutes = cal.get(Calendar.MINUTE);
        int mod = unroundedMinutes % 30;
        cal.add(Calendar.MINUTE, mod == 0 ? 30 : 30 - mod);

        realTimes.add(sdf.format(cal.getTime()));
        cal.add(Calendar.MINUTE, 30);
        realTimes.add(sdf.format(cal.getTime()));
        cal.add(Calendar.MINUTE, 30);
        realTimes.add(sdf.format(cal.getTime()));
        cal.add(Calendar.MINUTE, 30);
        realTimes.add(sdf.format(cal.getTime()));
        cal.add(Calendar.MINUTE, 30);
        realTimes.add(sdf.format(cal.getTime()));
        cal.add(Calendar.MINUTE, 30);
        realTimes.add(sdf.format(cal.getTime()));

        return realTimes;
    }
}
