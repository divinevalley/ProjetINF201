package startover03oct;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ActeDAO extends DAO<Acte>{

	String url = "jdbc:mysql://localhost/wung";
	String user = "root";
	String password = "";
	
	public ActeDAO(Connection conn) {
		super(conn);
	}
	//METHOD FIND ACT BY ID NUM
	@Override
	public Acte findByNum(int id) {
		Acte acte = new Acte();

		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection con = DriverManager.getConnection(url, user, password);

			java.sql.Statement stt = con.createStatement();

			String query = "SELECT NumActe, DateActe "
					+ "FROM tab_acte WHERE NumActe = " + id;
			ResultSet res = stt.executeQuery(query);

			if(res.first()) {  // assign info to a new Acte
				acte=new Acte(
						res.getInt("NumActe"), 
						res.getDate("DateActe").toLocalDate()
						);

			} else {
				System.out.println("no results for Acte id#" + id);  //this will print if problem with SQL query
			}

			res.close();
			stt.close();
			con.close();

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		
		return acte;
	}

	@Override
	public ArrayList<Acte> findByName(String nom, String prenom) {
		// TODO Auto-generated method stub
		return null;
	}

}
