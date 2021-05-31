package command;

import bookModelConsol.BookModel;
import model.Book;
import viewConsole.IUsersDialog;

public class AddParaCommandBook extends CommandBookWithUser {

	public AddParaCommandBook(final BookModel bookModel, final IUsersDialog userDialog) {
		super(2, bookModel, userDialog);
	}

	@Override
	protected void execute(final BookModel bookModel) {
		char choixType = userDialog.readChar("Type paragraphe (C)onditionnel ou (L)ibre? ");
		int numPara = IntegerMatches("Numéro du nouveau paragraphe ? ");
		String type="";
		String text = userDialog.readLine("Texte du nouveau paragraphe ? ");
		
		if (Character.toLowerCase(choixType) == 'c') {
			type= "Conditionné";

		} else if (Character.toLowerCase(choixType) == 'l') {
			type= "Libre";
			// bookModel.addParagraph(numPara, text);
			
		}
		addAction(bookModel, bookModel.addParagraph(numPara, text,type));
		afficharge();
	}

	private void addAction(final BookModel bookModel, final int numeroPara) {
		String texAction;
		int numDes = 0;
		var type = bookModel.getType(numeroPara);
		switch (type) {
		case "Libre":
			do {
			texAction = userDialog.readLine("Texte de l’action possible (Enter si aucune): ");
			if (!texAction.isBlank()) {
				numDes = numberPositif(userDialog.displayInteger("Numéro du paragraphe de destination : "),
						"Numéro du paragraphe de destination : ", true);
				bookModel.addChoice(numeroPara, numDes, texAction);
			}
		} while (!texAction.isBlank());
			break;
		case "Conditionné":
			
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
					numDes = numberPositif(userDialog.displayInteger("Numéro du paragraphe de destination : "),
							"Numéro du paragraphe de destination : ", true);
					String chaineConditionne = "Si votre résultat est "+chaine +" "+numAct;
					bookModel.addChoice(numeroPara, numDes, chaineConditionne);
				}

			} while (numComparaison != 0);
			
			
			break;
		default:
			break;
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
}
