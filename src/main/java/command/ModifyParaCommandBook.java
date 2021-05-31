package command;

import bookModelConsol.BookModel;
import model.Book;
import viewConsole.IUsersDialog;

public class ModifyParaCommandBook extends CommandBookWithUser {

	public ModifyParaCommandBook(final BookModel bookModel, final IUsersDialog userDialog) {
		super(4, bookModel, userDialog);

	}

	@Override
	public void execute(final BookModel bookModel) {

		if (bookModel.length() > 0) {
			int numeroPara = validerNumeroOfParagraph("Numéro du paragraphe à modifier? ");
			String textCourant = bookModel.getTextOfParagraphe(numeroPara);
			// bookModel.removeParagraph(numero);
			userDialog.displayLine("Texte actuel du paragraphe %d: %s", numeroPara, textCourant);
			String texte = userDialog.readLine("Encodez le nouveau texte ou Enter pour le conserver: ");
			if (!texte.isBlank())
				bookModel.saveParagraph(numeroPara, texte);

			if (bookModel.getType(numeroPara) == "Libre") {

				char c1 = userDialog.readChar("Souhaitez-vous modifier les actions possibles (o/n)? ");
				updateAction(bookModel, numeroPara, c1);
				char c2 = userDialog.readChar("Souhaitez-vous ajouter une action possible (o/n)? ");
				addNewAction(bookModel, numeroPara, c2);
			} else if (bookModel.getType(numeroPara) == "Conditionné") {
				char c1 = userDialog.readChar("Souhaitez-vous modifier les actions possibles (o/n)? ");
				updateActionCondtionne(bookModel, numeroPara, c1);
				char c2 = userDialog.readChar("Souhaitez-vous ajouter une action possible (o/n)? ");
				addNewActionConditionne(bookModel, numeroPara, c2);
			}
			// bookModel.addParagraph(numeroPara);
			// bookModel.addTodo();
			afficharge();
		} else {
			userDialog.displayLine("Votre livre est vide! Veuillez d'abord ajouter les paragraphs\n");
		}

	}

	private void addNewActionConditionne(BookModel bookModel, int numeroPara, char c2) {
		if (c2 == 'o') {

			String[] choix = new String[] { "inférieur à", "inférieur ou égal à", "égal à", " supérieur à",
					"supérieur ou égal à" };
			int numComparaison = 0, numAct = 0;
			String chaine = "";
			do {
				userDialog.displayLine("choisir un élément de comparaison : ");
				int cpt = 1;
				for (String str : choix) {
					userDialog.displayLine(cpt + "." + str);
					cpt++;
				}

				do {
					numComparaison = IntegerMatches("choisir un numero (Enter si aucun): ");
					if (numComparaison < 0 || numComparaison > choix.length) {
						userDialog.displayLine("choix incorrect ! ");
					}
				} while (numComparaison < 0 || numComparaison > choix.length);
				if (numComparaison != 0) {
					chaine = choix[numComparaison - 1];
					do {
						numAct = userDialog.displayInteger("choisir un numero compris entre 1 et 12 ?(Lancer le dé) ");
						if (numAct <= 0 || numAct > 12) {
							userDialog.displayLine("choix incorrect ! ");
						}
					} while (numAct <= 0 || numAct > 12);
					int numDes = numberPositif(userDialog.displayInteger("Numéro du paragraphe de destination : "),
							"Numéro du paragraphe de destination : ", true);
					String chaineConditionne = "Si votre résultat est "+chaine +" "+numAct;
					bookModel.addChoice(numeroPara, numDes, chaineConditionne);
				}

			} while (numComparaison != 0);
		}
		
	}

	private void updateActionCondtionne(BookModel bookModel, int numeroPara, char c1) {
		if (c1 == 'o') {

			var allChoicce = bookModel.getNumOfActions(numeroPara);
			if (allChoicce.size() == 0) {
				userDialog.displayLine("Aucune action pour ce paragraph! ");
				return;
			}
			for (var integer : allChoicce) {

				String actText = bookModel.getTextOfAction(numeroPara, integer);
				userDialog.displayLine("Action possible : %s  %d", actText, integer);
				char s1 = userDialog.readChar("Supprimer (o/n) ? ");
				if (s1 == 'o') {
					deleteAction(bookModel, numeroPara, integer);
				} else {
					
					modifyActionConditionne(bookModel, numeroPara, integer);
				}

			}
		}
	}

	/**
	 * Modifier les actions lie a un paragraph
	 * 
	 * @param numeroPara paragraph courant a modifier
	 * @param c1         option de modification
	 */
	private void updateAction(final BookModel bookModel, final int numeroPara, final char c1) {
		if (c1 == 'o') {

			var allChoicce = bookModel.getNumOfActions(numeroPara);
			if (allChoicce.size() == 0) {
				userDialog.displayLine("Aucune action pour ce paragraph! ");
				return;
			}
			for (var integer : allChoicce) {

				String actText = bookModel.getTextOfAction(numeroPara, integer);
				userDialog.displayLine("Action possible : %s  %d", actText, integer);
				char s1 = userDialog.readChar("Supprimer (o/n) ? ");
				if (s1 == 'o') {
					deleteAction(bookModel, numeroPara, integer);
				} else {
					modifyAction(bookModel, numeroPara, integer);
					//modifyActionConditionne(bookModel, numeroPara, integer);
				}
			}
		}

	}

