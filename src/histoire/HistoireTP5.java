package histoire;

import personnages.*;

public class HistoireTP5 {
	private static void scenar1() {
		Commercant marco = new Commercant("Marco", "thé", 20);
		Commercant chonin = new Commercant("Chonin", "shochu", 40);
		Commercant kumi = new Commercant("Kumi", "thé", 10);
		Yakuza yaku = new Yakuza("Yaku Le Noir", "whisky", 30, "Warsong");
		Ronin roro = new Ronin("Roro", "shochu", 60);
		Samourai akimoto = new Samourai("Miyamoto", "Akimoto", "saké", 80);
		Traitre masako = new Traitre("Miyamoto", "Masako", "whisky", 100);
		
		marco.faireConnaissance(roro);
		marco.faireConnaissance(yaku);
		marco.faireConnaissance(chonin);
		marco.faireConnaissance(kumi);
		marco.listerConnaissance();
		
		roro.listerConnaissance();
		
		yaku.listerConnaissance();
		
		akimoto.faireConnaissance(marco);
		akimoto.listerConnaissance();
		
		masako.faireLeGentil();
		masako.ranconner(kumi);
		masako.ranconner(chonin);
		masako.ranconner(marco);
		
		akimoto.faireConnaissance(masako);
		
		masako.ranconner(kumi);
		masako.faireConnaissance(yaku);
		masako.faireLeGentil();
		masako.faireConnaissance(roro);
	}
	
	public static void main(String[] args) {
		scenar1();
	}
}
