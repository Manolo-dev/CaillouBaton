package personnages;

public class Ronin extends Humain {
	private int honneur = 1;
	
	public Ronin(String nom, String boissonFav, int capital, int honneur) {
		super(nom, boissonFav, capital);
		this.honneur = honneur;
	}
	
	public void donner(Commercant beneficiaire) {
		parler(beneficiaire.getNom() + " prend ces 6 sous.");
		beneficiaire.recevoir(capital/10);
		perdreArgent(capital/10);
	}
	
	public void provoquer(Yakuza advairsaire) {
		int force = honneur * 2;
		parler("Je t'ai retrouvé vermine, tu vas payer pour ce que tu as fait à ce pauvre marchand!");
		if(force >= advairsaire.getReputation()) {
			parler("Je t'ai eu petit yakusa!");
			int tmp = advairsaire.perdre();
			gagnerArgent(tmp);
		} else {
			int tmp = capital;
			advairsaire.gagner(tmp);
			parler("J'ai perdu contre ce yakuza, mon honneur et ma bourse ont en pris un coup.");
		}
	}
}
