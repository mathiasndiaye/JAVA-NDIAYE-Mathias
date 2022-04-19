package marketplace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class Marketplace {
	

	// Variables de la classe Marketplace
	private ArrayList<Produit> listeProduits;
	private ArrayList<User> listeUsers;
	
	//Indexation des User
	private Map<String,User> indexLoginUser;     //Permet de mapper un login avec son User
	private Map<Integer,Produit> indexRefProduit;   //Permet de mapper une ref produit avec son produit
	
	
	//Constructeur de la classe Marketplace
	public Marketplace() {
		listeProduits=new ArrayList<Produit>();
		listeUsers=new ArrayList<User>();
		indexLoginUser= new HashMap<String,User>();
		indexRefProduit=new HashMap<Integer,Produit>();
	}
	
	
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
		boolean ajoutOK;
		
		//Verifie si notre indexation par login ne contient pas déjà le User 
		if(indexRefProduit.containsKey(p.getReference())) {
			//on refuse l'ajout du User
			return false;
			}
		
		//Ajout du User dans la liste de user
		ajoutOK= listeProduits.add(p);
				
		//Indexation du User
		if(ajoutOK) {
			indexRefProduit.put(p.getReference(), p);
		}
				
		return ajoutOK;		
	}
	
	public boolean addUser(User u) {
		boolean ajoutOK;
		
		//Verifie si notre indexation par login ne contient pas déjà le User 
		if(indexLoginUser.containsKey(u.getLogin())) {
			//on refuse l'ajout du User
			return false;
		}
		
		//Ajout du User dans la liste de user
		ajoutOK= listeUsers.add(u);
		
		//Indexation du User
		if(ajoutOK) {
			indexLoginUser.put(u.getLogin(), u);
		}
		
		return ajoutOK;
	}
	
	public boolean removeUser(User u) {
		return this.listeUsers.remove(u);
	}
	
	//public boolean removeUserLogin()
}
