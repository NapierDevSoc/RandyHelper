package uk.napierdevsoc;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class RandyHotBits {
	
    private static final String URL = "https://www.fourmilab.ch/cgi-bin/Hotbits?nbytes=%d&fmt=hex";
	
    private String hotBits;

    public RandyHotBits(int bytes) throws Exception {
        this.hotBits = requestHotBits(bytes);
    }

    private String requestHotBits(int bytes) throws Exception {
        Document doc = Jsoup.connect(String.format(URL, bytes)).get();
        Elements data = doc.select("pre");

        return data.text();
    }

    public String getHotBits() {
        return hotBits;
    }
}
