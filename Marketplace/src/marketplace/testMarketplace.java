package marketplace;

import java.time.LocalDate;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOError;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Object;
import java.util.Scanner;

public class testMarketplace {

	public static void main(String[] args) {
		
		Marketplace marketplace=new Marketplace();
		/*Produit p1=new Produit("Assiette",14.5,7);
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
		//System.out.println(v1.toString());
		*/
		//addProduit(marketplace);
		//System.out.println(marketplace.toString());
		
		//Test ajout produit à un vendeur
		
		/*Vendeur v1 = new Vendeur("yoyo", "4201", "0652957430", "Jean", "Ti");
		addProduit(v1);
		addProduit(v1);
		System.out.println(v1.toString());*/
		
		/*
		//Test inscription client 
		inscrireClient(marketplace);
		inscrireVendeur(marketplace);
		System.out.println(marketplace.toString());
		 */
		
		//Test ajout produit et ajout panier
		/*marketplace.addVendeur("yoyo", "4201", "0652957430", "Jean", "Ti");
		addProduit(marketplace);
		addProduit(marketplace);
		addProduit(marketplace.getListeUsers().get(0));
		marketplace.addClient("yaya", "0521", "056321495", "Loic","Sims", "3 avenue des lilas");
		afficherProduits(marketplace);
		ajouterPanier(marketplace, marketplace.getListeUsers().get(1));*/
		
		//Test premier menu connexion ou inscription
		//menuConnexionInscription(marketplace);
		
		/*Test menu client
		marketplace.addVendeur("yoyo", "4201", "0652957430", "Jean", "Ti");
		addProduit(marketplace);
		addProduit(marketplace);
		addProduit(marketplace.getListeUsers().get(0));
		marketplace.addClient("yaya", "0521", "056321495", "Loic","Sims", "3 avenue des lilas");
		menuClient(marketplace,marketplace.getListeUsers().get(1));
		*/
		
		//Test menu vendeur
		/*marketplace.addVendeur("yoyo", "4201", "0652957430", "Jean", "Ti");
		menuVendeur(marketplace, marketplace.getListeUsers().get(0));*/
		
		chargerUsers(marketplace);
		chargerProduits(marketplace);
		menuConnexionInscription(marketplace);
		
		
		
	}
				
		
	
	//METHODES IMPORTANTES
	
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
	
	
	//GESTION DES PRODUITS DES VENDEURS ET DU MARKETPLACE
	
    
    //Lis entree utilisateur pour prix
    private static double saisiePrix(){
		String chainePrix;
		double prix = -1;
		boolean erreur;
		do {
			try {
				erreur = false;
				chainePrix= lireInfo("Prix ");
				prix = Double.parseDouble(chainePrix);
			} catch (NumberFormatException e) {
				erreur = true;
			}
		} while (erreur || (prix < 0));
		return prix;
	}
    
    //Lis entree utilisateur pour délai de livraison
    private static int saisieDelai(){
		String chaineDelai;
		int delai = -1;
		boolean erreur;
		do {
			try {
				erreur = false;
				chaineDelai= lireInfo("Délai de livraison ");
				delai = Integer.parseInt(chaineDelai);
			} catch (NumberFormatException e) {
				erreur = true;
			}
		} while (erreur || (delai < 0));
		return delai;
	}
    
	
	//Ajouter un produit a la liste des produits marketplace
	private static void addProduit(Marketplace m) {
		String reference;
		double prix;
		int delai_livraison;
		boolean produitAjoute;
		
		//On lit les entrées de l'utilisateur
		reference=lireInfo("Reference ");
		prix=saisiePrix();
		delai_livraison=saisieDelai();
		
		//On cree le produit et l'ajoute à la liste des produits
		produitAjoute=m.addProduit(reference, prix, delai_livraison);
		
		if(produitAjoute) {
			System.out.println("Produit ajouté à la liste des produits du Marketplace");
		}
		else {
			System.out.println("Ce produit existe déjà");
		}
	}
	
