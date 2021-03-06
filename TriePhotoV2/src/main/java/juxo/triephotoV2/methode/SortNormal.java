package juxo.triephotoV2.methode;

import juxo.system.Parametrage;
import juxo.triephotoV2.accessFichier.Fichier;

/**
 * trie par ANNEES/MOIS tous les fichiers restant
 * @author Juxo
 *
 */
public class SortNormal extends AbstractSortMethod {

	private static SortNormal mySort;
	
	public SortNormal(){
		
	}
	
	public SortNormal(int p) {
		super(p);
		mySort = this;
	}

	@Override
	public void trie() {
		Fichier.listFic.trieFichiers(Parametrage.getInstance().getDossierDestination());
	}
	
	public static SortNormal getInstance(){
		return mySort;
	}
	
	public void loadMe() {
		mySort = this;
	}
	
}
