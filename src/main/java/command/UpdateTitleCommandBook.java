package command;

import bookModelConsol.BookModel;
import model.Book;
import viewConsole.IUsersDialog;

/**
 * Permet de modifier le titre 
 * @author tamko
 *
 */
public class UpdateTitleCommandBook extends CommandBookWithUser {
/**
 * Initialise une nouvelle commande de modifier titre du livre.
 * @param bookModel
 * @param userDialog
 */
	public UpdateTitleCommandBook(final BookModel bookModel, final IUsersDialog userDialog) {
		super(1, bookModel,userDialog);
	}

	@Override
	public void execute(final BookModel bookModel) {
		final	String newTitle = userDialog.readLine(bookModel.getTitle() + " ? ");
			if (!newTitle.isBlank()) {
				bookModel.setTitle(newTitle);
			}
			userDialog.displayLine("%10s", bookModel.getTitle());
	}

}
