package command;

import bookModelConsol.BookModel;
import model.Book;
import viewConsole.IUsersDialog;

public class SousMenuCommand extends CommandBookWithUser {

	
	public SousMenuCommand( final BookModel bookModel,final  IUsersDialog userDialog) {
		super(2, bookModel, userDialog);
		
	}

	@Override
	protected void execute(BookModel bookModel) {
		if (!bookModel.getTitle().isBlank()) {
			userDialog.displayLine(bookModel.getTitle());
			super.verify(true);
		} else {
			userDialog.displayLine("Livre pas encore crée ! ");
		}
	}
		
}
