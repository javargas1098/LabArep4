package groupId.ClientAWS;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class URLReader implements Runnable {

	private URL url;
	private int x;

	public URLReader(URL url, int x) {
		this.url = url;
		this.x = x;
	}

	@Override
	public void run() {
		try {
			File archivo = new File("./rta" + x + ".html");
			BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
			try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
				String inputLine = null;
				while ((inputLine = reader.readLine()) != null) {
					System.out.println(inputLine);
					bw.write(inputLine);
				}
				bw.close();
			} catch (IOException e) {
				Logger.getLogger(URLClient.class.getName()).log(Level.SEVERE, null, e);
			}
		} catch (IOException ex) {
			Logger.getLogger(URLReader.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}