package uk.napierdevsoc;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
        ArrayList<String> arrayList = parseMembersList(args[0]);

        RandyHotBits randyHotBits = new RandyHotBits(1);
        String hotBits = randyHotBits.getHotBits();

        int decimal = Integer.valueOf(hotBits, 16);
        int index = decimal % arrayList.size();

        System.out.println(arrayList.get(index));
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