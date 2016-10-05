package data;

import java.sql.SQLException;

import model.Arquive;

public interface DataProvider {

public void insertArquive (Arquive arquive)throws ClassNotFoundException, SQLException; 
public void updateArquive (Arquive arquive);
public void fetchArquivesWithQuery(String  pathName)throws ClassNotFoundException, SQLException;
}
