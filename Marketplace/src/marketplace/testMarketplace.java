package marketplace;

public class testMarketplace {

	public static void main(String[] args) {
		
		Marketplace marketplace=new Marketplace();
		Produit p1=new Produit(1,14.5,7);
		Produit p2=new Produit(1, 29.99, 3);
		Client c1=new Client(1, "azerty", "1234", "0783453104", "Mathias", "NDIAYE", 1, "3 avenue de Pompadour 19350 Juillac");
		Client c2=new Client(2, "qwerty", "5678", "0782484331", "Yoan", "NDIAYE", 2, "13 Rue du lavoir 243567 Lolo");
		marketplace.addProduit(p1);
		marketplace.addProduit(p2);
		marketplace.addUser(c1);
		marketplace.addUser(c2);
		marketplace.addClient(3, "qwerty", "9101", "0662154960", "Cheikh", "NDIAYE", 3, "4 Rue BooskaP 15620 Lerap");
		//marketplace.removeUser(c1);
		System.out.println(marketplace.toString());
	}

}
