package develop;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;



public class Test {
	
	public static void main(String[] args) {
		
		try {
			
			 /*
			  * Metod 1
			  */
//			URL url = new URL("http://www.corren.se");
//			URLConnection conn = url.openConnection();
//			InputStream in = conn.getInputStream();
//			String encoding = conn.getContentEncoding();
//			encoding = encoding == null ? "UTF-8" : encoding;
//			String body = IOUtils.toString(in,encoding);
//			System.out.println(body);
			
			
			
			/*Metod 2
			 * ändrar user agent till ...
			 * 
			 */
			
			HttpGet req = new HttpGet("http://www.corren.se");
	        HttpContext HTTP_CONTEXT = new BasicHttpContext();
	        HTTP_CONTEXT.setAttribute("User-Agent", "Mozilla/5.0 (Linux; U; Android 2.3.3; zh-tw; HTC_Pyramid Build/GRI40) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1");
	        //HTTP_CONTEXT.setAttribute(CoreProtocolPNames.USER_AGENT, "Mozilla/5.0 (Linux; U; Android 2.3.3; zh-tw; HTC_Pyramid Build/GRI40) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1");
	       // req.setHeader("Referer", "http://www.google.com");
	        
	        HttpClient httpClient = new DefaultHttpClient();
	        HttpResponse response = httpClient.execute(req, HTTP_CONTEXT);
	        if (response.getStatusLine().getStatusCode() < 200 || response.getStatusLine().getStatusCode() >= 400) {
	            throw new IOException("Got bad response, error code = " + response.getStatusLine().getStatusCode());
	        }

	        HttpEntity entity = response.getEntity();
	        if (entity != null) {
	            System.out.println(EntityUtils.toString(entity));
	            EntityUtils.consume(entity);
	        }
			 		 

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
