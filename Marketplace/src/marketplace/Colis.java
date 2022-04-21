package marketplace;

import java.util.ArrayList;

public class Colis {
	
	public enum Statut{En_attente, En_livraison, Livré};
	
	//Variables de la classe Colis
	private int numSuivi;
	private Statut statut;
	private ArrayList<Produit> listeProduits;
	
	
	//Constructeur de la classe Colis
	public Colis(int numSuivi, Statut statut) {
		this.numSuivi = numSuivi;
		this.statut = statut;
		this.listeProduits=new ArrayList<Produit>();
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
	
	//Méthodes de la classe Colis
	void ajouterProduit(Produit p) {
		listeProduits.add(p);
	}
	
	void retirerProduit(Produit p) {
		listeProduits.remove(p);
	}

}
