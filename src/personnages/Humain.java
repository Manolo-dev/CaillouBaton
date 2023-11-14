package personnages;

public class Humain {
	private String boissonFav;
	protected String nom;
	protected int capital;
	
	public Humain(String nom, String boissonFav, int capital) {
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
		parler("Bonjour, Je m'appelle " + nom + " et j'aime boire du " + boissonFav);
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
			parler("J'ai " + (capital + prix) + " sous en poche. Je vais pouvoir m'orir " + bien + " à " + prix + " sous");
		else
			parler("Je n'ai plus que " + capital + " sous en poche. Je ne peux même pas m'orir " + bien + " à " + prix + " sous");
	}
}
