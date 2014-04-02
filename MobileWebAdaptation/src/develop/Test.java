package develop;
import java.io.File;
import java.io.FileOutputStream;
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
import org.apache.http.params.HttpParams;
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
			 * 		http://stackoverflow.com/questions/5027309/how-to-set-custom-user-agent-with-apache-http-client-library-4-1
			 */
			
			HttpGet req = new HttpGet("http://www.corren.se");
	       // HttpContext HTTP_CONTEXT = new BasicHttpContext();
	        //HTTP_CONTEXT.setAttribute("User-Agent","Mozilla/5.0 (Linux; U; Android 4.0.3; ko-kr; LG-L160L Build/IML74K) AppleWebkit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30");
	        //HTTP_CONTEXT.setAttribute(CoreProtocolPNames.USER_AGENT, "Mozilla/5.0 (Linux; U; Android 2.3.3; zh-tw; HTC_Pyramid Build/GRI40) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1");
	       // req.setHeader("Referer", "http://www.google.com");
	        
	        HttpClient httpClient = new DefaultHttpClient();
	        httpClient.getParams().setParameter(HttpParams.,
	        		arg1)
	        HttpResponse response = httpClient.execute(req);
	        if (response.getStatusLine().getStatusCode() < 200 || response.getStatusLine().getStatusCode() >= 400) {
	            throw new IOException("Got bad response, error code = " + response.getStatusLine().getStatusCode());
	        }

	        HttpEntity entity = response.getEntity();
	        
	        
	        if (entity != null) {
	        	File f = new File("src/test1.txt");
	        	FileOutputStream fOS = new FileOutputStream(f);
	        	entity.writeTo(fOS);
	        	entity.consumeContent();
	        	fOS.flush();
	        	fOS.close();

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
