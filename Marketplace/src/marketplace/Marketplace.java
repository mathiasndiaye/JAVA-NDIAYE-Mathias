package marketplace;

import java.util.ArrayList;

public class Marketplace {
	

	// Variables de la classe Marketplace
	private ArrayList<Produit> listeProduits = new ArrayList<Produit>();
	private ArrayList<User> listeUsers = new ArrayList<User>();
	
	
	// Getters et Setters
	public ArrayList<Produit> getListeProduits() {
		return listeProduits;
	}
	
	public ArrayList<User> getListeUsers() {
		return listeUsers;
	}	
	
	
	
	// Méthodes de la classe Marketplace
	@Override
	public String toString() {
		return "Marketplace [listeProduits=" + listeProduits + ", listeUsers=" + listeUsers + "]";
	}
	
	public boolean addProduit(Produit p) {
		return this.listeProduits.add(p);
	}

	
}
