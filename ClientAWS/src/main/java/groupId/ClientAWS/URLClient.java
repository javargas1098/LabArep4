package groupId.ClientAWS;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class URLClient {
	 public static void main(String[] args) {
	        ExecutorService es = Executors.newFixedThreadPool(10);
	        int i=0;
	        for (String s : args) {
	            i++;
	            try {
	                URLReader urlReader = new URLReader(new URL(s),i);
	                es.execute(urlReader);
	            } catch (MalformedURLException ex) {
	                Logger.getLogger(URLClient.class.getName()).log(Level.SEVERE, null, ex);
	            }
	        }
	        try {
	            es.awaitTermination(1, TimeUnit.MINUTES);
	        } catch (InterruptedException ex) {
	            Logger.getLogger(URLClient.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }

}
