package command;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Permet que l'utilisateur puisse dialogue avec le sous menu
 * 
 * @author tamko
 *
 */
public class GameBooKCommandMapSousMain implements Iterable<CommandBook> {

	private final Map<Integer, CommandBook> commandBooks;
	private final Iterable<CommandBook> values;

	/**
	 * initialisation de la commande
	 * 
	 * @param commandBooks
	 */
	public GameBooKCommandMapSousMain(final CommandBook... commandBooks) {
		this.commandBooks = new HashMap<>();
		for (final CommandBook command : commandBooks) {
			this.commandBooks.put(command.getNumCommand(), command);
		}
		this.values = this.commandBooks.values();
	}

	/**
	 * Obtenire une command sur base de sa key
	 * @param key
	 * @return
	 */
	public CommandBook get(final int key) {
		return commandBooks.get(key);
	}

	@Override
	public Iterator<CommandBook> iterator() {
		return values.iterator();
	}

}
