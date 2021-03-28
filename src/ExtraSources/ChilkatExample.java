package ExtraSources;

import com.chilkatsoft.*;

public class ChilkatExample {

  static {
    try {
        System.loadLibrary("chilkat");
    } catch (UnsatisfiedLinkError e) {
      System.err.println("Native code library failed to load.\n" + e);
      System.exit(1);
    }
  }

  public static void main(String argv[])
  {
    CkSpider spider = new CkSpider();

    //  The spider object crawls a single web site at a time.  As you'll see
    //  in later examples, you can collect outbound links and use them to
    //  crawl the web.  For now, we'll simply spider 10 pages of chilkatsoft.com
    spider.Initialize("www.chilkatsoft.com");

    //  Add the 1st URL:
    spider.AddUnspidered("http://www.chilkatsoft.com/");

    //  Begin crawling the site by calling CrawlNext repeatedly.
    int i;
    for (i = 0; i <= 9; i++) {
        boolean success;
        success = spider.CrawlNext();
        if (success == true) {
            //  Show the URL of the page just spidered.
            System.out.println(spider.lastUrl());

            //  The HTML META keywords, title, and description are available in these properties:
            System.out.println(spider.lastHtmlTitle());
            System.out.println(spider.lastHtmlDescription());
            System.out.println(spider.lastHtmlKeywords());

            //  The HTML is available in the LastHtml property
        }
        else {
            //  Did we get an error or are there no more URLs to crawl?
            if (spider.get_NumUnspidered() == 0) {
                System.out.println("No more URLs to spider");
            }
            else {
                System.out.println(spider.lastErrorText());
            }

        }

        //  Sleep 1 second before spidering the next URL.
        spider.SleepMs(1000);
    }


  }
}