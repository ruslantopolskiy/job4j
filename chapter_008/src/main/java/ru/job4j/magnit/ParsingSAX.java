package ru.job4j.magnit;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class ParsingSAX {

    private int sum;

    private File file;

    public ParsingSAX(File file) {
        this.file = file;
    }

    public int getSum() {
        return sum;
    }

    DefaultHandler defaultHandler = new DefaultHandler() {

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("entry")) {
                String value = attributes.getValue("field");
                sum += Integer.valueOf(value);
            }
        }
    };

    public void parsing() {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            parser.parse(file, defaultHandler);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
