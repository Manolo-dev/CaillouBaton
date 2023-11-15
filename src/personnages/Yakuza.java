package personnages;

public class Yakuza extends Humain {
	private String clan;
	private int reputation = 0;
	
	public Yakuza(String nom, String boissonFav, int capital, String clan) {
		super(nom, boissonFav, capital);
		this.clan = clan;
	}

	public Yakuza(String nom, String boissonFav, int capital, String clan, int reputation) {
		super(nom, boissonFav, capital);
		this.clan = clan;
		this.reputation = reputation;
	}
	
	public int getReputation() {
		return reputation;
	}
	
	@Override
	public void direBonjour() {
		super.direBonjour();
		parler("Mon clan est celui de " + clan + ".");
	}
	
	public void extorquer(Commercant victime) {
		parler("Tiens, tiens, ne serait-ce pas un faible marchand qui passe par là ?");
		parler(victime.getNom() + ", si tu tiens à la vie donne moi ta bourse !");
		int tmp = victime.seFaireExtorquer();
		gagnerArgent(tmp);
		parler("J'ai piqué les " + tmp + " sous de " + victime.getNom() + ", ce qui me fait " + capital + " sous dans ma poche. Hi ! Hi !");
	}
	
	protected int perdre() {
		int tmp = capital;
		perdreArgent(tmp);
		reputation -= 1;
		parler("J'ai perdu mon duel et mes " + tmp + " sous, snif... J'ai déshonoré le clan de " + clan + ".");
		return tmp;
	}
	
	protected void gagner(int gain) {
		gagnerArgent(gain);
		parler("Ce ronin pensait vraiment battre " + getNom() + " du clan de " + clan + " ? Je l'ai dépouillé de ses " + gain + " sous.");
	}
}
