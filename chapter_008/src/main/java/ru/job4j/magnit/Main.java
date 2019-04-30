package ru.job4j.magnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class Main {

    private static final int size =  4000;
    private static final Logger LOG = LogManager.getLogger(Main.class.getName());
    private static final File entries = new File("entries.xml");


    public static void main(String[] args) {
        StoreSQL storeSQL = new StoreSQL(new Config());
        storeSQL.create();
        storeSQL.generate(size);
        storeSQL.load();
        StoreXML storeXML = new StoreXML(entries);
        storeXML.save(storeSQL.load());

    }


}
