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
	
	//Méthodes de la classe Livreur
	
	/*public String listeColis() {                         //est censé afficher la liste des colis associé au livreur
		//TODO
	}*/
	
	/*
	public String notifier_client_colis(Colis c) {
		return "Votre colis numéro " + c.getNomSuivi() + " est en route";
	}*/
	
	void ajouterColis(Colis c) {
		listeColis.add(c);
	}
	
	void retirerColis(Colis c) {
		listeColis.remove(c);
	}

}
