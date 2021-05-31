package applicationConsole;

import bookModelConsol.BookModel;
import command.*;
import model.Book;
import model.DisplayGraph;
import model.ValidateGameBook;
import viewConsole.IUsersDialog;
import viewConsole.UsersDialog;

public class Program {

	public static void main(String[] args) {
	
	final IUsersDialog userDialog = new UsersDialog();
	final BookModel bookModel = new BookModel(new Book(" "), new ValidateGameBook()	, new DisplayGraph());
	final CommandMap bookMap = new CommandMap(new AddCommandBook(bookModel, userDialog),
			new SousMenuCommand(bookModel, userDialog),new ExitCommandBook(userDialog),
			new VerifyCommandBook(bookModel, userDialog),new DisplayGragraphCommandBook(bookModel, userDialog));
	final GameBooKCommandMapSousMain sousMainBookMap = new GameBooKCommandMapSousMain(
		new UpdateTitleCommandBook(bookModel, userDialog), new AddParaCommandBook(bookModel, userDialog),new ModifyTypeCommande(bookModel, userDialog),
		new ModifyParaCommandBook(bookModel, userDialog),new DeleteParaCommandBook(bookModel, userDialog)
		);
	final Controller ctrl = new Controller(userDialog, bookMap, sousMainBookMap);
	ctrl.start();

	}

}
