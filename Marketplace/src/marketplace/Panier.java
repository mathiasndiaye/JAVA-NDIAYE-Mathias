package marketplace;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class Panier {
	//Variables de la classe Panier
	private double montant;
	private ArrayList<Produit> listeProduits;
	
	//Indexation des produits
	private Map<String,Produit> indexRefProduit;     //Permet de mapper un produit avec sa ref   			//A VOIR SI ON FAIT CA, PAS SUR

	
	//Constructeur de la classe Panier
	public Panier() {
		this.montant=0;
		this.listeProduits=new ArrayList<Produit>();
	}
	
	//Getters et Setters de la classe Panier
	public ArrayList<Produit> getListeProduits() {
		return listeProduits;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}
	
	public Map<String,Produit> getIndexRefProduit(){
		return indexRefProduit;
	}
	
	//Méthodes de la classe panier
	public void afficherPanier() {
		for(int i=0; i<listeProduits.size(); i++) {
			System.out.println("Reference : " + listeProduits.get(i).getReference() + "   -----   " + "Prix : " + listeProduits.get(i).getPrix() + "€" + "   -----   " + "Délai de livraison : " + listeProduits.get(i).getDelai_livraison() + " jours");
		}
	}
	
	@Override
	public String toString() {
		return "Panier [montant=" + montant + ", listeProduits=" + listeProduits + "]";
	}

	public void retirerProduit(Produit p) {
		listeProduits.remove(p);
		montant=montant-p.getPrix();
	}
	
	public void viderPanier() {
		Iterator<Produit> iterator = listeProduits.iterator();
		while(iterator.hasNext()) {
			Produit p=iterator.next();
			iterator.remove();
		}
		montant=0;
	}
	
}
