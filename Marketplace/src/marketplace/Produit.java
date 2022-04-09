package marketplace;

public class Produit {
	
	
	// Variables de la classe Produit
	private int reference;
	private double prix;
	private int delai_livraison;   //délai en jours
	
	
	// Constructeur de la classe Produit
	public Produit(int reference, double prix, int delai_livraison) {
		super();
		this.reference = reference;
		this.prix = prix;
		this.delai_livraison = delai_livraison;
	}
	
	
	// Getters et setters
	public int getReference() {
		return reference;
	}
	public void setReference(int reference) {
		this.reference = reference;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public int getDelai_livraison() {
		return delai_livraison;
	}
	public void setDelai_livraison(int delai_livraison) {
		this.delai_livraison = delai_livraison;
	}
	
}
