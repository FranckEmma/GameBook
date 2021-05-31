package model;

import java.util.*;

/**
 * 
 * @author tamko
 *
 */
public class Paragraphe {

	private String text;
	private String type;
	private final Map<Integer, Action> choices;

	/**
	 * Permet de creer un paragraph
	 * 
	 * @param text
	 */
	public Paragraphe(final String text ,final String type) {
		this.text = text;
		this.type=type;
		choices = new HashMap<>();

	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

/**
 * Contructeur par copie
 * @param paragraphe
 */
	public Paragraphe(final Paragraphe paragraphe) {
		choices = paragraphe.choices;
		text= paragraphe.text;
		type= paragraphe.type;
	}

	/**
	 * Permet d'ajouter une action a un paragraph
	 * 
	 * @param numChoice
	 * @param text
	 */
	public void addChoice(final int numChoice, final String text) {
		choices.put(numChoice, new Action(text));
	}

	/**
	 * retourne le text un paragraph
	 * 
	 * @return
	 */
	public String getText() {
		return text;
	}

	/**
	 * Permet de modifier le text d'un paragraph
	 * 
	 * @param text
	 */
	public void setText(final String text) {
		this.text = text;
	}

	/**
	 * Permet d'obtenir tous les textes d'action d'un paragraphe
	 * 
	 * @return
	 */
	public List<String> getAllTextOfActions() {
		final List<String> allText = new ArrayList<>();
		for (final var item : choices.values()) {
			allText.add(item.getDesText());
		}

		return allText;
	}

	/**
	 * Permet d'obtenir tous les numeros d'action d'un paragraph
	 * 
	 * @return
	 */
	public List<Integer> getNumOfActions() {
		final List<Integer> allNumber = new ArrayList<>();
		for (final Integer num : choices.keySet()) {
			allNumber.add(num);
		}
		return allNumber;
	}

	/**
	 * Permet d'obtenir le text d'une action pour un numero d'action donnée
	 * 
	 * @param numAction
	 * @return
	 */
	public String getTextOfAction(final int numAction) {
		final var act = new Action (getAction(numAction));
		return act.getDesText();
	}

	/**
	 * Permet d'obtenir une action d'un paragraphe
	 * 
	 * @param numAction
	 * @return
	 */
	private Action getAction(final int numAction) {
		return choices.get(numAction);
	}

	/**
	 * Permet de deplacer les numeros des actions de +1
	 * 
	 * @param num
	 */
	public void moveActionToUp(final int num) {
		final Map<Integer, Action> choiceTemp = new HashMap<>();
		for (final Integer key : choices.keySet()) {
			if (key >= num) {
				choiceTemp.put(key + 1, choices.get(key));
			}

		}
		choices.clear();
		choices.putAll(choiceTemp);
	}

	/**
	 * Permet de supprimer une action sur base du numero de l'action
	 * 
	 * @param numChoice
	 */
	public void deleteAction(final int numChoice) {
		choices.remove(numChoice);

	}

	/**
	 * Permet de setter le texte d'une action
	 * 
	 * @param temp
	 * @param newTextAction
	 */
	public void setTextAction(final int numAct, final String newTextAction) {
		final var act = new Action (getAction(numAct));
		act.setDesText(newTextAction);
		choices.remove(numAct);
		choices.put(numAct, act);

	}

	/**
	 * Permet de setter le numero d'une action
	 * 
	 * @param numChoice
	 * @param newNumAct
	 */
	public void setNumAction(final int numChoice, final int newNumAct) {
		final var act = new Action (getAction(numChoice));
		deleteAction(numChoice);
		addChoice(newNumAct, act.getDesText());

	}

	/**
	 * Permet de deplacer les numeros des actions de -1
	 * 
	 * @param num
	 */
	public void moveActionToBack(final int num) {
		final Map<Integer, Action> choiceTemp = new HashMap<>();
		for (final Integer key : choices.keySet()) {
			if (key >= num) {
				choiceTemp.put(key - 1, choices.get(key));
			}
		}

		choices.clear();
		choices.putAll(choiceTemp);

	}

	/**
	 * 
	 * @return retourne vrai si la liste contient les actions
	 */
	public boolean isHasAction() {
		return !choices.isEmpty();
	}

}
