package applicationConsole;

import command.AddCommandBook;
import command.CommandMap;
import command.ExitCommandBook;
import model.Book;
import viewConsole.IUsersDialog;
import viewConsole.UsersDialog;

public class Program {

	public static void main(String[] args) {
	
			final IUsersDialog userDialog = new UsersDialog();
			final Book book = new Book("defaultTitle");
			final CommandMap bookMap = new CommandMap(new AddCommandBook(book, userDialog),new ExitCommandBook(userDialog));
//			final GameBooKCommandMapSousMain sousMainBookMap = new GameBooKCommandMapSousMain(
//					new UpdateTitleCommandBook(book, userDialog), new AddParaCommandBook(book, userDialog),
//					new ModifyParaCommandBook(book, userDialog), new DeleteParaCommandBook(book, userDialog)
//				);
			final Controller ctrl = new Controller(userDialog, bookMap);
			ctrl.start();

	}

}
