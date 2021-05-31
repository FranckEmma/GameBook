package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import imodel.IBook;

/**
 * 
 * @author tamko
 *
 */
public class Book implements IBook{

	private String title;
	final private Map<Integer, Paragraphe> paragraphs;

	/**
	 * Permet de cree un livre
	 * 
	 * @param title
	 */
	public Book(final String title) {
		this.title = title;
		paragraphs = new HashMap<>();
	}

	/**
	 * Permet d'obtenir le nombre de paragraphe dans la Map
	 * 
	 * @return
	 */
	public int length() {
		return paragraphs.size();
	}

	/**
	 * permet d'ajouter un paragraph au livre
	 * 
	 * @param numParagraph numero du paragraph
	 * @param text         text du paragraph
	 */
	public int addParagraph(final int numParagraph, final String text, String type) {
		int num = numParagraph;
		if (num == 0 || num > paragraphs.size()) {
			num = paragraphs.size() + 1;
		}
		final var pa = new Paragraphe(text.isBlank() ? "TODO" : text, type);
		insertParagraph(num, pa);

		return num;

	}

	/**
	 * permet d'obtenir tous les numero de choice
	 * 
	 * @return
	 */
	public List<Integer> allNumberOfAction() {
		final List<Integer> pListSorti = new ArrayList<>();
		for (final Integer key : paragraphs.keySet()) {
			final var copiePara = new Paragraphe(getParagraph(key));
			pListSorti.addAll(copiePara.getNumOfActions());
		}
		return pListSorti;
	}

	/**
	 * Permet d'ajouter les textes todo
	 */
	private void addTodo() {
		final List<Integer> allNumAction = allNumberOfAction();
		for (final Integer integer : allNumAction) {
			if (integer > length()) {
				paragraphs.put(integer, new Paragraphe("TODO","Libre"));
			}
		}

	}

	/**
	 * Permet d'insere un paragraph en decalant les paragrap existant et les actions
	 * 
	 * @param pa
	 */
	private void insertParagraph(final int num, final Paragraphe pa) {
		// var num = pa.getNumberOfParagrph();
		if (paragraphs.containsKey(num)) {
			// final var oldPar = paragraphs.get(num);
			final var oldPara = new Paragraphe(getParagraph(num)).getText();
			if ("TODO".equals(oldPara)) {
				paragraphs.remove(num);
				paragraphs.put(num, pa);
			} else {
				decalerParagraphToUp(num, pa);
				updateActionInFront(num);
			}
		} else {
			paragraphs.put(num, pa);
		}
	}

	/**
	 * Permet de la mise a jour des numeros d'action de +1
	 * 
	 * @param num
	 */
	private void updateActionInFront(final int num) {
		for (final Integer key : paragraphs.keySet()) {
			final var copiePara = new Paragraphe(getParagraph(key));
			copiePara.moveActionToUp(num);
		}
	}

	/**
	 * Permet de la mise a jour des numeros d'action de -1
	 * 
	 * @param num
	 */
	private void updateActionInBack(final int num) {
		for (final Integer key : paragraphs.keySet()) {
			final var copiePara = new Paragraphe(getParagraph(key));
			copiePara.moveActionToBack(num);
		}
	}

	/**
	 * permet d'obtenir le titre du livre
	 * 
	 * @return
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * permet de modifier le titre du livre
	 * 
	 * @param title
	 */
	public void setTitle(final String title) {
		this.title = title;
	}

	/**
	 * Perme d'ajouter une choice a un paragraph
	 * 
	 * @param numParagraph numero du paragraph
	 * @param numChoice    numero du choice
	 * @param textChoice   description du choix
	 */
	public void addChoice(final int numParagraph, final int numChoice, final String textChoice) {
		final var copiePara = new Paragraphe(getParagraph(numParagraph));
		copiePara.addChoice(numChoice, textChoice);
		addTodo();
	}

	/**
	 * Permet d'obtenir un paragraph sur base de sa key
	 * 
	 * @param key
	 * @return
	 */
	private Paragraphe getParagraph(final int key) {
		return paragraphs.get(key);
	}

