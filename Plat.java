package tp1_part2_QA;

public class Plat {
	
	String nom;
	double prix;
	
	public Plat() {
	}
	
	public Plat(String Nom, double Prix) {
		this.nom = Nom;
		this.prix = Prix;
	}
	
	  public String getName() {
		    return nom;
		  }

	  public void setName(String Nom) {
		    this.nom = Nom;
		  }
	  
	  public double getPrix() {
		    return prix;
		  }

	  public void setPrix(int Prix) {
		    this.prix = Prix;
		  }
}
