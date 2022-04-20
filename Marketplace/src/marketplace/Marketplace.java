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
	
	//Ajoute un produit en vérifiant s'il n'est pas déjà contenu dans la liste
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
	
	//Ajoute un produit à la liste en fonction des paramètres 
	public boolean addProduit(int ref, double prix, int delai_livraison) {
		Produit p=new Produit(ref, prix, delai_livraison);
		return this.addProduit(p);
	}
	
	//Ajoute un user en vérifiant s'il n'est pas déjà contenu dans la liste
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
	
	//Ajoute un client à la liste en fonction des paramètres 
	public boolean addClient(int id, String login, String password, String tel, String nom, String prenom, int numClient, String adresse) {
		Client c=new Client(id, login, password, tel, nom, prenom, numClient, adresse);
		return this.addUser(c);
	}
	
	//Ajoute un vendeur à la liste en fonction des paramètres 
	public boolean addVendeur(int id, String login, String password, String tel, String nom, String prenom, int idVendeur) {
		Vendeur v=new Vendeur(id, login, password, tel, nom, prenom, idVendeur);
		return this.addUser(v);
	}
	
	public boolean removeUser(User u) {
		return this.listeUsers.remove(u);
	}
	
	//public boolean removeUserLogin()
}