	/**
	 * Permet obtenir le text d'un paragraph pour un numero de paragraph donée
	 * 
	 * @param num
	 * @return
	 */
	public String getTextOfParagraphe(final int num) {
		final var copiePara = new Paragraphe(getParagraph(num));
		return copiePara.getText();
	}

	/**
	 * Permet obtenir tous les numeros des paragraphes
	 * 
	 * @return
	 */
//	public List<Integer> getAllNumberOfPara() {
//		final List<Integer> allNumber = new ArrayList<>();
//		for (final Integer num : paragraphs.keySet()) {
//			allNumber.add(num);
//		}
//		return allNumber;
//	}

	/**
	 * Permet obtenitr tous les textes des paragraphes
	 * 
	 * @return
	 */
	public List<String> getAllTextOfPara() {
		final List<String> allNumber = new ArrayList<>();
		for (final var item : paragraphs.values()) {
			allNumber.add(item.getText());

		}

		return allNumber;
	}

	/**
	 * Permet d'obtenir tous les textes d'action pour un numero de paragraph donnée
	 * 
	 * @param numPara
	 * @return
	 */
	public List<String> getAllTextOfAction(final int numPara) {
		final var copiePara = new Paragraphe(getParagraph(numPara));
		return copiePara.getAllTextOfActions();
	}

	/**
	 * Permet d'obbtenir le texte d'une action sur base du numero d'un paragraphe et
	 * le numero d'action
	 * 
	 * @param numPara
	 * @param numAction
	 * @return
	 */
	public String getTextOfAction(final int numPara, final int numAction) {
		final var copiePara = new Paragraphe(getParagraph(numPara));
		return copiePara.getTextOfAction(numAction);
	}

	/**
	 * Permet d'obtenir tous les numeros d'action pour un numero paragraph donnée
	 * 
	 * @param numPara
	 * @return
	 */
	public List<Integer> getNumOfActions(final int numPara) {
		final var copiePara = new Paragraphe(getParagraph(numPara));
		return copiePara.getNumOfActions();
	}

	/**
	 * Permet de setter le texte du nouveau paragraphe
	 * 
	 * @param numeroPara
	 * @param texte
	 */
	public void saveParagraph(final int numeroPara, final String texte) {
		final var copiePara = new Paragraphe(getParagraph(numeroPara));
		copiePara.setText(texte);
		paragraphs.remove(numeroPara);
		paragraphs.put(numeroPara, copiePara);
	}

	/**
	 * Permet de supprimer le texte d'une action sur base du numero d'un paragraphe
	 * et le numero d'action
	 * 
	 * @param numeroPara
	 * @param numChoice
	 */
	public void deleteAction(final int numeroPara, final int numChoice) {
		final var copiePara = new Paragraphe(getParagraph(numeroPara));
		copiePara.deleteAction(numChoice);

	}

	/**
	 * Permet de setter l'action d'un paragraphe sur base du numero d'un paragraphe
	 * et le numero d'action
	 * 
	 * @param numeroPara numero de paragraphe
	 * @param numChoice  numero de l'action
	 * @param newPosAct  numero de la nouvelle position de l'action
	 * @param newTexte   texte de la nouvelle action
	 */
	public boolean saveAction(final int numeroPara, final int numChoice, final String newPosAct,
			final String newTextAction) {
		final var pa = getParagraph(numeroPara);
		var temp = numChoice;
		if (!newPosAct.isBlank()) {
			if (Integer.parseInt(newPosAct) <= 0 || pa == null) {
				return false;
			}
			final var newNumAct = Integer.parseInt(newPosAct);
			setNumActionOfParagraph(pa, numChoice, newNumAct);
			temp = newNumAct;
		}
		if (!newTextAction.isBlank()) {
			setTextActionOfParagraph(pa, temp, newTextAction);
		}
		addTodo();
		return true;
	}

	/**
	 * Permet de setter le texte d'une action
	 * 
	 * @param pa
	 * @param temp
	 * @param newTextAction
	 */
	private void setTextActionOfParagraph(final Paragraphe pa, final int numAct, final String newTextAction) {
		pa.setTextAction(numAct, newTextAction);
	}

