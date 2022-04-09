package marketplace;

public class testMarketplace {

	public static void main(String[] args) {
		
		Marketplace marketplace=new Marketplace();
		Produit p1=new Produit(1,14.5,7);
		Produit p2=new Produit(2, 29.99, 3);
		marketplace.addProduit(p1);
		marketplace.addProduit(p2);
		System.out.println(marketplace.toString());
		
	}

}
