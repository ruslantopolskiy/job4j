package ru.job4j.magnit;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

public class ConvertXSQT {

    public static void main(String args[]) throws TransformerException, TransformerException {
        Source inputXML = new StreamSource(
                new File("target.xml"));

        Result fileResult = new StreamResult(
                new File("output.xml")) {
        };

        String xsl = "<?xml version=\"1.0\"?>\n" +
                "<xsl:stylesheet xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\" version=\"1.0\">\n" +
                "<xsl:template match=\"/\">\n" +
                "<entries>" +
                "   <xsl:for-each select=\"user/values\">\n" +
                "       <entry>" +
                "           <xsl:attribute name=\"field\">" +
                "               <xsl:value-of select=\"value\"/>" +
                "           </xsl:attribute>" +
                "       </entry>\n" +
                "   </xsl:for-each>\n" +
                " </entries>\n" +
                "</xsl:template>\n" +
                "</xsl:stylesheet>\n";

        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer(new StreamSource(new ByteArrayInputStream(xsl.getBytes())));
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
        transformer.transform(inputXML, fileResult);

    }

}