	private void modifyActionConditionne(BookModel bookModel, int numeroPara, int numChoice) {
		userDialog.displayLine("choisir un nouveau élément de comparaison : ");
		String[] choix = new String[] { "inférieur à", "inférieur ou égal à", "égal à", " supérieur à",
				"supérieur ou égal à" };
		int numComparaison = 0, numAct = 0;
		String chaine = "";
		int cpt = 1;
		for (String str : choix) {
			userDialog.displayLine(cpt + "." + str);
			cpt++;
		}

		do {
			numComparaison = IntegerMatches("choisir un numero (Enter pour le conserver:): ");
			if (numComparaison < 0 || numComparaison > choix.length) {
				userDialog.displayLine("choix incorrect ! ");
			}
		} while (numComparaison < 0 || numComparaison > choix.length);
		if (numComparaison != 0) {
			chaine = choix[numComparaison - 1];
			do {
				numAct = userDialog.displayInteger("choisir un numero compris entre 1 et 12 ?(Lancer le dé) ");
				if (numAct <= 0 || numAct > 12) {
					userDialog.displayLine("choix incorrect ! ");
				}
			} while (numAct <= 0 || numAct > 12);

			String chaineConditionne = "Si votre résultat est " + chaine + " " + numAct;
			String newPosAct = IntegerMatches();
			bookModel.saveAction(numeroPara, numChoice, newPosAct, chaineConditionne);
		}
	}

	/**
	 * 
	 * @return
	 */
	private int IntegerMatches(String chaine) {
		String str = userDialog.readLine(chaine);
		if (!str.isBlank()) {
			if (!str.matches("^[+-]?\\d+$")) {
				do {
					str = userDialog.readLine("Numero incorrect !  Numéro du nouveau paragraphe ? ");
					// userDialog.displayLine("");
				} while (!str.matches("^[+-]?\\d+$"));
			}
		} else {
			return 0;
		}
		return numberPositif(Integer.parseInt(str), chaine, false);

	}

	/**
	 * @param numeroPara
	 * @return
	 */
	private int numberPositif(final int numeroPara, String chaine, boolean isAction) {
		var num = numeroPara;
		do {
			if (num <= 0) {
				userDialog.displayLine("Le numéro doit être positif ! ");
				if (isAction)
					num = userDialog.displayInteger(chaine);
				else
					num = IntegerMatches(chaine);
			}
		} while (num <= 0);

		return num;
	}

	/**
	 * Permet de supprimer les actions dans un paragraph
	 * 
	 * @param para paragraph courant
	 * @param act  action courante
	 */
	private void deleteAction(final BookModel bookModel, int numeroPara, int numChoice) {
		char s2 = userDialog.readChar("Êtes-vous sûr ?(o/n) ");
		if (s2 == 'o') {
			bookModel.deleteAction(numeroPara, numChoice);
			userDialog.displayLine("Action supprimée ");
		}
	}

	/**
	 * Modifier les actions associer a un paragraph
	 * 
	 * @param act action a modifier
	 */
	private void modifyAction(final BookModel bookModel, int numeroPara, int numChoice) {
		String newTexte = userDialog.readLine("Encodez le nouveau texte ou Enter pour le conserver: ");
		String newPosAct = IntegerMatches();
		bookModel.saveAction(numeroPara, numChoice, newPosAct, newTexte);
	}

	private String IntegerMatches() {
		String str = userDialog.readLine("Encodez le nouveau numéro : ");
		if (!str.isBlank()) {
			if (!str.matches("^[+-]?\\d+$")) {
				do {
					str = userDialog.readLine("Numero incorrect ! Encodez le nouveau numéro :  ");
					// userDialog.displayLine("");
				} while (!str.matches("^[+-]?\\d+$"));
			}
		} else {
			return " ";
		}
		return numberPositif(str);
	}

	private String numberPositif(final String str) {
		var num = Integer.parseInt(str);
		if (num <= 0) {
			do {
				num = userDialog.displayInteger("Encodez le nouveau numéro :  ");
				userDialog.displayLine("Le numéro doit être positif ! ");
			} while (num <= 0);
		}
		return String.valueOf(num);
	}

	/**
	 * ajouté de nouvelle action a un paragraph
	 * 
	 * @param para paragraph qui recois l'action
	 * @param c2   action a ajouté
	 */
	private void addNewAction(final BookModel bookModel, final int numPara, final char c2) {
		if (c2 == 'o') {
			String textAct;
			do {
				textAct = userDialog.readLine("Texte de l’action possible (Enter si aucune): ");
				if (!textAct.isBlank()) {
					int numDes = userDialog.displayInteger("Numéro du paragraphe de destination : ");
					bookModel.addChoice(numPara, numDes, textAct);
				}
			} while (!textAct.isBlank());

		}

	}
}