	//Ajoute un produit a la liste des produits d'un vendeur 
	private static void addProduit(User u) {
		String reference;
		double prix;
		int delai_livraison;
		boolean produitAjoute=false;
		
		//On lit les entrées de l'utilisateur
		reference=lireInfo("Reference ");
		prix=saisiePrix();
		delai_livraison=saisieDelai();
		
		//On cree le produit et l'ajoute à la liste des produits
		if(u.getClass().getSimpleName().equals("Vendeur")) {
			produitAjoute=u.addProduit(reference, prix, delai_livraison);
		}
		
		if(produitAjoute==true) {
			//Inscription du produit dans le fichier csv
			String text = u.getLogin() + "," + reference + "," + prix + "," + delai_livraison + "," + "\n";
		    // first create file object for file placed at location
		    // specified by filepath
			String filePath="C:\\Users\\CYTech Student\\git\\Marketplace\\Marketplace\\data_files\\produit.csv";
			File file = new File(filePath);
			try {
		        // create FileWriter object with file as parameter
				PrintWriter writer = new PrintWriter(new FileWriter(file, true));
		  
		        //write into the file
		        writer.append(text);
		  
		        // close the file
		     	writer.close();
		    }
		    catch (IOException e) {
		        // TODO Auto-generated catch block
		        System.out.print(e.getMessage());
		    }
			System.out.println("Produit ajouté à votre liste des produits");
		}
		else {
			System.out.println("Ce produit existe déjà");
		}
	}
	
	//Retire un produit a la liste des produits d'un vendeur 
		private static void removeProduit(User u) {
			String reference;
			boolean produitRetire=false;
			
			//On lit les entrées de l'utilisateur
			reference=lireInfo("Reference ");
			
			//On cree le produit et l'ajoute à la liste des produits
			if(u.getClass().getSimpleName().equals("Vendeur")) {
				produitRetire=u.removeProduitReference(reference);
			}
			
			if(produitRetire==true) {
				System.out.println("Produit retiré de votre liste des produits");
			}
			else {
				System.out.println("Ce produit existe déjà");
			}
		}
	
	//Affiche les liste de tous les produits présent sur le marketplace
	private static void afficherProduits(Marketplace m) {
		m.afficherProduits();
		System.out.println("");
		for(int i=0; i<m.getListeUsers().size(); i++) {
			if(m.getListeUsers().get(i).getClass().getSimpleName().equals("Vendeur")) {
				System.out.println("");
				m.getListeUsers().get(i).afficherProduits();
			}
		}
		System.out.println("");
	}
	
	//Affiche la liste de tous les produits vendu par un vendeur
	private static void afficherProduits(Marketplace m, User u) {
		System.out.println("");
		for(int i=0; i<m.getListeUsers().size(); i++) {
			if(m.getListeUsers().get(i).getClass().getSimpleName().equals("Vendeur") && m.getListeUsers().get(i).getLogin().equals(u.getLogin())) {
				m.getListeUsers().get(i).afficherProduits();
			}
		}
		System.out.println("");
	}
	
	
	//GESTION DES UTILISATEURS
 
