package marketplace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Marketplace {
	

	// Variables de la classe Marketplace
	private ArrayList<Produit> listeProduits;
	private ArrayList<User> listeUsers;
	
	//Indexation des User
	private Map<String,User> indexLoginUser;     //Permet de mapper un login avec son User
	private Map<String, Produit> indexRefProduit;   //Permet de mapper une ref produit avec son produit
	private Map<String, String> indexLoginPassword;  //Permet de mapper un login avec son password
	
	//Constructeur de la classe Marketplace
	public Marketplace() {
		listeProduits=new ArrayList<Produit>();
		listeUsers=new ArrayList<User>();
		indexLoginUser= new HashMap<String,User>();
		indexRefProduit=new HashMap<String,Produit>();
		indexLoginPassword=new HashMap<String,String>();
	}
	
	
	// Getters et Setters
	public ArrayList<Produit> getListeProduits() {
		return listeProduits;
	}
	
	public ArrayList<User> getListeUsers() {
		return listeUsers;
	}	
	
	public Map<String, Produit> getIndexRefProduit(){
		return indexRefProduit;
	}
	
	public Map<String, String> getIndexLoginPassword(){
		return indexLoginPassword;
	}
	
	public Map<String, User> getIndexLoginUser(){
		return indexLoginUser;
	}
	
	// Méthodes de la classe Marketplace
	@Override
	public String toString() {
		String s;
		s="MarketPlace : Liste Produits : ";
		for(Produit p:this.getListeProduits()) {
			s=s+p.toString();
		}
		s=s+"; Liste Users : ";
		for(User u:this.getListeUsers()) {
			s=s+u.toString();
		}
		return s;
	}
	
	//Affiche tous les produits vendus par le Marketplace
	public void afficherProduits() {
		System.out.println("Liste des produits vendues par le Marketplace : ");
		System.out.println("");
		for(int i=0; i<listeProduits.size(); i++) {
			System.out.println("Reference : " + listeProduits.get(i).getReference() + "   -----   " + "Prix : " + listeProduits.get(i).getPrix() + "€" + "   -----   " + "Délai de livraison : " + listeProduits.get(i).getDelai_livraison() + " jours");
		}
	}
	
	
	//METHODES CONCERNANT LES PRODUITS ET LA GESTION DE LA LISTE DES PRODUITS
	
	
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
	public boolean addProduit(String ref, double prix, int delai_livraison, int quantite) {
		Produit p=new Produit(ref, prix, delai_livraison, quantite);
		return this.addProduit(p);
	}
	
	//Retire un produit de la liste ainsi que de l'indexation
	public boolean removeProduit(Produit p) {
		boolean supprimeOK;
		supprimeOK=this.listeProduits.remove(p);
		
		if(supprimeOK) {
			indexRefProduit.remove(p.getReference());
		}
		return supprimeOK;
	}
	
	//Retire un produit en fonction de la clef d'indexation et de l'index
		private <K> boolean removeProduit(K clef, Map<K,Produit> index) {
			Produit produitASupprimer;
			if (!index.containsKey(clef)) {
				// Le produit n'est pas référencé
				return false;
			}
			produitASupprimer = index.get(clef);
			return removeProduit(produitASupprimer);
		}
		
		//Retire un produit en fonction de sa reference
		public boolean removeProduitReference(String ref) {
			boolean produitASupprimer;
			produitASupprimer=removeProduit(ref, indexRefProduit);
			return produitASupprimer;
		}
	
	
		
	////METHODES CONCERNANT LES USERS ET LA GESTION DE LA LISTE DES USERS
		
	
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
			indexLoginPassword.put(u.getLogin(), u.getPassword());
		}
		
		return ajoutOK;
	}
	
	//Ajoute un client à la liste en fonction des paramètres 
	public boolean addClient(String login, String password, String tel, String nom, String prenom, String adresse) {
		Client c=new Client(login, password, tel, nom, prenom, adresse);
		return this.addUser(c);
	}
	
	//Ajoute un vendeur à la liste en fonction des paramètres 
	public boolean addVendeur(String login, String password, String tel, String nom, String prenom) {
		Vendeur v=new Vendeur(login, password, tel, nom, prenom);
		return this.addUser(v);
	}
	
	//Retire un user de la liste ainsi que de l'indexation
	public boolean removeUser(User u) {
		boolean supprimeOK;
		supprimeOK=this.listeUsers.remove(u);
		
		if(supprimeOK) {
			indexLoginUser.remove(u.getLogin());
		}
		return supprimeOK;
	}
	
	//Retire un user en fonction de la clef d'indexation et de l'index
	private <K> boolean removeUser(K clef, Map<K,User> index) {
		User userASupprimer;
		if (!index.containsKey(clef)) {
			// Le CD n'est pas référencé
			return false;
		}
		userASupprimer = index.get(clef);
		return removeUser(userASupprimer);
	}
	
	//Retire un user en fonction du login 
	public boolean removeUserLogin(String login) {
		boolean userASupprimer;
		userASupprimer=removeUser(login, indexLoginUser);
		return userASupprimer;
	}
}
