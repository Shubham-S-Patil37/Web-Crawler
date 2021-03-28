package ExtraSources;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class JSoupeDemo {
    public static void main( String[] args ) throws IOException{
                Document doc = Jsoup.connect("https://www.google.com").get();  
                String title = doc.title();  
                System.out.println("title is: " + title);
    }
}