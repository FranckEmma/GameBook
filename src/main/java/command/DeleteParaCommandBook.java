package command;

import bookModelConsol.BookModel;
import model.Book;
import viewConsole.IUsersDialog;

/**
 * Permet de supprimer un paragraphe
 * 
 * @author tamko
 *
 */
public class DeleteParaCommandBook extends CommandBookWithUser {
	/**
	 * Initialisation de la command delete
	 * 
	 * @param bookModel
	 * @param userDialog
	 */
	public DeleteParaCommandBook(final BookModel bookModel, final IUsersDialog userDialog) {
		super(5, bookModel, userDialog);
	}

	@Override
	public void execute(final BookModel bookModel) {
		if (bookModel.length() > 0) {
			final var numero = validerNumeroOfParagraph("Numéro du paragraphe à supprimer? ");
			final char c = userDialog
					.readChar("Êtes-vous sûr (o/n)? Le paragraphe " + numero + " va être définitivement supprimé. ");
			if (c == 'o') {
				bookModel.deleteParagraph(numero);

			afficharge();
			userDialog.displayLine("Paragraphe supprimée ");
			}
		} else {
			userDialog.displayLine("Votre livre est vide! Veuillez d'abord ajouter les paragraphs\n");
		}
		
	}

}
