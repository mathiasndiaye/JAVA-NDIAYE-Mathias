package marketplace;

import java.time.LocalDate;
import java.util.Scanner;

public class testMarketplace {

	public static void main(String[] args) {
		
		Marketplace marketplace=new Marketplace();
		Produit p1=new Produit("Assiette",14.5,7);
		Produit p2=new Produit("Casserole", 29.99, 3);
		Client c1=new Client("azerty", "1234", "0783453104", "Mathias", "NDIAYE", 1, "3 avenue de Pompadour 19350 Juillac");
		Client c2=new Client("qwerty", "5678", "0782484331", "Yoan", "NDIAYE", 2, "13 Rue du lavoir 243567 Lolo");
		marketplace.addProduit(p1);
		marketplace.addProduit(p2);
		marketplace.addUser(c1);
		marketplace.addUser(c2);
		marketplace.addClient("qwerty", "9101", "0662154960", "Fatou", "NDIAYE", 3, "4 Rue BooskaP 15620 Lerap");
		marketplace.addClient("aloha", "4521", "066214204", "Loic", "Moix", 4, "10 Rue BooskaP 15620 Lerap");
		marketplace.addClient("zar01", "7410", "066214520", "Mathieu", "Furon", 5, "19 Rue BooskaP 15620 Lerap");
		//marketplace.removeUser(c1);
		marketplace.removeUserLogin("zar01");
		//System.out.println(marketplace.toString());
		c1.ajouterPanier(p1, 2);
		c1.ajouterPanier(p2);
		c1.viderPanier();
		//System.out.println("Panier :" + c1.getPanier().toString());
		Vendeur v1 = new Vendeur("yoyo", "4201", "0652957430", "Jean", "Ti", 1);
		v1.signerContrat(1, LocalDate.of(2022,04,21), LocalDate.of(2023,04,21));
		v1.addProduit("Fourchette", 1.0, 4);
		v1.addProduit("Couteau", 2.0, 4);
		System.out.println(v1.toString());
		
	
		
		}
	
	/**
	 * lire une information au clavier avec un message d'attente
	 * @param messageInfo le message d'attente (prompt)
	 * @return chaîne lu au clavier
	 */
    private static String lireInfo(String messageInfo) {
		String infoLue;
		System.out.print(messageInfo + " : ");
		// lecture clavier et nettoyage des espaces en tête ou en queue de
		// chaîne
		 Scanner s = new Scanner(System.in);
		 infoLue = s.nextLine();
		return infoLue;
	}
    
    //Lis entree utilisateur pour prix
    private static double saisiePrix(){
		String chainePrix;
		double prix = -1;
		boolean erreur;
		do {
			try {
				erreur = false;
				chainePrix= lireInfo("Prix ");
				prix = Integer.parseInt(chainePrix);
			} catch (NumberFormatException e) {
				erreur = true;
			}
		} while (erreur || (prix < 0));
		return prix;
	}
    
	
	//Ajouter un produit a la liste des produits marketplace
	private static void addProduit(Marketplace m) {
		String reference;
		double prix;
		int delai_livraison;
		
		//On lit les entrées de l'utilisateur
		reference=lireInfo("Reference ");
		prix=saisiePrix();
				
	}
	
	
	
}
