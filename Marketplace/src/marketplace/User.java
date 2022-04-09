package marketplace;

public class User {
	
	
	// Variables de la classe User
	private int id;
	private String login;
	private String password;
	private String tel;
	private String nom;
	private String prenom;
	
	
	// Constructeur de la classe User
	public User(int id, String login, String password, String tel, String nom, String prenom) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.tel = tel;
		this.nom = nom;
		this.prenom = prenom;
	}
	
	
	// Getters et setters
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
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
	
	

}
