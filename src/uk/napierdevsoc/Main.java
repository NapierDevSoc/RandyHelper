package uk.napierdevsoc;

import com.sun.xml.internal.bind.v2.TODO;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.awt.*;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
        // get some randy hot bits
        RandyHotBits randyHotBits = new RandyHotBits(256);
        String hotBits = randyHotBits.getHotBits();

        ArrayList<String> arrayList = parseMembersList(args[0]);

        // TODO Implement shuffle on the list using the hot bits
    }

    private static ArrayList<String> parseMembersList(String path) throws Exception {
        ArrayList<String> arrayList = new ArrayList();

        Reader in = new FileReader(path);
        Iterable<CSVRecord> records = CSVFormat.EXCEL.withHeader().parse(in);
        for (CSVRecord record : records) {
            arrayList.add(String.format("%s %s - %s", record.get("First Name"), record.get("Last Name"), record.get("Email")));
        }

        return arrayList;
    }
}