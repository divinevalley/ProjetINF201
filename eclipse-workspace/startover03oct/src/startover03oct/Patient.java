package startover03oct;

import java.util.ArrayList;

public class Patient {
	protected int numPatient; 
	protected String prenom;
	protected String nom;
	protected ArrayList<Hospitalisation> listHospi = new ArrayList<Hospitalisation>();
	
	
	//constructor
	public Patient(int numPatient, String prenom, String nom) {
		super();
		this.numPatient = numPatient;
		this.prenom = prenom;
		this.nom = nom;
	}

	//simple constructor to be able to create pt with no attributes
	public Patient() {
	}
	
	public String toString() {
		   return "Numero de Patient : " + this.numPatient +
			  " | Prenom : " + this.prenom +
			  " | Nom : " + this.nom;
		}
	
}