	/**
	 * Permet de modifier le numero d'une action
	 * 
	 * @param pa
	 * @param numChoice
	 * @param newNumAct
	 */
	private void setNumActionOfParagraph(final Paragraphe pa, final int numChoice, final int newNumAct) {
		pa.setNumAction(numChoice, newNumAct);

	}

	/**
	 * Permet de supprimer un paragraphe
	 * 
	 * @param numero
	 */
	public void deleteParagraph(final int numero) {
		removeBranchToParagraph(numero);
		decalerParagraphToBack(numero);
		updateActionInBack(numero);
	}

	/**
	 * Permet de decaler un paragraphe dans le Map de +1
	 * 
	 * @param num
	 * @param pa
	 */
	private void decalerParagraphToUp(final int num, final Paragraphe pa) {
		final Map<Integer, Paragraphe> paragraphTemp = new HashMap<>();
		for (final Integer integer : paragraphs.keySet()) {
			if (integer > num) {
				paragraphTemp.put(integer + 1, paragraphs.get(integer));
			} else if (integer == num) {
				paragraphTemp.put(num, pa);
				paragraphTemp.put(integer + 1, paragraphs.get(integer));
			} else {
				paragraphTemp.put(integer, paragraphs.get(integer));

			}
		}
		paragraphs.clear();
		paragraphs.putAll(paragraphTemp);
	}

	/**
	 * Permet de decaler un paragraphe dans le Map de -1
	 * 
	 * @param num
	 * @param pa
	 */
	private void decalerParagraphToBack(final int numPara) {
		final Map<Integer, Paragraphe> paragraphTemp = new HashMap<>();
		for (final Integer integer : paragraphs.keySet()) {
			if (integer > numPara) {
				paragraphTemp.put(integer - 1, paragraphs.get(integer));
			} else if (integer < numPara) {
				paragraphTemp.put(integer, paragraphs.get(integer));
			}
		}
		paragraphs.clear();
		paragraphs.putAll(paragraphTemp);
	}

	/**
	 * Permet de supprimer tous les actions menant a un paragraphe
	 * 
	 * @param numero
	 */
	private void removeBranchToParagraph(final int numero) {
		for (final Paragraphe itPara : paragraphs.values()) {
			itPara.deleteAction(numero);
		}
	}

	/**
	 * Permet de retourner la liste des numeros de paragraph
	 * 
	 * @return
	 */
	public Set<Integer> getAllNumberOfPara() {
		return paragraphs.keySet();
	}

	/**
	 * Permet de determiner les paragraphes terminaux
	 * 
	 * @return
	 */
	public List<Integer> allTerminalNodeOfBook() {
		final List<Integer> nodeTerminal = new ArrayList<>();
		for (final Integer key : paragraphs.keySet()) {
			final var copiePara = new Paragraphe(getParagraph(key));
			if (!copiePara.isHasAction()) {
				nodeTerminal.add(key);
			}

		}
		return nodeTerminal;
	}

	/**
	 * retourne vrai si la liste contient les actions pour un numero de paragraph
	 * donnée
	 * 
	 * @param choice
	 * @return
	 */
	public boolean isHasAction(final int choice) {
		final var copiePara = new Paragraphe(getParagraph(choice));
		return copiePara.isHasAction();
	}

	/**
	 * Je choici une Map parce que je besion d'avoir une les numero de paragraph qui
	 * refference leur liste d'action D'ou une key pour les numero de paragraph et
	 * la value pour la liste d'action Et je choici une TreeMap pour garder ma
	 * collection trier
	 * 
	 * @return
	 */
	public Map<Integer, List<Integer>> getNumParaAndListAction() {
		final Map<Integer, List<Integer>> keyset = new TreeMap<Integer, List<Integer>>();
		for (final Integer item : paragraphs.keySet()) {
			final var copiePara = new Paragraphe(getParagraph(item));
			keyset.put(item, copiePara.getNumOfActions());
		}

		return keyset;
	}

	@Override
	public String getType(int num) {
		final var copiePara = new Paragraphe(getParagraph(num));
		return copiePara.getType();
	}

	@Override
	public void setType(int numPara) {
		final var copiePara = new Paragraphe(getParagraph(numPara));
		copiePara.setType("Conditionné");
		paragraphs.remove(numPara);
		paragraphs.put(numPara, copiePara);
	}

}
