package marketplace;

public class Colis {
	
	public enum Statut{En_attente, En_livraison, Livré};
	
	//Variables de la classe Colis
	private int numSuivi;
	private Statut statut;
	
	
	//Constructeur de la classe Colis
	public Colis(int numSuivi, Statut statut) {
		this.numSuivi = numSuivi;
		this.statut = statut;
	}


	//Getters et Setters de la classe Colis
	public int getNumSuivi() {
		return numSuivi;
	}


	public void setNumSuivi(int numSuivi) {
		this.numSuivi = numSuivi;
	}


	public Statut getStatut() {
		return statut;
	}

	public void setStatut(Statut statut) {
		this.statut = statut;
	}
	

}
