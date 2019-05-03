package ru.job4j.magnit;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class ConvertXSQT {

/*    String xsl = "<?xml version=\"1.0\"?>\n" +
            "<xsl:stylesheet xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\" version=\"1.0\">\n" +
            "<xsl:template match=\"/\">\n" +
            "<entries>" +
            "   <xsl:for-each select=\"entries/list\">\n" +
            "       <entry>" +
            "           <xsl:attribute name=\"href\">" +
            "               <xsl:value-of select=\"field\"/>" +
            "           </xsl:attribute>" +
            "       </entry>\n" +
            "   </xsl:for-each>\n" +
            " </entries>\n" +
            "</xsl:template>\n" +
            "</xsl:stylesheet>\n";*/

    public void convert(File source, File dest, File scheme) {
        try {
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(new StreamSource(scheme));
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
            transformer.transform(
                    new StreamSource(source),
                    new StreamResult(dest));
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
