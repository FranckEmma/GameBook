package command;

import bookModelConsol.BookModel;
import model.Book;
import model.DisplayGraph;
import viewConsole.IUsersDialog;

public class DisplayGragraphCommandBook  extends CommandBookWithUser{

	public DisplayGragraphCommandBook( final BookModel bookModel, IUsersDialog userDialog) {
		super(4, bookModel, userDialog);
		
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
			userDialog.displayLine("   Graphe vide ");
		} else {
			userDialog.displayLine("\n"+bookModel.displayGraph());
			
		}
	}



	
}
