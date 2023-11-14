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
	
	private static void scenar3() {
		Commercant marco = new Commercant("Marco", "thé", 15);
		Yakuza yaku = new Yakuza("Yaku Le Noir", "whisky", 30, "");
		yaku.direBonjour();
		yaku.extorquer(marco);
	}
	
	private static void scenar4() {
		Commercant marco = new Commercant("Marco", "thé", 15);
		Ronin roro = new Ronin("Roro", "shochu", 60);
		roro.direBonjour();
		roro.donner(marco);
	}
	
	public static void main(String[] args) {
		scenar4();
	}
}
