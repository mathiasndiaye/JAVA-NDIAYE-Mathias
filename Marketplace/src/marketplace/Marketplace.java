package marketplace;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class Marketplace {
	

	// Variables de la classe Marketplace
	private ArrayList<Produit> listeProduits = new ArrayList<Produit>();
	private Set<User> listeUsers= new HashSet<User>();
	
	
	// Getters et Setters
	public ArrayList<Produit> getListeProduits() {
		return listeProduits;
	}
	
	public Set<User> getListeUsers() {
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

	public boolean addUser(User u) {
		return this.listeUsers.add(u);
	}
	
	public boolean removeUser(User u) {
		return this.listeUsers.remove(u);
	}
}
