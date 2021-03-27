package command;

import model.Book;
import viewConsole.IUsersDialog;

/**
 * 
 * @author tamko
 *
 */
public class AddCommandBook extends CommandBook {

	private Book book;

	public AddCommandBook(final Book book, final IUsersDialog userDialog) {
		super(1, userDialog);
		this.book = book;
	}

	@Override
	public void execute() {
		String title = userDialog.readLine("Entrer le titre du livre ");
		if (!title.isBlank()) {
			if (book.getTitle().equals("defaultTitle")) {
				book.setTitle(title);
			} else {
				char reponse = userDialog
						.readChar("Le livre précédent sera perdu, Voulez vous  confirmation (O)ui/(N)on ? ");
				if (reponse == 'o')
					book.setTitle(title);
			}
			userDialog.displayBook("   " + book.getTitle(), "  (Aucun paragraphe )\n");
		} else if (book.getTitle().length() > 0) {
			userDialog.displayLine("\n Titre non modifier ! ");
		} else
			userDialog.displayLine("\n Aucun livre crée !");
	}

}
