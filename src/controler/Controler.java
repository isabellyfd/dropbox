package controler;

import dropbox.DropboxHandler;
import data.DataProvideFactory;
import model.User;

public class Controler {
	private DropboxHandler dropHandler;
	private DataProvideFactory dataProvider;
	
	
	public Controler(){
		this.dropHandler = new DropboxHandler();
		this.dataProvider = new DataProvideFactory();
	}
	
	public String getDropboxAuthURL() {
		return this.dropHandler.getAuthorizedURL();
	}
	
	public User finishAuth(String code) {
		return this.dropHandler.finalAuth(code);
	}
	
}
