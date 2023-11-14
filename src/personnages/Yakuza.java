package personnages;

public class Yakuza extends Humain {
	private String clan;
	private int reputation = 0;
	
	public Yakuza(String nom, String boissonFav, int capital, String clan) {
		super(nom, boissonFav, capital);
		this.clan = clan;
	}
	
	public void extorquer(Commercant victime) {
		parler("Tiens, tiens, ne serait-ce pas un faible marchand qui passe par là ?");
		parler(victime.getNom() + ", si tu tiens à la vie donne moi ta bourse !");
		int tmp = victime.seFaireExtorquer();
		gagnerArgent(tmp);
		parler("J'ai piqué les " + tmp + " sous de " + victime.getNom() + ", ce qui me fait " + capital + " sous dans ma poche. Hi ! Hi !");
	}
}
