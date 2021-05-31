package command;

import bookModelConsol.BookModel;
import model.Book;
import model.ValidateGameBook;
import viewConsole.IUsersDialog;

public class VerifyCommandBook extends CommandBookWithUser {

	public VerifyCommandBook(final BookModel bookModel, final IUsersDialog userDialog) {
		super(3, bookModel, userDialog);

	}

	@Override
	protected void execute(final BookModel bookModel) {
		var title = bookModel.getTitle();
		if (title.equals("defaultTitle") ) {
			userDialog.displayLine("Livre pas encore crée ! ");
			return;
		}
		
		afficharge();
		if (bookModel.length() == 0) {
			userDialog.displayLine(" \n    ( Aucun paragraphe )");
			userDialog.displayLine("Nœuds absents de toute action :  aucun noeud");
			userDialog.displayLine("Nœuds terminaux inaccessibles à partir du début : aucun nœud ");
		} else 
			userDialog.displayLine("\n"+bookModel.displayNoeud());
		
	}

}
