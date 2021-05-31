package model;



/**
 * 
 * @author Tamko
 *
 */
public class Action {
	
	private  String text;

	/**
	 * initialsation des choix
	 * 
	 * @param desText text
	 * @param choice  numero du choix
	 */
	public Action(final String desText) {
		this.text = desText;
//		this.number = choice;
	}
/**
 * 
 * @param action
 */
	public Action(final Action action) {
		text=action.text;
	}

	/**
	 * afficher le texte du libelle
	 * 
	 * @return
	 */
	public String getDesText() {
		return text;
	}

	/**
	 * permet de modifier le texte du paragraph
	 * 
	 * @param desText
	 */
	public void setDesText(final String desText) {
		this.text = desText;
	}

	/**
	 * obtenir le numero du choix
	 * 
	 * @return
	 */
//	public int getChoice() {
//		return number;
//	}
//
//	/**
//	 * Permet de modifier la position du choix de +1
//	 */
//	public void updateChoiceInFront() {
//		number++;
//	}
//
//	/**
//	 * modifier le choix
//	 * 
//	 * @param choice
//	 */
//	public void setChoice(final int choice) {
//		this.number = choice;
//	}
//
//	/**
//	 * Permet de modifier la position du choix de -1
//	 */
//	public void updateChoiceInBack() {
//		number--;
//
//	}
//
////	@Override
////	public int hashCode() {
////		return Objects.hash(choice);
////	}
//
//	@Override
//	public boolean equals(final Object obj) {
//		if (this == obj) {
//			return true;
//		}
//		if (!(obj instanceof Choice)) {
//			return false;
//		}
//		final Choice other = (Choice) obj;
//		return number == other.number;
//	}
}
