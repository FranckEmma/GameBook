package viewModel;

import java.util.List;
import java.util.Set;



public interface ViewModel {
	/**
	 * permet d'obtenir le titre du livre
	 * 
	 * @return
	 */
	String getTitle();

	String displayNoeud();

	String displayGraph();
	/**
	 * Modifie le message d'erreur
	 * 
	 * @param message
	 */
//	void setMessage(String message);

	/**
	 * Permet de creer un livre
	 * 
	 * @param book
	 */
//	void createBook(IBook book);
	/**
	 * Permet d'obtenir la list paragraph sous frome de string
	 * 
	 * @return
	 */
	List<String> paragraphToString();

	/**
	 * Permet d'obtenire la liste de numero des paragraph
	 * 
	 * @return
	 */
	Set<Integer> allNumber();

	/**
	 * Permet d'obtenir une liste d'action sous forme de string
	 * 
	 * @param numPara
	 * @return
	 */
	List<String> actionToString(int numPara);

	/**
	 * Permet d'obtenir le texte d'un paragraph sur base de son numero
	 * 
	 * @param numPara
	 * @return
	 */
	String getTextOfParagraph(int numPara);

	/**
	 * Permet d'obtenir le numero d'un paragraph
	 * 
	 * @param numPara
	 * @return
	 */
	int getNumberOfParagraph(int numPara);

	/**
	 * Permet d'obtenir le text d'une action sur base de son numero de paragraph et
	 * d'action
	 * 
	 * @param numPara
	 * @param numAct
	 * @return
	 */
	String getTextActionByNumber(int numPara, int numAct);

}
