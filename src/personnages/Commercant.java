package personnages;

public class Commercant extends Humain {
	public Commercant(String nom, String boissonFav, int capital) {
		super(nom, boissonFav, capital);
	}
	
	public int seFaireExtorquer() {
		parler("J'ai tout perdu! Le monde est trop injuste... ");
		int tmp = capital;
		perdreArgent(tmp);
		return tmp;
	}
	
	public void recevoir(int argent) {
		parler(argent + " sous ! Je te remercie généreux donateur !");
		gagnerArgent(argent);
	}
}
