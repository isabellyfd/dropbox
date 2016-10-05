package dropbox;

import java.util.Locale;
import com.dropbox.core.DbxAppInfo;
import com.dropbox.core.DbxWebAuthNoRedirect;
import com.dropbox.core.DbxRequestConfig;

public class DropboxHandler {
	private DbxWebAuthNoRedirect webAuth;
	private String AuthorizedURL;
	
	public DropboxHandler() {
		DbxAppInfo appInfo = new DbxAppInfo(Constants.APP_KEY, Constants.APP_SECRET);
		DbxRequestConfig config = new DbxRequestConfig("JavaTutorial/1.0", Locale.getDefault().toString());
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
		AuthorizedURL = authorizedURL;
	}
	
	
}
