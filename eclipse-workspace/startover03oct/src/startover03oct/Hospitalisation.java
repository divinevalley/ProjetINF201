package startover03oct;

import java.time.LocalDate;
import java.util.ArrayList;

public class Hospitalisation {
	protected Integer numHospi; 
	protected LocalDate dateEntree;
	protected LocalDate dateSortie;
	protected ArrayList<Acte> listActe = new ArrayList<Acte>();
	
	
	public Hospitalisation(Integer numHospi, LocalDate dateEntree, LocalDate dateSortie) {
		super();
		this.numHospi = numHospi;
		this.dateEntree = dateEntree;
		this.dateSortie = dateSortie;
	}
	
	//simple blank constructor no attributes
	public Hospitalisation() {};

	
	public String toString() {
		   return "\n Numero Hospitalisation : " + this.numHospi 
				   + " | Date D'entree : " + this.dateEntree  + " | Date de Sortie : " + this.dateSortie;
		}
	
}


