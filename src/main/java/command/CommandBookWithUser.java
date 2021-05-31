package command;

import bookModelConsol.BookModel;
import model.Book;
import viewConsole.IUsersDialog;

public abstract class CommandBookWithUser extends CommandBook {
	
	private final BookModel bookModel;

	/**
	 * 
	 * @param numberOfCommande
	 * @param bookModel
	 * @param userDialog
	 */
	public CommandBookWithUser(int numberOfCommande, final BookModel bookModel, IUsersDialog userDialog) {
		super(numberOfCommande, userDialog);
		this.bookModel = bookModel;
	}

	@Override
	public void execute() {
		execute(bookModel);

	}
	protected abstract void execute(final BookModel bookModel);

	protected void afficharge() {
		userDialog.displayLine("%5s", bookModel.getTitle());
		for (Integer num : bookModel.getAllNumberOfPara()) {
			userDialog.display("§%d %s ", num, bookModel.getType(num));
			userDialog.display("%s ",
					bookModel.getTextOfParagraphe(num).length() > 25
							? bookModel.getTextOfParagraphe(num).substring(0, 25) + "..."
							: bookModel.getTextOfParagraphe(num));
			var numAct = bookModel.getNumOfActions(num);
			if (numAct.isEmpty())
				userDialog.display("-\n");
			else { 
				for (int i = 0; i < numAct.size() - 1; i++) {
					var text = bookModel.getTextOfAction(num, numAct.get(i));
					userDialog.display("%s ", text.length() > 10 ? text.substring(0, 10) + "..." : text);
					userDialog.display("%d-", numAct.get(i));

				} 
				var text = bookModel.getTextOfAction(num, numAct.get(numAct.size()-1));
				userDialog.display(" %s ", text.length() > 10 ? text.substring(0, 10) + "..." : text);
				userDialog.display(" %d \n", numAct.get(numAct.size()-1));
			}
		}
	}

	/**
	 * permet de verifier si le numero donnée par l'utilisateur est correct
	 * 
	 * @return
	 */
	protected int validerNumeroOfParagraph(String chaine) {
		int numero = 0;
		do {
			numero = userDialog.displayInteger(chaine);
			if (numero <= 0 || numero > bookModel.length())
				userDialog.displayLine("Ce numéro n’existe pas, Entrer un numéro valide ?");

		} while (numero <= 0 || numero > bookModel.length());
		return numero;
	}
}
