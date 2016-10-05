
/*import com.dropbox.core.*;
import java.io.*;
import java.util.Locale;
*/

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
		
		
		DbxAuthFinish authFinish = webAuth.finish(code);
		String accessToken = authFinish.accessToken;
		
		
		// acessToken is done once for each user
		
		
		DbxClient client = new DbxClient(config, accessToken);
		System.out.print("Linked account: " + client.getAccountInfo().displayName);
		*/
		
		
		DataProvideFactory db = new DataProvideFactory();
		try {
			db.insertArquive(new Arquive ("belly.txt"));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
