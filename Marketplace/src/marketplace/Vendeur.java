package marketplace;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Vendeur extends User {
	
	//Variables de la classe Vendeur
	private Contrat contrat;
	private ArrayList<Produit> listeProduits=new ArrayList<Produit>();
		
	//indexation des produits
	private Map<String,Produit> indexRefProduit=new HashMap<String,Produit>();   //Permet de mapper une ref produit avec son produit
	
	//Constructeur de la classe Vendeur
	public Vendeur(String login, String password, String tel, String nom, String prenom) {
		super(login, password, tel, nom, prenom);
	}
	
	//Getters et Setters de la classe vendeur
	public Contrat getContrat() {
		return contrat;
	}

	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}

	public ArrayList<Produit> getListeProduits() {
		return listeProduits;
	}

	@Override
	public Map<String, Produit> getIndexRefProduit() {
		return indexRefProduit;
	}

	//Methodes de la classe vendeur
	@Override
	public String toString() {
		return "Vendeur [contrat=" + contrat + ", listeProduits=" + listeProduits
				+ ", indexRefProduit=" + indexRefProduit + "]";
	}

	
	public void signerContrat(int num, LocalDate dateDebut, LocalDate dateFin) {
		contrat=new Contrat(num, dateDebut, dateFin);
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
	@Override
	public boolean addProduit(String ref, double prix, int delai_livraison) {
		Produit p=new Produit(ref, prix, delai_livraison);
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
			// Le CD n'est pas référencé
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
	
	//Affiche tous les produits vendus par le vendeur
	@Override
	public void afficherProduits() {
		System.out.println("Liste des produits vendues par " + this.getLogin() + " : ");
		System.out.println("");
		for(int i=0; i<listeProduits.size(); i++) {
			System.out.println("Reference : " + listeProduits.get(i).getReference() + "   -----   " + "Prix : " + listeProduits.get(i).getPrix() + "€" + "   -----   " + "Délai de livraison : " + listeProduits.get(i).getDelai_livraison() + " jours");
		}
	}
}
