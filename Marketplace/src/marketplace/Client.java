package marketplace;

import java.util.ArrayList;

public class Client extends User {
	
	// Variables de la classe Client
	private String adresse;
	private Panier panier;
	//private double solde;
	
	//Constructeur de la classe Client
	public Client(String login, String password, String tel, String nom, String prenom, String adresse){
		super(login, password, tel, nom, prenom);
		this.adresse=adresse;
		this.panier= new Panier();
	}

	//Getter et setter de la Classe Client
	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public Panier getPanier() {
		return panier;
	}

	public void setPanier(Panier panier) {
		this.panier = panier;
	}

	//Méthodes de la classe Client
	@Override
	public String toString() {
		return "[Login :" + this.getLogin() + ", Password : " + this.getPassword() +", Tel : " + this.getTel() + ", Nom : " + this.getNom() + ", Prenom : " + this.getPrenom() + ", adresse : " + adresse +"]";
	}
	
	void Acheter() {
		//TODO
	}
	
	void choixLivraison() {	
		//TODO
	}
	
	
	void suivreCommande(Commande C) {
		//TODO
	}

	//Ajoute un produit au panier
	@Override
	public void ajouterPanier(Produit p) {
		panier.getListeProduits().add(p);
		panier.setMontant(panier.getMontant()+p.getPrix());
	}
	
	//Ajoute un produit au panier avec n quantité
	public void ajouterPanier(Produit p, int quantité) {
		for(int i=0; i<quantité; i++) {
			ajouterPanier(p);
		}
	}
	
	//Vide le panier
	@Override
	public void viderPanier() {
		panier.viderPanier();
	}
	
	//Affiche le panier
	@Override
	public void afficherPanier() {
		System.out.println("Mon panier : ");
		System.out.println("");
		for(int i=0; i<panier.getListeProduits().size(); i++) {
			System.out.println("Reference : " + panier.getListeProduits().get(i).getReference() + "   -----   " + "Prix : " + panier.getListeProduits().get(i).getPrix() + "€" + "   -----   " + "Délai de livraison : " + panier.getListeProduits().get(i).getDelai_livraison() + " jours");
		}
		System.out.println("");
		System.out.println("");
		System.out.println("Montant total : " + panier.getMontant() + " €");
	}
	

	
}
