package juxo.triephotoV2.methode;

import juxo.apiCalendar.connexionGoogle.ConnexionGoogle;
import juxo.system.Parametrage;
import juxo.triephotoV2.accessFichier.Fichier;

public class SortByPlace extends AbstractSortMethod {

	private static SortByPlace mySort;
	
	public SortByPlace(int p) {
		super(p);
		mySort = this;
	}

	@Override
	public void trie() {
		if(ConnexionGoogle.googleConnexion!=null){
			Fichier.listFic.trieFichiersParLieu(Parametrage.getInstance().getDossierDestination());
		}
	}

	public SortByPlace getInstance(){
		return mySort;
	}
	
}
