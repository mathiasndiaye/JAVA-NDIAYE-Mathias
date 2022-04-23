package marketplace;

import java.util.Map;

public abstract class User {
	
	
	// Variables de la classe User
	private String login;
	private String password;
	private String tel;
	private String nom;
	private String prenom;
	
	
	// Constructeur de la classe User
	public User(String login, String password, String tel, String nom, String prenom) {
		this.login = login;
		this.password = password;
		this.tel = tel;
		this.nom = nom;
		this.prenom = prenom;
	}
	
	
	// Getters et setters
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public Map<String, Produit> getIndexRefProduit() {
		return null;
	}
	
	
	//Méthodes de la classe User 
	public String toString() {
		String u;
		u="[Login :" + this.getLogin() + ", Password : " + this.getPassword() +", Tel : " + this.getTel() + ", Nom : " + this.getNom() + ", Prenom : " + this.getPrenom() + "]";
		return u;
	}
	
	public void afficherProduits() {
		//Nothing here, we override it in vendeur class
	}
	
	public boolean addProduit(String reference, double prix, int delai_livraison) {
		return false; //We redefenite it in vendeur class
	}
	
	public void ajouterPanier(Produit p) {
		//Nothing here, we override it in vendeur class
	}

	public void viderPanier() {
		//Nothing here, we override it in vendeur class
	}
}
