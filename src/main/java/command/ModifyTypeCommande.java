package command;

import bookModelConsol.BookModel;
import viewConsole.IUsersDialog;

public class ModifyTypeCommande extends CommandBookWithUser {

	public ModifyTypeCommande(final BookModel bookModel, final IUsersDialog userDialog) {
		super(3, bookModel, userDialog);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void execute(BookModel bookModel) {
		int numPara = IntegerMatches("Numéro du nouveau paragraphe ? ");
		String[] choix = new String[] { "Libre", "Conditionné" };
		userDialog.displayLine("choisir un élément de comparaison : ");
		int cpt = 1;
		for (String str : choix) {
			userDialog.displayLine(cpt + "." + str);
			cpt++;
		}
		int numType;
		do {
			numType = userDialog.displayInteger("choisir un numero : ");
			if (numType <= 0 || numType > choix.length) {
				userDialog.displayLine("choix incorrect ! ");
			}
		} while (numType <= 0 || numType > choix.length);
		String type = choix[numType-1];
		if (bookModel.getType(numPara).equals("Libre") && bookModel.getNumOfActions(numPara).isEmpty()) {
			bookModel.setType(numPara);
			userDialog.displayLine("Le type du paragraphe " + numPara + " est Modifié");
		} else {
			userDialog.displayLine("Le type du paragraphe " + numPara + " ne peut pas être Modifié");
		}
		afficharge();
	}

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
