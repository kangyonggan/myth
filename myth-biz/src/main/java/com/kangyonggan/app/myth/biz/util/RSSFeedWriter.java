package com.kangyonggan.app.myth.biz.util;

import com.kangyonggan.app.myth.model.rss.Feed;
import com.kangyonggan.app.myth.model.rss.FeedMessage;

import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.*;
import java.io.FileOutputStream;

/**
 * @author kangyonggan
 * @since 2017/1/24
 */
public class RSSFeedWriter {

    private String outputFile;
    private Feed feed;

    public RSSFeedWriter(Feed feed, String outputFile) {
        this.feed = feed;
        this.outputFile = outputFile;
    }

    public void write() throws Exception {
        XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();

        XMLEventWriter eventWriter = outputFactory.createXMLEventWriter(new FileOutputStream(outputFile));

        XMLEventFactory eventFactory = XMLEventFactory.newInstance();
        XMLEvent end = eventFactory.createDTD("\n");

        // Create and write Start Tag

        StartDocument startDocument = eventFactory.createStartDocument();

        eventWriter.add(startDocument);

        // Create open tag
        eventWriter.add(end);

        StartElement rssStart = eventFactory.createStartElement("", "", "rss");
        eventWriter.add(rssStart);
        eventWriter.add(eventFactory.createAttribute("version", "2.0"));
        eventWriter.add(end);

        eventWriter.add(eventFactory.createStartElement("", "", "channel"));
        eventWriter.add(end);

        // Write the different nodes

        createNode(eventWriter, "title", feed.getTitle());

        createNode(eventWriter, "link", feed.getLink());

        createNode(eventWriter, "description", feed.getDescription());

        createNode(eventWriter, "language", feed.getLanguage());

        createNode(eventWriter, "copyright", feed.getCopyright());

        createNode(eventWriter, "pubdate", feed.getPubDate());

        for (FeedMessage entry : feed.getFeedMessages()) {
            eventWriter.add(eventFactory.createStartElement("", "", "item"));
            eventWriter.add(end);
            createNode(eventWriter, "title", entry.getTitle());
            createNode(eventWriter, "description", entry.getDescription());
            createNode(eventWriter, "link", entry.getLink());
            createNode(eventWriter, "author", entry.getAuthor());
            createNode(eventWriter, "guid", entry.getGuid());
            createNode(eventWriter, "pubDate", entry.getPubDate());
            eventWriter.add(end);
            eventWriter.add(eventFactory.createEndElement("", "", "item"));
            eventWriter.add(end);

        }

        eventWriter.add(end);
        eventWriter.add(eventFactory.createEndElement("", "", "channel"));
        eventWriter.add(end);
        eventWriter.add(eventFactory.createEndElement("", "", "rss"));

        eventWriter.add(end);

        eventWriter.add(eventFactory.createEndDocument());

        eventWriter.close();
    }

    private void createNode(XMLEventWriter eventWriter, String name,

                            String value) throws XMLStreamException {
        XMLEventFactory eventFactory = XMLEventFactory.newInstance();
        XMLEvent end = eventFactory.createDTD("\n");
        XMLEvent tab = eventFactory.createDTD("\t");
        // Create Start node
        StartElement sElement = eventFactory.createStartElement("", "", name);
        eventWriter.add(tab);
        eventWriter.add(sElement);
        // Create Content
        Characters characters = eventFactory.createCharacters(value);
        eventWriter.add(characters);
        // Create End node
        EndElement eElement = eventFactory.createEndElement("", "", name);
        eventWriter.add(eElement);
        eventWriter.add(end);
    }
}
