package tp1_part2_QA;

public class Commande {
	
	String nom;
	String plat;
	int quantite;
	

	public Commande() {
	}
	
	public Commande(String Nom, String Plat, int Quantite) {
		this.nom = Nom;
		this.plat = Plat;
		this.quantite = Quantite;
	}
	
	  public String getName() {
		    return nom;
		  }

	  public void setName(String Nom) {
		    this.nom = Nom;
		  }
	  
	  public String getPlat() {
		    return plat;
		  }

	  public void setPlat(String Plat) {
		    this.plat = Plat;
		  }
	  
	  public int getQuantite() {
		    return quantite;
		  }

	  public void setQuantite(int Quantite) {
		    this.quantite = Quantite;
		  }	  
}
