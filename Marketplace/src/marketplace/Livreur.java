package marketplace;

import java.util.ArrayList;

public class Livreur extends User {
	
	//Variables classe Livreur
	private ArrayList<Colis> listeColis;
	
	
	//Constructeur de la classe Livreur
	public Livreur(String login, String password, String tel, String nom, String prenom) {
		super(login, password, tel, nom, prenom);
		this.listeColis=new ArrayList<Colis>();
	}
	
	//M�thodes de la classe Livreur
	
	/*public String listeColis() {                         //est cens� afficher la liste des colis associ� au livreur
		//TODO
	}*/
	
	/*
	public String notifier_client_colis(Colis c) {
		return "Votre colis num�ro " + c.getNomSuivi() + " est en route";
	}*/
	
	void ajouterColis(Colis c) {
		listeColis.add(c);
	}
	
	void retirerColis(Colis c) {
		listeColis.remove(c);
	}

}