    //Methode pour se connecter
	private static User seConnecter(Marketplace m) {
		String login=null;
		String password;
		boolean clientConnecte=false;
		
		while(clientConnecte==false) {
		login=lireInfo("Login ");
		password=lireInfo("Password ");
		
		//On verifie si les login et mot de passe sont bons
		if(m.getIndexLoginPassword().containsKey(login)) {
			if(m.getIndexLoginPassword().get(login).equals(password)) {
				System.out.println("");
				System.out.println("Connexion réussie");
				System.out.println("");
				clientConnecte=true;
			}
	    else {
			System.out.println("");
			System.out.println("Mot de passe erroné. Recommencez.");
			System.out.println("");
			}
		}
		else {
			System.out.println("");
			System.out.println("Client introuvable. Recommencez");
			System.out.println("");
		}
		}
		return m.getIndexLoginUser().get(login);
	}
	
	
	//Methode pour inscrire un client 
	private static void inscrireClient(Marketplace m) {
		String login;
		String password;
		String tel;
		String nom;
		String prenom;
		String adresse;
		boolean clientAjoute;
		
		login=lireInfo("Login ");
		password=lireInfo("Password ");
		tel=lireInfo("Telephon number ");
		nom=lireInfo("Nom ");
		prenom=lireInfo("Prenom ");
		adresse=lireInfo("Adresse ");
		
		//On cree le produit et l'ajoute à la liste des produits
		clientAjoute=m.addClient(login, password, tel, nom, prenom, adresse);
				
		if(clientAjoute) {
			//Inscription du login et du password dans le fichier csv
			String text = login + "," + password + "," + "client," + tel + ", " + nom + "," + prenom + "," + adresse + ","+ "\n";
		    
		    // specified by filepath
			String filePath="C:\\Users\\CYTech Student\\git\\Marketplace\\Marketplace\\data_files\\user.csv";
			File file = new File(filePath);
			try {
		        // create FileWriter object with file as parameter
				PrintWriter writer = new PrintWriter(new FileWriter(file, true));
		  
		        //write into the file
		        writer.append(text);
		  
		        // close the file
		     	writer.close();
		    }
		    catch (IOException e) {
		        // TODO Auto-generated catch block
		        System.out.print(e.getMessage());
		    }
			System.out.println(" ");
			System.out.println("Inscription réussie");
			System.out.println(" ");
			
			System.out.println(" ");
			System.out.println("Inscription réussie");
			System.out.println(" ");
		}
		else {
			System.out.println("Vous possedez déjà un compte. Veuillez vous connecter");
		}
	}
	
	
	//Methode pour inscrire un vendeur
	private static void inscrireVendeur(Marketplace m) {
		String login;
		String password;
		String tel;
		String nom;
		String prenom;
		boolean vendeurAjoute;
		
		login=lireInfo("Login ");
		password=lireInfo("Password ");
		tel=lireInfo("Telephon number ");
		nom=lireInfo("Nom ");
		prenom=lireInfo("Prenom ");
		
		//On cree le produit et l'ajoute à la liste des produits
		vendeurAjoute=m.addVendeur(login, password, tel, nom, prenom);
		
		
		if(vendeurAjoute) {
			
			//Inscription du login et du password dans le fichier csv
			String text = login + "," + password + ",vendeur," + tel + "," + nom + "," + prenom + "," + "\n";
		    // first create file object for file placed at location
		    // specified by filepath
			String filePath="C:\\Users\\CYTech Student\\git\\Marketplace\\Marketplace\\data_files\\user.csv";
			File file = new File(filePath);
			try {
		        // create FileWriter object with file as parameter
				PrintWriter writer = new PrintWriter(new FileWriter(file, true));
		  
		        //write into the file
		        writer.append(text);
		  
		        // close the file
		     	writer.close();
		    }
		    catch (IOException e) {
		        // TODO Auto-generated catch block
		        System.out.print(e.getMessage());
		    }
			System.out.println(" ");
			System.out.println("Inscription réussie");
			System.out.println(" ");
		}
		else {
			System.out.println("Vous possedez déjà un compte. Veuillez vous connecter");
		}
	}
	
	
	
	//METHODE GESTION PANIER CLIENT
	
