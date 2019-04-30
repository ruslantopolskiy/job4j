package ru.job4j.magnit;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.List;

public class StoreXML {
    private File file;

    public StoreXML(File file){
        this.file = file;
    }

    public void save (List<Entry>list) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Entries.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(
                    new Entries(list),
                    this.file
            );
            System.out.println("Операция успешна.");
        }catch (Exception e){
            e.getStackTrace();
        }
    }
}
