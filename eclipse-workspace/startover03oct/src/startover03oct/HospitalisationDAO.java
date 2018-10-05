package startover03oct;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

public class HospitalisationDAO extends DAO<Hospitalisation>{
	
	String url = "jdbc:mysql://localhost/wung";
	String user = "root";
	String password = "";

	public HospitalisationDAO(Connection conn) {
		super(conn);
	}

	//METHOD FIND HOSPITALISATION BY ID NUM 
	@Override
	public Hospitalisation findByNum(int id) {
		Hospitalisation hospi = new Hospitalisation();
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection con = DriverManager.getConnection(url, user, password);

			java.sql.Statement stt = con.createStatement();

			String query = "SELECT tab_hospitalisation.NumHospitalisation, NumPatient, DateEntree, DateSortie, NumActe "
					+ "FROM tab_hospitalisation "
					+ "LEFT JOIN tab_acte ON tab_hospitalisation.NumHospitalisation = NumHopitalisation "
					+ "WHERE NumHospitalisation = " + id;
			
			ResultSet res = stt.executeQuery(query);

			if(res.first()) { 
				hospi=new Hospitalisation(  //Take result and assign to a new Hospitalisation
						res.getInt("NumHospitalisation"), 
						res.getDate("DateEntree").toLocalDate(),
						res.getDate("DateSortie").toLocalDate()
						);
				
				res.beforeFirst();
		        ActeDAO acteDao = new ActeDAO(this.connect);
		        
		        /* Note to self for code below: 
		         * Use the Acte DAO and use findByNum() to create a new Acte(s)
		         * with the id from query results 
		         * => We'll then add that Acte to the Hospitalisation's list 
		         */
		        while(res.next() != false && res.getInt("NumActe") != 0)
		          hospi.listActe.add(acteDao.findByNum(res.getInt("NumActe")));
		        
			} else {
				System.out.println("No SQL results, hospitalisationDAO");
			}

			res.close();
			stt.close();
			con.close();

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return hospi;

	}
		

	@Override
	public ArrayList<Hospitalisation> findByName(String nom, String prenom) {
		// TODO Auto-generated method stub
		return null;
	}


}
