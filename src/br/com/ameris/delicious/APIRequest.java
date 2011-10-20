package br.com.ameris.delicious;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.util.EntityUtils;

import android.net.Credentials;
import android.util.Log;

public class APIRequest 
{
	public String POSTS 		= "posts";
	public String TAG 			= "tags";
	public String BUNDLES 		= "bundles";
	
	public String UPDATE 		= "update"; 
	public String ADD			= "add"; 
	public String DELETE		= "delele"; 
	public String GET 			= "get"; 
	public String RECENT 		= "recent"; 
	public String DATES 		= "dates"; 
	public String ALL 			= "all"; 
	public String HASHES		= "hashes"; 
	public String SUGGEST 		= "suggest";
	public String RENAME 		= "";
	public String SET 			= "";
	
	public String DOMAIN = "http://api.del.icio.us/v1";
	
	public void login(String deliciousID, String password) throws IOException
	{
		try {
			HttpClient client = new DefaultHttpClient();
			AuthScope as = new AuthScope(DOMAIN, 443);
			
			UsernamePasswordCredentials upc = new UsernamePasswordCredentials(deliciousID, password);
			
			((AbstractHttpClient) client).getCredentialsProvider().setCredentials(as, upc);
			
			BasicHttpContext localContext = new BasicHttpContext();
			
			BasicScheme basicAuth = new BasicScheme();
			
			localContext.setAttribute("preemptive-auth", basicAuth);
			
			HttpHost targetHost = new HttpHost(DOMAIN);
			
			HttpGet httpget = new HttpGet(DOMAIN + "/" + POSTS + "/" + GET);
			//httpget.setHeader("Content-Type", "application/xml");
			
			HttpResponse response = client.execute(targetHost, httpget, localContext);
			
			HttpEntity entity = response.getEntity();
			
			Object content = EntityUtils.toString(entity);
			
			Log.d("teste", content.toString());
		} catch (Exception e) {
			e.printStackTrace();
			Log.d("error", e.getMessage());
		}
		 
	}
}
