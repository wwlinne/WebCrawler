package Main;

import java.io.IOException;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Douban {
	public void setCookies(String url) throws IOException {

       Document document = Jsoup.connect(url)
	    		.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36")
	    		.header("Cookie", "Your Cookie")//check network cookie information in the inspect view 
	            .get();
	    
	    if (document != null) {
	        Element element = document.select(".info h1").first();
	        if (element == null) {
	            System.out.println("Not Found User");
	            return;
	        }
	        String userName = element.ownText();
	        System.out.println("UserName" + userName);
	    } else {
	        System.out.println("Error!!!");
	    }
	}
	public static void main(String[] args) throws Exception {
		//check the user info page to add your id
		 String user_info_url = "https://www.douban.com/people/"+"YourUserId"+"/";
		    new Douban().setCookies(user_info_url);
		}}
