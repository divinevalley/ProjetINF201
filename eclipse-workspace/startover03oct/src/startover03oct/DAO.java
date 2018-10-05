package startover03oct;

import java.sql.Connection;
import java.util.ArrayList;

public abstract class DAO<T> {
	protected Connection connect = null; 
	
	public DAO(Connection conn) {
		connect = conn;
	}
	
	//METHODS
	public abstract T findByNum(int id);
	public abstract ArrayList<T> findByName(String nom, String prenom);

}
