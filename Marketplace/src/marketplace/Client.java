package marketplace;

public class Client extends User {
	
	// Variables de la classe Client
	private int numClient;
	private String adresse;
	
	//Constructeur de la classe Client
	public Client(String login, String password, String tel, String nom, String prenom, int numClient, String adresse){
		super(login, password, tel, nom, prenom);
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
	@Override
	public String toString() {
		return "[Login :" + this.getLogin() + ", Password : " + this.getPassword() +", Tel : " + this.getTel() + ", Nom : " + this.getNom() + ", Prenom : " + this.getPrenom() + ", numéro client : " + numClient + ", adresse : " + adresse +"]";
	}
	
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
