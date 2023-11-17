package personnages;

import java.util.Random;

public class Traitre extends Samourai {
	private int traitrise = 0;
	private Random rnd = new Random();
	
	public Traitre(String seigneur, String nom, String boissonFav, int capital) {
		super(seigneur, nom, boissonFav, capital);
	}
	
	@Override
	public void direBonjour() {
		super.direBonjour();
		parler("Mais je suis un traître et mon niveau de traîtrise est : " + traitrise + ". Chut !");
	}
	
	public void ranconner(Commercant commercant) {
		if(traitrise < 3) {
			int argentRanconne = commercant.getArgent() * 2 / 10;
			commercant.perdreArgent(argentRanconne);
			gagnerArgent(argentRanconne);
			parler("Si tu veux ma protection contre les Yakuzas, il va falloir payer ! Donne-moi " + argentRanconne + " sous ou gare à toi !");
			commercant.parler("Tout de suite grand " + getNom() + ".");
			traitrise += 1;
		} else {
			parler("Mince je ne peux plus rançonner personne sinon un samouraï risque de me démasquer !");
		}
	}
	
	public void faireLeGentil() {
		if(nbConnaissance == 0) {
			parler("Je ne peux faire ami ami avec personne car je ne connais personne ! Snif.");
		} else {
			Humain h1 = memoire[rnd.nextInt(nbConnaissance)];
			int don = capital / 20;
			parler("Il faut absolument remonter ma cote de confiance. Je vais faire ami ami avec " + h1.getNom() + ".");
			parler("Bonjour l'ami ! Je voudrais vous aider en vous donnant 5 sous.");
			h1.gagnerArgent(don);
			perdreArgent(don);
			String nom = getNom();
			h1.parler("Merci " + nom + ". Vous êtes quelqu'un de bien.");
			if(traitrise != 0)
				traitrise -= 1;
		}
	}
}
 