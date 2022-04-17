package marketplace;

public class Client extends User {
	
	// Variables de la classe Client
	private int numClient;
	private String adresse;
	
	//Constructeur de la classe Client
	public Client(int id, String login, String password, String tel, String nom, String prenom, int numClient, String adresse){
		super(id, login, password, tel, nom, prenom);
		this.numClient=numClient;
		this.adresse=adresse;
	}

	//Getter et setter de la Classe Client
	public int getNumClient() {
		return numClient;
	}

	public void setNumClient(int numClient) {
		this.numClient = numClient;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	
	//Méthodes de la classe Client
	void Acheter() {
		//TODO
	}
	
	
	void choixLivraison() {	
		//TODO
	}
	
	
	void suivreCommande(Commande C) {
		//TODO
	}
	

}
