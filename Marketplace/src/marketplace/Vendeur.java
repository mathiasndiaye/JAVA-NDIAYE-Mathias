package marketplace;

public class Vendeur extends User {
	
	//Variables de la classe Vendeur
	private int idVendeur;

	
	//Constructeur de la classe Vendeur
	public Vendeur(String login, String password, String tel, String nom, String prenom, int idVendeur) {
		super(login, password, tel, nom, prenom);
		this.idVendeur=idVendeur;
	}
	
	//Getters et Setters de la classe vendeur
	public int getIdVendeur() {
		return idVendeur;
	}
	
	public void setIdVendeur(int idVendeur) {
		this.idVendeur = idVendeur;
	}

	//Methodes de la classe vendeur
	@Override
	public String toString() {
		return "[Login :" + this.getLogin() + ", Password : " + this.getPassword() +", Tel : " + this.getTel() + ", Nom : " + this.getNom() + ", Prenom : " + this.getPrenom() + ", id vendeur : " + idVendeur + "]";
	}
}
