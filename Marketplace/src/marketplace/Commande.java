package marketplace;

import java.util.ArrayList;

public class Commande {

	//Variables de la classe commande
	private int numero;
	private int mode_de_livraison; //Peut prendre que la valeur 0 ou 1, 0=livraison standard 1=livraison en point relais. FAIRE UN CONSTRAINT
	private Panier panier;
	
	//Constructeur de la classe commande
	public Commande(int numero, int mode_de_livraison) {
		this.numero = numero;
		this.mode_de_livraison = mode_de_livraison;
		this.panier=null;
	}
	
	//Getters et Setters de la classe Commande
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getMode_de_livraison() {
		return mode_de_livraison;
	}

	public void setMode_de_livraison(int mode_de_livraison) {
		this.mode_de_livraison = mode_de_livraison;
	}
	
	public void setPanier(Panier p) {
		panier=p;
	}
	
	public Panier getPanier() {
		return panier;
	}
}
