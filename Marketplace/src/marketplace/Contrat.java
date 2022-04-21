package marketplace;

import java.time.LocalDate;

public class Contrat {
	
	//Variables de la classe Contrat
	private int num;
	private LocalDate dateDebut;
	private LocalDate dateFin;
	
	
	//Constructeur de la classe Contrat
	public Contrat(int num, LocalDate dateDebut, LocalDate dateFin) {
		super();
		this.num = num;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}
	
	
	//Getters et Setters de la classe Contrat
	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


	public LocalDate getDateDebut() {
		return dateDebut;
	}


	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}


	public LocalDate getDateFin() {
		return dateFin;
	}


	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}
	
	
	//Methodes de la classe contrat
	@Override
	public String toString() {
		return "Contrat [num=" + num + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + "]";
	}

}
