package uk.napierdevsoc;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.Reader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class Main {

    public static void main(String[] args) throws Exception {
        List<String> arrayList = parseMembersList(args[0]);

        RandyHotBits randyHotBits = new RandyHotBits(1);
        String hotBits = randyHotBits.getHotBits();

        int decimal = Integer.valueOf(hotBits, 16);
        int index = decimal % arrayList.size();

        System.out.println(arrayList.get(index));
	}

    private static List<String> parseMembersList(String path) throws Exception {
        Reader in = new FileReader(path);
        Iterable<CSVRecord> records = CSVFormat.EXCEL.withHeader().parse(in);

        return StreamSupport.stream(records.spliterator(), false)
        	    .map(r -> r.get("NAME"))
        	    .collect(Collectors.toList());
	}
}