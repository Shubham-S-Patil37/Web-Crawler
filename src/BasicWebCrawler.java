
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.HashSet;

public class BasicWebCrawler {
private static HashSet<String> links;
public static Boolean valid;
public BasicWebCrawler() {
    links = new HashSet<>();
}

public static void getPageLinks(String URL) {
    //4. Check if you have already crawled the URLs 
    //(we are intentionally not checking for duplicate content in this example)
//    notEmpty(URL);
//    URL = showFrame.site_txt.getText();
//    System.out.println(URL);
//    showFrame.print_txt.setText(URL);

    if (!links.contains(URL)) {
        try {
            //4. (i) If not add it to the index
            if (links.add(URL)) {
                    showFrame.print_txt.append("\n"+URL);
                    showFrame.print_txt.update(showFrame.print_txt.getGraphics());
            }                       

//            if (links.isEmpty()) {
//                System.out.println(URL+" is broken*****");
//            } 
            //2. Fetch the HTML code
            Document document = Jsoup.connect(URL).get();
//                String keywords = document.select("meta[name=keywords]").first().attr("content");  
//                System.out.println("Meta keyword : " + keywords);

//                Element metaTag = null;
//                keywords = metaTag.attr("content");
//                System.out.println("Meta keyword :- " + keywords);

//            valid = document.select("meta[name=keywords]").first().attr("content").isEmpty();  
//               
//            if(valid){
//                String keywords = document.select("meta[name=keywords]").first().attr("content");  
//                System.out.println("Meta keyword : " + keywords);
//            }
            //            System.out.print(document);

//            if(document.equals(null)){
//                System.out.println(URL+"is broken");
//            }
//            else{
//                System.err.println(URL+"is not broken");
//            }

            //3. Parse the HTML to extract links to other URLs
            Elements linksOnPage = document.select("a[href]");
            
//            for (Element metaTag : linksOnPage) {
////                
//                String content = metaTag.attr("content");
//                System.out.print("\n"+content);
//            //    String content = metaTag.attr("name");
//            }
            
            
            //5. For each extracted URL... go back to Step 4.
            for (Element page : linksOnPage) {
                 System.out.print("\n"+URL);
                if(!page.equals(null)){
                    getPageLinks(URL);
                }
                getPageLinks(page.attr("abs:href"));
            }
        } catch (IOException e) {
//            System.err.println("For '" + URL + "': " + e.getMessage());
            System.err.println(URL+"\t is broken.....");
        }
    }
}

//public static void main(String[] args) {
//    //1. Pick a URL from the frontier
//    new BasicWebCrawler().getPageLinks("https://www.google.com");
//}http://nextechinfosystems.com/all-course/
}