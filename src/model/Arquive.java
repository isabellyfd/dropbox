package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Arquive {
	private int indexOnTable;
	private String path;
	private boolean isSync;
	private long lastLength;
	
	
	public Arquive( String path ){
		this.path = path;
		this.isSync = false;
		this.setLastLength(this.getFileLength());
	}
	
	public int getIndexOnTable() {
		return indexOnTable;
	}

	public void setIndexOnTable(int indexOnTable) {
		this.indexOnTable = indexOnTable;
	}
		
	public String getPath (){
		return this.path;
	}
	
	public void setPath (String path){
		this.path = path;
	}
	
	public boolean getIsSync() {
		return this.isSync;
	}
	
	public void setIsSync (boolean isSync){
		this.isSync = isSync;
	}
	
	public long getLastLength() {
		return lastLength;
	}


	public void setLastLength(long lastLength) {
		this.lastLength = lastLength;
	}
	
	public long getFileLength() {
		File inputFile = new File(this.path);
		return inputFile.length();
	}
	
	public boolean fileExists() {
		File inputFile = new File(this.path);
		return inputFile.exists();
	}

	
}
