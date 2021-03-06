package dropbox;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;
import com.dropbox.core.DbxAppInfo;
import com.dropbox.core.DbxAuthFinish;
import com.dropbox.core.DbxClient;
import com.dropbox.core.DbxEntry;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxWebAuthNoRedirect;
import com.dropbox.core.DbxWriteMode;
import com.dropbox.core.DbxRequestConfig;
import model.User;

public class DropboxHandler {
	private DbxWebAuthNoRedirect webAuth;
	private DbxAppInfo appInfo;
	private DbxRequestConfig config;
	private DbxAuthFinish authFinish;
	private DbxClient client;
	private String authorizedURL;
	
	public DropboxHandler() {
		this.appInfo = new DbxAppInfo(Constants.APP_KEY, Constants.APP_SECRET);
		this.config = new DbxRequestConfig("JavaTutorial/1.0", Locale.getDefault().toString());
		this.setWebAuth(new DbxWebAuthNoRedirect(config, appInfo));
	}

	public DbxWebAuthNoRedirect getWebAuth() {
		return webAuth;
	}

	public void setWebAuth(DbxWebAuthNoRedirect webAuth) {
		this.webAuth = webAuth;
	}

	public String getAuthorizedURL() {
		return this.webAuth.start();
	}

	public void setAuthorizedURL(String authorizedURL) {
		this.authorizedURL = authorizedURL;
	}
	
	public User finalAuth(String code){
		User user = null;
		try {
			this.authFinish = webAuth.finish(code);
			String accessToken = this.authFinish.accessToken;
			this.client = new DbxClient(config, accessToken);
			System.out.print("Linked account: " + client.getAccountInfo().displayName);
			user = new User( client.getAccountInfo().displayName);
		} catch (DbxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;	
	}
	
	
	public void sendArquiveToDropBox(String path) {
		File inputFile = new File(path);
		FileInputStream inputStream = null;
		
		try {
			
			inputStream = new FileInputStream(inputFile);
		    DbxEntry.File uploadedFile = client.uploadFile(path,
		        DbxWriteMode.add(), inputFile.length(), inputStream);
		    System.out.println("Uploaded: " + uploadedFile.toString());
		    
		} catch (DbxException | IOException e) {
			e.printStackTrace();
			
		} finally {
		    try {
				inputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
