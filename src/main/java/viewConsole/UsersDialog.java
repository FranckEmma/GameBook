package viewConsole;

import java.util.Scanner;
import java.util.regex.Pattern;

public class UsersDialog implements IUsersDialog {
	private Scanner keyboard = new Scanner(System.in);
	private static final String INTEGER_PATTERN = "^[+-]?\\d+$";

	@Override
	public void menuPrincipal() {
		displayLine("1. Créer un livre");
		displayLine("2. Modifier un livre");
		displayLine("3. Vérifier un livre");
		displayLine("4. Afficher le graphe");
		displayLine("5. Quitter");
	}

	public void sousMenu() {
		displayLine("	1. Modifier le titre du livre");
		displayLine("	2. Ajouter un nouveau paragraphe");
		displayLine("	3. Modifier le type d'un paragraphe existant");
		displayLine("	4. Modifier un paragraphe existant");
		displayLine("	5. Supprimer un paragraphe");
		displayLine("	6. Arrêter la modification\n");

	}

	public String readLine(String fmt, Object... args) {
		display(fmt, args);
		String result = keyboard.nextLine();
		return result;
	}
	
	public int displayInteger(String fmt, Object... args) {
		String intAsText = null;
		do {
			intAsText = readLine(fmt, args);
		} while (!intAsText.matches(INTEGER_PATTERN));

		return Integer.parseInt(intAsText);
	}
	public char readChar(String chaine, Object... args) {
		char c2 = 0;
		boolean valide = false;
		String result = "";
		do {
			result = readLine(chaine);
			try {
				result = result.toLowerCase();
				if (!Pattern.matches("^[oncl]$", result))
					display("Caractère incorrect ! ");
				c2 = result.charAt(0);
				valide = true;
			} catch (StringIndexOutOfBoundsException e) {
				display("Veuillez encoder un seul caractere (O)ui/(N)on. ");
			}

		} while (!valide || !Pattern.matches("^[oncl]$", result));
		return c2;
	}
	@Override
	public void display(String message, Object... args) {
		System.out.printf(message, args);
	}

	@Override
	public void displayBook(String message, String para, Object... args) {
		displayLine(message, args);
		displayLine(para, args);
	}

	@Override
	public void exit() {
		System.exit(0);

	}

	@Override
	public void displayLine(String message, Object... args) {
		display(message, args);
		System.out.println();

	}
}
