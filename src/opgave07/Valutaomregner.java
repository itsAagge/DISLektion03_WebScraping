package opgave07;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class Valutaomregner {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://valutakurser.dk");
            InputStreamReader r = new InputStreamReader(url.openStream());
            BufferedReader in = new BufferedReader(r);

            String str;

            while ((str = in.readLine()) != null) {
                if (str.contains("USD") && str.contains("\"actualValue\"")) {
                    System.out.println(str.substring(str.indexOf("USD") + 73, str.indexOf("USD") + 79));
                }
            }

            in.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }
    }
}
