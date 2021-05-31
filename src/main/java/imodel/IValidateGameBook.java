package imodel;


public interface IValidateGameBook {
	/**
	 * Permet d'initialiser le validateur avec un book
	 * @param book
	 */
	//void initValidate(IBook book);
	/**
	 * aficher les neouds
	 * @return
	 */
	String displayNoeud(final IBook book);
	/**
	 * Permet d'obtenir la liste des noeud terminaux inaccessible
	 * @return
	 */
	// List<Integer> terminalNodeUnreachable();
	 /**
	  * Permet d'obtenir la lisrte des noeuds non refferencé
	  * @return
	  */
	// List<Integer> noeudAbsent() ;
}
