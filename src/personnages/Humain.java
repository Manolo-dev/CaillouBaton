package personnages;

public class Humain {
	private String nom;
	private String boissonFav;
	protected int capital;
	protected Humain memoire[];
	protected int nbConnaissance = 0;
	private int memoireDebut = 0;
	private static int maxMemoire = 30;

	public Humain(String nom, String boissonFav, int capital) {
		if (this.memoire == null) {
            this.memoire = new Humain[maxMemoire];
        }
		
		this.nom        = nom;
		this.boissonFav = boissonFav;
		this.capital    = capital;
	}
	
	public String getNom() {
		return nom;
	}
	
	public int getCapital() {
		return capital;
	}
	
	protected void parler(String text) {
		System.out.println("\033[3m(" + nom + ") - " + text + "\033[0m");
	}
	
	public void direBonjour() {
		parler("Bonjour, Je m'appelle " + nom + " et j'aime boire du " + boissonFav + ".");
	}
	
	public void boire() {
		parler("Mmmm, un bon verre de " + boissonFav + " ! GLOUPS !");
	}
	
	protected boolean gagnerArgent(int prix) {
		if(prix >= 0) {
			capital += prix;
			return true;
		}
		return false;
	}
	
	protected boolean perdreArgent(int prix) {
		if(prix >= 0 && prix <= capital) {
			capital -= prix;
			return true;
		}
		return false;
	}
	
	public void acheter(String bien, int prix) {
		if(perdreArgent(prix))
			parler("J'ai " + (capital + prix) + " sous en poche. Je vais pouvoir m'orir " + bien + " à " + prix + " sous.");
		else
			parler("Je n'ai plus que " + capital + " sous en poche. Je ne peux même pas m'orir " + bien + " à " + prix + " sous.");
	}
	
	private void memoriser(Humain h) {
		if(nbConnaissance < maxMemoire) {
			memoire[nbConnaissance] = h;
			nbConnaissance += 1;
		} else {
			memoire[memoireDebut] = h;
			memoireDebut += 1;
			memoireDebut = memoireDebut % maxMemoire;
		}
	}
	
	private void repondre(Humain h1) {
		direBonjour();
		memoriser(h1);
	}
	
	public void faireConnaissance(Humain h2) {
		direBonjour();
		h2.repondre(this);
		memoriser(h2);
	}
	
	public void listerConnaissance() {
		StringBuffer buffer = new StringBuffer("Je connais beaucoup de monde dont : ");
		for (int i = memoireDebut; i < (memoireDebut + nbConnaissance); i++) {
			buffer.append(memoire[i % maxMemoire].getNom());
			if (i < (memoireDebut + nbConnaissance - 1))
				buffer.append(", ");
		}
		buffer.append(".");
		String result = buffer.toString();
		parler(result);
	}
}
