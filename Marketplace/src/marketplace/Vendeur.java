package marketplace;

public class Vendeur extends User {
	
	//Variables de la classe Vendeur
	private int idVendeur;

	
	//Constructeur de la classe Vendeur
	public Vendeur(int id, String login, String password, String tel, String nom, String prenom, int idVendeur) {
		super(id, login, password, tel, nom, prenom);
		this.idVendeur=idVendeur;
	}
	
	//Getters et Setters de la classe vendeur
	public int getIdVendeur() {
		return idVendeur;
	}
	
	public void setIdVendeur(int idVendeur) {
		this.idVendeur = idVendeur;
	}
	
	
	
}
