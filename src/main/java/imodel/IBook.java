package imodel;

import java.util.List;
import java.util.Map;
import java.util.Set;

import model.Paragraphe;
/**
 * 
 * @author tamko
 *
 */
public interface IBook {

	/**
	 * Permet d'obtenir le nombre de paragraphe dans la Map
	 * 
	 * @return
	 */
	int length();

	/**
	 * permet d'ajouter un paragraph au livre
	 * 
	 * @param numParagraph numero du paragraph
	 * @param text         text du paragraph
	 */
	int addParagraph(final int numParagraph, final String text,final String type);

	/**
	 * permet d'obtenir tous les numero de choice
	 * 
	 * @return
	 */
	List<Integer> allNumberOfAction();

	/**
	 * permet d'obtenir le titre du livre
	 * 
	 * @return
	 */
	String getTitle();

	/**
	 * permet de modifier le titre du livre
	 * 
	 * @param title
	 */
	void setTitle(final String title);

	/**
	 * Perme d'ajouter une choice a un paragraph
	 * 
	 * @param numParagraph numero du paragraph
	 * @param numChoice    numero du choice
	 * @param textChoice   description du choix
	 */
	void addChoice(final int numParagraph, final int numChoice, final String textChoice);

	/**
	 * Permet obtenir le text d'un paragraph pour un numero de paragraph donée
	 * 
	 * @param num
	 * @return
	 */
	String getTextOfParagraphe(final int num);

	/**
	 * Permet obtenir tous les numeros des paragraphes
	 * 
	 * @return
	 */
	Set<Integer> getAllNumberOfPara();

	/**
	 * Permet obtenitr tous les textes des paragraphes
	 * 
	 * @return
	 */
	List<String> getAllTextOfPara();

	/**
	 * Permet d'obtenir tous les textes d'action pour un numero de paragraph donnée
	 * 
	 * @param numPara
	 * @return
	 */
	List<String> getAllTextOfAction(final int numPara);

	/**
	 * Permet d'obbtenir le texte d'une action sur base du numero d'un paragraphe et
	 * le numero d'action
	 * 
	 * @param numPara
	 * @param numAction
	 * @return
	 */
	String getTextOfAction(final int numPara, final int numAction);

	/**
	 * Permet d'obtenir tous les numeros d'action pour un numero paragraph donnée
	 * 
	 * @param numPara
	 * @return
	 */
	List<Integer> getNumOfActions(final int numPara);

	/**
	 * Permet de setter le texte du nouveau paragraphe
	 * 
	 * @param numeroPara
	 * @param texte
	 */
	void saveParagraph(final int numeroPara, final String texte);

	/**
	 * Permet de supprimer le texte d'une action sur base du numero d'un paragraphe
	 * et le numero d'action
	 * 
	 * @param numeroPara
	 * @param numChoice
	 */
	void deleteAction(final int numeroPara, final int numChoice);

	/**
	 * Permet de setter l'action d'un paragraphe sur base du numero d'un paragraphe
	 * et le numero d'action
	 * 
	 * @param numeroPara numero de paragraphe
	 * @param numChoice  numero de l'action
	 * @param newPosAct  numero de la nouvelle position de l'action
	 * @param newTexte   texte de la nouvelle action
	 */
	boolean saveAction(final int numeroPara, final int numChoice, final String newPosAct, final String newTextAction);

	/**
	 * Permet de supprimer un paragraphe
	 * 
	 * @param numero
	 */
	void deleteParagraph(final int numero);

	/**
	 * Permet de determiner les paragraphes terminaux
	 * 
	 * @return
	 */
	List<Integer> allTerminalNodeOfBook();

	/**
	 * retourne vrai si la liste contient les actions pour un numero de paragraph
	 * donnée
	 * 
	 * @param choice
	 * @return
	 */
	boolean isHasAction(final int choice);

	/**
	 * Je choici une Map parce que je besion d'avoir une les numero de paragraph qui
	 * refference leur liste d'action D'ou une key pour les numero de paragraph et
	 * la value pour la liste d'action Et je choici une TreeMap pour garder ma
	 * collection trier
	 * 
	 * @return
	 */
	Map<Integer, List<Integer>> getNumParaAndListAction();
	/**
	 * Permet d'obtenir le type de paragraphe sur base du numero de paragraphe
	 * @param num
	 * @return
	 */
	String getType(final int num);

	void setType(int numPara);

}
