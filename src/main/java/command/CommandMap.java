package command;

import java.util.*;

public class CommandMap  implements Iterable<CommandBook>{
	private Map<Integer,CommandBook> commands;
	
	public CommandMap(final CommandBook...books) {
		
		commands= new HashMap<>();
		for (CommandBook commandBook : books) {
			commands.put(commandBook.getNumCommand(), commandBook);
		}
	}
	public CommandBook getCommand(final int key) {
		return commands.get(key);
	}
	@Override
	public Iterator<CommandBook> iterator() {
	
		return commands.values().iterator();
	}
	
}
