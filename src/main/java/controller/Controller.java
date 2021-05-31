package controller;

import view.FXMLGameBookController;
import viewModel.ViewModel;

/**
 * 
 * @author tamko
 *
 */
public interface Controller {
	/**
	 * Permet d'initialiser mon FXMLGameBookController
	 * @param view
	 */
	void setView(FXMLGameBookController view);
	/**
	 * Permet de creer mon livre
	 * @param strTitle titre du livre
	 */
	void createBook(String strTitle);
//	/**
//	 * Permet d'aojouter un paragraph dans mon livre
//	 * @param text text du paragraph
//	 * @param pos numero de paragraph
//	 */
//	void addParagraph(String text, String pos);
//	/**
//	 * Permet d'afficher le contenu entier d'un paragraph et ces actions
//	 * @param numPara 
//	 */
//	void displayParagraphAndAction(int numPara);
//	/**
//	 * Permet de modifier le contenu du paragraph et de le save
//	 * @param numPara
//	 * @param str
//	 */
//	void saveParagraph(int numPara, String str);
//	/**
//	 * Permet de supprimer un paragraph avec tous ces actions sur base de son 
//	 * numero 
//	 * @param numPara
//	 */
//	void deleteParagraph(int numPara);
//	/**
//	 * Permet d'afficher une action selectioné et son numero
//	 * @param numPara
//	 * @param numAct
//	 */
//	void displayTextAndNumberAction(int numPara, int numAct);
//	/**
//	 * Permet d'ajouter une action a un paragraph 
//	 * @param numPara numero de paragraph 
//	 * @param textAct text d'action 
//	 * @param numDest numero d'action 
//	 */
//	void addAction(int numPara, String textAct, int numDest);
//	/**
//	 * Supprimer un action dans un paragraph sur base de son numero d'action
//	 * @param numPara numero de paragraph 
//	 * @param numAct numero d'action d'action
//	 */
//	void deleteAction(int numPara, int numAct);
//	/**
//	 * Permet d'ajouter une action a un paragraph 
//	 * @param numPara numero de paragraph 
//	 * @param newPosAct
//	 * @param newTextAction
//	 */
//	void newAction(int numPara, String newPosAct, String newTextAction);
//	/**
//	 * permet de save une action  modifier
//	 * @param numPara
//	 * @param numAct
//	 * @param newPosAct
//	 * @param newTextAction
//	 */
//	void saveAction(int numPara, int numAct, String newPosAct, String newTextAction);
//	/**
//	 * Permert d'afficher les noeud manquant
//	 */
//	void validateNoeud();
//	/**
//	 * Permet d'afficher le graph
//	 */
//	void showGraph();
	/**
	 * Permet de charger un livre jeu 
	 * @param path
	 * @return
	 */
//	boolean loadBook(String path);
//	/**
//	 * Permet de save le book 
//	 * @param path
//	 * @return
//	 */
//	boolean saveBook(String path);
//	ViewModel getViewModel();
//	/**
//	 * Permet de save le book en Json
//	 * @param path
//	 * @return
//	 */
//	boolean saveBookToJson(String path);
}
