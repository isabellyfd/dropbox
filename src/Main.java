
/*import com.dropbox.core.*;
import java.io.*;
import java.util.Locale;
*/

import java.io.IOException;
import java.sql.*;

import data.DataProvideFactory;
import model.Arquive;

public class Main {

	public static void main(String[] args)  {
		//keys for accessing drobox app`s folder
		/*final String APP_KEY = "pf67r86rjfb3s1i";
		final String APP_SECRET = "8sd1a66mkunjpze";
		
		
		
		DbxAppInfo appInfo = new DbxAppInfo(APP_KEY, APP_SECRET);
		
		DbxRequestConfig config = new DbxRequestConfig("JavataTutorial/1.0",
														Locale.getDefault().toString());
		
		DbxWebAuthNoRedirect webAuth = new DbxWebAuthNoRedirect(config, appInfo);
		
		//Generate an autorizatinon URL 
		
		String authorizedURL = webAuth.start();
		
		System.out.println (authorizedURL);
		
		
		System.out.println("1. Go to: " + authorizedURL);
		System.out.println("2. Click \"Allow\" (you might have to log in first)");
		System.out.println("3. Copy the authorization code.");
		String code = new BufferedReader(new InputStreamReader(System.in)).readLine().trim();
		
		System.out.println(code);
		
		
		;
		String accessToken = authFinish.accessToken;
		
		
		// acessToken is done once for each user
		
		
		
		*/
		
		
		try {
			java.awt.Desktop.getDesktop().browse(java.net.URI.create("http://google.com"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
