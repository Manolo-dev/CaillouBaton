package personnages;

import java.util.Random;

public class GrandMere extends Humain {
	private Random rnd = new Random();
	private static final int maxMemoire = 5;
	
	private enum TypeHumain {
        COMMERCANT("un commerçant"),
        RONIN("un ronin"),
        SAMOURAIL("un samourail"),
        YAKUZA("un yakuza"),
        HABITANT("un habitant"),
        GRANDMERE("une grand-mère");
		
		private final String value;
		private static final Random rng = new Random();
		
		private TypeHumain(String value) {
			this.value = value;
		}
		
		public static TypeHumain randomTypeHumain() {
			TypeHumain[] typeHumain = values();
	        return typeHumain[rng.nextInt(typeHumain.length)];
		}
		
		@Override
		public String toString() {
			return value;
		}
    }
	
	public GrandMere(String nom, int capital) {
		super(nom, "rooibos", capital);
	}
	
	@Override
	protected void memoriser(Humain h) {
		if(nbConnaissance >= maxMemoire) {
			parler("Oh ma tête ! Je ne peux plus retenir le nom d'une personne supplémentaire !");
		} else {
			super.memoriser(h);
		}
	}
    
    public void ragoter() {
		for(int i = nbConnaissance; i < (nbConnaissance + maxMemoire); i++) {
			if(memoire[i % maxMemoire] != null) {
				Humain h = memoire[i % maxMemoire];
				if(h instanceof Traitre) {
					parler("Je sais que " + h.getNom() + " est un traître. Petit chenapan !");
				} else {
					TypeHumain rndType = TypeHumain.randomTypeHumain();
					parler("Je crois que " + h.getNom() + " est " + rndType + ".");
				}
			}
		}
    }
}