	//Ajoute un article au panier selon la ref saisie par le client. Attention, on considère que la reference d'un produit constitue la clé primaire de notre table produit. Par consequent on imagine que 2 artciles n'auront jamais la meme ref. Si cela venait à arriver, cette méthode ajoute uniquement le premier article au panier. 
	private static void ajouterPanier(Marketplace m, User u) {
		String refProduit;
		
		refProduit=lireInfo("Veuillez inscrire la référence du produit que vous voulez achetez ");
		
		//Verifie si le produit avec cette ref est vendu par le marketplace
		if(m.getIndexRefProduit().containsKey(refProduit)) {
			u.ajouterPanier(m.getIndexRefProduit().get(refProduit));
			System.out.println("Article ajouté au panier avec succès.");
			return; //Pour arreter la méthode
		}
		
		//Verifie si le produit avec cette ref est vendu par un des vendeurs
		for(int i=0; i<m.getListeUsers().size(); i++) {
				if(m.getListeUsers().get(i).getClass().getSimpleName().equals("Vendeur")){
					if(m.getListeUsers().get(i).getIndexRefProduit().containsKey(refProduit)) {
						u.ajouterPanier(m.getListeUsers().get(i).getIndexRefProduit().get(refProduit));
						System.out.println("Article ajouté au panier avec succès.");
						return; //pour arreter la méthode
					}
				}
			
		}
		
		//Si le produit n'a pas été trouvé
		System.out.println("Désolé ce produit n'existe pas. Veuillez réessayer.");
		
	}
	
	//Vider le Panier d'un client
	private static void viderPanier(User u) {
		u.viderPanier();
	}
	
	//Afficher le panier d'un client
	private static void afficherPanier(User u) {
		System.out.println("");
		u.afficherPanier();
		System.out.println("");
	}
	
	//Méthode pour saisie montant à créditer
	private static double saisieMontant() {
		double montant = 0;
		boolean erreur;
		String lecture; // buffer de lecture clavier

		// lecture du choix jusqu'Ã  ce qu'elle soit correcte
		do {
			try {
				erreur = false;
				lecture = lireInfo("Montant à créditer ");
				montant = Double.parseDouble(lecture);
			} catch (NumberFormatException e) {
				//erreur
				erreur = true;
			}
		} while (erreur || montant<0);
		return montant;
	}
	
