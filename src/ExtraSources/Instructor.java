
package ExtraSources;

import java.net.InetSocketAddress;
import static java.net.Proxy.Type.HTTP;
import java.net.Socket;
import javax.swing.JOptionPane;


public class Instructor {

public static Boolean connect;
    
    public static void getNotification(){
        Socket socket = new Socket();
        InetSocketAddress add = new InetSocketAddress("www.youtube.com",80);
        try{
            socket.connect(add,3000);
//            JOptionPane.showMessageDialog(null,"Connection is true");
            connect = true;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Check Your Internet Connection");
            connect = false;
        } finally{
            try{
                socket.close();
            }catch(Exception e){}
        }    
    }
    
//    void checklinks(String url){
//        try{
//            content=HTTP.getContents(url);
//            String[] links=content.getAllRegexMatches('href="(http://.*?)"');
//            foreach(links as String link)
//                 checklinks(link);
//        } catch (Exception e) {
//            System.out.println("Link "+url" failed");
//        }
//   }    
}
