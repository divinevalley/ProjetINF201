package startover03oct;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PatientDAO extends DAO<Patient> {
	
	String url = "jdbc:mysql://localhost/wung";
	String user = "root";
	String password = "";
	
	public PatientDAO(Connection conn) {
		super(conn);
	}

	//METHOD 1 : FIND PATIENT BY NUM
	public Patient findByNum(int id) {
		Patient pt = new Patient();

		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection con = DriverManager.getConnection(url, user, password);

			java.sql.Statement stt = con.createStatement();

			String query = "SELECT tab_patient.NumPatient, Prenom, Nom, NumHospitalisation "
					+ "FROM tab_patient "
					+ "LEFT JOIN tab_hospitalisation "
					+ "ON tab_patient.NumPatient = tab_hospitalisation.NumPatient "
					+ "WHERE tab_patient.NumPatient = " + id;
			ResultSet res = stt.executeQuery(query);

			if(res.first()) { 
				pt=new Patient(
						id,
						res.getString("Prenom"),
						res.getString("Nom")
						);
				
				res.beforeFirst();
		        HospitalisationDAO hospiDao = new HospitalisationDAO(this.connect);
		        
		        /* Note for code below: 
		         * Go into the Hospitalisation DAO and use findByNum() to create a new Hospitalisation(s) 
		         * with the id from query results 
		         * => We'll then add that hospitalisation to the patient's list 
		         */
		        while(res.next() != false && res.getInt("NumHospitalisation") != 0)
		          pt.listHospi.add(hospiDao.findByNum(res.getInt("NumHospitalisation")));
		        
		        
			} else {
				System.out.println("no results, PatientDAO");
			}

			res.close();
			stt.close();
			con.close();

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return pt;

	}

	//METHOD 2 : FIND PATIENT BY NAME
	@Override
	public ArrayList<Patient> findByName(String nom, String prenom) {

		Patient pt = new Patient();
		ArrayList<Patient> ptlist = new ArrayList<Patient>();


		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection con = DriverManager.getConnection(url, user, password);

			System.out.println("FIND PATIENT BY NAME...");
			java.sql.Statement stt = con.createStatement();

			String query = "SELECT NumPatient, Prenom, Nom FROM tab_patient WHERE (Prenom = " 
					+ "\"" + prenom + "\"" + " AND NOM = " + "\"" + nom + "\")";
			ResultSet res = stt.executeQuery(query);


			while (res.next()) {
				pt=new Patient(
						res.getInt("NumPatient"),
						res.getString("Prenom"),
						res.getString("Nom")
						);
				ptlist.add(pt); 	
			}


			res.close();
			stt.close();
			con.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return ptlist;
	}
	
	
	
}
