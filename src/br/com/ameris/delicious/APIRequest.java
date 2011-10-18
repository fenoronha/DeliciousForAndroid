package br.com.ameris.delicious;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

import android.net.Credentials;

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
	
	public String QUESTION 		= "?";
	public String E_COMMERCIAL 	= "&";
	public String SLASH 		= "/";
	public String _HTTP			= "https://";
	
	public String DOMAIN = "api.del.icio.us/v1/";
	
	String thisLine;
	private URL url;
	HttpURLConnection conn;
	private DefaultHttpClient client;
	
	public void login(String deliciousID, String pasword) throws IOException
	{
		String urlString = _HTTP + deliciousID + ":" + pasword + "@" + DOMAIN + POSTS + SLASH + GET; 
		url=new URL(urlString );
		
        URLConnection connection;
        String authority = url.getAuthority();
        if (authority.contains("@")) {
            String userPasswordString = authority.split("@")[0];
            url = new URL(urlString.replace(userPasswordString + "@", ""));
            connection = url.openConnection();
            //String encoded = new String(Base64.encode(userPasswordString.getBytes(), Base64.DEFAULT), "UTF-8");
            //connection.setRequestProperty("Authorization", "Basic " + encoded);
        } else {
            connection = url.openConnection();
        }

        InputStream responseStream = connection.getInputStream();
		
	}
}
