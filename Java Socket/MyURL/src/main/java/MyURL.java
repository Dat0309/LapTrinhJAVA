
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
public class MyURL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MalformedURLException, IOException {
        //Tao doi tuong URL
        URL myURL= new URL("https://www.facebook.com/");
        
        //Ket noi tai nguyen mang
        URLConnection conn= myURL.openConnection();
        
        //Doc noi dung tai nguyen la mot trang web
        BufferedReader input= new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String nextLine;
        while((nextLine=input.readLine())!=null){
            System.out.println(nextLine);
        }
        input.close();
    }
    
}
