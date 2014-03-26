package develop;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.IOUtils;



public class Test {
	
	public static void main(String[] args) {
		
		try {
			URL url = new URL("http://m.corren.se");
			 URLConnection conn = url.openConnection();
			InputStream in = conn.getInputStream();
			String encoding = conn.getContentEncoding();
			encoding = encoding == null ? "UTF-8" : encoding;
			String body = IOUtils.toString(in,encoding);
			System.out.println(body);
			 
			 
//			 
//			 Map<String, List<String>> headerFields= conn.getHeaderFields();
//			 Set<String> headerFieldsSet = headerFields.keySet();
//			 Iterator<String> hearerFieldsIter = headerFieldsSet.iterator();
//			 
//			
			 

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