	//Crediter le compte d'un client
	private static void crediterCompte(User u) {
		double montant;
		montant=saisieMontant();
		u.crediterCompte(montant);
		System.out.println("");
		System.out.println("Le montant a été crédité sur votre compte avec succès");
		System.out.println("");
	}
	
	
	//Passer commande pour le client
	private static void acheter(User u) {
		int numCommande;
		int choixLivraison;
		System.out.println("");
		System.out.println("Veuillez écrire le numéro de la commande : ");
		numCommande=saisieChoix(1,10);
		System.out.println("");
		System.out.println("Veuillez saisir le mode de livraison :");
		System.out.println("");
		System.out.println("(1) Livraison standard");
		System.out.println("(2) Livraison en point relais");
		System.out.println("");
		choixLivraison=saisieChoix(1,2);
		System.out.println("");
		if(u.getPanier().getMontant()>u.getSolde()) {
			System.out.println("Désolé vous ne disposez pas de suffisaments de fonds pour passer cette commande. Veuillez créditer votre compte.");
		}
		else {
			Commande commande = new Commande(numCommande, choixLivraison);
			final Panier panier=u.getPanier();
			//panier=u.getPanier();
			commande.setPanier(panier);
			u.addListeCommandes(commande);
			u.retirerSolde(u.getPanier().getMontant());
			System.out.println("Commande passée avec succès.");
		}
		
	}
	
	
	//Afficher la liste des commandes d'un client
	private static void afficherListeCommandes(User u) {
		System.out.println("Mes commandes : ");
		System.out.println("");
		for(int i=0; i<u.getListeCommandes().size(); i++ ) {
			System.out.println("Commande "+u.getListeCommandes().get(i).getNumero()+" : ");
			//System.out.println(u.getListeCommandes().get(i).toString());
			u.getListeCommandes().get(i).getPanier().afficherPanier();
			System.out.println("");
			System.out.print("Montant de la commande : "+u.getListeCommandes().get(i).getPanier().getMontant() + "€");
			if(u.getListeCommandes().get(i).getMode_de_livraison()==1) {
				System.out.println("                 Mode de livraison : Livraison standard");
			}
			else {
				System.out.println("                 Mode de livraison : Livraison en point relais");
			}
		}
	}
	
	
	//Charger les users à partir du fichier csv
	private static void chargerUsers(Marketplace m) {
		String filepath="C:\\Users\\CYTech Student\\git\\Marketplace\\Marketplace\\data_files\\user.csv";
		BufferedReader reader = null;
		String line="";
		try {
			reader=new BufferedReader(new FileReader(filepath));
			while((line=reader.readLine()) != null) {
				String[] row = line.split(",");
				m.getIndexLoginPassword().put(row[0], row[1]);    //Vient charger les users du fichier csv
				if(row[2].equals("client")) {
					m.addClient(row[0], row[1], row[3], row[4], row[5], row[6]);
				}
				if(row[2].equals("vendeur")) {
					m.addVendeur(row[0], row[1], row[3], row[4], row[5]);
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	//Charger les produits à partir du fichier csv
		private static void chargerProduits(Marketplace m) {
			String filepath="C:\\Users\\CYTech Student\\git\\Marketplace\\Marketplace\\data_files\\produit.csv";
			BufferedReader reader = null;
			String line="";
			try {
				reader=new BufferedReader(new FileReader(filepath));
				while((line=reader.readLine()) != null) {
					String[] row = line.split(",");
					User u = m.getIndexLoginUser().get(row[0]);
					Produit p = new Produit(row[1], Double.parseDouble(row[2]), Integer.parseInt(row[3]));
					m.getIndexRefProduit().put(row[1], p);    //Vient charger les produits du fichier csv
					u.addProduit(row[1], Double.parseDouble(row[2]), Integer.parseInt(row[3]));
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	
	//AFFICHAGE DES MENUS
	//Gere saisie menu 
	private static int saisieChoix(int borneMin, int borneMax) {
		int choix = -1;
		boolean erreur;
		String lecture; // buffer de lecture clavier

		// lecture du choix jusqu'Ã  ce qu'elle soit correcte
		do {
			try {
				erreur = false;
				lecture = lireInfo("Votre choix");
				choix = Integer.parseInt(lecture);
			} catch (NumberFormatException e) {
				// ce n'est pas un entier qui a Ã©tÃ© lu au clavier
				erreur = true;
			}
		} while (erreur || choix<borneMin || choix>borneMax);
		return choix;
	}

	
	//Affichage du menu d'inscription ou de connexion
	private static void menuConnexionInscription(Marketplace marketplace) {
		int choix=-1;
	    
		try {
		while (choix!=0) {
			afficherMenuAuthentification();
			choix = saisieChoix(0,2);	
			System.out.println("\n--------------------------------------------");
			switch (choix){
				case 1 :   
					choixInscription(marketplace);
					break;
				case 2 :   
					User u=seConnecter(marketplace);
					if(u.getClass().getSimpleName().equals("Client")) {
						System.out.println("");
						System.out.println("Bienvenue dans votre espace client : ");
						System.out.println("");
						menuClient(marketplace,u);
					}
					else {
						System.out.println("");
						System.out.println("Bienvenue dans votre espace vendeur : ");
						System.out.println("");
						menuVendeur(marketplace,u);
					}
					break;
				
				case 0 :   System.out.println("Bye Bye");
					break;
			}
			choix=0;
		}
		} catch (IOError e) {
			System.err.println("Erreur grave d'entrÃ©e/sortie, fin de l'application");
		}

	}
	
	//Affichage menu inscription client ou vendeur
	private static void choixInscription(Marketplace marketplace) {
		int choix2=-1;
		try {
			while (choix2!=0) {
				afficherMenuInscription();
				choix2 = saisieChoix(0,2);	
				System.out.println("\n--------------------------------------------");
				switch (choix2){
					case 1 :   
						inscrireClient(marketplace);
						menuConnexionInscription(marketplace);
						break;
					case 2 :   
						inscrireVendeur(marketplace);
						menuConnexionInscription(marketplace);
						break;
					
					case 0 :   
						System.out.println("Bye Bye");
						break;
				}
				choix2=0;
			}
			} catch (IOError e) {
				System.err.println("Erreur grave d'entrÃ©e/sortie, fin de l'application");
			}
		}
	

	private static void menuClient(Marketplace m, User u) {
		int choix=-1; 
	    
		try {
		while (choix!=0) {
			afficherMenuClient();  
			choix = saisieChoix(0,7);	
			System.out.println("\n--------------------------------------------");
			switch (choix){
				case 1 : 
					afficherProduits(m);
					ajouterPanier(m,u);  
					break;
				case 2 :   
					viderPanier(u);
					System.out.println("");
					System.out.println("Panier vidé avec succès");
					break;
				
				case 3 :   
					acheter(u);
					//viderPanier(u);
					break;
					
				case 4 :
					afficherPanier(u);
					break;
					
				case 5 :
					afficherListeCommandes(u);
					break;
					
				case 6 : 
					crediterCompte(u);
					break;
					
				case 7 : 
					System.out.println("Déconnexion réussie");
					menuConnexionInscription(m);
					break;
					
				case 0 :   System.out.println("Bye Bye");
					break;
			}
		}
		} catch (IOError e) {
			System.err.println("Erreur grave d'entrÃ©e/sortie, fin de l'application");
		}
	}
	
	private static void menuVendeur(Marketplace m, User u) {
		int choix=-1; 
	    
		try {
		while (choix!=0) {
			afficherMenuVendeur();
			choix = saisieChoix(0,4);	
			System.out.println("\n--------------------------------------------");
			switch (choix){
				case 1 : 
					addProduit(u);  
					break;
				
				case 2 :   
					afficherProduits(m,u);
					removeProduit(u);
					break;
				
				case 3 :
					afficherProduits(m,u);
					break;
					
				case 4 : 
					System.out.println("Déconnexion réussie");
					menuConnexionInscription(m);
					break;
				
				case 0 :   System.out.println("Bye Bye");
					break;
			}
		}
		} catch (IOError e) {
			System.err.println("Erreur grave d'entrÃ©e/sortie, fin de l'application");
		}
	}
	
	private static void afficherMenuAuthentification() {
		System.out.println("Veuillez vous connecter ou vous inscrire :");
		System.out.println("");
		System.out.println("(1) Créer un compte");
		System.out.println("(2) Se connecter");
		System.out.println("");
	}
	
	private static void afficherMenuInscription() {
		System.out.println("Inscription en tant que : ");
		System.out.println("");
		System.out.println("(1) Client");
		System.out.println("(2) Vendeur");
		System.out.println("");
	}
	
	private static void afficherMenuClient() {
		System.out.println("");
		System.out.println("Menu :");
		System.out.println("(1) Ajouter au panier");
		System.out.println("(2) Vider le panier");
		System.out.println("(3) Acheter");
		System.out.println("(4) Afficher mon panier");
		System.out.println("(5) Afficher ma liste de commandes");
		System.out.println("(6) Créditer mon compte");
		System.out.println("(7) Se déconnecter");
		System.out.println("");
		
}
	
	private static void afficherMenuVendeur() {
		System.out.println("");
		System.out.println("Menu :");
		System.out.println("(1) Ajouter un produit");
		System.out.println("(2) Retirer un produit");
		System.out.println("(3) Afficher ma liste de produits à la vente");
		System.out.println("(4) Se déconnecter");
		System.out.println("");
		
}

	}
