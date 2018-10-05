package startover03oct;

import java.time.LocalDate;

public class Acte {
	protected Integer numActe;
	protected LocalDate dateActe;
	
	//basic constructor
	public Acte() {};
	
	//constructor with attributes
	public Acte(Integer numActe, LocalDate dateActe) {
		super();
		this.numActe = numActe;
		this.dateActe = dateActe;
	}
	
	
	
	
	/**
	 * @return the numActe
	 */
	public Integer getNumActe() {
		return numActe;
	}

	/**
	 * @param numActe the numActe to set
	 */
	public void setNumActe(Integer numActe) {
		this.numActe = numActe;
	}

	/**
	 * @return the dateActe
	 */
	public LocalDate getDateActe() {
		return dateActe;
	}

	/**
	 * @param dateActe the dateActe to set
	 */
	public void setDateActe(LocalDate dateActe) {
		this.dateActe = dateActe;
	}

	public String toString() {
		   return "\n Numero Acte : " + this.numActe
				   + " | Date d'acte : " + this.dateActe; 
		}
	
	

}
