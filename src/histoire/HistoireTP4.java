package histoire;

import personnages.*;

public class HistoireTP4 {
	private static void scenar1() {
		Humain prof = new Humain("Prof", "kombucha", 54);
		prof.direBonjour();
		prof.acheter("une boisson", 12);
		prof.boire();
		prof.acheter("un jeu", 2);
		prof.acheter("un kimono", 50);
	}
	
	private static void scenar2() {
		Commercant marco = new Commercant("Marco", "thé", 1002020);
		marco.direBonjour();
		marco.seFaireExtorquer();
		marco.recevoir(15);
		marco.boire();
	}
	
	public static void main(String[] args) {
		scenar2();
	}
}
