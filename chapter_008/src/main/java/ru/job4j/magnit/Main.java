package ru.job4j.magnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class Main {
    private static long time = System.currentTimeMillis();
    private static final int size =  4000;
    private static final Logger LOG = LogManager.getLogger(Main.class.getName());
    private static final File entries = new File("chapter_008/target/entries.xml");
    private static final File convert_entries = new File("chapter_008/target/convert_entries");
    private static final File sheme = new File("chapter_008/target/cheme.xsl");

    public static void main(String[] args) {
        StoreSQL storeSQL = new StoreSQL(new Config());
        storeSQL.create();
        storeSQL.generate(size);
        storeSQL.load();
        StoreXML storeXML = new StoreXML(entries);
        storeXML.save(storeSQL.load());
        ConvertXSQT convertXSQT = new ConvertXSQT();
        convertXSQT.convert(entries, convert_entries, sheme);
        ParsingSAX parsingSAX = new ParsingSAX(convert_entries);
        parsingSAX.Parsing();
        System.out.println("Cумма всех значений атрибутов: " + parsingSAX.getSum());
        System.out.println("Затреченное время в (мс): " +(System.currentTimeMillis()-time));

    }


}
