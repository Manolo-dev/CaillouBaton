package personnages;

public class Ronin extends Humain {
	private int honneur = 1;
	
	public Ronin(String nom, String boissonFav, int capital) {
		super(nom, boissonFav, capital);
	}
	
	public void donner(Commercant beneficiaire) {
		parler(beneficiaire.getNom() + " prend ces 6 sous.");
		beneficiaire.recevoir(capital/10);
		perdreArgent(capital/10);
	}
}
