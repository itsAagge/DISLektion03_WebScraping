package opgave07;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://dis.students.dk/example1.php");
            InputStreamReader r = new InputStreamReader(url.openStream());
            BufferedReader in = new BufferedReader(r);

            String str;

            while ((str = in.readLine()) != null) {
                if (str.startsWith("This page")) {
                    System.out.println(str.substring(str.indexOf("230"), str.indexOf(" times")));
                }
            }

            in.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }
    }
}