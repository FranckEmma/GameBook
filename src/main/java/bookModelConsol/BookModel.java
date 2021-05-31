package bookModelConsol;

import java.util.List;
import java.util.Set;

import imodel.*;

/**
 * Contient la logique du livre jeu et permet de l'interaction avec la console
 * @author tamko
 *
 */
public class BookModel {

	private IBook book;
	private IValidateGameBook validate;
	private String message;
	private IDisplayGraph dg;

	public BookModel(IBook book, IValidateGameBook validate,IDisplayGraph dg) {
		this.book=book;
		this.validate= validate;
		this.dg= dg;
	}

	public IBook create(final String title) {
		
		return book;
	}
	
	public String getMessage() {
		return message;
	}

	/**
	 * Permet d'initialiser le validateur avec un book
	 * 
	 * @param book
	 */
	
	
	public String displayNoeud( ) {
		return validate.displayNoeud(book);
	}

	
	public String displayGraph() {
		return dg.displayGraph(book);
	}

//	public Iterator<Paragraph> getIteratorParagraph() {
//		return book.iterator();
//	}

	public void setTitle(String title) {
		book.setTitle(title);
	}

	public IBook getBook() {
		return book;
	}

	public String getTitle() {
		return book.getTitle();
	}

//	public int getNumberOfLastPara() {
//		return book.getNumberOfLastPara();
//	}

	/**
	 * Permet de verifier si un numero de paragraph existe
	 * 
	 * @param numeroPara
	 * @return retourne vrai ce numero de paragra existe
	 */
//	public boolean isNumberExist(int numeroPara) {
//		return book.isNumberExist(numeroPara);
//	}

	/**
	 * Obtenir un paragraph su pase de son numero
	 * 
	 * @param numero
	 * @return
	 */
	public String getTextOfParagraphe(int numeroPara) {
		return book.getTextOfParagraphe(numeroPara);
	}

	public List<Integer> getNumOfActions(int numPara) {
		return book.getNumOfActions(numPara);
	}


	/**
	 * permet d'obtenir le texte de l'action sur base de son numero de paragraph
	 * @param numPara
	 * @param numAct
	 * @return
	 */
	public String getTextOfAction(int numPara, int numAct) {
		return book.getTextOfAction(numPara, numAct);
	}
	/**
	 * Obtenire le nombre de paragraph dans le book
	 * 
	 * @return
	 */
	public int length() {
		return book.length();
	}

	/**
	 * Permet de supprimer un paragraph avec tous ces actions sur base de son 
	 * numero 
	 * @param numPara
	 */
	public void deleteParagraph(final int numero) {
		book.deleteParagraph(numero);
	
	}
	/**
	 * Permet d'aojouter un paragraph dans mon livre
	 * @param text
	 * @param numeroPara
	 */
	public int addParagraph( final int numeroPara,final String text,final String type) {
		return book.addParagraph(numeroPara, text, type);

	}

	/**
	 * Permet d'ajouter une action a un paragraph 
	 * @param numPara numero de paragraph 
	 * @param textAct text d'action 
	 * @param numDest numero d'action 
	 */
	public void addChoice(final int numParagraph, final int numChoice, final String textChoice) {
		book.addChoice(numParagraph, numChoice , textChoice);

	}
	

	/**
	 * permet de save une action  modifier
	 * @param numPara
	 * @param numAct
	 * @param newPosAct
	 * @param newTextAction
	 */
	public void saveAction(final int numPara2, final int numAct, final String newPosAct, final String newTextAction) {
		book.saveAction(numPara2, numAct, newPosAct, newTextAction);

	}
	/**
	 * Supprimer un action dans un paragraph sur base de son numero d'action
	 * @param numPara numero de paragraph 
	 * @param numAct numero d'action d'action
	 */
	public void deleteAction(int numPara, int numAct) {
		 book.deleteAction(numPara, numAct);
	}
	/**
	 * Permet de modifier le contenu du paragraph et de le save
	 * @param numPara
	 * @param str
	 */
	public void saveParagraph(int numPara, String str) {
		 book.saveParagraph(numPara, str);

	}

	public Set<Integer> getAllNumberOfPara() {
		return book.getAllNumberOfPara();
	}
	
	public String getType(final int num) {
		
		return book.getType(num);
	}

	public void setType(int numPara) {
		book.setType(numPara);
		
	}

}
